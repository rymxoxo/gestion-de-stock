package com.rymchaouch.gestion_de_stock.services;

import com.rymchaouch.gestion_de_stock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
     EntrepriseDto save(EntrepriseDto dto);
    EntrepriseDto findById(Integer id);

    List<EntrepriseDto> findAll();

    void delete(Integer id);
}
