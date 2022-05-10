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
import note.Note;

/**
 *
 * @author Kamilė
 */
public class Main {
     public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        
        Address address = new Address("Lietuva", "Vilnius", "Savanoriu prospektas",
                                       6, 20106);

        Contact contact = new Contact("Kamile", "Samusiovaite", "60569664",
                                      "kamilesamusiovaite", "2002-02-12",
                                       address);
        
        Contact contact1 = new Contact("Emilija", "Samusiovaite", "83628362",
                                      "emilijasamusiovaite", "2000-10-30",
                                       address);
        
        Note note = new Note("Namu darbas", "padaryti Op laboratorini darba");
        Note note1 = new Note("koncertas", "Nusipirkti bilietus i koncerta");
        
        BinFileReader reader = new BinFileReader("data"); 
        BinFileWriter writer = new BinFileWriter("note.bin", "data");
        writer.setWritable(note1);
        
        Thread thread = new Thread(reader);
        thread.start();
        
        
        
     }
}
