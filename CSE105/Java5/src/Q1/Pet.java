/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author Minhao.Jin17
 */
public class Pet {
    private String name;
    private String type;
    private String food;
    private int IDNumber;
    
    public Pet(String name,
            String type,
            String food,
            int IDNumber){
    this.IDNumber=IDNumber;
    this.food=food;
    this.name=name;
    this.type=type;
    }
    
    public String getname(){
        return name;
    }
    
    public String gettype(){
        return type;
    }
    
    public String getfood(){
        return food;
    }
    
    public int getIDNumber(){
        return IDNumber;
    }
    
    public void setname(String s){
        name=s;
    }
    
    public void settype(String s){
        type=s;
    }
    
    public void setfood(String s){
        food=s;
    }
    
    public void setIDNumber(int s){
        IDNumber=s;
    }
    
    @Override
    public String toString(){
        return "";
    }
}
