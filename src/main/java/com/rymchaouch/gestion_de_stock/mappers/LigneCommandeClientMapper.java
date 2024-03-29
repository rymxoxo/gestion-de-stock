package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.LigneCommandeClientDto;
import com.rymchaouch.gestion_de_stock.models.LigneCommandeClient;

public class LigneCommandeClientMapper {

    public static LigneCommandeClientDto toLigneCommandeClientDto(LigneCommandeClient ligneCommandeClient) {
        if (ligneCommandeClient == null) {
            return null;
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .article(ArticleMapper.toArticleDto(ligneCommandeClient.getArticle()))
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .idEntreprise(ligneCommandeClient.getIdEntreprise())
                .build();
    }

    public static LigneCommandeClient toLigneCommandeClient (LigneCommandeClientDto ligneCommandeClientDto) {
        if (ligneCommandeClientDto == null) {
            return null;
        }

        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.id());
        ligneCommandeClient.setArticle(ArticleMapper.toArticle(ligneCommandeClientDto.article()));
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.prixUnitaire());
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.quantite());
        ligneCommandeClient.setIdEntreprise(ligneCommandeClientDto.idEntreprise());
        return ligneCommandeClient;
    }
}
