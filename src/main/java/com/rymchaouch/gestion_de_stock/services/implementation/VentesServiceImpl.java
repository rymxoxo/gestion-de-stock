package com.rymchaouch.gestion_de_stock.services.implementation;

import com.rymchaouch.gestion_de_stock.dto.VentesDto;
import com.rymchaouch.gestion_de_stock.exceptions.EntityNotFoundException;
import com.rymchaouch.gestion_de_stock.exceptions.ErrorCodes;
import com.rymchaouch.gestion_de_stock.exceptions.InvalidEntityException;
import com.rymchaouch.gestion_de_stock.mappers.LigneVenteMapper;
import com.rymchaouch.gestion_de_stock.mappers.VenteMapper;
import com.rymchaouch.gestion_de_stock.models.Article;
import com.rymchaouch.gestion_de_stock.models.LigneVente;
import com.rymchaouch.gestion_de_stock.repositories.ArticleRepository;
import com.rymchaouch.gestion_de_stock.repositories.LigneVenteRepository;
import com.rymchaouch.gestion_de_stock.repositories.VentesRepository;
import com.rymchaouch.gestion_de_stock.services.VentesService;
import com.rymchaouch.gestion_de_stock.validators.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VentesServiceImpl implements VentesService {
    private ArticleRepository articleRepository;
    private VentesRepository ventesRepository;
    private VenteMapper venteMapper;
    private LigneVenteRepository ligneVenteRepository;

    public VentesServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VentesValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Ventes n'est pas valide");
            throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);

        }


        List<String> articleErrors = new ArrayList<>();

        if (dto.ligneVenteDtoList() != null) {
            dto.ligneVenteDtoList().forEach((ligneVenteDto -> {
                if (ligneVenteDto.article() != null) {
                    Optional<Article> articles = articleRepository.findById(ligneVenteDto.article().id());
                    if (articles.isEmpty()) {
                        articleErrors.add("L'article avec l'ID " + ligneVenteDto.article().id() + " n'existe pas");

                    }

                } else {
                    articleErrors.add("Impossible d'enregister une commande avec un aticle NULL");

                }

            }));
            if (!articleErrors.isEmpty()) {
                log.error("One or more articles were not found in the DB, {}", errors);
                throw new InvalidEntityException("Un ou plusieurs articles n'ont pas ete trouve dans la BDD", ErrorCodes.VENTE_NOT_VALID, errors);
            }

        }
        var savedCmd = ventesRepository.save(VenteMapper.toVentes(dto));
        dto.ligneVenteDtoList().forEach(
                ligneVenteDto -> {
                    LigneVente ligneVente = LigneVenteMapper.toLigneVente(ligneVenteDto);
                    ligneVente.setVente(savedCmd);
                    ligneVenteRepository.save(ligneVente);
                }
        );
        return VenteMapper.toVentesDto(savedCmd);
    }


    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            log.error("Ventes ID is NULL");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VenteMapper::toVentesDto)
                .orElseThrow(() -> new EntityNotFoundException("Aucun vente n'a ete trouve dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
    }


    @Override
    public VentesDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return ventesRepository.findVentesByCode(code)
                .map(VenteMapper::toVentesDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente client n'a ete trouve avec le CODE " + code, ErrorCodes.VENTE_NOT_VALID
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VenteMapper::toVentesDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Vente ID is NULL");
            return;
        }
        ventesRepository.deleteById(id);

    }
}
