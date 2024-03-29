package com.rymchaouch.gestion_de_stock.services;

import com.rymchaouch.gestion_de_stock.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto dto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void delete(Integer id);
}
