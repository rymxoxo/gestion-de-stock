package com.rymchaouch.gestion_de_stock.validators;

import com.rymchaouch.gestion_de_stock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(utilisateurDto.nom())) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.prenom())) {
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.email())) {
            errors.add("Veuillez renseigner l'email d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.motDePasse())) {
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
        }
        if (utilisateurDto.dateDeNaissance() == null) {
            errors.add("Veuillez renseigner la date de naissance d'utilisateur");
        }
        errors.addAll(AdresseValidator.validate(utilisateurDto.adresse()));

        return errors;
    }

}
