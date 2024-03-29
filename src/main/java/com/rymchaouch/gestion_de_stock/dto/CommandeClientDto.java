package com.rymchaouch.gestion_de_stock.dto;

import com.rymchaouch.gestion_de_stock.models.Client;
import com.rymchaouch.gestion_de_stock.models.EtatCommande;
import com.rymchaouch.gestion_de_stock.models.LigneCommandeClient;
import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record CommandeClientDto(
        Integer id ,
        String code,
        Instant dateDeCommande,
        EtatCommande etatCommande ,
        Integer idEntreprise,

        ClientDto client,
        List<LigneCommandeClientDto> ligneCommandeClientDtoList
) {
}
