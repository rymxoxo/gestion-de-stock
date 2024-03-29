package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.AdresseDto;
import com.rymchaouch.gestion_de_stock.dto.CategoryDto;
import com.rymchaouch.gestion_de_stock.models.Adresse;
import com.rymchaouch.gestion_de_stock.models.Category;

public class AdresseMapper {

    public static AdresseDto toAdresseDto(Adresse adresse){
        if (adresse ==null){
            throw  new NullPointerException("adresse does Not exist") ;
        }
        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .zipCode(adresse.getZipCode())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toAdresse(AdresseDto adresseDto){
        if (adresseDto ==null){
            throw  new NullPointerException("adresseDto does Not exist") ;
        }
        var adresse = new Adresse();
        adresse.setAdresse1(adresseDto.adresse1());
        adresse.setAdresse2(adresse.getAdresse2());
        adresse.setZipCode(adresseDto.zipCode());
        adresse.setVille(adresseDto.ville());
        adresse.setPays(adresseDto.pays());
        return  adresse;
    }
}
