/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

/**
 *
 * @author Minhao.Jin17
 */
class B extends A {
    int d;
    B(int l,int m,int n,int o){
        super(l,m,n);
        d=o;
    }
    
    void show(){
        System.out.println(a+","+b+","+c+","+d);
    }
    
    public static void main(String args[]){
        B b=new B(4,3,8,7);
        b.show();
    }
}
