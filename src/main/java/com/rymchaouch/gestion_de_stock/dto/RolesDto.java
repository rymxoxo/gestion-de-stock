package com.rymchaouch.gestion_de_stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

@Builder
public record RolesDto(
        Integer id ,
        String roleNom,

        @JsonIgnore
        UtilisateurDto utilisateurDto
) {
}
