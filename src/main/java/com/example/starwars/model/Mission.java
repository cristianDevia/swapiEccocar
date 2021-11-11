package com.example.starwars.model;

import java.time.LocalDateTime;

public class Mission {

    private  Long id;

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

    private int crew;

    public Mission() {

    }

    public Mission(Long id, LocalDateTime beginDate, LocalDateTime endDate, int crew) {
        this.id = id;
        this.beginDate = beginDate;
        this.endDate = endDate;
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

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }
}
