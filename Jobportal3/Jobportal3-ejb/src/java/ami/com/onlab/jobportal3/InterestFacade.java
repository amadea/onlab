/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ami.com.onlab.jobportal3;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ami
 */
@Stateless
public class InterestFacade extends AbstractFacade<Interest> {
    @PersistenceContext(unitName = "Jobportal3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InterestFacade() {
        super(Interest.class);
    }
    
    public Interest getInterest(long interestID) {
        Interest interest = em.find(Interest.class, interestID);
        return interest;
    }
    
}
