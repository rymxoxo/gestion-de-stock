package com.rymchaouch.gestion_de_stock.dto;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record LigneCommandeFournisseurDto(
        Integer id ,

        CommandeFournisseurDto commandeFournisseurDto,
        ArticleDto article,
        BigDecimal quantite,
        Integer idEntreprise,



        BigDecimal prixUnitaire
) {
}
