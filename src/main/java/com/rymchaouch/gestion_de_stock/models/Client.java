package com.rymchaouch.gestion_de_stock.models;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Client extends  BaseEntity{
    private  String nom ;
    private  String prenom ;
    @Embedded
    private Adresse adresse ;
    private String mail;
    private String photo ;
    private String numTel ;
    private Integer idEntreprise;

    @OneToMany(
            mappedBy = "client"
    )
    private List<CommandeClient> commandeClientList ;

}
