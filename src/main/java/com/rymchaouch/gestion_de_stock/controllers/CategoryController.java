package com.rymchaouch.gestion_de_stock.controllers;

import com.rymchaouch.gestion_de_stock.controllers.api.CategoryApi;
import com.rymchaouch.gestion_de_stock.dto.CategoryDto;
import com.rymchaouch.gestion_de_stock.repositories.CategoryRepository;
import com.rymchaouch.gestion_de_stock.services.CategoryService;
import com.rymchaouch.gestion_de_stock.services.implementation.CategoryServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {
    private CategoryServiceImpl categoryService ;


    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return  categoryService.save(dto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCode(String code) {
        return categoryService.findByCode(code);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);

    }
}
