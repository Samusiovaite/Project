/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Kamilė
 */

public class IncorrectFileNameException extends Exception {
    private String fileName; 
    
    public IncorrectFileNameException(String errorMessage, String fileName) {
        super(errorMessage); 
        this.fileName = fileName;
    }
    
    public String getFileName(){
        return this.fileName;
    }
    
    public void setFileName(String input){
        this.fileName = input; 
    }
}
