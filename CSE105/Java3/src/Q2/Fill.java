/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.util.Arrays;

/**
 *
 * @author Minhao.Jin17
 */
public class Fill {
public static void main(String[] args) {
        int[] numbers = new int[30]; 
        fillArray(numbers);
        System.out.println("Array contents: "); 
        printArray(numbers);
        System.out.println("The largest number is: " + largestNumber(numbers)); 
        reverse(numbers);
        System.out.println("Array contents after reversal: ");
        printArray(numbers);
    } 
    // fill an array with random integers between 0 and 100 
    // use Math.random() which gives a double between 0.0 and 1.0 
    public static void fillArray(int[] arr) {
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*100);
        }
    } 
    // print the array with ten numbers printed per line 
    public static void printArray(int[] arr) {
        int count=0;
        while(count<arr.length){
            for(int i=1;i<=10;i++){
                System.out.print( arr[count]+" ");
                count++;
            }
            System.out.println();
        }
        
    } 
        // give the largest element of the array
    public static int largestNumber(int[] a) {
        int max=Integer.MIN_VALUE;
        
        for(int i:a){
            max=Math.max(max, i);
        }
        return max;
    } 
    // reverse the elements of an array
    public static void reverse(int[] a) {   
        for(int i=0;i<a.length/2;i++){
            int temp=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=temp;
        }
    } 
    
}
