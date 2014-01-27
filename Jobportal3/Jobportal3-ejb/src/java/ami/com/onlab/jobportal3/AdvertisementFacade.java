/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ami.com.onlab.jobportal3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ami
 */
@Stateless
public class AdvertisementFacade extends AbstractFacade<Advertisement> {
    
    private Set<Advertisement> visibleAdvertisements;
    
    @PersistenceContext(unitName = "Jobportal3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdvertisementFacade() {
        super(Advertisement.class);
    }
    
     public List<Advertisement> getAllAdvertisement() {
        return em.createNamedQuery("advertisement.getAll").getResultList();
    }
    /* 
    public Set<Advertisement> getCreatedAdvertisements(){
        
    }
    
    public Set<Advertisement> getAppliedAdvertisements(){
        
    }*/
    
    public Set<Advertisement> findAllVisibleForUser(long userID){
        
        Set<Advertisement> resultList = new HashSet<Advertisement>();
        //List<Advertisement> allList = this.getAllAdvertisement();
        
        //find the groups where the user is a member
        List<Group> groupList = em.createQuery("SELECT Group_ID FROM USERS_GROUPS WHERE USER_ID = 'userID'").getResultList();
     
        for(Group g : groupList){
            
            //get the commonAdvertisments set and add it to the resultList
            Set<Advertisement> advSet = g.getCommonAdvertisements();
          
            resultList.addAll(advSet);
        }
        
        visibleAdvertisements = resultList;
        
        return resultList;
    }
    
    public Set<Advertisement> selectAdvertisements(Advertisement.Type type, Interest interest){
        
        Set<Advertisement> resultList = new HashSet<Advertisement>();
        
        //type
        for(Advertisement a:visibleAdvertisements){
            if(a != null && a.getType()!= type){
                      a = null;
                  }
        }
        
          //education
          if(interest.getEducation()!=null){
              for(Advertisement a:visibleAdvertisements){
                  if(a != null && a.getEducation()!=interest.getEducation()){
                      a = null;
                  }
              }  
          }
            
          //positionField
          if(interest.getPositionField()!=null){
                for(Advertisement a:visibleAdvertisements){
                  if(a != null && a.getPositionField()!=interest.getPositionField()){
                      a = null;
                  }
              }
          }
            
          //region
          if(interest.getRegion()!=null){
                for(Advertisement a:visibleAdvertisements){
                  if(a != null && a.getRegion()!=interest.getRegion()){
                      a = null;
                  }
              }
          }
          
          //keyword
           if(interest.getKeyWord()!=null){
                for(Advertisement a:visibleAdvertisements){
                 
                      //search in title, positionName and advText
                  if(a != null && 
                     !a.getTitle().toLowerCase().contains(interest.getKeyWord().toLowerCase()) && 
                     !a.getPositionName().toLowerCase().contains(interest.getKeyWord().toLowerCase()) &&
                     !a.getAdvText().toLowerCase().contains(interest.getKeyWord().toLowerCase())  ){
                        a = null;
                  }

                  
              }
          }
           
          //creationDateInterval
          if(interest.getCreationDateInterval()!=null && interest.getCreationDateInterval()!=Interest.DateInterval.ALL){
              for(Advertisement a:visibleAdvertisements){
                long diffMilisec = (new java.util.Date()).getTime() - a.getCreationDate().getTime();
                switch(interest.getCreationDateInterval()){
                    case LAST_DAY: if(diffMilisec>1000 * 60 * 60 * 24){a = null;}
                        break;
                    case LAST_WEEK: if(diffMilisec>1000 * 60 * 60 * 24 * 7){a = null;}
                        break;
                    case LAST_MONTH: if(diffMilisec>1000 * 60 * 60 * 24*30){a = null;}
                        break;
                }
              }
          }
          
            
        //delete the null elements
         resultList.removeAll(Collections.singleton(null));
                
      /*  if(interest.getKeyWord()!=null){
            Set<Advertisement> tempList = visibleAdvertisements;
            resultList.addAll(tempList);
        }
        
         if(interest.getPositionField()!=null){
            Set<Advertisement> tempList = visibleAdvertisements;
            resultList.addAll(tempList);
        }*/
        
        return resultList;
        
    }
    
}
