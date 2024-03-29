package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.dto.CategoryDto;
import com.rymchaouch.gestion_de_stock.models.Category;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class CategoryMapper {

    public static CategoryDto toCategoryDto(Category category){
        if (category ==null){
            throw  new NullPointerException("category does Not exist") ;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .idEntreprise(category.getIdEntreprise())
                .build();
    }

    public static Category toCategory(CategoryDto categoryDto){
        if (categoryDto ==null){
            throw  new NullPointerException("categoryDto does Not exist") ;
        }
        var category = new Category();
        category.setId(categoryDto.id());
        category.setCode(categoryDto.code());
        category.setDesignation(categoryDto.designation());
        category.setIdEntreprise(categoryDto.idEntreprise());
        return  category;
    }
}
