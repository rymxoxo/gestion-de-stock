package com.rymchaouch.gestion_de_stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rymchaouch.gestion_de_stock.models.Adresse;
import com.rymchaouch.gestion_de_stock.models.Utilisateur;
import lombok.Builder;

import java.util.List;
@Builder
public record EntrepriseDto(
        Integer id ,
        String nom,
        String description ,
        AdresseDto adresse,
        String codeFiscal,
        String photo,
        String email,
        String numTel,
        String siteWeb,
        @JsonIgnore
        List<UtilisateurDto> utilisateurDtoListList

) {
}
