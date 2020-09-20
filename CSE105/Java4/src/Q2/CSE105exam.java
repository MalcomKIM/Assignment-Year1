/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.util.Arrays;
import java.util.Scanner;

public class CSE105exam { 
    public static void main(String[] args) {
        int[] numbers = new int[30]; 
        dataEntryArray(numbers);
        System.out.println("Array contents: "); 
        printArray(numbers);
        System.out.println("The average number is: " + averageNumber(numbers)); 
        removeElement(numbers,5); 
     System.out.println("Array contents after removal: "); 
        printArray(numbers);
    } 
    // enter numbers from the keyboard to fill the array 
    public static void dataEntryArray(int[] arr) {
       Scanner kb=new Scanner(System.in);
       
       for(int i=0;i<arr.length;i++){
           arr[i]=kb.nextInt();         
       }
    } 
    // print the array withten numbers printed per line 
    public static void printArray(int[] arr) {
        int count=0;
        while(count<arr.length){
            for(int i=1;i<=10;i++){
                  System.out.print(arr[count]+" ");
            }
            System.out.println();
        }
    } 
        // give the largest element of the array
    public static int averageNumber(int[] a) { 
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum=sum+a[i];
        }
        return sum/a.length;
    } 
// remove an element from array
    private static void removeElement(int[] intArray, int removePosition) { 
        for(int i=removePosition;i<intArray.length-1;i++){
            intArray[i]=intArray[i+1];
        }
        intArray=Arrays.copyOf(intArray, intArray.length-1);
    } 
}