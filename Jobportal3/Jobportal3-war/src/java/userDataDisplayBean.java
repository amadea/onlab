/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Ami
 */
@Named(value = "userDataDisplayBean")
@SessionScoped
public class userDataDisplayBean implements Serializable {

    /**
     * Creates a new instance of userDataDisplayBean
     */
    public userDataDisplayBean() {
    }
    
}
