package com.rymchaouch.gestion_de_stock.repositories;

import com.rymchaouch.gestion_de_stock.models.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {
}
