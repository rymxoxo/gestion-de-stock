package com.rymchaouch.gestion_de_stock.services.implementation;

import com.rymchaouch.gestion_de_stock.dto.ArticleDto;
import com.rymchaouch.gestion_de_stock.exceptions.EntityNotFoundException;
import com.rymchaouch.gestion_de_stock.exceptions.ErrorCodes;
import com.rymchaouch.gestion_de_stock.exceptions.InvalidEntityException;
import com.rymchaouch.gestion_de_stock.mappers.ArticleMapper;
import com.rymchaouch.gestion_de_stock.models.Article;
import com.rymchaouch.gestion_de_stock.repositories.ArticleRepository;
import com.rymchaouch.gestion_de_stock.services.ArticleService;
import com.rymchaouch.gestion_de_stock.validators.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service("implementation1")
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private final ArticleMapper articleMapper ;

    public ArticleServiceImpl(ArticleRepository articleRepository , ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if(!errors.isEmpty())
        {
            log.error("article nest pas valide", dto);
             throw new InvalidEntityException("article nest pas valide", ErrorCodes.ARTICLE_NOT_VALID , errors) ;
        }
       var article = articleMapper.toArticle(dto);
       var savedArticle = articleRepository.save(article);
       return articleMapper.toArticleDto(savedArticle);


    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id == null)
        {
            log.error("article id est null");
            return null ;
        }
        return articleRepository.findById(id)
            .map(ArticleMapper::toArticleDto)
            .orElseThrow(()->
                   new EntityNotFoundException("article avec id = "+ id + " nest pas trouvé dans bdd" , ErrorCodes.ARTICLE_NOT_FOUND)

                    );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null");
            return null;
        }

        return articleRepository.findArticleByCodeIgnoreCase(codeArticle)
                .map(ArticleMapper::toArticleDto)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun article avec le CODE = " + codeArticle + " n' ete trouve dans la BDD",
                                ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }


    @Override
    public List<ArticleDto> findAll() {
       return  articleRepository.findAll()
               .stream()
               .map(ArticleMapper::toArticleDto)
               .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null)
        {
            log.error("id n'existe pas");
            return;
        }
        articleRepository.deleteById(id);

    }
}
