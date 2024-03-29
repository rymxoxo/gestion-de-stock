package com.rymchaouch.gestion_de_stock.services.implementation;

import com.rymchaouch.gestion_de_stock.dto.CommandeClientDto;
import com.rymchaouch.gestion_de_stock.exceptions.EntityNotFoundException;
import com.rymchaouch.gestion_de_stock.exceptions.ErrorCodes;
import com.rymchaouch.gestion_de_stock.exceptions.InvalidEntityException;
import com.rymchaouch.gestion_de_stock.mappers.CommandeClientMapper;
import com.rymchaouch.gestion_de_stock.mappers.CommandeFournisseurMapper;
import com.rymchaouch.gestion_de_stock.mappers.LigneCommandeClientMapper;
import com.rymchaouch.gestion_de_stock.models.Article;
import com.rymchaouch.gestion_de_stock.models.Client;
import com.rymchaouch.gestion_de_stock.models.CommandeClient;
import com.rymchaouch.gestion_de_stock.models.LigneCommandeClient;
import com.rymchaouch.gestion_de_stock.repositories.ArticleRepository;
import com.rymchaouch.gestion_de_stock.repositories.ClientRepository;
import com.rymchaouch.gestion_de_stock.repositories.CommandeClientRepository;
import com.rymchaouch.gestion_de_stock.repositories.LigneCommandeClientRepository;
import com.rymchaouch.gestion_de_stock.services.CommandeClientService;
import com.rymchaouch.gestion_de_stock.validators.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {
    private CommandeClientRepository commandeClientRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, LigneCommandeClientRepository ligneCommandeClientRepository, CommandeClientMapper commandeClientMapper, ClientRepository clientRepository, ArticleRepository articleRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.commandeClientRepository = commandeClientRepository;
        this.commandeClientMapper = commandeClientMapper;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    private CommandeClientMapper commandeClientMapper;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;


    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
        }
        Optional<Client> client = clientRepository.findById(dto.client().id());
        if (client.isEmpty()) {
            log.warn("Client with ID {} was not found in the DB", dto.client().id());
            throw new EntityNotFoundException("Aucun client avec l'ID" + dto.client().id() + " n'a ete trouve dans la BDD",
                    ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String > articleErrors = new ArrayList<>();
        if(dto.ligneCommandeClientDtoList() != null)
        {
                dto.ligneCommandeClientDtoList().forEach(ligneCommandeClientDto ->
                {
                    if (ligneCommandeClientDto.article() != null) {

                        Optional<Article> article = articleRepository.findById(ligneCommandeClientDto.article().id());
                        if (article.isEmpty()) {
                            articleErrors.add("L'article avec l'ID " + ligneCommandeClientDto.article().id() + " n'existe pas");
                        }
                    }
                    else {
                        articleErrors.add("Impossible d'enregister une commande avec un aticle NULL");
                    }


                });
        }
        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        CommandeClient savedCmd = commandeClientRepository.save(commandeClientMapper.toCommandeClient(dto));
        dto.ligneCommandeClientDtoList().forEach(ligneCommandeClientDto ->
                {
                    LigneCommandeClient ligneCommandeClient = LigneCommandeClientMapper.toLigneCommandeClient(ligneCommandeClientDto);
                    ligneCommandeClient.setCommandeClient(savedCmd);
                    ligneCommandeClientRepository.save(ligneCommandeClient);
                }
                );
        return commandeClientMapper.toCommandeClientDto(savedCmd);

    }

    @Override
    public CommandeClientDto findById(Integer id) {
            if (id == null) {
                log.error("Commande client ID is NULL");
                return null;
            }
            return commandeClientRepository.findById(id)
                    .map(commandeClientMapper::toCommandeClientDto)
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Aucune commande client n'a ete trouve avec l'ID " + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                    ));
        }



    @Override
    public CommandeClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Commande client CODE is NULL");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(commandeClientMapper::toCommandeClientDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'a ete trouve avec le CODE " + code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(commandeClientMapper::toCommandeClientDto)
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Commande client ID is NULL");
            return;
        }
        commandeClientRepository.deleteById(id);
    }

}
