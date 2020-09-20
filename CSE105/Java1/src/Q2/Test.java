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

    /**
     * @param args the command line arguments
     */
    public static void mb(StringBuffer x,StringBuffer y){
        x.append(y);
        y=x;
    }
    
    public static void main(String[] args) {
        StringBuffer a= new StringBuffer("A");
        StringBuffer b= new StringBuffer("B");
        mb(a,b);
        System.out.println(a+","+b);
    }
    
}
