package com.rymchaouch.gestion_de_stock.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ligne_commande_client")
public class LigneCommandeClient extends  BaseEntity {

    @ManyToOne
    @JoinColumn(
            name = "command_client_id"
    )
    private CommandeClient commandeClient ;
    @ManyToOne
    @JoinColumn(
            name = "article_id"
    )
    private Article article;
    private BigDecimal quantite ;
    private BigDecimal prixUnitaire ;
    private Integer idEntreprise;
}
