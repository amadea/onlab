/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.Advertisement;
import ami.com.onlab.jobportal3.AdvertisementFacade;
import ami.com.onlab.jobportal3.Group;
import ami.com.onlab.jobportal3.GroupFacade;
import ami.com.onlab.jobportal3.Interest;
import ami.com.onlab.jobportal3.User;
import ami.com.onlab.jobportal3.UserFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
   @EJB
    GroupFacade groupFacade;
   
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
   

    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    private List<Interest> interests;
    private List<Group> groups;
    
    private Set<Advertisement> visibleAdvertisements;
    private Set<User> visibleMembers;
    private Set<Group> visibleGroups;
    

   //advForm data
       
       private Advertisement.Type type;
       private Interest interest;
       
   //newAdvData
       
       private Advertisement newAdv;
   
   //results
       Set<Advertisement> advResultSet;
       
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
        setVisibleAdvertisements(advertisementFacade.findAllVisibleForUser(userID));
        setVisibleMembers(userFacade.findAllVisibleForUser(userID));
        setVisibleGroups(groupFacade.findAllVisibleForUser(userID));
        
    }

    /**
     * @return the userID
     */
    
     public Set<Advertisement> getVisibleAdvertisements() {
        return visibleAdvertisements;
    }

    public void setVisibleAdvertisements(Set<Advertisement> visibleAdvertisements) {
        this.visibleAdvertisements = visibleAdvertisements;
    }
    
    public Set<User> getVisibleMembers() {
        return visibleMembers;
    }

    public void setVisibleMembers(Set<User> visibleMembers) {
        this.visibleMembers = visibleMembers;
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
    
 
     /* @param userID the userID to set
     
    public void setUserID(long userID) {
        this.userID = userID;
    }*/
    
    //getter methods are called in the client interface

  

    public Date getBirthDate() {
        return user.getBirthDate();
    }

    public void setBirthDate(Date birthDate) {
        user.setBirthDate(birthDate);
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


    
   
    public void savePersonalData(){
        
        userFacade.edit(user);
    }
    
     public void saveCV(){
        
        userFacade.edit(user);
    }
    
    
     public void saveNewPassword(){
        
        userFacade.edit(user);
    }
    
     public void createInterest(){
         //forward to the interest creation panel
     }

    /**
     * @return the visibleGroups
     */
    public Set<Group> getVisibleGroups() {
        return visibleGroups;
    }

    /**
     * @param visibleGroups the visibleGroups to set
     */
    public void setVisibleGroups(Set<Group> visibleGroups) {
        this.visibleGroups = visibleGroups;
    }
    

    /**
     * @return the type
     */
    public Advertisement.Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Advertisement.Type type) {
        this.type = type;
    }

    /**
     * @return the interest
     */
    public Interest getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    /**
     * @return the newAdv
     */
    public Advertisement getNewAdv() {
        return newAdv;
    }

    /**
     * @param newAdv the newAdv to set
     */
    public void setNewAdv(Advertisement newAdv) {
        this.newAdv = newAdv;
    }
   
    
    
    public void createANewAdvertisement(){
        
        newAdv = new Advertisement();
    }
    
    public void createANewSearch(){
        
        type = null;
        interest = new Interest();
        
    }
    
   
    
    //post new adv.
    public void postAdvertisement(){
        
        //set the creation date and the creator
         newAdv.setCreationDate(new Date());
         newAdv.setCreator(user);
         
         //call the advertisementFacade method
         advertisementFacade.createAdvertisement(newAdv);
    }
    
    //start adv. search
     public void searchAdvertisement(){
         
         //call the advertisementFacade method
        advResultSet = advertisementFacade.selectAdvertisements(type, interest);
    }
     
     public Set<Advertisement> getAdvResultSet(){
         return advResultSet;
     }
}
