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
public class richer {
    public static void main(String[] args) {
        for(int i=0;i<=7;i++){
            System.out.println(money(i));
        }
    }
    
    public static int money(int i){
        if(i==0) return 0;
        
        if(i%3==1||i%3==2) return money(i-1)+7;
        else return money(i-1)+11;
    }
}
