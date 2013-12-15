/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ami.com.onlab.jobportal3;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ami
 */
@Stateless
@LocalBean
public class UserDao {
    @PersistenceContext
    private EntityManager em;

    public void addUser(User user) {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void deleteUser(String userName) {
    }

    public void editUser(User user) {
    }

    public User getUser(String userName) {
        return null;
    }

    public List<User> getAllUser() {
        return em.createNamedQuery("User.getAll").getResultList();
    }
    
    
    
    
}
