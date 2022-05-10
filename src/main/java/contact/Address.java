/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contact;

import java.io.Serializable;

/**
 *
 * @author Kamilė
 */
public class Address implements Cloneable, Serializable {
    private String country; 
    private String city; 
    private String streetName; 
    private int houseOrApartamentNumber; 
    private long zipCode; 
    
    public Address(String country, String city, String streetName, int houseOrApartamentNumber,
                   long zipCode){
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.houseOrApartamentNumber = houseOrApartamentNumber;
        this.zipCode = zipCode;
    }
    
    public String getCoutry(){
        return country;
    }
    
    public String getCity(){
        return city;
    }
    
    public String getStreetName(){
        return streetName;
    }
    
    public int getHouseOrApartamentNumber(){
        return houseOrApartamentNumber;
    }
    
    public long getZipCode(){
        return zipCode;
    }
    
    public void setCountry(String input){
        this.country = input;
    }
    
    public void setCity(String input){
        this.city = input;
    }
    
    public void setStreetName(String input){
        this.streetName = input;
    }
    
    public void setHouseOrApartamentNumberString (int input){
        this.houseOrApartamentNumber = input;
    }
    
    public void setZipCode(long input){
        this.zipCode = input;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
    
    @Override
    public String toString(){
        return  "\nCoutry: " + this.country + "\nCity: " + this.city + 
                "\nStreet Name: " + this.streetName + "\nHouse or Apartament Number: " +
                this.houseOrApartamentNumber + "\nZip Code: " + this.zipCode; 
    }
}
