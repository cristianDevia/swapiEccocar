package com.example.starwars.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.starwars.model.PlanetModel;
import com.example.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PlanetService {

    @Autowired
    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public PlanetModel addPlanet(PlanetModel planetModel) {
        return this.planetRepository.save(planetModel);
    }

    public List<PlanetModel> listAll() {
        return this.planetRepository.findAll();
    }

    public PlanetModel searchById(Long id) {
        return this.planetRepository.findById(id).get();
    }

    public PlanetModel updatePlanet(PlanetModel planetModel) {
        return this.planetRepository.save(planetModel);
    }

    public void deletePlanet(PlanetModel planetModel) {
        this.planetRepository.delete(planetModel);
    }
}
