package com.example.starwars.service;

import com.example.starwars.model.PlanetsModel;
import com.example.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    @Autowired
    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public PlanetsModel addPlanet(PlanetsModel planetsModel){
        return  this.planetRepository.save(planetsModel);
    }
}
