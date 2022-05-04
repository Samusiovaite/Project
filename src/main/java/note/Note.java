/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package note;

import java.io.Serializable;

/**
 *
 * @author Kamilė
 */
public class Note implements Serializable {
    private String name;
    private String description; 
    
    public Note(String noteName, String description){
        this.name = noteName;
        this.description = description; 
    }
    
    public String getName(){
        return this.name;
    }

    public String getdescription(){
        return this.description; 
    }
    
    public void setName(String input){
        this.name = input; 
    }

    public void setDescription(String input){
        this.description = input; 
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\nDescription: " + this.description;
    }
    
}
