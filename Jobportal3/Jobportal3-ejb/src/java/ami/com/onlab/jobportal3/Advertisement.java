/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ami.com.onlab.jobportal3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Ami
 */
@Entity
@Table(name="ADVERTISEMENT")
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long advertisementID;

    
    public enum Type{
    LOOKING_FOR_A_JOB, EMPLOYEE_WANTED
    }
    enum PositionField{
ADMINISTRATIVE_OFFICEWORK, 
BANK_INSURANCE_STOCKEXCHANGE,
CONSTRUCTION_REALESTATE, 
CUSTOMERSERVICE_RELATIONS, 
EDUCATION_SCIENCE, 
ENGINEERING, 
ENVIRONMENT_AGRICULTURE, 
FINANCE_ACCOUNTING, 
FRESHGRADUATE_TRAINEEPROGRAMS, 
HEALTHCARE_BEAUTY, 
HOSPITALITY_TOURISM, 
HR_HUMANRESOURCES_LABOUR, 
ITDEVELOPMENT, 
ITOPERATIONS, 
LEGAL_PUBLICADMINISTRATION, 
MANUFACTURING_ENGINEERING, 
MARKETING_MEDIA_ART, 
PERSONAL_PROPERTYPROTECTION, 
PHYSICALLABOUR_UNSKILLEDLABOUR, 
PROJECTMANAGEMENT, 
SALES_TRADE_BUSINESS,  
SHAREDSERVICESCENTER,  
SHIPPING_LOGISTICS, 
SHOWBUSINESS,
SKILLEDWORK

    }
    

    enum Education{
        ALL, ELEMENTARY, VOCATIONAL, HIGHSCHOOL, COLLEGE, UNIVERSITY
    }

    enum Region{
        ALL, NORTH_HUNGARY, NORTH__ALFOLD, SOUTH_ALFOLD, MIDDLE_HUNGARY, BUDAPEST, MIDDLE_DUNANTUL, SOUTH_DUNANTUL, WEST_DUNANTUL
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
    
    @ManyToOne
    private User creator;
    
    
    @ManyToMany
    @JoinTable
    private List<User> candidates;                 //many-to-many
    
    
    @ManyToMany(mappedBy = "commonAdvertisements")
    private List<Group> visibleFor;                 //many-to-many
    
    public Advertisement(){
        candidates = new ArrayList<User>();
        visibleFor = new ArrayList<Group>();
    }
    
    public Long getId() {
        return advertisementID;
    }

    public void setId(Long advertisement_id) {
        this.advertisementID = advertisement_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (advertisementID != null ? advertisementID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertisement)) {
            return false;
        }
        Advertisement other = (Advertisement) object;
        if ((this.advertisementID == null && other.advertisementID != null) || (this.advertisementID != null && !this.advertisementID.equals(other.advertisementID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ami.jobportal.Advertisement[ id=" + advertisementID + " ]";
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<User> candidates) {
        this.candidates = candidates;
    }

    public List<Group> getVisibleFor() {
        return visibleFor;
    }

    public void setVisibleFor(List<Group> visibleFor) {
        this.visibleFor = visibleFor;
    }

  
    
}
