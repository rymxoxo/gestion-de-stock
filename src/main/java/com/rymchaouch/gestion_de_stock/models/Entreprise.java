package com.rymchaouch.gestion_de_stock.models;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Entreprise extends  BaseEntity {
    private String nom ;
    private String description ;

    @Embedded
    private Adresse adresse ;
    private String codeFiscal;
    private String photo ;
    private String numTel;
    private String email ;
    private String siteWeb ;

    @OneToMany(
            mappedBy = "entreprise"
    )
    private List<Utilisateur> utilisateurList ;
}
