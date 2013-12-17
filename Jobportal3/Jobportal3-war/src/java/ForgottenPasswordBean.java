/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.User;
import ami.com.onlab.jobportal3.UserFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
//import javax.mail.*;

/**
 *
 * @author Ami
 */
@Named(value = "forgottenPasswordBean")
//@Dependent
@RequestScoped
public class ForgottenPasswordBean {
    
    @EJB
    private UserFacade userFacade;

   
   private String message;
   private String userName;
   private String email;
    
     /**
     * Creates a new instance of ForgottenPasswordBean
     */
    public ForgottenPasswordBean() {
    }
    

    public String getUserName() {
        return userName;
    }

    public void setEmailToSend(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
   
    public void sendEmail(){
        //find the given email address in the database
        User user = userFacade.findByUserName(userName);
        
        
        //if user is not find, message will shown
        if(user == null){
        message = "Nincs ilyen felhasználónevű felhasználó!";
        }
        else{
        //else, email will be sent
        email = user.getEmail();
        //clling email sener method
        
        message = "Az új jelszó el lett küldve a felhasználóhoz tartozó email címre";
        }
            
    }
    
}
