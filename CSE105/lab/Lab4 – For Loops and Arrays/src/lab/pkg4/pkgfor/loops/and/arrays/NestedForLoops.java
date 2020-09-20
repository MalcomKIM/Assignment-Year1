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
public class NestedForLoops {
    
    public static int getNumber(){
        Scanner input= new Scanner(System.in);
         int n= input.nextInt();
         return n;
    }
    
    public static void multTable(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(i*j+"\t");
            }
            System.out.println();
        }
    }
    
     public static void main(String[] args){
         multTable(getNumber());
    }
}
