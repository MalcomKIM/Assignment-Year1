/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg4.pkgfor.loops.and.arrays;
import java.util.Scanner;
/**
 *
 * @author Minhao.Jin17
 */
public class HW {
    
    public static void tree(){
        Scanner input=new Scanner(System.in);
        int m=input.nextInt();
        int n=2*m-1;
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=m-i;j++){
                System.out.print(" ");
            }
            for(int k=i;k>=1;k--){
                System.out.print(k);
            }
            for(int l=1;l<=i-1;l++){
                System.out.print(l+1);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
         tree();
    }
    
}
