package com.rymchaouch.gestion_de_stock.services;

import com.rymchaouch.gestion_de_stock.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    FournisseurDto save(FournisseurDto dto);

    FournisseurDto findById(Integer id);

    List<FournisseurDto> findAll();

    void delete(Integer id);
}
