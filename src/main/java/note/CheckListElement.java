/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package note;

/**
 *
 * @author Kamilė
 */
public class CheckListElement{
    private boolean check;
    private String text;
    
    public CheckListElement(boolean check, String text){
        this.check = check;
        this.text = text; 
    }

    public boolean getCheck(){
        return this.check;
    }
    
    public String getText(){
        return this.text;
    }
    
    public void setCheck(boolean input){
        this.check = input; 
    }
    
    public void setText(String input){
        this.text = input; 
    }
    
}
