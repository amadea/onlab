/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ami.onlab.jobportal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Ami
 */
@Entity
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    public enum Type{
    KERES, KINAL
    }
    enum PositionField{
        ADMINISZTRIO, BANKGAZDASAG, BETANiTOTT, EGESZSEGĂśGY, EGYEB, EPITOIPAR, ERTEKESITES, FIZIKAIMUNKA, GYARTAS, HR, INFORMATIKAI, JOGKOZIG, MERNOKI, MEZOGAZDASAG, OKTATAS, PENZUGY, SZAKMUNKA, SZALLITMANYOZAS, UGYFELSZOLGALAT, VENDEGLATAS
    }

    enum Education{
        MINDENFOK, ALTISK, SZAKISK, KOZEPISK, FOISK, EGYETEM
    }

    enum Region{
        ESZAKMO, ESZAKALF, DELALF, KOZEPMO, BUDAPEST, KOZEPDT, DELDT, NYUGATDT
    }

private Type type;
private String title;
private String positionName;
private String advText;
private PositionField positionField;
private Education education;
private Region region;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModified;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Advertisement)) {
            return false;
        }
        Advertisement other = (Advertisement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ami.jobportal.Advertisement[ id=" + id + " ]";
    }
    
    
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getAdvText() {
        return advText;
    }

    public void setAdvText(String advText) {
        this.advText = advText;
    }

    public PositionField getPositionField() {
        return positionField;
    }

    public void setPositionField(PositionField positionField) {
        this.positionField = positionField;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the lastModified
     */
    public Date getLastModified() {
        return lastModified;
    }

    /**
     * @param lastModified the lastModified to set
     */
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

  
}
