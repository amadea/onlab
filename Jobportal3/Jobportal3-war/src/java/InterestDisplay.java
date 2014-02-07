/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.Interest;
import ami.com.onlab.jobportal3.InterestFacade;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ami
 */
@Named(value = "interestDisplay")
@RequestScoped
public class InterestDisplay {
    
    private Interest interest;
    InterestFacade interestFacade;

    /**
     * Creates a new instance of InterestDisplay
     */
    public InterestDisplay() {
    }
    
   @PostConstruct
   public void init() {
       Map<String,String> params;
       FacesContext fc = FacesContext.getCurrentInstance();
       params = fc.getExternalContext().getRequestParameterMap();
 
        String stringId = params.get("interestlist");
        long longId = Long.parseLong(stringId); 
        
        setInterest(interestFacade.getInterest(longId));
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
    
    
}
