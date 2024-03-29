package com.rymchaouch.gestion_de_stock.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Adresse {
    private String adresse1 ;
    private String adresse2 ;
    private String ville ;
    private String pays ;
    private String zipCode ;

}
