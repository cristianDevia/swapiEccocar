package com.example.starwars.controller;


import com.example.starwars.model.PlanetModel;
import com.example.starwars.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planet")
@CrossOrigin(origins = "*")
public class PlanetController {

    @Autowired
    PlanetService planetService;

    @PostMapping
    public ResponseEntity<PlanetModel> addNewPlanet(@RequestBody @Validated PlanetModel planetModel){
        try {
            System.out.println("los datos del planeta son: "+ planetModel.toString());
            return  new ResponseEntity<>(this.planetService.addPlanet(planetModel), HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("error : "+e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

}
