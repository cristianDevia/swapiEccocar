package com.example.starwars.controller;

import java.util.List;

import com.example.starwars.model.MissionModel;
import com.example.starwars.service.MissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mission")
@CrossOrigin(origins = "*")
public class MissionController {

    @Autowired
    MissionService missionService;

    @PostMapping
    public ResponseEntity<MissionModel> addNewMission(@RequestBody @Validated MissionModel starshipModel) {
        try {

            return new ResponseEntity<>(this.missionService.addMission(starshipModel), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MissionModel>> listMission() {
        try {
            if (this.missionService.listAll() != null) {
                return ResponseEntity.ok(this.missionService.listAll());

            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionModel> findMission(@PathVariable("id") Long id) {
        try {
            if (this.missionService.searchById(id) != null) {
                return ResponseEntity.ok(this.missionService.searchById(id));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<MissionModel> updateMission(@PathVariable("id") Long id,
            @RequestBody @Validated MissionModel starshipModel) {
        try {
            MissionModel auxMission = this.missionService.searchById(id);
            if (auxMission == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {

            }
            return new ResponseEntity<>(this.missionService.updateMission(auxMission), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable("id") Long id) {
        try {
            MissionModel auxMission = this.missionService.searchById(id);
            if (auxMission != null) {
                this.missionService.deleteMission(auxMission);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
