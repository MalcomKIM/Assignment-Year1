/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

/**
 *
 * @author Minhao.Jin17
 */
public class Armstrong {
    public static void main(String[] args){
        for(int i=100;i<=999;i++){
            if(isArmstrong(i)){
                System.out.println(i);
            }
        }
    }
    
    public static boolean isArmstrong(int n){
        int a=n/100;
        int b=n%100/10;
        int c=n%10;
        
        int sum=a*a*a+b*b*b+c*c*c;
        
        if(sum==n){
            return true;
        }
        else{
            return false;
        }
    }
}
