package com.rymchaouch.gestion_de_stock.dto;

import lombok.Builder;

import java.time.Instant;
import java.util.List;
@Builder
public record UtilisateurDto(
        Integer id ,

        String nom,
        String prenom,
         String email,
         String motDePasse,
        Instant dateDeNaissance,
        AdresseDto adresse,
        String photo,
        EntrepriseDto entreprise,
        List<RolesDto>roleList

) {
}
