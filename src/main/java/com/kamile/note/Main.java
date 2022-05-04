/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kamile.note;


import contact.Address;
import contact.Contact;
import contact.ContactFactory;
import data.FileIsDirectoryException;
import data.IncorrectFileNameException;
import data.ReaderInputFile;
import java.io.IOException;
import note.CheckListElement;
import note.ShoppingList;

/**
 *
 * @author Kamilė
 */
public class Main {
     public static void main(String[] args) {
       
        CheckListElement checkList = new CheckListElement(false, "Duona");
        CheckListElement checkList1 = new CheckListElement(false, "Jogurtas");
        CheckListElement checkList2 = new CheckListElement(false, "Morkos");
        CheckListElement checkList3 = new CheckListElement(false, "Pienas");
        CheckListElement checkList4 = new CheckListElement(false, "Saldainiai");
        CheckListElement checkList5 = new CheckListElement(false, "Obuoliai");
        
        ShoppingList shoppingList = new ShoppingList("Prekiu sarasas",
        "Ketvirtadieni nueiti i parduotuve 9:00", "Maxima");
        
        shoppingList.addElement(checkList);
        shoppingList.addElement(checkList1);
        shoppingList.addElement(checkList2);
        shoppingList.addElement(checkList3);
        shoppingList.addElement(checkList4);
        shoppingList.addElement(checkList5);
        
        System.out.println(shoppingList.toString());
        System.out.println("_________________");
        
        
        System.out.println(shoppingList.toString());
        System.out.println("_________________");
        
        shoppingList.deleteElement(2);
     
        shoppingList.checkElement(0);
        shoppingList.checkElement(1);
        shoppingList.checkElement(2);
        shoppingList.checkElement(3);
        shoppingList.checkElement(4);
        
        shoppingList.uncheckElement(2);
        
        System.out.println(shoppingList.toString());
        System.out.println("_________________");
        
        ReaderInputFile reader = new ReaderInputFile("Contact");
         try {
             reader.read();
        } catch(FileIsDirectoryException e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            System.out.println("File Name is: " + e.getFileName());
        } catch(IncorrectFileNameException e) {
            System.out.println(e.getMessage());
            System.out.println("File Name is: " + e.getFileName());
        } catch (IOException e) {
            System.out.println(e.getMessage());
         }
         
         
         Address address = new Address("Lietuva", "Vilnius", "Savanoriu prospektas",
                                       6, 20106);
         Contact contact1 = new Contact("Kamile", "Samusiovaite", "60569664",
                                      "kamilesamusiovaite@gmail.com", "2002-02-12",
                                       address);
         
//        try{
//            Object object = contact1.clone();
//            Contact contact2 = (Contact)object;
       
            Contact contact2 = new ContactFactory().create(contact1);

            contact2.setFirstName("Emilija");
            contact2.setPhoneNumber("60731937");
            contact2.setEmail("emilijasamusiovaite@gmail.com");
            contact2.setDateOfBirthday("2000-10-30");
            
            contact2.getAddress().setCity("Kaunas");
            
            System.out.println("_________________");
            System.out.println("Original Contact object: ");
            System.out.println(contact1);
            System.out.println("_________________");
            System.out.println("Cloned Contact object: ");
            System.out.println(contact2);
            System.out.println("_________________");
//        } catch(CloneNotSupportedException e ){
//            System.out.println(e.getMessage());
//        }

     }
}
