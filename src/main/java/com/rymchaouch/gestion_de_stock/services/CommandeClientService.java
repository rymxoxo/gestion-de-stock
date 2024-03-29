package com.rymchaouch.gestion_de_stock.services;

import com.rymchaouch.gestion_de_stock.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto dto);
    CommandeClientDto findById(Integer id);

    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();

    void delete(Integer id);

}
