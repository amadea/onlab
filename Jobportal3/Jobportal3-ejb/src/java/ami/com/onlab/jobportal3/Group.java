/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ami.com.onlab.jobportal3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Ami
 */
@Entity
@Table(name="GROUPS")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupID;
    
    
private String name;
private String description;
private byte[] picture;

@ManyToMany(mappedBy = "groups")
private List<User> members;                 //many-to-many

@ManyToMany
@JoinTable
private List<Advertisement> commonAdvertisements;                 //many-to-many

    public Group(){
    members = new ArrayList<User>();
    commonAdvertisements = new ArrayList<Advertisement>();
    }


    public Long getId() {
        return groupID;
    }

    public void setId(Long id) {
        this.groupID = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupID != null ? groupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Group)) {
            return false;
        }
        Group other = (Group) object;
        if ((this.groupID == null && other.groupID != null) || (this.groupID != null && !this.groupID.equals(other.groupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ami.jobportal.Group[ id=" + groupID + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Advertisement> getCommonAdvertisements() {
        return commonAdvertisements;
    }

    public void setCommonAdvertisements(List<Advertisement> commonAdvertisements) {
        this.commonAdvertisements = commonAdvertisements;
    }
    
}
