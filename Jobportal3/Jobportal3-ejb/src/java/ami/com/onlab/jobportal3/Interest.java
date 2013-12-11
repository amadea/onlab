/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ami.com.onlab.jobportal3;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Ami
 */
@Entity
@Table(name="INTEREST")
public class Interest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long interest_id;

    private String name;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModified;
    private String keyWord;
    private Advertisement.PositionField PositionField;
    private Advertisement.Education education;
    private Advertisement.Region region;
    
    

        public Long getId() {
        return interest_id;
    }

    public void setId(Long interest_id) {
        this.interest_id = interest_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interest_id != null ? interest_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interest)) {
            return false;
        }
        Interest other = (Interest) object;
        if ((this.interest_id == null && other.interest_id != null) || (this.interest_id != null && !this.interest_id.equals(other.interest_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ami.jobportal.Interest[ id=" + interest_id + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * @return the keyWord
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * @param keyWord the keyWord to set
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * @return the PositionField
     */
    public Advertisement.PositionField getPositionField() {
        return PositionField;
    }

    /**
     * @param PositionField the PositionField to set
     */
    public void setPositionField(Advertisement.PositionField PositionField) {
        this.PositionField = PositionField;
    }

    /**
     * @return the education
     */
    public Advertisement.Education getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(Advertisement.Education education) {
        this.education = education;
    }

    /**
     * @return the region
     */
    public Advertisement.Region getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(Advertisement.Region region) {
        this.region = region;
    }

    /**
     * @return the PositionField
     */
    
    
}
