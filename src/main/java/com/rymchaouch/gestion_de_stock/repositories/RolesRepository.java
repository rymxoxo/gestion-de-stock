package com.rymchaouch.gestion_de_stock.repositories;

import com.rymchaouch.gestion_de_stock.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
