package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.MvtStkDto;
import com.rymchaouch.gestion_de_stock.models.MvtStk;
import lombok.Builder;

@Builder
public class MvtStkMapper {


    public static MvtStkDto toMvtStkDto(MvtStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleMapper.toArticleDto(mvtStk.getArticle()))
                .typeMvt(mvtStk.getTypeMvt())
                .sourceMvt(mvtStk.getSourceMvt())
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public static MvtStk toMvtStk(MvtStkDto mvtStkDto) {
        if (mvtStkDto == null) {
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.id());
        mvtStk.setDateMvt(mvtStkDto.dateMvt());
        mvtStk.setQuantite(mvtStkDto.quantite());
        mvtStk.setArticle(ArticleMapper.toArticle(mvtStkDto.article()));
        mvtStk.setTypeMvt(mvtStkDto.typeMvt());
        mvtStk.setSourceMvt(mvtStkDto.sourceMvt());
        mvtStk.setIdEntreprise(mvtStkDto.idEntreprise());
        return mvtStk;
    }

}
