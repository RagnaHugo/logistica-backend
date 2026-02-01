package com.hugo.logistica_backend.repository;

import com.hugo.logistica_backend.model.Camion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamionRepository extends JpaRepository<Camion,Long> {
}
