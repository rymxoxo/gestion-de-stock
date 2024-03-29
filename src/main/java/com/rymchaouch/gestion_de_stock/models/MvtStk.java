package com.rymchaouch.gestion_de_stock.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mvt_stock")
public class MvtStk extends  BaseEntity {
    @ManyToOne
    @JoinColumn(
            name = "article_id"
    )
    private Article article;

    private Instant dateMvt;
    private BigDecimal quantite;
    @Enumerated(EnumType.STRING)
    private TypeMvtStk typeMvt;
    @Enumerated(EnumType.STRING)
    private SourceMvt sourceMvt;
    private Integer idEntreprise;


}
