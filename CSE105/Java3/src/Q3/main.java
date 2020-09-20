
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.util.Date;

/**
 *
 * @author Minhao.Jin17
 */
public class main {
    public static void main(String[] args){
        Date dateOfBirth;
        dateOfBirth = new Date("1998/11/15");
        Person a=new Person("",dateOfBirth,"");
        Person b=new Person("",dateOfBirth,"");
        
        System.out.println(a.equals(b));
        System.out.println(a.isHomeless());
    }
}
