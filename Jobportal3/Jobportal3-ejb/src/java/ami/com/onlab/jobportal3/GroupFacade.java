/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ami.com.onlab.jobportal3;

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
public class GroupFacade extends AbstractFacade<Group> {
    @PersistenceContext(unitName = "Jobportal3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupFacade() {
        super(Group.class);
    }
    
    public Set<Group> findAllVisibleForUser(long userID){
        
        Set<Group> resultList = new HashSet<Group>();
        
        List<Group> groupList = em.createQuery("SELECT Group_ID FROM USERS_GROUPS WHERE USER_ID = 'userID'").getResultList();
        
        resultList.addAll(groupList);
        
        return resultList;
  
  }
    
     public Group getGroup(long groupID) {
        Group group = em.find(Group.class, groupID);
        return group;
    }
    
}
