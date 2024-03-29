package com.rymchaouch.gestion_de_stock.repositories;

import com.rymchaouch.gestion_de_stock.dto.UtilisateurDto;
import com.rymchaouch.gestion_de_stock.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findUtilisateurByEmail(String email);

}
