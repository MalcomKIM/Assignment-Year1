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
public class PerfectNumber {
    public static void main(String[] args){
        for(int i=1;i<=10000;i++){
            if(isPerfect(i)){
                System.out.println(i);
            }
        }
    }
    
    public static boolean isPerfect(int n){
        int sum=0;
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                sum=sum+i;
            }
        }
        if(sum==n){
            return true;
        }
        else{
            return false;
        }
    }
}
