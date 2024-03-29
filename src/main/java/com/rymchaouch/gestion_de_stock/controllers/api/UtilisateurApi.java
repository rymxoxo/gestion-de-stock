package com.rymchaouch.gestion_de_stock.controllers.api;

import com.rymchaouch.gestion_de_stock.dto.UtilisateurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rymchaouch.gestion_de_stock.utils.Constants.UTILISATEUR_ENDPOINT;

public interface UtilisateurApi {
    @PostMapping(UTILISATEUR_ENDPOINT + "/create")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
    UtilisateurDto findByEmail(@PathVariable("email") String email);

    @GetMapping(UTILISATEUR_ENDPOINT + "/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);

}
