package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.LigneCommandeFournisseurDto;
import com.rymchaouch.gestion_de_stock.models.LigneCommandeFournisseur;

public class LigneCommandeFournisseurMapper {
    public static LigneCommandeFournisseurDto toLigneCommandeFournisseurDto (LigneCommandeFournisseur ligneCommandeFournisseur) {
        if (ligneCommandeFournisseur == null) {
            return null;
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .article(ArticleMapper.toArticleDto(ligneCommandeFournisseur.getArticle()))
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .idEntreprise(ligneCommandeFournisseur.getIdEntreprise())
                .build();
    }

    public static LigneCommandeFournisseur toLigneCommandeFournisseur (LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        if (ligneCommandeFournisseurDto == null) {
            return null;
        }

        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.id());
        ligneCommandeFournisseur.setArticle(ArticleMapper.toArticle(ligneCommandeFournisseurDto.article()));
        ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.prixUnitaire());
        ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.quantite());
        ligneCommandeFournisseur.setIdEntreprise(ligneCommandeFournisseur.getIdEntreprise());
        return ligneCommandeFournisseur;
    }
}
