/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

/**
 *
 * @author Minhao.Jin17
 */
public class Rectangle {
    private double length;
    private double width;
    
    public Rectangle(){
        length=0;
        width=0;
    }
    
    public Rectangle(double l,double w){
        length=l;
        width=w;
    }
    
    public void set(double l,double w){
        length=l;
        width=w;
    }
    
    public double area(){
        return length*width;
    }
    
    public double primeter(){
        return length*2+width*2;
    }
}
