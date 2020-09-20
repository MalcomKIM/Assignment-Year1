/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6checkpoint;


/**
 *
 * @author Minhao.Jin17
 */
public class Student extends Person{
    String major;
    int yearofStudy;
    public Student(String name,
            int age,
            String major,
            int id,
            String address,
            int yearofStudy ){
        
    super(name,age,address,id);
    this.major=major;
    this.yearofStudy=yearofStudy;
    }
    
    public void getMajor(){
        System.out.println("Major is "+major);
    }
    
    
}
