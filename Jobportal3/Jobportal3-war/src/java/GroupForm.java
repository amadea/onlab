/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.Group;
import ami.com.onlab.jobportal3.User;
import static com.sun.xml.ws.api.message.Packet.Status.Request;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ami
 */
@Named(value = "groupForm")
@RequestScoped
public class GroupForm {
    
    String name;
    String email;
    String groupName;
    List<User> selectedMembers;
    List<Group> selectedGroups;
    String keyword;

    /**
     * Creates a new instance of GroupForm
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getSelectedMembers() {
        return selectedMembers;
    }

    public void setSelectedMembers(List<User> selectedMembers) {
        this.selectedMembers = selectedMembers;
    }

    public List<Group> getSelectedGroups() {
        return selectedGroups;
    }

    public void setSelectedGroups(List<Group> selectedGroups) {
        this.selectedGroups = selectedGroups;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    
    
    public GroupForm() {
    }
    
    public void createGroup(){
        
    }
    
     public void findMember(){
        
    }
     
       public void invite(){
        
    }
    
}
