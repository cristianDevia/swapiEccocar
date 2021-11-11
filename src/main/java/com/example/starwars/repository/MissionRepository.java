package com.example.starwars.repository;

import com.example.starwars.model.MissionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<MissionModel, Long> {
}
