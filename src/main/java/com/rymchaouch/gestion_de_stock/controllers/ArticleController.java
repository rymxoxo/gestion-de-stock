package com.rymchaouch.gestion_de_stock.controllers;

import com.rymchaouch.gestion_de_stock.controllers.api.ArticleApi;
import com.rymchaouch.gestion_de_stock.dto.ArticleDto;
import com.rymchaouch.gestion_de_stock.services.implementation.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ArticleController implements ArticleApi {


    @Qualifier("implementation1")
    private ArticleServiceImpl articleService ;

    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return  articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id) ;
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
         articleService.delete(id);
    }
}
