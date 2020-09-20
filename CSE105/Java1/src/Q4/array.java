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
        double a[]=new double[10];
        
        for(int i=0;i<10;i++){
           a[i]=i;
        }
        
        
        reverse(a);
        
        for(int i=0;i<10;i++){
            System.out.print(a[i]+" ");
        }
    }
    
    public static double[] reverse(double a[]){
        int l=a.length;
        int count=l/2;
        
        for(int i=0;i<count;i++){
            double temp=a[i];
            a[i]=a[l-i-1];
            a[l-i-1]=temp;
        }
        return a;
    }
}
