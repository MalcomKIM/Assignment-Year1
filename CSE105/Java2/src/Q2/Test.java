/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author Minhao.Jin17
 */
public class Test {
    public static void main(String[] args) {
       int x;
       int a[]={0,0,0,0,0,0};
       calculate(a,a[5]);
       System.out.println("the value of a[0] is "+a[0]);
       System.out.println("the value of a[5] is "+a[5]);
    }
    
    static int calculate (int x[],int y){
        for(int i=1;i<x.length;i++){
            if(y<x.length){
                x[i]=x[i-1]+1;
            }
        }
        return x[0];
    }
    
}
