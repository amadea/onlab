/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

   private String emailToSend;
   private String message;
    
     /**
     * Creates a new instance of ForgottenPasswordBean
     */
    public ForgottenPasswordBean() {
    }
    

    public String getEmailToSend() {
        return emailToSend;
    }

    public void setEmailToSend(String emailToSend) {
        this.emailToSend = emailToSend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
   
    public void sendEmail(){
        //find the given email address in the database
        
        
        //if email is not find, message will shown
        message = "Nincs ilyen email címmel rendelkező felhasználó!";
        
        //else, email will be sent
      
            message = "Az új jelszó el lett küldve a megadott email címre";
            
            
    }
    
}
