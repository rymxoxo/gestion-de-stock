package com.rymchaouch.gestion_de_stock.validators;

import com.rymchaouch.gestion_de_stock.dto.CommandeFournisseurDto;
import com.rymchaouch.gestion_de_stock.models.CommandeFournisseur;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public  class  CommandeFournisseurValidator {
    public  static List<String> validate(CommandeFournisseurDto dto)
    {
        List<String> errors =  new ArrayList<>();
        if (dto == null) {
        errors.add("Veuillez renseigner le code de la commande");
        errors.add("Veuillez renseigner la date de la commande");
        errors.add("Veuillez renseigner l'etat de la commande");
        errors.add("Veuillez renseigner le client");
        return errors;
    }

        if (!StringUtils.hasLength(dto.code())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (dto.dateDeCommande() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (!StringUtils.hasLength(dto.etatCommande().toString())) {
            errors.add("Veuillez renseigner l'etat de la commande");
        }
        if (dto.fournisseur() == null || dto.fournisseur().id() == null) {
            errors.add("Veuillez renseigner le fournisseur");
        }

        return errors;

    }


}
