package com.rymchaouch.gestion_de_stock.controllers.api;

import com.rymchaouch.gestion_de_stock.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rymchaouch.gestion_de_stock.utils.Constants.APP_ROOT;

public interface CategoryApi {

    @PostMapping(value = APP_ROOT +"/categories/create" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT+ "/categories/{idcategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idcategory") Integer id);

    @GetMapping(value = APP_ROOT+"c/ategory/filtre/{codearticle}" , produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCode(@PathVariable String code);

    @GetMapping(value = APP_ROOT+"/categories/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT +"/categories/delete/{idcategory}")
    void delete(@PathVariable("idcategory") Integer id);

}
