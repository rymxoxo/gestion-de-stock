package com.rymchaouch.gestion_de_stock.controllers.api;

import com.rymchaouch.gestion_de_stock.dto.FournisseurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rymchaouch.gestion_de_stock.utils.Constants.FOURNISSEUR_ENDPOINT;

public interface FournisseurApi {
    @PostMapping(FOURNISSEUR_ENDPOINT + "/create")
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(FOURNISSEUR_ENDPOINT + "/{idFournisseur}")
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(FOURNISSEUR_ENDPOINT + "/all")
    List<FournisseurDto> findAll();

    @DeleteMapping(FOURNISSEUR_ENDPOINT + "/delete/{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Integer id);

}
