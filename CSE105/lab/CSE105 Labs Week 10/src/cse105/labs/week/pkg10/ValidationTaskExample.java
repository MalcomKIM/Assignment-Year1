package cse105.labs.week.pkg10;

import java.util.ArrayList;


public class ValidationTaskExample {
    public static void main(String[] args) {
        /*here, you must have one String for each possible error.
        As you write the test functions in the validateString method,
        test them from here.
        When you have finished, you should have a load of test Strings (16 or more?)
        and test every possible error. For each test, print out what you are testing
        and what the result is to the console
        */
        ArrayList <String> testdata= new ArrayList();
        testdata.add("ISCN-978-0-273-72131-4");
        testdata.add("ISBN 97a-0-273-72131-4");
        testdata.add("ISBN 978-b-273-72131-4");
        testdata.add("ISBN 978-0-2v3-72131-4");
        testdata.add("ISBN 978-0-273-7d131-4");
        testdata.add("ISBN 978-0-273-72131-4");
        
        for(String str:testdata){          
            System.out.println("========================================");
            System.out.println('\"'+str+'\"');
            boolean res=validateString(str);
            System.out.println(res);
        }

    }

    public static boolean validateString(String input) {       
        boolean valid = true;
        // Add validation checking here
        //System.out.println("Checking length...");
        if(input.length()!=22){
            System.out.print("The input's length is not 22.\t");
            return false;
        }
        
        String head=input.substring(0,4).toUpperCase();
        
        if(!head.equals("ISBN")){
            System.out.print("The input does not begin with ISBN.\t");
            return false;
        }
        
        if(input.charAt(4)!=' '){
            System.out.print("The input does not have one space ' ' after ISBN.\t");
            return false;
        }
        
        int pos[]={8,10,14,20};
        for(int i:pos){
            if(input.charAt(i)!='-'){
                System.out.print("There is '-' missing.\t");
                return false;
            }
        }
        
        String data[]=input.substring(5).split("-");
        
        for(String s:data){
            for(int i=0;i<s.length();i++){
                if(!Character.isDigit(s.charAt(i))){
                    System.out.print("Digits are wrong.\t");
                    return false;
                }
            }
        }


        
        return valid;
    }

}
