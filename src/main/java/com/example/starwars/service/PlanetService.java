package com.example.starwars.service;

import com.example.starwars.model.PlanetModel;
import com.example.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlanetService {

    @Autowired
    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public PlanetModel addPlanet(PlanetModel planetModel){
        return  this.planetRepository.save(planetModel);
    }
}
