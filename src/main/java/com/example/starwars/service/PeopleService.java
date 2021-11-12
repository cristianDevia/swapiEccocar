package com.example.starwars.service;

import java.util.List;

import com.example.starwars.model.PeopleModel;
import com.example.starwars.repository.PeopleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    @Autowired
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public PeopleModel addPeople(PeopleModel peopleModel) {
        return this.peopleRepository.save(peopleModel);
    }

    public List<PeopleModel> listAll() {
        return this.peopleRepository.findAll();
    }

    public PeopleModel searchById(Long id) {
        return this.peopleRepository.findById(id).get();
    }

    public PeopleModel updatePeople(PeopleModel peopleModel) {
        return this.peopleRepository.save(peopleModel);
    }

    public void deletePeople(PeopleModel peopleModel) {
        this.peopleRepository.delete(peopleModel);
    }

}
