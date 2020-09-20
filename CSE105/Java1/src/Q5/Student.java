/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

/**
 *
 * @author Minhao.Jin17
 */
public class Student extends Person {
    private int studentNumber;
    private String enrolledCourse;
    
    public Student(String name,
            String address,
            int studentNumber,
            String enrolledCourse){
    super(name,address);
    this.studentNumber=studentNumber;
    this.enrolledCourse=enrolledCourse;
    
    }


}
