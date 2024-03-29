package com.rymchaouch.gestion_de_stock.models;


import jakarta.persistence.*;
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
public class Utilisateur extends  BaseEntity {
    private String nom ;
    private String prenom ;
    private String email ;
    private String motDePasse ;
    private Instant dateDeNaissance ;
    private Adresse adresse ;
    private String photo ;


    @ManyToOne
    @JoinColumn(
            name = "entreprise_id"
    )
    private Entreprise entreprise ;
    @OneToMany(
            mappedBy = "utilisateur"
    )
    List<Roles> roleList ;
}
