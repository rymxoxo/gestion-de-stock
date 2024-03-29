package com.rymchaouch.gestion_de_stock.controllers;

import com.rymchaouch.gestion_de_stock.controllers.api.EntrepriseApi;
import com.rymchaouch.gestion_de_stock.dto.EntrepriseDto;
import com.rymchaouch.gestion_de_stock.services.EntrepriseService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}