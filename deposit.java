package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class deposit {

    Scanner sc = new Scanner(System.in);

    int copy; // this is the variable that takes the copy of the final amount after
    // operation1 and operation2
    deposit(int cn){
        try{
            // The amount that needs to be deposited..
            System.out.println("Enter the amount that needs to be deposited = ");
            int amount = sc.nextInt();

            boolean j = operation1(amount,cn);
            if (j){
                boolean k = update(copy,cn);
                if (k){
                    System.out.println("Amount deposited successfully!!!");
                }
                else {
                    System.out.println("Something went wrong...");
                }
            }
        }
        catch (Exception e){
            System.out.println("Sorry operation not performed...");
        }
    }


    public boolean operation1(int amount, int cn){
        try {
            // Getting the connection...
            Connection con = c.cc1();

            String p = "select * from customer_data;";

            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(p);

            while (r.next()){
                int acc_num = r.getInt("acc_num");
                if (acc_num == cn){
                    int a = r.getInt("acc_amount");
                    a = operation2(a,amount);
                    copy = a;
                    return true;
                }
            }
        }
        catch (Exception e){
            System.out.println("\nNot taken..");
        }
        return false;
    }

    public int operation2(int a,int change){
        // a is the amount at present and change is the amount that
        // needs to be deposited..
        a += change;
        return a;
    }

    public boolean update(int deposited,int cn){
        try {
            Connection con = c.cc1();

            String j = "update customer_data\n" +
                    "set acc_amount = ?\n" +
                    "where acc_num = ?;";

            PreparedStatement p = con.prepareStatement(j);

            p.setInt(1,deposited);
            p.setInt(2,cn);

            p.executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
