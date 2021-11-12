package com.example.starwars.controller;

import java.util.List;

import com.example.starwars.model.PeopleModel;
import com.example.starwars.service.PeopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
@CrossOrigin(origins = "*")
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    @PostMapping
    public ResponseEntity<PeopleModel> addNewPeople(@RequestBody @Validated PeopleModel peopleModel) {
        try {

            return new ResponseEntity<>(this.peopleService.addPeople(peopleModel), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PeopleModel>> listPeople() {
        try {
            if (this.peopleService.listAll() != null) {
                return ResponseEntity.ok(this.peopleService.listAll());

            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleModel> findPeople(@PathVariable("id") Long id) {
        try {
            if (this.peopleService.searchById(id) != null) {
                return ResponseEntity.ok(this.peopleService.searchById(id));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<PeopleModel> updatePeople(@PathVariable("id") Long id,
            @RequestBody @Validated PeopleModel peopleModel) {
        try {
            PeopleModel auxPeople = this.peopleService.searchById(id);
            if (auxPeople == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                auxPeople.setName(peopleModel.getName());
                auxPeople.setHeight(peopleModel.getHeight());
                auxPeople.setMass(peopleModel.getMass());
                auxPeople.setSkinColor(peopleModel.getSkinColor());
                auxPeople.setBirthYear(peopleModel.getBirthYear());
                auxPeople.setHairColor(peopleModel.getHairColor());
                auxPeople.setGender(peopleModel.getGender());
            }
            return new ResponseEntity<>(this.peopleService.updatePeople(auxPeople), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanet(@PathVariable("id") Long id) {
        try {
            PeopleModel auxPeople = this.peopleService.searchById(id);
            if (auxPeople != null) {
                this.peopleService.deletePeople(auxPeople);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
