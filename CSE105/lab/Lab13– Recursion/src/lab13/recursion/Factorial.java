/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13.recursion;

/**
 *
 * @author Minhao.Jin17
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i=0;i<=5;i++){
            System.out.println(factorial(i));
        }
    }
    
    public static int factorial(int i){
        if(i==0) return 1;
        else return i*factorial(i-1);
    }
    
}
