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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Ami
 */
@Entity
@Table(name="USERS")
@NamedQueries(
        @NamedQuery(name = "user.getAll", query="SELECT e FROM User e")
)
public class User implements Serializable {
    
    public enum Gender{
    FEMALE, MALE
    }

    public enum Nationality{
    HUNGARIAN
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;
    
    
private String userName;
private String password;
private String email;
private String firstName;
private String lastName;
@Temporal(javax.persistence.TemporalType.DATE)
private Date birthDate;
private Gender gender;
private Nationality nationality;
private String address;
private String phone;
private String skype;
private byte[] CVFile;
private byte[] picture;

@OneToMany(mappedBy = "creator")
private List<Advertisement> createdAdvertisements;  //one-to-many, bidirectional
@OneToMany
private List<Interest> interests;           //one-to-many, unidirectional 

@ManyToMany
@JoinTable
private List<Group> groups;                //many-to-many

@ManyToMany(mappedBy = "candidates")
private List<Advertisement> appliedAdvertisements;  //many-to-many

    public User(){
    groups = new ArrayList<Group>(); 
    appliedAdvertisements = new ArrayList<Advertisement>();
    }

    public Long getId() {
        return userID;
    }

    public void setId(Long user_id) {
        this.userID = user_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ami.jobportal.User[ id=" + userID + " ]";
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public byte[] getCVFile() {
        return CVFile;
    }

    public void setCVFile(byte[] CVFile) {
        this.CVFile = CVFile;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public List<Advertisement> getCreatedAdvertisements() {
        return createdAdvertisements;
    }

    public void setCreatedAdvertisements(List<Advertisement> createdAdvertisements) {
        this.createdAdvertisements = createdAdvertisements;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Advertisement> getAppliedAdvertisements() {
        return appliedAdvertisements;
    }

    public void setAppliedAdvertisements(List<Advertisement> appliedAdvertisements) {
        this.appliedAdvertisements = appliedAdvertisements;
    }
    
    
    
}
