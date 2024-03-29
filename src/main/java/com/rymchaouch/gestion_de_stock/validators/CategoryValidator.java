package com.rymchaouch.gestion_de_stock.validators;

import com.rymchaouch.gestion_de_stock.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public  static List<String> validate(CategoryDto categoryDto) {

        List<String> errors = new ArrayList<>();

        if (categoryDto == null || !StringUtils.hasLength(categoryDto.code())) {
            errors.add("Veuillez renseigner le code de la categorie");

        }
        return errors;
    }
}
