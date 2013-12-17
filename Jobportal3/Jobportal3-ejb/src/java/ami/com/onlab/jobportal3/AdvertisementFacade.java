/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ami.com.onlab.jobportal3;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ami
 */
@Stateless
public class AdvertisementFacade extends AbstractFacade<Advertisement> {
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
    
    List<Advertisement> findAllVisibleForUser(long userID){
        
        List<Advertisement> resultList = new ArrayList<Advertisement>();
        List<Advertisement> allList = this.getAllAdvertisement();
        
        //find the groups of the user
         List<Group> groupList = em.createQuery("SELECT Group_ID FROM USERS_GROUPS WHERE USER_ID = 'userID'").getResultList();
       
       
        
        for(Advertisement adv : allList){
            
           //add to the resultList,if matches
            resultList.add(adv);
        }
        
        return resultList;
    }
    
}
