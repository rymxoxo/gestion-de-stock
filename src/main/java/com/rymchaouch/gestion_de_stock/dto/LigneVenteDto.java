package com.rymchaouch.gestion_de_stock.dto;

import com.rymchaouch.gestion_de_stock.models.Ventes;
import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record LigneVenteDto(
        Integer id ,
         VentesDto vente ,
         BigDecimal quantite,
         BigDecimal prixUnitaire,
        Integer idEntreprise,

        ArticleDto article

) {
}
