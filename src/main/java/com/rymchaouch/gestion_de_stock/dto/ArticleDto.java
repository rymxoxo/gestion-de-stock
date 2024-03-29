package com.rymchaouch.gestion_de_stock.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ArticleDto(
         Integer id ,
         String code ,
         String description ,
         BigDecimal prixUnitaireHorsTaxe,
         BigDecimal tauxTva,
         String prixUnitaireTtc ,
         String photo ,
         Integer idEntreprise,
         CategoryDto category
)
{
}
