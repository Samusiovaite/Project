/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package note;

/**
 *
 * @author Kamilė
 */
public class ShoppingList extends SubjectList{
    private String title;
    private String description;
    private String storeName;
    
    public ShoppingList(String title, String description, String storeName){
        this.title = title;
        this.description = description; 
        this.storeName = storeName;
    }
    
    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description; 
    }
    
    public String getStoreName(){
        return this.storeName; 
    }
    
    
    public void setTitle(String input){
        this.title = input; 
    }

    public void setDescription(String input){
        this.description = input; 
    }
    
    public void setStoreName(String input){
        this.storeName = input; 
    }
    
    @Override
     public String toString(){
        return "Title: " + this.title + "\nDescription: " + this.description +
                "\nStore Name: " + this.storeName + "\nList:\t" + this.checkListToString();
    }
     
    private String checkListToString(){
        String checkListString = "";             
        for(int i = 0; i < this.checkList.size(); i++){
            if(this.checkList.get(i).getCheck()){
                checkListString += "+ ";
            }
            else checkListString += "- ";
            checkListString += this.checkList.get(i).getText(); 
            checkListString += "\n\t";
        }
        
        return checkListString; 
    }

}
