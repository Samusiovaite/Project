/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.io.*;
import java.util.ArrayList;

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

   public ArrayList<Object> readBytes() throws Exception{
       System.out.println("Reading...");
       File directory = new File(this.dir); 
       String[] fileNames = directory.list();
       int count = fileNames.length;
       ArrayList<Object> obectArray  = new ArrayList();
        
        for (int i = 0; i < count; ++i){ 
            File file = new File(directory, fileNames[i]);
            FileInputStream fileStream;
            fileStream = new FileInputStream(file);           
            try {
                while(true){
                    ObjectInputStream objStream = new ObjectInputStream(fileStream);
                    obectArray.add(objStream.readObject());
                }
            }
            catch (IOException | ClassNotFoundException e) {
                System.out.println("file is readed");
            }
            fileStream.close();
        }
        return obectArray; 
   }
   
   private volatile ArrayList<Object> objects;
   
    public ArrayList<Object> getObjects(){
        return this.objects;
    }

    public void setObjects(ArrayList<Object> input){
        this.objects = input; 
    }

    @Override
    public void run() {
        try {
            this.objects = this.readBytes(); 
        } catch (Exception ex) {
        }
    }
}
