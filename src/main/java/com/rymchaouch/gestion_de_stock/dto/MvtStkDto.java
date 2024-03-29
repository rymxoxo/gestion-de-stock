package com.rymchaouch.gestion_de_stock.dto;

import com.rymchaouch.gestion_de_stock.models.SourceMvt;
import com.rymchaouch.gestion_de_stock.models.TypeMvtStk;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;
@Builder
public record MvtStkDto (
        Integer id ,
        ArticleDto article,
        Instant dateMvt,
        TypeMvtStk typeMvt,
        SourceMvt sourceMvt,
        Integer idEntreprise,

        BigDecimal quantite
)
{
}
