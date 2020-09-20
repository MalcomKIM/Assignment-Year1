/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

import java.util.Scanner;

/**
 *
 * @author Minhao.Jin17
 */
public class ISBN {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);
        String test=kb.nextLine();
        
        System.out.println(isvalid(test));
    }
    
    public static boolean isvalid(String s){
        s=s.replaceAll("-", "");
        if(s.length()!=13){
            return false;
        }
        
        for(char c:s.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        
        return true;
    }
    
}
