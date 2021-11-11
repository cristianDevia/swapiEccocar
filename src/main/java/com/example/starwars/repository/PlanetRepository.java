package com.example.starwars.repository;

import com.example.starwars.model.PlanetsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetsModel, Long> {
}
