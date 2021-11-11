package com.example.starwars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author CRISTIAN
 */
@Entity
@Table(name = "planets", catalog = "starwars", schema = "")
@NamedQueries({
        @NamedQuery(name = "PlanetsModel.findAll", query = "SELECT p FROM PlanetsModel p"),
        @NamedQuery(name = "PlanetsModel.findById", query = "SELECT p FROM PlanetsModel p WHERE p.id = :id"),
        @NamedQuery(name = "PlanetsModel.findByName", query = "SELECT p FROM PlanetsModel p WHERE p.name = :name"),
        @NamedQuery(name = "PlanetsModel.findByRotationPeriod", query = "SELECT p FROM PlanetsModel p WHERE p.rotationPeriod = :rotationPeriod"),
        @NamedQuery(name = "PlanetsModel.findByOrbitalPeriod", query = "SELECT p FROM PlanetsModel p WHERE p.orbitalPeriod = :orbitalPeriod"),
        @NamedQuery(name = "PlanetsModel.findByDiameter", query = "SELECT p FROM PlanetsModel p WHERE p.diameter = :diameter"),
        @NamedQuery(name = "PlanetsModel.findByClimate", query = "SELECT p FROM PlanetsModel p WHERE p.climate = :climate"),
        @NamedQuery(name = "PlanetsModel.findByGravity", query = "SELECT p FROM PlanetsModel p WHERE p.gravity = :gravity"),
        @NamedQuery(name = "PlanetsModel.findByTerrain", query = "SELECT p FROM PlanetsModel p WHERE p.terrain = :terrain"),
        @NamedQuery(name = "PlanetsModel.findBySurfaceWater", query = "SELECT p FROM PlanetsModel p WHERE p.surfaceWater = :surfaceWater"),
        @NamedQuery(name = "PlanetsModel.findByPopulation", query = "SELECT p FROM PlanetsModel p WHERE p.population = :population")})
public class PlanetsModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @Column(name = "rotation_period", nullable = false, length = 255)
    private String rotationPeriod;
    @Basic(optional = false)
    @Column(name = "orbital_period", nullable = false, length = 255)
    private String orbitalPeriod;
    @Basic(optional = false)
    @Column(name = "diameter", nullable = false, length = 255)
    private String diameter;
    @Basic(optional = false)
    @Column(name = "climate", nullable = false, length = 255)
    private String climate;
    @Basic(optional = false)
    @Column(name = "gravity", nullable = false, length = 255)
    private String gravity;
    @Basic(optional = false)
    @Column(name = "terrain", nullable = false, length = 255)
    private String terrain;
    @Basic(optional = false)
    @Column(name = "surface_water", nullable = false, length = 255)
    private String surfaceWater;
    @Basic(optional = false)
    @Column(name = "population", nullable = false, length = 255)
    private String population;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPlanetsId")
    private List<MissionModel> missionModelList;
    @JsonIgnore
    @OneToMany(mappedBy = "fkPlanetsId")
    private List<PeopleModel> peopleModelList;

    public PlanetsModel() {
    }

    public PlanetsModel(Long id) {
        this.id = id;
    }

    public PlanetsModel(Long id, String name, String rotationPeriod, String orbitalPeriod, String diameter, String climate, String gravity, String terrain, String surfaceWater, String population) {
        this.id = id;
        this.name = name;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surfaceWater = surfaceWater;
        this.population = population;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<MissionModel> getMissionModelList() {
        return missionModelList;
    }

    public void setMissionModelList(List<MissionModel> missionModelList) {
        this.missionModelList = missionModelList;
    }

    public List<PeopleModel> getPeopleModelList() {
        return peopleModelList;
    }

    public void setPeopleModelList(List<PeopleModel> peopleModelList) {
        this.peopleModelList = peopleModelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanetsModel)) {
            return false;
        }
        PlanetsModel other = (PlanetsModel) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "entity.PlanetsModel[ id=" + id + " ]";
    }

}