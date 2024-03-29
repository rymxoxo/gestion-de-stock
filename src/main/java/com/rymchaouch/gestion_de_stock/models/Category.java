package com.rymchaouch.gestion_de_stock.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseEntity{

    private String code ;
    private String designation ;
    private Integer idEntreprise;

    @OneToMany(
            mappedBy = "category"
    )

    @JsonIgnore
    private  List<Article> articleList ;
}
