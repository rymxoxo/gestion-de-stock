package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.AdresseDto;
import com.rymchaouch.gestion_de_stock.dto.ArticleDto;
import com.rymchaouch.gestion_de_stock.dto.CategoryDto;
import com.rymchaouch.gestion_de_stock.models.Adresse;
import com.rymchaouch.gestion_de_stock.models.Article;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service

@Builder
public class ArticleMapper {

        public static ArticleDto toArticleDto(Article article){
        if (article ==null){
            throw  new NullPointerException("Article does Not exist") ;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .code(article.getCode())
                .description(article.getDescription())
                .prixUnitaireHorsTaxe(article.getPrixUnitaireHorsTaxe())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .idEntreprise(article.getIdEntreprise())
                .category(CategoryMapper.toCategoryDto(article.getCategory()))
                .build();
    }

    public static Article toArticle(ArticleDto articleDto){
        if (articleDto ==null){
            throw  new NullPointerException("ArticleDto does Not exist") ;
        }
        var article = new Article();
        article.setId(articleDto.id());
        article.setCode(articleDto.code());
        article.setDescription(articleDto.description());
        article.setPrixUnitaireHorsTaxe(articleDto.prixUnitaireHorsTaxe());
        article.setTauxTva(articleDto.tauxTva());
        article.setPrixUnitaireTtc(articleDto.prixUnitaireTtc());
        article.setPhoto(articleDto.photo());
        article.setIdEntreprise(articleDto.idEntreprise());
        article.setCategory(CategoryMapper.toCategory(articleDto.category()));
        return  article;
    }

}
