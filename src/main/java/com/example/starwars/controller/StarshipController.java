package com.example.starwars.controller;

import java.util.List;

import com.example.starwars.model.StarshipModel;
import com.example.starwars.service.StarshipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/starship")
@CrossOrigin(origins = "*")
public class StarshipController {

    @Autowired
    StarshipService starshipService;

    @PostMapping
    public ResponseEntity<StarshipModel> addNewStarship(@RequestBody @Validated StarshipModel starshipModel) {
        try {

            return new ResponseEntity<>(this.starshipService.addStarship(starshipModel), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<StarshipModel>> listStarship() {
        try {
            if (this.starshipService.listAll() != null) {
                return ResponseEntity.ok(this.starshipService.listAll());

            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StarshipModel> findStarship(@PathVariable("id") Long id) {
        try {
            if (this.starshipService.searchById(id) != null) {
                return ResponseEntity.ok(this.starshipService.searchById(id));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<StarshipModel> updateStarship(@PathVariable("id") Long id,
            @RequestBody @Validated StarshipModel starshipModel) {
        try {
            StarshipModel auxStarship = this.starshipService.searchById(id);
            if (auxStarship == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                auxStarship.setName(starshipModel.getName());
                auxStarship.setModel(starshipModel.getModel());
                auxStarship.setManufacturer(starshipModel.getManufacturer());
                auxStarship.setCostInCredits(starshipModel.getCostInCredits());
                auxStarship.setLength(starshipModel.getLength());
                auxStarship.setCrew(starshipModel.getCrew());
                auxStarship.setPassengers(starshipModel.getPassengers());
                auxStarship.setCargoCapacity(starshipModel.getCargoCapacity());
                auxStarship.setConsumables(starshipModel.getConsumables());
                auxStarship.setHyperdriveRating(starshipModel.getHyperdriveRating());
                auxStarship.setMGLT(starshipModel.getMGLT());
                auxStarship.setStarshipClass(starshipModel.getStarshipClass());
            }
            return new ResponseEntity<>(this.starshipService.updateStarship(auxStarship), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStarship(@PathVariable("id") Long id) {
        try {
            StarshipModel auxStarship = this.starshipService.searchById(id);
            if (auxStarship != null) {
                this.starshipService.deleteStarship(auxStarship);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
