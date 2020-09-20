/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.util.ArrayList;

/**
 *
 * @author Minhao.Jin17
 */
public class BankAccount {
    public static ArrayList<BankAccount> allAccounts= new ArrayList<BankAccount>();
    public static int lastNo = 100000;
    public String accountNumber;
    public String customerName;
    public double balance;
    public String shipToAddress;
    public String billToAddress;
    
    public BankAccount(String accountNumber,
            String customerName,
            double balance,
            String shipToAddress,
            String billToAddress){
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.billToAddress=billToAddress;
        this.customerName=customerName;
        this.shipToAddress=shipToAddress; 
        allAccounts.add(this);
    }
    
    public static int getnumber(){
        return allAccounts.size();
    }
    
    public boolean withdraw(double amount){
        if(amount>balance) return false;
        else return true;
    }
}
