/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kamile.note;



import contact.Address;
import contact.Contact;
import data.BinFileReader;
import data.BinFileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import note.CheckListElement;
import note.Note;
import note.ShoppingList;

/**
 *
 * @author Kamilė
 */
public class Main {
     public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
       
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
        
        Address address = new Address("Lietuva", "Vilnius", "Savanoriu prospektas",
                                       6, 20106);

        Contact contact = new Contact("Kamile", "Samusiovaite", "60569664",
                                      "kamilesamusiovaite", "2002-02-12",
                                       address);
        Note note = new Note("Namu darbas", "padaryti Op laboratorinį darbą");
        
        BinFileReader reader = new BinFileReader("data");
        BinFileWriter writer = new BinFileWriter("ne.bin", "data");
        //writer.setWritable(contact);
        writer.setWritable(contact);
//        Thread thread1 = new Thread(writer);
//        thread1.start();
        
        Thread thread2 = new Thread(reader);
        thread2.start();
        
        
        
     }
}
