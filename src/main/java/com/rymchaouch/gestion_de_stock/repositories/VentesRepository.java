package com.rymchaouch.gestion_de_stock.repositories;

import com.rymchaouch.gestion_de_stock.models.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {
    Optional<Ventes> findVentesByCode(String code);
}
