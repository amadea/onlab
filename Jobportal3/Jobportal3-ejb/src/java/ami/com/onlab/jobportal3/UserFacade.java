/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ami.com.onlab.jobportal3;

import java.util.HashSet;
import java.util.Iterator;
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
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "Jobportal3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
  public User findByUserName(String userName){
        
       User user = new User();
       List<User> allUser = this.findAll();
       
       for(Iterator<User> it = allUser.iterator(); it.hasNext();){
           user = it.next();
           if(userName.equals(user.getUserName()) ){
                return user;
           }
               
       }
       return user;
   }
   
    public void addUser(User user) {
        em.persist(user);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void deleteUser(long userID) {
        User user = this.getUser(userID);
        em.remove(user);
    }

    public void editUser(User user) {
        em.merge(user);
    }

    public User getUser(long userID) {
        User user = em.find(User.class, userID);
        return user;
    }

    public List<User> getAllUser() {
        return em.createNamedQuery("User.getAll").getResultList();
    }
 
  public Set<User> findAllVisibleForUser(long userID){
      
      Set<User> resultList = new HashSet<User>();
      
      List<Group> groupList = em.createQuery("SELECT Group_ID FROM USERS_GROUPS WHERE USER_ID = 'userID'").getResultList();
      
      for(Group g : groupList){
          resultList.addAll(g.getMembers());
      }
        
        return resultList;
  
  }
    
}
