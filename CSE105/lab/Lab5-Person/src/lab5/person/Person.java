/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.person;

/**
 *
 * @author Minhao.Jin17
 */
public class Person {
    String name;
    int age;
    String address;
    int id;
    
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }
    
    public Person(String name,int age,String address,int id){
        this.name=name;
        this.age=age;
        this.address=address;
        this.id=id;
        
        System.out.println("Person called "+name+" created with ID: "+id);
    }
}


