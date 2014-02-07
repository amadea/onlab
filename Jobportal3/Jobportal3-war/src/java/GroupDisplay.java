/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.Group;
import ami.com.onlab.jobportal3.GroupFacade;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ami
 */
@Named(value = "groupDisplay")
@RequestScoped
public class GroupDisplay {

    private Group group;
    private GroupFacade groupFacade;

    /**
     * Creates a new instance of groupDisplay
     */
    public GroupDisplay() {
    }
    
    @PostConstruct
   public void init() {
       Map<String,String> params;
       FacesContext fc = FacesContext.getCurrentInstance();
       params = fc.getExternalContext().getRequestParameterMap();
 
        String stringId = params.get("grouplist");
        long longId = Long.parseLong(stringId); 
        
        setGroup(groupFacade.getGroup(longId));
   }

    
    public Group getGroup() {
        return group;
    }

   
    public void setGroup(Group group) {
        this.group = group;
    }
    
}
