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
    
 
    
   public ArrayList<Object> readBytes() throws FileNotFoundException, IOException, ClassNotFoundException{
       System.out.println("Reading...");
       byte[] readBytes;           //baitų masyvas
       File directory = new File(this.dir);
       String[] fileNames = directory.list();
       int count = fileNames.length;
       ArrayList<Object> o  = new ArrayList();
        
        for (int i = 0; i < count; ++i){
            File file = new File(directory, fileNames[i]);
            FileInputStream fileStream = new FileInputStream(file);
            ByteArrayInputStream bis;
            ObjectInput in;
            boolean cont = true;
            try {
                while(cont){
                    ObjectInputStream objStream = new ObjectInputStream(fileStream);
                    readBytes = (byte[]) objStream.readObject();
                    bis = new ByteArrayInputStream(readBytes);
                    in = new ObjectInputStream(bis);
                    o.add(in.readObject());
                    in.close();
                }
            } catch (IOException | ClassNotFoundException e) {
//                System.out.println(e.getMessage());
            }
        }
        return o;
   }
   

    @Override
    public void run() {
        try {
            ArrayList<Object> objects = this.readBytes();
            for(int i = 0; i < objects.size(); ++i) {
                System.out.println(objects.get(i).toString());
                System.out.println("\n");
            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }
}
