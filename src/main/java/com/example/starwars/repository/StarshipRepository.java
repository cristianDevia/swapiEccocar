package com.example.starwars.repository;

import com.example.starwars.model.StarshipModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarshipRepository extends JpaRepository<StarshipModel, Long> {
}
