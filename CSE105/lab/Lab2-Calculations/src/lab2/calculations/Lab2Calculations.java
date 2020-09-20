/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.calculations;
import java.util.*;

/**
 *
 * @author minhao.jin17
 */
public class Lab2Calculations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
    double i=input.nextDouble();
    System.out.println("i="+i);
    if(i>0){
       
       System.out.println("Number i is positive.");
    }
    else if(i==0){
        System.out.println("Number i is zero.");
    }
    else{
        System.out.println("Number i is negative.");
    }
        
        
    }
    
}
