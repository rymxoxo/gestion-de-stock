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
@Table(name = "commande_client")
public class CommandeClient extends  BaseEntity {

    private String code ;
    private Instant dateDeCommande;
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(
            name = "client_id"
    )
    private Client client;

    @OneToMany(
            mappedBy = "commandeClient"
    )
    private List<LigneCommandeClient> ligneCommandeClientList ;
}
