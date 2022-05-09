/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


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
    
    public void write(Object object) throws IOException{
        try {
            System.out.println("Writing...");
            File targetDir=new File(this.dir);
            File targetFile=new File(targetDir, fileName);
            FileOutputStream file = new FileOutputStream(targetFile, true);
            try (ObjectOutputStream output = new ObjectOutputStream(file)) {
                byte[] bb = this.getByte(object);
                output.writeObject(bb);
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }
    
    private byte[] getByte(Object object) throws IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	ObjectOutputStream out;
	byte[] bytes = null;
	try {
            out = new ObjectOutputStream(bos);   
            out.writeObject(object);
            out.flush();
            bytes = bos.toByteArray();
            bos.close();

	}  catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return bytes;
    }

    @Override
    public void run() {
        try {
            this.write((Object) this.writable);
        } catch (IOException ex) {
        }
    }
}
