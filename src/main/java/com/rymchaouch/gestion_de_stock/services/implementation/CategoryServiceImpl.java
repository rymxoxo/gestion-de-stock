package com.rymchaouch.gestion_de_stock.services.implementation;

import com.rymchaouch.gestion_de_stock.dto.CategoryDto;
import com.rymchaouch.gestion_de_stock.exceptions.EntityNotFoundException;
import com.rymchaouch.gestion_de_stock.exceptions.ErrorCodes;
import com.rymchaouch.gestion_de_stock.exceptions.InvalidEntityException;
import com.rymchaouch.gestion_de_stock.mappers.CategoryMapper;
import com.rymchaouch.gestion_de_stock.models.Article;
import com.rymchaouch.gestion_de_stock.repositories.CategoryRepository;
import com.rymchaouch.gestion_de_stock.services.CategoryService;
import com.rymchaouch.gestion_de_stock.validators.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository ;

    private CategoryMapper categoryMapper ;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }
    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("La category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryMapper.toCategoryDto(
                categoryRepository.save(CategoryMapper.toCategory(dto))
        );
    }


    @Override
    public CategoryDto findById(Integer id) {
        if(id==null)
        {
            log.error("Category ID is null");
            throw  new EntityNotFoundException("id"+id+"is not valid", ErrorCodes.CATEGORY_NOT_VALID);
           // return  null ;
        }
        return categoryRepository.findById(id)
                .map(CategoryMapper::toCategoryDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune category avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Category CODE is null");
            return null;
        }
        return categoryRepository.findCategoryByCode(code)
                .map(CategoryMapper::toCategoryDto)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune category avec le CODE = " + code + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return;
        }
        categoryRepository.deleteById(id);
    }
}
