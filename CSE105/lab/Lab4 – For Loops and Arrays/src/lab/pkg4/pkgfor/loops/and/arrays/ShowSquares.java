/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg4.pkgfor.loops.and.arrays;

/**
 *
 * @author Minhao.Jin17
 */


public class ShowSquares {
    public static void showSquares(){
        System.out.println("CSE105 Square Program");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        for(int i=20;i>=0;i--)
        {
            if(i%6==2){
        System.out.println("Number;"+i+" "+"Square:"+i*i+" "+"Cube;"+i*i*i);
        System.out.println("--------------------------");
            }
        }
        System.out.println("Created by Malcom ID:1717576");
    } 
    
    public static void main(String[] args){
        showSquares();
    }
    
    
}
