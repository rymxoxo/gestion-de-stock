package com.rymchaouch.gestion_de_stock.repositories;

import com.rymchaouch.gestion_de_stock.models.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer> {
}
