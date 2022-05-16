/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Kamilė
 */

public class BinFileWriter implements Runnable {
    private String fileName;
    private Object writable;    
    private String dir; 
    
    public BinFileWriter(String fileName, String dir){
        this.fileName = fileName;
        this.dir = dir; 
    }
    
    public String getFileName(){
        return this.fileName;
    }
    
    public void setFileName(String input){
        this.fileName = input; 
    }
    
    public Object getWritable(){
        return this.writable;
    }
    
    public void setWritable(Object input){
        this.writable = input; 
    }
    
    public String getDirName(){
        return this.dir;
    }
    
    public void setDirName(String input){
        this.dir = input; 
    }
    
    public void write(Object object) throws Exception{
        try {
            System.out.println("Writing...");
            File targetDir = new File(this.dir);   
            File targetFile = new File(targetDir, fileName);
            FileOutputStream file = new FileOutputStream(targetFile, true); 
            try (ObjectOutputStream output = new ObjectOutputStream(file)) {
                output.writeObject(object); 
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }
    
    public void overwriteFile(ArrayList<Object> objects) throws Exception {
        File targetDir = new File(this.dir);   
        File targetFile = new File(targetDir, fileName);
        targetFile.delete();

        for(int i = 0; i < objects.size(); ++i) {
            this.write(objects.get(i));
        }
    }
    
    @Override
    public void run() {
        try {
            this.write((Object) this.writable); 
        }   catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
