package com.rymchaouch.gestion_de_stock.validators;

import com.rymchaouch.gestion_de_stock.dto.EntrepriseDto;
import com.rymchaouch.gestion_de_stock.models.Entreprise;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto entrepriseDto){
        List<String> errors = new ArrayList<>() ;
        if(entrepriseDto == null)
        {
            errors.add("Veuillez renseigner le nom de l'entreprise");
            errors.add("Veuillez renseigner la description de l'entreprise");
            errors.add("Veuillez renseigner le codeFiscal de l'entreprise");
            errors.add("Veuillez renseigner l'email de l'entreprise");
            errors.add("Veuillez renseigner le numero de telephone de l'entreprise");
            errors.addAll(AdresseValidator.validate(null));


            return  errors ;
        }

        if (!StringUtils.hasLength(entrepriseDto.nom()))
        {
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.description()))
        {
            errors.add("Veuillez renseigner la description de l'entreprise");

        }
        if (!StringUtils.hasLength(entrepriseDto.codeFiscal()))
        {
        }
        errors.add("Veuillez renseigner le codeFiscal de l'entreprise");
        if (!StringUtils.hasLength(entrepriseDto.email()))
        {
        }
        errors.add("Veuillez renseigner l'email de l'entreprise");
        if (!StringUtils.hasLength(entrepriseDto.numTel()))
        {
            errors.add("Veuillez renseigner le numero de telephone de l'entreprise");
        }

       errors.addAll(AdresseValidator.validate(entrepriseDto.adresse()));

        return errors ;
    }
}
