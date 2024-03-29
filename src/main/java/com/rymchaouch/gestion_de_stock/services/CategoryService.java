package com.rymchaouch.gestion_de_stock.services;

import com.rymchaouch.gestion_de_stock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Integer id);

    CategoryDto findByCode(String code);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
