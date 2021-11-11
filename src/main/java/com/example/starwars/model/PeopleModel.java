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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author CRISTIAN
 */
@Entity
@Table(name = "people", catalog = "starwars", schema = "")
@NamedQueries({
        @NamedQuery(name = "PeopleModel.findAll", query = "SELECT p FROM PeopleModel p"),
        @NamedQuery(name = "PeopleModel.findById", query = "SELECT p FROM PeopleModel p WHERE p.id = :id"),
        @NamedQuery(name = "PeopleModel.findByName", query = "SELECT p FROM PeopleModel p WHERE p.name = :name"),
        @NamedQuery(name = "PeopleModel.findByHeight", query = "SELECT p FROM PeopleModel p WHERE p.height = :height"),
        @NamedQuery(name = "PeopleModel.findByMass", query = "SELECT p FROM PeopleModel p WHERE p.mass = :mass"),
        @NamedQuery(name = "PeopleModel.findByHairColor", query = "SELECT p FROM PeopleModel p WHERE p.hairColor = :hairColor"),
        @NamedQuery(name = "PeopleModel.findBySkinColor", query = "SELECT p FROM PeopleModel p WHERE p.skinColor = :skinColor"),
        @NamedQuery(name = "PeopleModel.findByEyeColor", query = "SELECT p FROM PeopleModel p WHERE p.eyeColor = :eyeColor"),
        @NamedQuery(name = "PeopleModel.findByBirthYear", query = "SELECT p FROM PeopleModel p WHERE p.birthYear = :birthYear"),
        @NamedQuery(name = "PeopleModel.findByGender", query = "SELECT p FROM PeopleModel p WHERE p.gender = :gender")})
public class PeopleModel implements Serializable {

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
        @Column(name = "height", nullable = false)
        private int height;
        @Basic(optional = false)
        @Column(name = "mass", nullable = false)
        private int mass;
        @Column(name = "hair_color", length = 255)
        private String hairColor;
        @Basic(optional = false)
        @Column(name = "skin_color", nullable = false, length = 255)
        private String skinColor;
        @Basic(optional = false)
        @Column(name = "eye_color", nullable = false, length = 255)
        private String eyeColor;
        @Basic(optional = false)
        @Column(name = "birth_year", nullable = false, length = 255)
        private String birthYear;
        @Column(name = "gender", length = 255)
        private String gender;
        @JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPeopleId")
        private List<MissionModel> missionModelList;
        @JoinColumn(name = "fk_planets_id", referencedColumnName = "id")
        @ManyToOne
        private PlanetsModel fkPlanetsId;
        @JoinColumn(name = "fk_starship_id", referencedColumnName = "id")
        @ManyToOne
        private StarshipModel fkStarshipId;

        public PeopleModel() {
        }

        public PeopleModel(Integer id) {
                this.id = id;
        }

        public PeopleModel(Integer id, String name, int height, int mass, String skinColor, String eyeColor, String birthYear) {
                this.id = id;
                this.name = name;
                this.height = height;
                this.mass = mass;
                this.skinColor = skinColor;
                this.eyeColor = eyeColor;
                this.birthYear = birthYear;
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

        public int getHeight() {
                return height;
        }

        public void setHeight(int height) {
                this.height = height;
        }

        public int getMass() {
                return mass;
        }

        public void setMass(int mass) {
                this.mass = mass;
        }

        public String getHairColor() {
                return hairColor;
        }

        public void setHairColor(String hairColor) {
                this.hairColor = hairColor;
        }

        public String getSkinColor() {
                return skinColor;
        }

        public void setSkinColor(String skinColor) {
                this.skinColor = skinColor;
        }

        public String getEyeColor() {
                return eyeColor;
        }

        public void setEyeColor(String eyeColor) {
                this.eyeColor = eyeColor;
        }

        public String getBirthYear() {
                return birthYear;
        }

        public void setBirthYear(String birthYear) {
                this.birthYear = birthYear;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public List<MissionModel> getMissionModelList() {
                return missionModelList;
        }

        public void setMissionModelList(List<MissionModel> missionModelList) {
                this.missionModelList = missionModelList;
        }

        public PlanetsModel getFkPlanetsId() {
                return fkPlanetsId;
        }

        public void setFkPlanetsId(PlanetsModel fkPlanetsId) {
                this.fkPlanetsId = fkPlanetsId;
        }

        public StarshipModel getFkStarshipId() {
                return fkStarshipId;
        }

        public void setFkStarshipId(StarshipModel fkStarshipId) {
                this.fkStarshipId = fkStarshipId;
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
                if (!(object instanceof PeopleModel)) {
                        return false;
                }
                PeopleModel other = (PeopleModel) object;
                return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
        }

        @Override
        public String toString() {
                return "entity.PeopleModel[ id=" + id + " ]";
        }

}
