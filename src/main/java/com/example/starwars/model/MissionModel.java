package com.example.starwars.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CRISTIAN
 */
@Entity
@Table(name = "mission", catalog = "starwars", schema = "")
@NamedQueries({
        @NamedQuery(name = "MissionModel.findAll", query = "SELECT m FROM MissionModel m"),
        @NamedQuery(name = "MissionModel.findById", query = "SELECT m FROM MissionModel m WHERE m.id = :id"),
        @NamedQuery(name = "MissionModel.findByBeginDate", query = "SELECT m FROM MissionModel m WHERE m.beginDate = :beginDate"),
        @NamedQuery(name = "MissionModel.findByEndDate", query = "SELECT m FROM MissionModel m WHERE m.endDate = :endDate"),
        @NamedQuery(name = "MissionModel.findByCrew", query = "SELECT m FROM MissionModel m WHERE m.crew = :crew")})
public class MissionModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "beginDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginDate;
    @Basic(optional = false)
    @Column(name = "endDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "crew", nullable = false)
    private int crew;
    @JoinColumn(name = "fk_people_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PeopleModel fkPeopleId;
    @JoinColumn(name = "fk_planets_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PlanetsModel fkPlanetsId;
    @JoinColumn(name = "fk_starship_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private StarshipModel fkStarshipId;

    public MissionModel() {
    }

    public MissionModel(Long id) {
        this.id = id;
    }

    public MissionModel(Long id, Date beginDate, Date endDate, int crew) {
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public PeopleModel getFkPeopleId() {
        return fkPeopleId;
    }

    public void setFkPeopleId(PeopleModel fkPeopleId) {
        this.fkPeopleId = fkPeopleId;
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
        if (!(object instanceof MissionModel)) {
            return false;
        }
        MissionModel other = (MissionModel) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "entity.MissionModel[ id=" + id + " ]";
    }

}
