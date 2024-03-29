package com.rymchaouch.gestion_de_stock.controllers;

import com.rymchaouch.gestion_de_stock.controllers.api.ClientApi;
import com.rymchaouch.gestion_de_stock.dto.ClientDto;
import com.rymchaouch.gestion_de_stock.services.ClientService;
import com.rymchaouch.gestion_de_stock.services.implementation.ClientServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {
    private ClientServiceImpl clientService ;
    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);

    }
}
