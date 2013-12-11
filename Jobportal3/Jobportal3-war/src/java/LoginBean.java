/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ami
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    
    private String adminUsername;
    private String adminPassword;

    private String username;
    private String password;
    private String loginMessage;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        adminUsername = "admin";
        adminPassword = "admin";
        loginMessage = null;
    }
    
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the loginMessage
     */
    public String getLoginMessage() {
        return loginMessage;
    }

    /**
     * @param loginMessage the loginMessage to set
     */
    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
    
    public String login(){
       if(username.equals(adminUsername) && password.equals(adminPassword)){
            return "index-in";
        }
       else{
        loginMessage = "Rossz felhasználó név vagy jelszó!";  
        return null;
       }
        
    }
    
}
