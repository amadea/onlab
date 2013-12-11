/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.Interest;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;



/**
 *
 * @author Ami
 */
@Named(value = "advForm")
//@Dependent
@ConversationScoped()
public class AdvForm implements Serializable{
    
    
    private @Inject Conversation conversation;
    
   // ListAdvertisements list = new ListAdvertisements();
    
    private String operationType;       //új vagy keresés
    private String searchType;          //keres vagy kínál hírdetés
    private String sourceType;          //kitölti az űrlapot vagy érdeklőséi kör alapján
    
    private boolean advChooseVisible;
    private boolean advSearch1Visible;
    private boolean advSearch2Visible;
    private boolean advSearch3aVisible;
    private boolean advSearch3bVisible;
    private boolean advSearch4aVisible;

  
    private boolean advNewVisible;
    
    
    Interest choosedInterest;

  
 
    /**
     * Creates a new instance of AdvForm
     */
    public AdvForm() {
        
    
   // choosedInterest = new Interest();
        
    operationType = "search";       
    searchType = "job";  
    sourceType = "new";   
    
     advChooseVisible = true;
    
    advSearch1Visible = false;
    advSearch2Visible = false;
    advSearch3aVisible = false;
    advSearch3bVisible = false;
    advSearch4aVisible = false;
    advNewVisible = false;
    }
    
    
     public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    /**
     * @return the searchType
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * @param searchType the searchType to set
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * @return the sourceType
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * @param sourceType the sourceType to set
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }



    /**
     * @return the advChooseVisible
     */
    public boolean isAdvChooseVisible() {
        return advChooseVisible;
    }

    /**
     * @param advChooseVisible the advChooseVisible to set
     */
    public void setAdvChooseVisible(boolean advChooseVisible) {
        this.advChooseVisible = advChooseVisible;
        
    }
    
    
    /**
     * @return the advSearchVisible
     */
    public boolean isAdvSearch1Visible() {
        return advSearch1Visible;
    }

    /**
     * @param advSearchVisible the advSearchVisible to set
     */
    public void setAdvSearch1Visible(boolean advSearchVisible) {
        this.advSearch1Visible = advSearchVisible;
        
    }

    /**
     * @return the advNewVisible
     */
    public boolean isAdvNewVisible() {
        return advNewVisible;
    }

    /**
     * @param advNewVisible the advNewVisible to set
     */
    public void setAdvNewVisible(boolean advNewVisible) {
        this.advNewVisible = advNewVisible;
         
    }

    public boolean isAdvSearch2Visible() {
        return advSearch2Visible;
    }

    public void setAdvSearch2Visible(boolean advSearch2Visible) {
        this.advSearch2Visible = advSearch2Visible;
    }

    public boolean isAdvSearch3aVisible() {
        return advSearch3aVisible;
    }

    public void setAdvSearch3aVisible(boolean advSearch3aVisible) {
        this.advSearch3aVisible = advSearch3aVisible;
    }

    public boolean isAdvSearch3bVisible() {
        return advSearch3bVisible;
    }

    public void setAdvSearch3bVisible(boolean advSearch3bVisible) {
        this.advSearch3bVisible = advSearch3bVisible;
    }
    
      public boolean isAdvSearch4aVisible() {
        return advSearch4aVisible;
    }

    public void setAdvSearch4aVisible(boolean advSearch4aVisible) {
        this.advSearch4aVisible = advSearch4aVisible;
    }
    
    
      public Interest getChoosedInterest() {
        return choosedInterest;
    }

    public void setChoosedInterest(Interest choosedInterest) {
        this.choosedInterest = choosedInterest;
    }
    
    
    //after adv_choose
    public void step1(){
 
        setAdvChooseVisible(false);
        start();
        
        switch(operationType){
            case "search":  setAdvSearch1Visible(true);
                            break;
            case "new":     setAdvNewVisible(true);
                            break;
        }
    
    }

      public void step2(){
 
        setAdvSearch1Visible(false);
        
        switch(searchType){
            case "worker":  setAdvSearch3bVisible(true);
                            break;
            case "job":     setAdvSearch2Visible(true);
                            break;
        }
    
    }
      
      public void step3(){
 
        setAdvSearch2Visible(false);
        
        switch(sourceType){
            case "new":  setAdvSearch3aVisible(true);
                            break;
            case "interest":   setAdvSearch4aVisible(true);
                            break;
        }
    
    }
    
    public void stepLast(){
  
       //list.showResults();
       end();
    
    }
      
      public void start() {
    conversation.begin();
    
  }
  
  public void end() {
    conversation.end();
    
  }
}
