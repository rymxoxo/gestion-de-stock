package com.rymchaouch.gestion_de_stock.validators;

import com.rymchaouch.gestion_de_stock.dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VentesValidator {
    public static List<String> validate(VentesDto ventesDto) {
        List<String> errors = new ArrayList<>();
        if (ventesDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            return errors;
        }

        if (!StringUtils.hasLength(ventesDto.code())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (ventesDto.dateDeVente() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }

        return errors;
    }
}
