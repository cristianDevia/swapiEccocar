package com.example.starwars.model;

import java.time.LocalDateTime;

public class Mission {

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

    private int crew;

    public Mission() {

    }

    public Mission(LocalDateTime beginDate, LocalDateTime endDate, int crew) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.crew = crew;
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
