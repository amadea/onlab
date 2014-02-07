/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ami.com.onlab.jobportal3.Advertisement;
import ami.com.onlab.jobportal3.AdvertisementFacade;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ami
 */
@Named(value = "advertisementDisplay")
@RequestScoped
public class AppliedAdvDisplay {
    
    private Advertisement advertisement;
    private AdvertisementFacade advertisementFacade;

    /**
     * Creates a new instance of AdvertisementDisplay
     */
    public AppliedAdvDisplay() {
    }
    
     @PostConstruct
   public void init() {
       Map<String,String> params;
       FacesContext fc = FacesContext.getCurrentInstance();
       params = fc.getExternalContext().getRequestParameterMap();
 
        String stringId = params.get("appliedlist");
        long longId = Long.parseLong(stringId); 
        
        setAdvertisement(advertisementFacade.getAdvertisement(longId));
   }

    
    public Advertisement getAdvertisement() {
        return advertisement;
    }

   
    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
