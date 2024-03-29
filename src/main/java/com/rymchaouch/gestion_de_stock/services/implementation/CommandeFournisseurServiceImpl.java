package com.rymchaouch.gestion_de_stock.services.implementation;

import com.rymchaouch.gestion_de_stock.controllers.api.CommandeClientApi;
import com.rymchaouch.gestion_de_stock.dto.CommandeClientDto;
import com.rymchaouch.gestion_de_stock.dto.CommandeFournisseurDto;
import com.rymchaouch.gestion_de_stock.dto.FournisseurDto;
import com.rymchaouch.gestion_de_stock.exceptions.EntityNotFoundException;
import com.rymchaouch.gestion_de_stock.exceptions.ErrorCodes;
import com.rymchaouch.gestion_de_stock.exceptions.InvalidEntityException;
import com.rymchaouch.gestion_de_stock.mappers.CommandeFournisseurMapper;
import com.rymchaouch.gestion_de_stock.mappers.LigneCommandeFournisseurMapper;
import com.rymchaouch.gestion_de_stock.models.Article;
import com.rymchaouch.gestion_de_stock.models.Client;
import com.rymchaouch.gestion_de_stock.models.Fournisseur;
import com.rymchaouch.gestion_de_stock.models.LigneCommandeFournisseur;
import com.rymchaouch.gestion_de_stock.repositories.ArticleRepository;
import com.rymchaouch.gestion_de_stock.repositories.CommandeFournisseurRepository;
import com.rymchaouch.gestion_de_stock.repositories.FournisseurRepository;
import com.rymchaouch.gestion_de_stock.repositories.LigneCommandeFournisseurRepository;
import com.rymchaouch.gestion_de_stock.services.CommandeFournisseurService;
import com.rymchaouch.gestion_de_stock.validators.CommandeFournisseurValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {
    private CommandeFournisseurRepository commandeFournisseurRepository;
    private CommandeFournisseurMapper commandeFournisseurMapper;
    private ArticleRepository articleRepository;
    private LigneCommandeFournisseurMapper ligneCommandeFournisseurMapper;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, CommandeFournisseurMapper commandeFournisseurMapper, ArticleRepository articleRepository, LigneCommandeFournisseurMapper ligneCommandeFournisseurMapper, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository, FournisseurRepository fournisseurRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.commandeFournisseurMapper = commandeFournisseurMapper;
        this.articleRepository = articleRepository;
        this.ligneCommandeFournisseurMapper = ligneCommandeFournisseurMapper;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    private FournisseurRepository fournisseurRepository ;

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Commande fournisseur n'est pas valide");
            throw new InvalidEntityException("Commande fournisseur n'est pas valide" , ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.fournisseur().id());
        if (fournisseur.isEmpty()) {
            log.warn("Client with ID {} was not found in the DB", dto.fournisseur().id());
            throw new EntityNotFoundException("Aucun client avec l'ID" + dto.fournisseur().id() + " n'a ete trouve dans la BDD",
                    ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>() ;

        if(dto.ligneCommandeFournisseurDtosList() !=null) {
            dto.ligneCommandeFournisseurDtosList().forEach(ligneCommandeFournisseurDto
                            -> {
                        if (ligneCommandeFournisseurDto.article() != null) {
                            Optional<Article> article = articleRepository.findById(ligneCommandeFournisseurDto.article().id());
                            if (article.isEmpty()) {
                                articleErrors.add("L'article avec l'ID " + ligneCommandeFournisseurDto.article().id() + " n'existe pas");

                            }

                        } else {
                            articleErrors.add("Impossible d'enregister une commande avec un aticle NULL");
                        }

                    }
            );
        }
        if(!articleErrors.isEmpty())
        {
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID, articleErrors) ;
        }
        var savedCmd = commandeFournisseurRepository.save(commandeFournisseurMapper.toCommandeFournisseur(dto));
        dto.ligneCommandeFournisseurDtosList().forEach(ligneCommandeFournisseurDto ->
        {
            LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurMapper.toLigneCommandeFournisseur(ligneCommandeFournisseurDto);
            ligneCommandeFournisseur.setCommandeFournisseur(savedCmd);
            ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
        });

        return CommandeFournisseurMapper.toCommandeFournisseurDto(savedCmd);


    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if (id == null) {
            log.error("Commande fournisseur ID is NULL");
            return null;
        }
       return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurMapper::toCommandeFournisseurDto)
                .orElseThrow(() ->
                        new EntityNotFoundException("Aucune commande fournisseur n'a ete trouve avec l'ID " + id, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
                );
    }


    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if(code ==null)
        {
            log.error("code est null");
            return null;

        }
       return commandeFournisseurRepository.findByCode(code)
               .map(CommandeFournisseurMapper::toCommandeFournisseurDto)
               .orElseThrow(()->
                       new EntityNotFoundException("aucune commande fournisseur n'est trouvée" + code , ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
                       );
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll()
                .stream()
                .map(CommandeFournisseurMapper::toCommandeFournisseurDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Commande fournisseur ID is NULL");
            return;
        }
        commandeFournisseurRepository.deleteById(id);
    }
}
