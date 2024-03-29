package com.rymchaouch.gestion_de_stock.dto;

import lombok.Builder;

@Builder
public record AdresseDto(

         String adresse1 ,
         String adresse2,
         String ville ,
         String pays ,
         String zipCode
) {
}
