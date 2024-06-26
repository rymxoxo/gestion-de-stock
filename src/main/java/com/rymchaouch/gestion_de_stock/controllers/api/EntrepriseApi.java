package com.rymchaouch.gestion_de_stock.controllers.api;

import com.rymchaouch.gestion_de_stock.dto.EntrepriseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rymchaouch.gestion_de_stock.utils.Constants.ENTREPRISE_ENDPOINT;

public interface EntrepriseApi {
    @PostMapping(ENTREPRISE_ENDPOINT + "/create")
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(ENTREPRISE_ENDPOINT + "/{idEntreprise}")
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

    @GetMapping(ENTREPRISE_ENDPOINT + "/all")
    List<EntrepriseDto> findAll();

    @DeleteMapping(ENTREPRISE_ENDPOINT + "/delete/{idEntreprise}")
    void delete(@PathVariable("idEntreprise") Integer id);
}
