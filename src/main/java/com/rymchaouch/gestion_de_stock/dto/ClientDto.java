package com.rymchaouch.gestion_de_stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rymchaouch.gestion_de_stock.models.Adresse;
import com.rymchaouch.gestion_de_stock.models.CommandeClient;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;

import java.util.List;

@Builder
public record ClientDto(
        Integer id ,

        String nom,
        String prenom ,
        AdresseDto adresse ,
        String mail,
        String photo ,
        String numTel ,
        Integer idEntreprise,

        @JsonIgnore
        List<CommandeClientDto> commandeClientDtos
)
{
}
