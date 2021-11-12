package com.example.starwars.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author CRISTIAN
 */
@Entity
@Table(name = "planet", catalog = "starwars", schema = "")
@NamedQueries({ @NamedQuery(name = "PlanetModel.findAll", query = "SELECT p FROM PlanetModel p"),
        @NamedQuery(name = "PlanetModel.findById", query = "SELECT p FROM PlanetModel p WHERE p.id = :id"),
        @NamedQuery(name = "PlanetModel.findByName", query = "SELECT p FROM PlanetModel p WHERE p.name = :name"),
        @NamedQuery(name = "PlanetModel.findByRotationPeriod", query = "SELECT p FROM PlanetModel p WHERE p.rotationPeriod = :rotationPeriod"),
        @NamedQuery(name = "PlanetModel.findByOrbitalPeriod", query = "SELECT p FROM PlanetModel p WHERE p.orbitalPeriod = :orbitalPeriod"),
        @NamedQuery(name = "PlanetModel.findByDiameter", query = "SELECT p FROM PlanetModel p WHERE p.diameter = :diameter"),
        @NamedQuery(name = "PlanetModel.findByClimate", query = "SELECT p FROM PlanetModel p WHERE p.climate = :climate"),
        @NamedQuery(name = "PlanetModel.findByGravity", query = "SELECT p FROM PlanetModel p WHERE p.gravity = :gravity"),
        @NamedQuery(name = "PlanetModel.findByTerrain", query = "SELECT p FROM PlanetModel p WHERE p.terrain = :terrain"),
        @NamedQuery(name = "PlanetModel.findBySurfaceWater", query = "SELECT p FROM PlanetModel p WHERE p.surfaceWater = :surfaceWater"),
        @NamedQuery(name = "PlanetModel.findByPopulation", query = "SELECT p FROM PlanetModel p WHERE p.population = :population") })
public class PlanetModel implements Serializable {

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
    @JoinTable(name = "people_planet", joinColumns = {
            @JoinColumn(name = "planet_id", referencedColumnName = "id", nullable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "people_id", referencedColumnName = "id", nullable = false) })
    @ManyToMany
    private List<PeopleModel> peopleModelList;
    @ManyToMany(mappedBy = "planetModelList")
    private List<MissionModel> missionModelList;

    public PlanetModel() {
    }

    public PlanetModel(Long id) {
        this.id = id;
    }

    public PlanetModel(Long id, String name, String rotationPeriod, String orbitalPeriod, String diameter,
            String climate, String gravity, String terrain, String surfaceWater, String population) {
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

    public List<PeopleModel> getPeopleModelList() {
        return peopleModelList;
    }

    public void setPeopleModelList(List<PeopleModel> peopleModelList) {
        this.peopleModelList = peopleModelList;
    }

    public List<MissionModel> getMissionModelList() {
        return missionModelList;
    }

    public void setMissionModelList(List<MissionModel> missionModelList) {
        this.missionModelList = missionModelList;
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
        if (!(object instanceof PlanetModel)) {
            return false;
        }
        PlanetModel other = (PlanetModel) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "entity.PlanetModel[ id=" + id + " ]";
    }

}
