package com.rymchaouch.gestion_de_stock.validators;

import com.rymchaouch.gestion_de_stock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDto commandeClientDto) {
        List<String> errors = new ArrayList<>();
        if (commandeClientDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (!StringUtils.hasLength(commandeClientDto.code())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (commandeClientDto.dateDeCommande() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (!StringUtils.hasLength(commandeClientDto.etatCommande().toString())) {
            errors.add("Veuillez renseigner l'etat de la commande");
        }
        if (commandeClientDto.client() == null || commandeClientDto.client().id() == null) {
            errors.add("Veuillez renseigner le client");
        }

        return errors;

    }
    }
