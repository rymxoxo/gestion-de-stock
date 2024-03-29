package com.rymchaouch.gestion_de_stock.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue
    private  Integer id ;


    /* ce sont des champs techniques , aps besoin de les exposés */
    @CreatedDate
    @Column(name = "creation_date" , nullable = false)
    @JsonIgnore
    private Instant creationDate ;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    //@JsonIgnore
    private Date lastUpdateDate ;
}
