/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.User;
import ami.com.onlab.jobportal3.UserFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ami
 */
@Named(value = "loginBean")
@ManagedBean 
@RequestScoped
public class LoginBean {
    
    @EJB(name="UserService")
    private UserService userService;
       
    @EJB
    private UserFacade userFacade;
    
    private String adminUserName;
    private String adminPassword;

    private String userName;
    private String password;
    private String loginMessage;
    
    User user = new User();
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        //adminUsername = "admin";
        //adminPassword = "admin";
        //loginMessage = null;
        
        
    }
    
   
    
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
        
        //find user by id
        //List<User> usersList = new ArrayList<User>;
        //List<User> usersList = userFacade.findAll();
        //findByUsername
        user = userFacade.findByUserName(userName);
        String passwordFromDB = user.getPassword();
        
      /* if(userName.equals(adminUsername) && password.equals(adminPassword)){
            return "index-in";
        }
       else{
        loginMessage = "Rossz felhasználó név vagy jelszó!";  
        return null;
       }*/
        
        if(password.equals(passwordFromDB)){
            //find the userID, and set in the sessionBean
            long id = user.getUserID();
            userService.initialize(id);
            
            return "main.xhtml";
        }
       else{
        loginMessage = "Rossz felhasználó név vagy jelszó!";  
        return null;
       }
        
    }
    
}
