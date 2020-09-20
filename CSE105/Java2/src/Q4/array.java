/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

/**
 *
 * @author Minhao.Jin17
 */
public class array {
    public static void main(String[] args){
        int a[]= new int[10];
        for(int i=1;i<=a.length;i++){
            a[i-1]=i;
        }
        
        System.out.println(findmax(a));
    }
    
    public static int findmax(int a[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            max=Math.max(a[i], max);
        }
        return max;
    }
}
