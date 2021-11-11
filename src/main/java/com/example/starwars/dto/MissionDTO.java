package com.example.starwars.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

public class MissionDTO implements Serializable {

    private Long id;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Long starshipId;
    private String starshipName;
    private int starshipCrew;
    private int starshipPassengers;
    private Long peopleId;
    private String peopleName;
    private Long planetId;
    private String planetName;
    private int planetDiameter;
    private int crew;

    public MissionDTO() {
    }

    public MissionDTO(Long id, LocalDateTime beginDate, LocalDateTime endDate, Long starshipId, String starshipName,
                      int starshipCrew, int starshipPassengers, Long peopleId, String peopleName, Long planetId, String planetName,
                      int planetDiameter, int crew) {
        this.id = id;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.starshipId = starshipId;
        this.starshipName = starshipName;
        this.starshipCrew = starshipCrew;
        this.starshipPassengers = starshipPassengers;
        this.peopleId = peopleId;
        this.peopleName = peopleName;
        this.planetId = planetId;
        this.planetName = planetName;
        this.planetDiameter = planetDiameter;
        this.crew = crew;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getStarshipId() {
        return starshipId;
    }

    public void setStarshipId(Long starshipId) {
        this.starshipId = starshipId;
    }

    public String getStarshipName() {
        return starshipName;
    }

    public void setStarshipName(String starshipName) {
        this.starshipName = starshipName;
    }

    public int getStarshipCrew() {
        return starshipCrew;
    }

    public void setStarshipCrew(int starshipCrew) {
        this.starshipCrew = starshipCrew;
    }

    public int getStarshipPassengers() {
        return starshipPassengers;
    }

    public void setStarshipPassengers(int starshipPassengers) {
        this.starshipPassengers = starshipPassengers;
    }

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public Long getPlanetId() {
        return planetId;
    }

    public void setPlanetId(Long planetId) {
        this.planetId = planetId;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public int getPlanetDiameter() {
        return planetDiameter;
    }

    public void setPlanetDiameter(int planetDiameter) {
        this.planetDiameter = planetDiameter;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }
}
