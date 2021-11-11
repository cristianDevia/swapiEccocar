package com.example.starwars.controller;


import com.example.starwars.model.PlanetsModel;
import com.example.starwars.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planet")
@CrossOrigin(origins = "*")
public class PlanetController {

    @Autowired
    PlanetService planetService;

    @PostMapping
    public ResponseEntity<PlanetsModel> addNewPlanet(@RequestBody PlanetsModel planetsModel){
        try {
            return  new ResponseEntity<>(this.planetService.addPlanet(planetsModel), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
