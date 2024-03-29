package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.LigneVenteDto;
import com.rymchaouch.gestion_de_stock.models.LigneVente;

public class LigneVenteMapper {

    public static LigneVenteDto toLigneVenteDto(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .vente(VenteMapper.toVentesDto(ligneVente.getVente()))
                .article(ArticleMapper.toArticleDto(ligneVente.getArticle()))
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .idEntreprise(ligneVente.getIdEntreprise())
                .build();
    }

    public static LigneVente toLigneVente (LigneVenteDto ligneVenteDto) {
        if (ligneVenteDto == null) {
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.id());
        ligneVente.setVente(VenteMapper.toVentes(ligneVenteDto.vente()));
        ligneVente.setArticle(ArticleMapper.toArticle(ligneVenteDto.article()));
        ligneVente.setQuantite(ligneVenteDto.quantite());
        ligneVente.setPrixUnitaire(ligneVenteDto.prixUnitaire());
        ligneVente.setIdEntreprise(ligneVenteDto.idEntreprise());
        return ligneVente;
    }
}
