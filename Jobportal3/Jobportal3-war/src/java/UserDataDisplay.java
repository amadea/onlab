/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.Advertisement;
import ami.com.onlab.jobportal3.AdvertisementFacade;
import ami.com.onlab.jobportal3.Group;
import ami.com.onlab.jobportal3.GroupFacade;
import ami.com.onlab.jobportal3.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import ami.com.onlab.jobportal3.UserFacade;
import java.util.Set;
import javax.ejb.EJB;

/**
 *
 * @author Ami
 */
@Named(value = "userDataDisplay")
@SessionScoped
public class UserDataDisplay implements Serializable {

    @EJB
    private UserFacade userFacade;
   @EJB
    AdvertisementFacade advertisementFacade;
   @EJB
    GroupFacade groupFacade;
   
     private User user;
     
    private Set<Advertisement> createdAdvertisements;
    private Set<Advertisement> appliedAdvertisements;
    private Set<User> visibleMembers;
    private Set<Group> visibleGroups;
    
    /**
     * Creates a new instance of userDataDisplayBean
     */
    
    
    public UserDataDisplay() {
    }
    
    public void initialize(long userID){
        
        //load user data from DB
        setUser(userFacade.getUser(userID));
        
        //advertisements 
        createdAdvertisements.addAll(user.getCreatedAdvertisements());
        appliedAdvertisements.addAll(user.getAppliedAdvertisements());
        setVisibleMembers(userFacade.findAllVisibleForUser(userID));
        setVisibleGroups(groupFacade.findAllVisibleForUser(userID));
        
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the createdAdvertisements
     */
    public Set<Advertisement> getCreatedAdvertisements() {
        return createdAdvertisements;
    }

    /**
     * @param createdAdvertisements the createdAdvertisements to set
     */
    public void setCreatedAdvertisements(Set<Advertisement> createdAdvertisements) {
        this.createdAdvertisements = createdAdvertisements;
    }

    /**
     * @return the appliedAdvertisements
     */
    public Set<Advertisement> getAppliedAdvertisements() {
        return appliedAdvertisements;
    }

    /**
     * @param appliedAdvertisements the appliedAdvertisements to set
     */
    public void setAppliedAdvertisements(Set<Advertisement> appliedAdvertisements) {
        this.appliedAdvertisements = appliedAdvertisements;
    }

    /**
     * @return the visibleMembers
     */
    public Set<User> getVisibleMembers() {
        return visibleMembers;
    }

    /**
     * @param visibleMembers the visibleMembers to set
     */
    public void setVisibleMembers(Set<User> visibleMembers) {
        this.visibleMembers = visibleMembers;
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
    
}
