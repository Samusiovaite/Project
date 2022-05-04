/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calendar;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 *
 * @author Kamilė
 */

public class Event implements Serializable {
    protected String title;
    protected String description;
    protected LocalDateTime dateTime;
    protected String place;
    
    public Event() {}           //empty constructor
   
    public Event(String title, String description, LocalDateTime dateTime, String place){
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.place = place;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getDescription(){
        return this.description;
    }

    public LocalDateTime getDateTime(){
        return this.dateTime;
    }

    public String getPlace(){
        return this.place;
    }
    
    public void setTitle(String input){
        this.title = input;
    }

    public void setDescription(String input){
        this.description = input;
    }
    
    public void setDateTime(LocalDateTime input){
        this.dateTime = input;
    }
            
    public void setPlace(String input){
        this.place = input;
    }
    
    public final void postponeTheEvent(long days){
        this.dateTime = this.dateTime.plusDays(days);
    }

    public String message(){
        return "Will be an event";
    }
    
    @Override  //printing function
    public String toString(){  
        return "Event: " + this.title + "\nEvent description: " + this.description +
               "\nEvent date and Time: " + this.dateTime + "\nEvent place: " + this.place;
                
    }  
}