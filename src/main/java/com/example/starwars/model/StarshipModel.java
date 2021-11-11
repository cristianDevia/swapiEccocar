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
@Table(name = "starship", catalog = "starwars", schema = "")
@NamedQueries({
        @NamedQuery(name = "StarshipModel.findAll", query = "SELECT s FROM StarshipModel s"),
        @NamedQuery(name = "StarshipModel.findById", query = "SELECT s FROM StarshipModel s WHERE s.id = :id"),
        @NamedQuery(name = "StarshipModel.findByName", query = "SELECT s FROM StarshipModel s WHERE s.name = :name"),
        @NamedQuery(name = "StarshipModel.findByModel", query = "SELECT s FROM StarshipModel s WHERE s.model = :model"),
        @NamedQuery(name = "StarshipModel.findByManufacturer", query = "SELECT s FROM StarshipModel s WHERE s.manufacturer = :manufacturer"),
        @NamedQuery(name = "StarshipModel.findByCostInCredits", query = "SELECT s FROM StarshipModel s WHERE s.costInCredits = :costInCredits"),
        @NamedQuery(name = "StarshipModel.findByLength", query = "SELECT s FROM StarshipModel s WHERE s.length = :length"),
        @NamedQuery(name = "StarshipModel.findByMaxAtmospheringSpeed", query = "SELECT s FROM StarshipModel s WHERE s.maxAtmospheringSpeed = :maxAtmospheringSpeed"),
        @NamedQuery(name = "StarshipModel.findByMinCrew", query = "SELECT s FROM StarshipModel s WHERE s.minCrew = :minCrew"),
        @NamedQuery(name = "StarshipModel.findByMaxCrew", query = "SELECT s FROM StarshipModel s WHERE s.maxCrew = :maxCrew"),
        @NamedQuery(name = "StarshipModel.findByPassengers", query = "SELECT s FROM StarshipModel s WHERE s.passengers = :passengers"),
        @NamedQuery(name = "StarshipModel.findByCargoCapacity", query = "SELECT s FROM StarshipModel s WHERE s.cargoCapacity = :cargoCapacity"),
        @NamedQuery(name = "StarshipModel.findByConsumables", query = "SELECT s FROM StarshipModel s WHERE s.consumables = :consumables"),
        @NamedQuery(name = "StarshipModel.findByHyperdriveRating", query = "SELECT s FROM StarshipModel s WHERE s.hyperdriveRating = :hyperdriveRating"),
        @NamedQuery(name = "StarshipModel.findByMGLT", query = "SELECT s FROM StarshipModel s WHERE s.mGLT = :mGLT"),
        @NamedQuery(name = "StarshipModel.findByStarshipClass", query = "SELECT s FROM StarshipModel s WHERE s.starshipClass = :starshipClass")})
public class StarshipModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @Column(name = "model", nullable = false, length = 255)
    private String model;
    @Basic(optional = false)
    @Column(name = "manufacturer", nullable = false, length = 255)
    private String manufacturer;
    @Basic(optional = false)
    @Column(name = "cost_in_credits", nullable = false)
    private int costInCredits;
    @Basic(optional = false)
    @Column(name = "length", nullable = false)
    private double length;
    @Column(name = "max_atmosphering_speed")
    private Integer maxAtmospheringSpeed;
    @Basic(optional = false)
    @Column(name = "min_crew", nullable = false)
    private int minCrew;
    @Basic(optional = false)
    @Column(name = "max_crew", nullable = false)
    private int maxCrew;
    @Basic(optional = false)
    @Column(name = "passengers", nullable = false)
    private int passengers;
    @Basic(optional = false)
    @Column(name = "cargo_capacity", nullable = false)
    private int cargoCapacity;
    @Basic(optional = false)
    @Column(name = "consumables", nullable = false, length = 255)
    private String consumables;
    @Basic(optional = false)
    @Column(name = "hyperdrive_rating", nullable = false)
    private double hyperdriveRating;
    @Basic(optional = false)
    @Column(name = "mGLT", nullable = false)
    private int mGLT;
    @Basic(optional = false)
    @Column(name = "starship_class", nullable = false, length = 255)
    private String starshipClass;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkStarshipId")
    private List<MissionModel> missionModelList;
    @JsonIgnore
    @OneToMany(mappedBy = "fkStarshipId")
    private List<PeopleModel> peopleModelList;

    public StarshipModel() {
    }

    public StarshipModel(Integer id) {
        this.id = id;
    }

    public StarshipModel(Integer id, String name, String model, String manufacturer, int costInCredits, double length, int minCrew, int maxCrew, int passengers, int cargoCapacity, String consumables, double hyperdriveRating, int mGLT, String starshipClass) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        this.minCrew = minCrew;
        this.maxCrew = maxCrew;
        this.passengers = passengers;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.hyperdriveRating = hyperdriveRating;
        this.mGLT = mGLT;
        this.starshipClass = starshipClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(int costInCredits) {
        this.costInCredits = costInCredits;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Integer getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(Integer maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public int getMinCrew() {
        return minCrew;
    }

    public void setMinCrew(int minCrew) {
        this.minCrew = minCrew;
    }

    public int getMaxCrew() {
        return maxCrew;
    }

    public void setMaxCrew(int maxCrew) {
        this.maxCrew = maxCrew;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public double getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(double hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public int getMGLT() {
        return mGLT;
    }

    public void setMGLT(int mGLT) {
        this.mGLT = mGLT;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
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
        if (!(object instanceof StarshipModel)) {
            return false;
        }
        StarshipModel other = (StarshipModel) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "entity.StarshipModel[ id=" + id + " ]";
    }

}
