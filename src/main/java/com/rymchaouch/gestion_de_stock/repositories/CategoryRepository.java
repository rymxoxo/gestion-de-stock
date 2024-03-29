package com.rymchaouch.gestion_de_stock.repositories;

import com.rymchaouch.gestion_de_stock.dto.CategoryDto;
import com.rymchaouch.gestion_de_stock.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findCategoryByCode(String code);

}
