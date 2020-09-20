/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13.recursion;

/**
 *
 * @author Minhao.Jin17
 */
public class Student_Money {
    public static void main(String[] args) {
        for(int i=0;i<=7;i++){
            System.out.println(money(i));
        }
    }
    
    public static int money(int i){
        if(i==0) return 0;
        else return money(i-1)+7;
    }
}
