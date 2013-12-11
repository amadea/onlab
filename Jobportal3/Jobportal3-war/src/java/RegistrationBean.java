/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ami
 */
@Named(value = "registrationBean")
@FacesValidator(value="passwordValidator")
@ViewScoped
public class RegistrationBean implements Validator{

    private String lastName;
    private String firstName;
    private String email;
    private String username;
    private String password1;
    private String password2;
    private String securePassword;
    private String passwordMessage;
    private String registerMessage;
    private boolean passwordOK;
    /**
     * Creates a new instance of registrationBean
     */
    public RegistrationBean() {
        passwordOK = false;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
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
     * @return the password1
     */
    public String getPassword1() {
        return password1;
    }

    /**
     * @param password1 the password1 to set
     */
    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    /**
     * @return the password2
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * @param password2 the password2 to set
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    /**
     * @return the passwordMessage
     */
    public String getPasswordMessage() {
        return passwordMessage;
    }

    /**
     * @param passwordMessage the passwordMessage to set
     */
    public void setPasswordMessage(String passwordMessage) {
        this.passwordMessage = passwordMessage;
    }

    /**
     * @return the registerMessage
     */
    public String getRegisterMessage() {
        return registerMessage;
    }

    /**
     * @param registerMessage the registerMessage to set
     */
    public void setRegisterMessage(String registerMessage) {
        this.registerMessage = registerMessage;
    }
    
    public void register(){
        if(passwordOK == true){
           
           startRegProcess();
    
        }
        else 
            setRegisterMessage("A regisztráció sikertelen!");
        
    }
    
    public void startRegProcess(){
        setRegisterMessage("A regisztráció sikeres!");
    }
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIInput passwordComponent = (UIInput) component.getAttributes().get("confirm");
        String password = (String) passwordComponent.getValue();
        String confirmPassword = (String) value;

        if (confirmPassword != null && !confirmPassword.equals(password)) {
            throw new ValidatorException(new FacesMessage(
                "A két jelszónak meg kell egyeznie!"));
        }
        else{
            
            passwordOK = true;
        }
    }
}

