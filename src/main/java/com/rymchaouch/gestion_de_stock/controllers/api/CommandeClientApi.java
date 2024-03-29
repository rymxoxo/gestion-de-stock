package com.rymchaouch.gestion_de_stock.controllers.api;

import com.rymchaouch.gestion_de_stock.dto.CommandeClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rymchaouch.gestion_de_stock.utils.Constants.APP_ROOT;

public interface CommandeClientApi {
    @PostMapping(APP_ROOT + "/commandesclients/create")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    @GetMapping(APP_ROOT + "/commandesclients/{idCommandeClient}")

    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandeClient);

    @GetMapping(APP_ROOT + "/commandesclients/filter/{codeCommandeClient}")

    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(APP_ROOT + "/commandesclients/all")

    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")

    ResponseEntity<Void> delete(@PathVariable("idCommandeClient") Integer id);
}
