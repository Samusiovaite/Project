/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.*;

/**
 *
 * @author Kamilė
 */

public class ReaderInputFile {
    private String fileName; 
    
    public ReaderInputFile(String fileName){
        this.fileName = fileName;
    }
    
    public String getFileName(){
        return this.fileName;
    }
    
    public void setFileName(String input){
        this.fileName = input; 
    }
    
    public void read() throws IncorrectFileNameException, IOException {
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
}
