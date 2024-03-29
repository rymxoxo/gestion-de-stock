package com.rymchaouch.gestion_de_stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rymchaouch.gestion_de_stock.models.Article;
import com.rymchaouch.gestion_de_stock.models.CommandeClient;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record LigneCommandeClientDto(
        Integer id ,

        @JsonIgnore
        CommandeClientDto commandeClientDto,
        ArticleDto article,
        BigDecimal quantite,
        Integer idEntreprise,


        BigDecimal prixUnitaire

) {
}
