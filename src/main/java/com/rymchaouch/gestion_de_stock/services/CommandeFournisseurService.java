package com.rymchaouch.gestion_de_stock.services;

import com.rymchaouch.gestion_de_stock.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseurDto save(CommandeFournisseurDto dto);
    CommandeFournisseurDto findById(Integer id);

    CommandeFournisseurDto findByCode(String code);

    List<CommandeFournisseurDto> findAll();

    void delete(Integer id);
}
