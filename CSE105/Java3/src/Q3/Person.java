/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Minhao.Jin17
 */
public class Person {
    private static ArrayList<Person> listOfPeople = new ArrayList<Person>();
    private static int lastId = 0;
    private String name;
    private Date dateOfBirth;
    private String address;
    private int idNumber;
    public Person(String name, Date dateOfBirth, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        lastId++;
        this.idNumber = lastId;
        listOfPeople.add(this);
    }

    public boolean equals(Person x) {
        if(name!=x.name) return false;
        if(dateOfBirth!=x.dateOfBirth) return false;
        if(address!=x.address) return false;
        
        return true;
    }
    
    public static int num(){
        return listOfPeople.size();
    }
    
    public boolean isHomeless(){
        if(address.equals("")){
            return true;
        }
        else return false;
    }
   
}
