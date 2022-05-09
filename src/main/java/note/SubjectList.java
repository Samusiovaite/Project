/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package note;
       

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author KamilÄ—
 */
public abstract class SubjectList implements Checkable, Serializable {
    protected ArrayList<CheckListElement> checkList  = new ArrayList(); 

    SubjectList(){}
    
    public ArrayList getCheckList(){
        return this.checkList;
    }

    public void setCheckList(ArrayList<CheckListElement> input){
        this.checkList = input; 
    }

  
    @Override
    public void checkElement(int integer){
        for(int i  = 0; i < this.checkList.size(); i++){
            if(i == integer){
                 this.checkList.get(i).setCheck(true);
            }
        }
    }

    @Override
    public void uncheckElement(int integer){
        for(int i  = 0; i < this.checkList.size(); i++){
            if(i == integer){
                this.checkList.get(i).setCheck(false);
            }
        }
    }

    @Override
    public void addElement(CheckListElement element){
        this.checkList.add(element);
    }

    @Override
    public void editElement(int integer, String input){
        for(int i  = 0; i < this.checkList.size(); i++){
            if(i == integer){
               this.checkList.get(i).setText(input);
            }
        }
        
    }

    @Override
    public void deleteElement(int integert){
        this.checkList.remove(integert);
    }

}
