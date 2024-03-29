package com.rymchaouch.gestion_de_stock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article extends BaseEntity{
    private String code ;
    private String description ;
    private BigDecimal prixUnitaireHorsTaxe;
    private BigDecimal tauxTva ;
    private String prixUnitaireTtc ;
    private String photo ;
    Integer idEntreprise;

    @ManyToOne
    @JoinColumn(
            name = "categorie_id"
    )
    private Category category ;
    @OneToMany(
            mappedBy = "article"
    )
    private List<LigneCommandeClient> ligneCommandeClientList ;
    @OneToMany(
            mappedBy = "article"
    )
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurList ;
    @OneToMany(
            mappedBy = "article"
    )
    private List<MvtStk> mvtStkList;

    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes;





}
