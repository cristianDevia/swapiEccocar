package com.example.starwars.model;


import java.time.LocalDateTime;
import java.util.List;

public class Starship {

    private Long id;
    private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String length;
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    private String cargo_capacity;
    private String consumables;
    private String hyperdrive_rating;
    //@JsonProperty("MGLT")
    private String mGLT;
    private String starship_class;
    private List<Object> pilots;
}
