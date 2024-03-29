package com.rymchaouch.gestion_de_stock.mappers;

import com.rymchaouch.gestion_de_stock.models.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    private CategoryMapper categoryMapper ;

    @BeforeEach
    void setUp() { categoryMapper= new CategoryMapper();
    }

   /* @Test
    void shoudMapCategoryToCategoryDto() {
        Category category = new Category(
                "code01",
                "blue"


        );
    }*/

    @Test
    void shoudMapCategoryDtoToCategory() {
    }
}