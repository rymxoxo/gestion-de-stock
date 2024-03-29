package com.rymchaouch.gestion_de_stock.controllers.api;

import com.rymchaouch.gestion_de_stock.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rymchaouch.gestion_de_stock.utils.Constants.APP_ROOT;

public interface ClientApi {
    @GetMapping(value = APP_ROOT + "/clients/create" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto dto);

    @PostMapping(value = APP_ROOT+ "/clients/{idclient}")
    ClientDto findById(@PathVariable("idclient") Integer id);

    @PostMapping(value = APP_ROOT+ "/clients/all")
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/clients/delete/{idClient}")
    void delete(@PathVariable("idClient") Integer id);

}
