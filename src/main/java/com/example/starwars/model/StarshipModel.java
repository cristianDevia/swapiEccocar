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
import javax.persistence.ManyToMany;
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
        @NamedQuery(name = "StarshipModel.findByCrew", query = "SELECT s FROM StarshipModel s WHERE s.crew = :crew"),
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
    private Long id;
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
    @Column(name = "cost_in_credits", nullable = false, length = 255)
    private String costInCredits;
    @Basic(optional = false)
    @Column(name = "length", nullable = false, length = 255)
    private String length;
    @Column(name = "max_atmosphering_speed", length = 255)
    private String maxAtmospheringSpeed;
    @Basic(optional = false)
    @Column(name = "crew", nullable = false, length = 255)
    private String crew;
    @Basic(optional = false)
    @Column(name = "passengers", nullable = false, length = 255)
    private String passengers;
    @Basic(optional = false)
    @Column(name = "cargo_capacity", nullable = false, length = 255)
    private String cargoCapacity;
    @Basic(optional = false)
    @Column(name = "consumables", nullable = false, length = 255)
    private String consumables;
    @Basic(optional = false)
    @Column(name = "hyperdrive_rating", nullable = false, length = 255)
    private String hyperdriveRating;
    @Basic(optional = false)
    @Column(name = "mGLT", nullable = false, length = 255)
    private String mGLT;
    @Basic(optional = false)
    @Column(name = "starship_class", nullable = false, length = 255)
    private String starshipClass;
    @ManyToMany(mappedBy = "starshipModelList")
    private List<PeopleModel> peopleModelList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkStarshipId")
    private List<MissionModel> missionModelList;

    public StarshipModel() {
    }

    public StarshipModel(Long id) {
        this.id = id;
    }

    public StarshipModel(Long id, String name, String model, String manufacturer, String costInCredits, String length, String crew, String passengers, String cargoCapacity, String consumables, String hyperdriveRating, String mGLT, String starshipClass) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        this.crew = crew;
        this.passengers = passengers;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.hyperdriveRating = hyperdriveRating;
        this.mGLT = mGLT;
        this.starshipClass = starshipClass;
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

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getMGLT() {
        return mGLT;
    }

    public void setMGLT(String mGLT) {
        this.mGLT = mGLT;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
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
