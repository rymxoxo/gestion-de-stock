package com.rymchaouch.gestion_de_stock.repositories;

import com.rymchaouch.gestion_de_stock.models.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;
import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {
    Optional<CommandeClient> findCommandeClientByCode(String code);
}
