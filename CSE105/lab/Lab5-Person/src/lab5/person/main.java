/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.person;

/**
 *
 * @author Minhao.Jin17
 */
public class main {
    
    public static int birthday(int num){
        System.out.println("Happy birthday!!");
        return num+1;
    }
    
//    public static void Change_name(String name){
//        Person b= new Person(name,63,"fd");
//    }
    
    public static void main(String[] args){
//        Person person1=new Person("Joe",87,"London",123);
//       
//        System.out.println("You were "+person1.age+" but you are now "+birthday(person1.age));
        String name[]={"Ting","Joe","Andrew","Conor","Yuexuan"};
        int id[]={123,102,227,993,702,102};
        
        int low=Integer.MAX_VALUE;
        int pos=0;
        for(int i=0;i<name.length;i++){
            Person a=new Person(name[i],1,"0",id[i]);
            if(a.id<low){
                low=a.id;
                pos=i;
            } 
        }
        System.out.println("The Lowest ID number is "+low);
        System.out.println("The ID belongs to "+name[pos]);
    
    }
    
}
