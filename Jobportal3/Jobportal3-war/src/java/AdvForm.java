/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ami.com.onlab.jobportal3.Interest;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;



/**
 *
 * @author Ami
 */
@Named(value = "advForm")
//@Dependent
//@ConversationScoped()
public class AdvForm implements Serializable{
    
    
   // @Inject private Conversation conversation;
    
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
    private boolean addCV;
 
    private Interest choosedInterest;

  private String newTitle;
   private String newPosName;
   
    
    private List<String> positions;
    private List<String> regions;
    private List<String> educations;
    private List<String> intervals;
    
    private String position;

    
    private String region;
    private String education;
    private String interval;
    
    private String keyword;
    private boolean saveAsInterest;
     boolean addInterest;

    

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
    
  /*  @PostConstruct
    private void initialize() {
   conversation.begin();
    }*/
    
    
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

    public boolean isAddCV() {
        return addCV;
    }

    public void setAddCV(boolean addCV) {
        this.addCV = addCV;
    }
    
    
    
     
     
     
    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public List<String> getEducations() {
        return educations;
    }

    public void setEducations(List<String> educations) {
        this.educations = educations;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<String> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<String> intervals) {
        this.intervals = intervals;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
/*
    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }*/

    public boolean isSaveAsInterest() {
        return saveAsInterest;
    }

    public void setSaveAsInterest(boolean saveAsInterest) {
        this.saveAsInterest = saveAsInterest;
    }
    
    public boolean isAddInterest() {
        return addInterest;
    }

    public void setAddInterest(boolean addInterest) {
        this.addInterest = addInterest;
    }
    

    public String getNewPosName() {
        return newPosName;
    }

    public void setNewPosName(String newPosName) {
        this.newPosName = newPosName;
    }
  

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }
 
    
    //navigate by operation type
    public String next1(){
        if(operationType.equalsIgnoreCase("new")){
            
            return "../../adverts2";
        }
        return "../../adverts1";
    }
    
    //navigate by search type
     public String next2(){
        if(searchType.equalsIgnoreCase("worker")){
            
            return "../../adverts1_2";
        }
        return "../../adverts1_1";
    }
    
     //navigate by source type
     public String next3(){
        if(sourceType.equalsIgnoreCase("interest")){
            
            return "../../adverts1_1_2";
        }
        return "../../adverts1_1_1";
    }
     
     //send new adv.
      public String sendAdvertisement(){
         return "../../advertsended";
     }
     
     //show results
     public String showResults(){
         return "../../advertsresults";
     }
    
    
    /* 
    
    //after adv_choose
    public void step1(){
 
        setAdvChooseVisible(false);
        //start();
        
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
    
  }*/
}
