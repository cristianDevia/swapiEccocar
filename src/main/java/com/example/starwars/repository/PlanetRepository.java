package com.example.starwars.repository;

import com.example.starwars.model.PlanetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetModel, Long> {
}
