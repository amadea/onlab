/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ami.com.onlab.jobportal3;

import java.util.Iterator;
import java.util.List;
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
    
   public User findByUserName(String username){
       
       User user = new User();
       List<User> allUser = this.findAll();
       
       for(Iterator<User> it = allUser.iterator(); it.hasNext();){
           user = it.next();
           if(username.equals(user.getUserName()) ){
                return user;
           }
               
       }
       return user;
   }
  
    
}
