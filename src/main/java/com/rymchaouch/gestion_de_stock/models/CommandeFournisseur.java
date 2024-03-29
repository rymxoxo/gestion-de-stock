package com.rymchaouch.gestion_de_stock.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "commande_fournisseur")

public class CommandeFournisseur extends  BaseEntity {
    private Integer id;
    private String code ;
    private Instant dateDeCommande ;
    private EtatCommande etatCommande;
    private Integer idEntreprise;


    @ManyToOne
    @JoinColumn(
            name = "fournisseur_id"
    )
    private Fournisseur fournisseur ;

    @OneToMany(
            mappedBy = "commandeFournisseur"
    )
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurList ;
}
