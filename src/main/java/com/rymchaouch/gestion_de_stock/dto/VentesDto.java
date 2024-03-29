package com.rymchaouch.gestion_de_stock.dto;

import lombok.Builder;

import java.time.Instant;
import java.util.List;
@Builder
public record VentesDto(
        Integer id ,
        String code,
        Instant dateDeVente,
        String commentaire,
        Integer idEntreprise,

        List<LigneVenteDto>  ligneVenteDtoList
) {
}
