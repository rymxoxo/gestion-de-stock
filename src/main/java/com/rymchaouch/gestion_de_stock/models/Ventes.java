package com.rymchaouch.gestion_de_stock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ventes extends  BaseEntity {
    private String code ;
    private Instant dateDeVente;
    private String commentaire ;
    private Integer idEntreprise;


    @OneToMany(
            mappedBy = "vente"
    )

    private List<LigneVente> ligneVenteList ;
}
