package com.rymchaouch.gestion_de_stock.validators;

import com.rymchaouch.gestion_de_stock.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {
    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto) {
        List<String> errors = new ArrayList<>();
        if (ligneCommandeClientDto == null) {
            errors.add("Veuillez renseigner la quantite ");
            errors.add("Veuillez renseigner le prixUnitaire");
            errors.add("Veuillez renseigner l'article'");
            return errors;
        }


        return errors;
    }
}
