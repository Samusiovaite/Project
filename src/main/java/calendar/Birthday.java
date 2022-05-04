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
public class Birthday extends Event{
    private String peopleNameAndSurname;
    private int age;
    private ArrayList<String> giftNames = new ArrayList<>(); 
    
    public Birthday(String title, String description, LocalDateTime dateTime, String place, 
            String peopleNameAndSurname, int age, String gift){
        super(title, description, dateTime, place);

        this.peopleNameAndSurname = peopleNameAndSurname;
        this.age = age;
        this.addGift(gift);
    }
    
    public String getPeopleNameAndSurname(){
        return this.peopleNameAndSurname;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public ArrayList getGiftName(){
        return this.giftNames;
    }
    
    public void setPeopleNameAndSurname(String input){
        this.peopleNameAndSurname = input;
    }

    public void setAge(int input){
        this.age = input;
    }
    
    public void setGiftName(ArrayList<String> input){
        this.giftNames = input;
    }
    
    public final void addGift(String gift){
       this.giftNames.add(gift);
    }
    
    public final void removeGift(String gift){
        this.giftNames.remove(gift);
    }
    
    @Override
    public String message(){
        return "Will be a Birthday";
    }
    
    @Override
    public String toString(){
         return super.toString() + "\nName and Surname of the birthday person: "
                + this.peopleNameAndSurname + "\nAge is: " + this.age + "\nGifts:\t" 
                + this.giftNamesToString();
    }
    
    private String giftNamesToString(){
        String names = "";      
        for(int i = 0; i < this.giftNames.size(); i++){ 
            names += this.giftNames.get(i); 
            names += "\n\t";
        }
        
        return names;
    }
}
    
   