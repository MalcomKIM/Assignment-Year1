/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author minhao.jin17
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayStack<String> as = new ArrayStack();

        for (String s : "This is a test for arraystack".split(" ")) {
            as.push(s);
        }
        System.out.println("Size: "+as.size());
        System.out.println(as.peek());

        while (!as.isEmpty()) {
            System.out.print(as.pop() + " ");
        }
        System.out.println();
        System.out.println("Size: "+as.size());

    }

}
