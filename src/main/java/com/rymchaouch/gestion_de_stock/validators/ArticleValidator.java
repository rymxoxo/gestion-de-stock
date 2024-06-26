package com.rymchaouch.gestion_de_stock.validators;

import com.rymchaouch.gestion_de_stock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();

        if (articleDto == null) {
            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner la designation de l'article");
            errors.add("Veuillez renseigner le prix unitaire HT l'article");
            errors.add("Veuillez renseigner le taux TVA de l'article");
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
            errors.add("Veuillez selectionner une categorie");
            return errors;
        }

        if (!StringUtils.hasLength(articleDto.code())) {
            errors.add("Veuillez renseigner le code de l'article");
        }
        if (!StringUtils.hasLength(articleDto.description())) {
            errors.add("Veuillez renseigner la designation de l'article");
        }
        if (articleDto.prixUnitaireHorsTaxe() == null) {
            errors.add("Veuillez renseigner le prix unitaire HT l'article");
        }
        if (articleDto.tauxTva() == null) {
            errors.add("Veuillez renseigner le taux TVA de l'article");
        }
        if (articleDto.prixUnitaireTtc() == null) {
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
        }
        if (articleDto.category() == null || articleDto.category().id() == null) {
            errors.add("Veuillez selectionner une categorie");
        }
        return errors;
    }
}
