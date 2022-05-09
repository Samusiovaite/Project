/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import contact.Contact;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;



/**
 *
 * @author Kamilė
 */

public class BinFileReader implements Runnable {
    private String fileName; 
    private String dir; 
    
    public BinFileReader(String dir){
        this.dir = dir; 
    }
    
    public BinFileReader(String dir, String fileName){
        this.dir = dir;
        this.fileName = fileName;
    }
    
    public String getFileName(){
        return this.fileName;
    }
    
    public String getDirName(){
        return this.dir;
    }
    
    public void setFileName(String input){
        this.fileName = input; 
    }
    
    public void setDirName(String input){
        this.dir = input; 
    }
    
    public void read() throws IncorrectFileNameException, IOException, FileNotFoundException {
        File file = new File(this.fileName);
        BufferedReader bufferedReader = null;

        if (file.exists() && !file.isDirectory()) {
            bufferedReader = new BufferedReader(new FileReader(file));
        } else if (file.isDirectory()) {
            throw new FileIsDirectoryException("Incorrect filename.", this.fileName);
        } else {
            throw new IncorrectFileNameException("Incorrect filename.", this.fileName);
        }

        String curLine;
        while ((curLine = bufferedReader.readLine()) != null){
            System.out.println(curLine);
        }
    }
    
 
    
   public Object readBytes() throws FileNotFoundException, IOException, ClassNotFoundException{
        byte[] readBytes = null;           //baitų masyvas
        System.out.println("Reading...");
        File directory = new File(this.dir);
        String[] fileNames = directory.list();
        int count = fileNames.length;
        ArrayList<Object> o  = new ArrayList(); 
        
        for (int i = 0; i < count; ++i){
            File file = new File(directory, fileNames[i]);
            FileInputStream fileStream = new FileInputStream(file);
            
            try (ObjectInputStream objStream = new ObjectInputStream(fileStream)) {
                readBytes = (byte[]) objStream.readObject();    
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            ByteArrayInputStream bis = new ByteArrayInputStream(readBytes);
            ObjectInput in = null;
           
            try {
                    in = new ObjectInputStream(bis);
                    o.add(in.readObject());
                     
            } catch(IOException | ClassNotFoundException e) {} 
            finally {
                    try {
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException ex) {}
            }

           
           
            //System.out.println(con.getFirstName());
            }
            return o;
   }
   

    @Override
    public void run() {
        try {
            //this.readBytes();
            System.out.println(this.readBytes());
        } catch (IOException | ClassNotFoundException ex) {
        }
    }
}
