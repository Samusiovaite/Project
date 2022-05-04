/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Kamilė
 */

public class FileIsDirectoryException extends IncorrectFileNameException {
    
    public FileIsDirectoryException(String errorMessage, String fileName) {
        super(errorMessage, fileName); 
    }

    @Override
    public final String toString() {
        return "File is a directory.";
    }
}
