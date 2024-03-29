package com.rymchaouch.gestion_de_stock.dto;

import com.rymchaouch.gestion_de_stock.models.Adresse;
import com.rymchaouch.gestion_de_stock.models.CommandeFournisseur;
import lombok.Builder;

import java.util.List;
@Builder
public record FournisseurDto(
        Integer id ,
        String nom ,
        String prenom,
        AdresseDto adresse,
        String mail,
        String photo,
        String numTel,
        Integer idEntreprise,


        List<CommandeFournisseurDto> commandeFournisseurDtoList
) {
}
