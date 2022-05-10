/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contact;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Kamil?
 */

public class Contact implements Cloneable, Serializable {
    private String firstName;
    private String lastName;
    private static String phoneNumberPrefix = "+370";
    private String phoneNumber;
    private final String emailPostfix = "@gmail.com";
    private String email;
    private String dateOfBirthday;
    
    private Address address; 
 
    //constructor, the first method
    public Contact(String firstName, String lastName, String phoneNumber, 
                   String email, String dateOfBirthday, Address address){
        
        //assigns constructor arguments to each value
        this.firstName = firstName;
        this.lastName  = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
        this.address = address;
    }
    
    public Contact(Contact contact) {
        this.firstName = contact.firstName;
        this.lastName = contact.lastName;
        this.phoneNumber = contact.phoneNumber;
        this.email = contact.email;
        this.dateOfBirthday = contact.dateOfBirthday; 
        //this.address = contact.address; //shallow
        try {
            this.address = (Address) contact.address.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Functions that return values to a contact-type variable 
    //The get method returns the value of the variable
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getPhoneNumberPrefix(){
        return this.phoneNumberPrefix;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    //overloaded method
    public String getPhoneNumber(String input){
        return this.phoneNumber + " " + input;
    }
    
    public String getEmailPostfix(){
        return this.emailPostfix;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getDateOfBirthday(){
        return this.dateOfBirthday;
    }
    
    public Address getAddress(){
        return address;
    }
    
   public void setAddress(Address address){
       this.address = address;
   }
   
    //The set method assigns a value to the variable.
    public void setFirstName(String input){
        this.firstName = input;
    }
    
    public void setLastName(String input){
        this.lastName = input;
    }   
    
    public void setPhoneNumberPrefix(String input){
        this.phoneNumberPrefix = input;
    }
     
    public void setPhoneNumber(String input){
        this.phoneNumber = input;
    }
    
    public void setEmail(String input){
        this.email = input;
    }
     
    public void setDateOfBirthday(String input){
        this.dateOfBirthday = input;
    }
    
    private int calculateAge(){
        LocalDate dateOfBirth = LocalDate.parse(this.dateOfBirthday);
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        //return (Contact)super.clone(); //Shallow copy
        Contact contact = (Contact)super.clone();
        contact.address = (Address)super.clone();
        return contact;
    }
    
    //Printing function
    @Override
    public String toString(){
        return "Contact: \n" + "First Name: " + this.firstName + "\nLast Name: " + this.lastName + 
        "\nPhone Number: " + this.phoneNumberPrefix + this.phoneNumber + "\nEmail Address: " + 
        this.email + this.emailPostfix + "\nDOB: " + this.dateOfBirthday + "\nAddress: " + address.toString();
    }
}
