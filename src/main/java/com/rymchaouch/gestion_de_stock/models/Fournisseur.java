package com.rymchaouch.gestion_de_stock.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Fournisseur extends BaseEntity{
    private  String nom ;
    private  String prenom ;
    @Embedded
    private Adresse adresse ;
    private String mail;
    private String photo ;
    private String numTel ;
    private Integer idEntreprise;

    @OneToMany(
            mappedBy = "fournisseur"
    )
    private List<CommandeFournisseur> commandeFournisseurList ;
}
