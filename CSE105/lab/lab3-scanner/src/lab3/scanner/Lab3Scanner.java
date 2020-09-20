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
public class Lab3Scanner {
    
    public static String password(String a){
        
        if(a.length()>5){
            return a.substring(a.length()-5);
        }
        else{
            return a;
        }
        
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        String psw = keyboard.nextLine();
        
        System.out.println(password(psw));
        
    }
    
}
