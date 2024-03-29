package com.rymchaouch.gestion_de_stock.controllers;

import com.rymchaouch.gestion_de_stock.controllers.api.CommandeClientApi;
import com.rymchaouch.gestion_de_stock.dto.CommandeClientDto;
import com.rymchaouch.gestion_de_stock.services.CommandeClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeClientController implements CommandeClientApi {
    private CommandeClientService commandeClientService;

    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }
    @Override
    public ResponseEntity<CommandeClientDto> save(CommandeClientDto dto) {
        return ResponseEntity.ok(commandeClientService.save(dto));
       // return ResponseEntity.status(HttpStatus.OK).body(commandeClientService.save(dto));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findById(Integer id) {
        return ResponseEntity.ok(commandeClientService.findById(id));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findByCode(String code) {
        return ResponseEntity.ok(commandeClientService.findByCode(code));

    }

    @Override
    public ResponseEntity<List<CommandeClientDto>> findAll() {
        return ResponseEntity.ok(commandeClientService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        //here we have used .buid() because delege does not return any type
            commandeClientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
