package com.example.starwars.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/starship")
@CrossOrigin(origins = "*")
public class StarshipController {
}
