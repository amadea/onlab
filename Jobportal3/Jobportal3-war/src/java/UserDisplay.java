/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.User;
import ami.com.onlab.jobportal3.UserFacade;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ami
 */
@Named(value = "userDisplay")
@RequestScoped
public class UserDisplay {
    
    private User user;
    private UserFacade userFacade;

    /**
     * Creates a new instance of UserDisplay
     */
    public UserDisplay() {
    }
    
    
    @PostConstruct
   public void init() {
       Map<String,String> params;
       FacesContext fc = FacesContext.getCurrentInstance();
       params = fc.getExternalContext().getRequestParameterMap();
 
        String stringId = params.get("memberlist");
        long longId = Long.parseLong(stringId); 
        
        setUser(userFacade.getUser(longId));
   }

    
    public User getUser() {
        return user;
    }

   
    public void setUser(User user) {
        this.user = user;
    }
}
