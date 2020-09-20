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
public class Employee extends Person{
    private int employeeNumber;
    private String jobTitle;
    
    public Employee(String name,
            String address,
            int employeeNumber,
            String jobTitlel){
    super(name,address);
    this.employeeNumber=employeeNumber;
    this.jobTitle=jobTitle;
    
    }

}
