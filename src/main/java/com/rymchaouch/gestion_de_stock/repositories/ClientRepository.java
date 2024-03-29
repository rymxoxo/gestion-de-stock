package com.rymchaouch.gestion_de_stock.repositories;

import com.rymchaouch.gestion_de_stock.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
