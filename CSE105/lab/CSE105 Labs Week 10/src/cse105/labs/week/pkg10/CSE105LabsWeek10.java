/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse105.labs.week.pkg10;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Minhao.Jin17
 */
public class CSE105LabsWeek10 {
    static ArrayList <String> names=new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       names.add("1");
       names.add("2");
       names.add("3");
       names.add("4");
       names.add("5");
       for(String str:names){
           System.out.print(str+" ");
       }
       System.out.println();
       
       removeString("2");
       removeString("4");
       
       for(String str:names){
           System.out.print(str+" ");
       }
    }
    
    public static boolean removeString(String s){
        Iterator it =names.iterator();
        while(it.hasNext()){
            if(it.next().equals(s)){
                it.remove();
                return true;
            }
        }
        return false;
    }
    
}
