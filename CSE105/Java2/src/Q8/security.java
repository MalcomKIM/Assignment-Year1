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
public class security {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);
        
        String test = kb.nextLine();
        
        System.out.println(isValid(test));
    }
    
    public static boolean isValid(String s){
        if(s.length()!=11){
            return false;
        }
        
        if(s.charAt(3)!='-'||s.charAt(6)!='-'){
            return false;
        }
        
        String[] ss=s.split("-");
        
        if(ss.length!=3){
            return false;
        }
        
        for(String p:ss){
            for(char c:p.toCharArray()){
                if(!Character.isDigit(c)){
                    return false;
                }
            }
        }
        return true;
    }
}
