package com.example.starwars.service;

import java.util.List;

import com.example.starwars.model.StarshipModel;
import com.example.starwars.repository.StarshipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarshipService {

    @Autowired
    private final StarshipRepository starshipRepository;

    public StarshipService(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public StarshipModel addStarship(StarshipModel starshipModel) {
        return this.starshipRepository.save(starshipModel);
    }

    public List<StarshipModel> listAll() {
        return this.starshipRepository.findAll();
    }

    public StarshipModel searchById(Long id) {
        return this.starshipRepository.findById(id).get();
    }

    public StarshipModel updateStarship(StarshipModel starshipModel) {
        return this.starshipRepository.save(starshipModel);
    }

    public void deleteStarship(StarshipModel starshipModel) {
        this.starshipRepository.delete(starshipModel);
    }

}
