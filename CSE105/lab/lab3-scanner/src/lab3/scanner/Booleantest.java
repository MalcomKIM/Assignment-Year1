/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.scanner;
import java.util.Scanner;
/**
 *
 * @author minhao.jin17
 */
public class Booleantest {
    public static boolean judge(int a){
        if(a==4) return false;
        else return true;
    }
    
    public static void main(String[] args){
        int a=100;
        int count=0;
                
        Scanner keyboard = new Scanner(System.in);
        while(judge(a)!=false){
            System.out.println("Enter a number 0 and 9");
            a=keyboard.nextInt();
            count++;
        }
        if(a==4){
            System.out.println("You got it, in "+count+" guesses!");
        }
    }
    
}
