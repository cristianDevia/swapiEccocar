package com.example.starwars.controller;

import java.util.List;

import com.example.starwars.model.PlanetModel;
import com.example.starwars.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/planet")
@CrossOrigin(origins = "*")
public class PlanetController {

    @Autowired
    PlanetService planetService;

    @PostMapping
    public ResponseEntity<PlanetModel> addNewPlanet(@RequestBody @Validated PlanetModel planetModel) {
        try {

            return new ResponseEntity<>(this.planetService.addPlanet(planetModel), HttpStatus.CREATED);
        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PlanetModel>> listPlanet() {
        try {
            if (this.planetService.listAll() != null) {
                return ResponseEntity.ok(this.planetService.listAll());

            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetModel> findPlanet(@PathVariable("id") Long id) {
        try {
            if (this.planetService.searchById(id) != null) {
                return ResponseEntity.ok(this.planetService.searchById(id));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanetModel> updatePlanet(@PathVariable("id") Long id,
            @RequestBody @Validated PlanetModel planetModel) {
        try {
            PlanetModel auxPlanet = this.planetService.searchById(id);
            if (auxPlanet == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                auxPlanet.setName(planetModel.getName());
                auxPlanet.setRotationPeriod(planetModel.getRotationPeriod());
                auxPlanet.setOrbitalPeriod(planetModel.getOrbitalPeriod());
                auxPlanet.setDiameter(planetModel.getDiameter());
                auxPlanet.setClimate(planetModel.getClimate());
                auxPlanet.setGravity(planetModel.getGravity());
                auxPlanet.setTerrain(planetModel.getTerrain());
                auxPlanet.setSurfaceWater(planetModel.getSurfaceWater());
                auxPlanet.setPopulation(planetModel.getPopulation());
            }
            return new ResponseEntity<>(this.planetService.updatePlanet(auxPlanet), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanet(@PathVariable("id") Long id) {
        try {
            PlanetModel auxPlanet = this.planetService.searchById(id);
            if (auxPlanet != null) {
                this.planetService.deletePlanet(auxPlanet);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
