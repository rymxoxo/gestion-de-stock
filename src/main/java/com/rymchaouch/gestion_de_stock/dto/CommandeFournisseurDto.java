package com.rymchaouch.gestion_de_stock.dto;

import com.rymchaouch.gestion_de_stock.models.EtatCommande;
import lombok.Builder;

import java.time.Instant;
import java.util.List;
@Builder
public record CommandeFournisseurDto(
        Integer id ,
        String code,
        Instant dateDeCommande,
        EtatCommande etatCommande,
        Integer idEntreprise,

        FournisseurDto fournisseur,
        List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDtosList
) {
}
