/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.Advertisement;
import ami.com.onlab.jobportal3.AdvertisementFacade;
import ami.com.onlab.jobportal3.Group;
import ami.com.onlab.jobportal3.Interest;
import ami.com.onlab.jobportal3.User;
import ami.com.onlab.jobportal3.UserFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Ami
 */

//serve jsf pages with data through userfacade
@Named(value = "userService")
@SessionScoped
public class UserService implements Serializable {
    
    @EJB
    private UserFacade userFacade;
    
    @EJB
    AdvertisementFacade advertisementFacade;
    
    
    private User user;
    
    
    private String password1;
    private String password2;
    
    //personal data
   // private long userID;
    /*
    private String address;
    private String birthDate;
    private String email;
    private String firstName;
    private String gender;
    private String lastName;
    private String nationality;
    //String password;
    private String phone;
    private String skype;
    private String userName;
    
    */

    
    
    
    private List<Interest> interests;
    private List<Group> groups;
    
    private List<Advertisement> visibleAdvertisements;

   

    /**
     * Creates a new instance of UserService
     */
   
    public UserService() {
    }
    
    //@PostConstruct
    public void initialize(long userID){
        
        //load user data from DB
        user = userFacade.getUser(userID);
        
        //advertisements
        visibleAdvertisements = new ArrayList<Advertisement>();
        visibleAdvertisements = advertisementFacade.findAllVisibleForUser(userID);
        
    }

    /**
     * @return the userID
     */
    
     public List<Advertisement> getVisibleAdvertisements() {
        return visibleAdvertisements;
    }

    public void setVisibleAdvertisements(List<Advertisement> visibleAdvertisements) {
        this.visibleAdvertisements = visibleAdvertisements;
    }
    
    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    public long getUserID() {
        return user.getUserID();
    }

    /**
     * @param userID the userID to set
     
    public void setUserID(long userID) {
        this.userID = userID;
    }*/
    
    //getter methods are called in the client interface

    public String getAddress() {
        return user.getAddress();
    }

    public void setAddress(String address) {
        user.setAddress(address);
    }

    public Date getBirthDate() {
        return user.getBirthDate();
    }

    public void setBirthDate(Date birthDate) {
        user.setBirthDate(birthDate);
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public void setFirstName(String firstName) {
        user.setFirstName(firstName);
    }

    public String getGender() {
        if(user.getGender()== User.Gender.FEMALE){
            return "female";
        }
        else{
            return "male";
        }
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("female")){
        user.setGender(User.Gender.FEMALE);
        }
        else{
           user.setGender(User.Gender.MALE); 
        }
    }

    public String getLastName() {
        return user.getLastName();
    }

    public void setLastName(String lastName) {
        user.setLastName(lastName);
    }

    public String getNationality() {
        if(user.getNationality()== User.Nationality.HUNGARIAN){
            return "hungarian";
        }
        return null;
       
    }

    public void setNationality(String nationality) {
       if(nationality.equals("hungarian")){
           user.setNationality(User.Nationality.HUNGARIAN);
       }
    }

    public String getPhone() {
        return user.getPhone();
    }

    public void setPhone(String phone) {
        user.setPhone(phone);
    }

    public String getSkype() {
        return user.getSkype();
    }

    public void setSkype(String skype) {
         user.setSkype(skype);
    }

    public String getUserName() {
        return user.getUserName();
    }

    public void setUserName(String userName) {
         user.setUserName(userName);
    }

    public List<Interest> getInterests() {
        return user.getInterests();
    }

    public void setInterests(List<Interest> interests) {
        user.setInterests(interests);
    }

    public List<Group> getGroups() {
        return user.getGroups();
    }

    public void setGroups(List<Group> groups) {
        user.setGroups(groups);
    }
    
   
    public void savePersonalData(){
        
        userFacade.edit(user);
    }
    
     public void saveNewPassword(){
        
        userFacade.edit(user);
    }
    
    
}
