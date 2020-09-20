/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13.recursion;

/**
 *
 * @author Minhao.Jin17
 */
public class Santa {

    static int count = 0;

    public static void main(String[] args) {
        System.out.println(christmasComing("christmasiscoming"));
    }

    public static String christmasComing(String s) {
        StringBuffer res = new StringBuffer(s);
        if (count == s.length()) {
            return res.toString();
        }

        if (res.charAt(count) == 's') {
            res.replace(count, count + 1, "Santa");
            count += 5;
        } else {
            count++;
        }
        return christmasComing(res.toString());
    }
}
