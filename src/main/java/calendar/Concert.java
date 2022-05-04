/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calendar;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Kamilė
 */

public class Concert extends Event{
    private ArrayList<String> performers = new ArrayList<>();
    private int numberOfSeats; 
    private double ticketPrice;
    
    public Concert(String title, String description, LocalDateTime dateTime, String place, 
            String performer, int numberOfSeats, double ticketPrice){
        super(title, description, dateTime, place);

        this.addPerformers(performer);
        this.numberOfSeats = numberOfSeats; 
        this.ticketPrice = ticketPrice;
    }
    
    public ArrayList getPerformer(){
        return this.performers;
    }
    
    public int getNumberOfSeats(){
        return this.numberOfSeats;
    }
    
    public double getTicketPrice(){
        return this.ticketPrice;
    }
    
    public void setPerformer(ArrayList<String> input){
        this.performers = input;
    }
    
    public void setNumberOfSeats(int input){
        this.numberOfSeats = input;
    }
    
    public void setTicketPrice(double input){
        this.ticketPrice = input;
    }
    
    
    public final void addPerformers(String performer){
       this.performers.add(performer);
    }
    
    public final void removePerformer(String performer){
        this.performers.remove(performer);
    }
    
    @Override
    public String message(){
        return "Will be a Concert";
    }
    
     @Override  //printing function
    public String toString(){  
        return super.toString() + "\nConcert ticket price: " + this.ticketPrice + 
                "\nConcert performers:\n\t" + this.performersToString();
                
    }  
    
    private String performersToString(){
        String performersNames = "";             
        for(int i = 0; i < this.performers.size(); i++){ 
            performersNames += this.performers.get(i); 
            performersNames += "\n\t";
        }
        
        return performersNames; 
    }
}