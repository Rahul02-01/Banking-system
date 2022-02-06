package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class addacc {

    Scanner sc = new Scanner(System.in);

    addacc(){
        // Details of new user is taken....
        System.out.println("Enter the account holder number=");
        int acc_num = sc.nextInt();
        System.out.println("Enter the account holder name=");
        String acc_name = sc.nextLine();
        acc_name+=sc.nextLine();
        System.out.println("Enter the pin for the account=");
        int acc_pin = sc.nextInt();
        System.out.println("Enter the opening amount=");
        int acc_amount = sc.nextInt();
        // Details have been sent for verification...
        boolean g = false; // a variable that helps for keeping the loop on...
        int f = 0; // An indicator that will help making two separate decisions..
        do {
            if (f==0){
                g = ac_check(acc_num,acc_name,acc_pin,acc_amount);
                f = 1;
            }
            else {
                System.out.println("Enter the account holder number=");
                int sec_num = sc.nextInt();
                g = ac_check(sec_num,acc_name,acc_pin,acc_amount);
                acc_num = sec_num;
            }
        }while (g==false);

        try{
            // Getting connection..
            Connection con = c.cc1();

            // Query..
            String k = "insert into customer_data(acc_num,acc_name,acc_pin,acc_amount) values (?,?,?,?);";

            // Prepare Statements..
            PreparedStatement p = con.prepareStatement(k);

            // Inserting the values in the database..
            p.setInt(1,acc_num);
            p.setString(2,acc_name);
            p.setInt(3,acc_pin);
            p.setInt(4,acc_amount);
            // Execution...
            p.executeUpdate();
            System.out.println("Account added successfully!!!");
        }catch (Exception e){
            System.out.println("Account cannot be added...");
        }
    }

    public boolean ac_check(int acc_num, String acc_name, int acc_pin, int acc_amount){

        try{
            // Getting the connection
            Connection con = c.cc1();

            // Giving the orders...
            String p = "select * from customer_data;";

            // Statement for static query..
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(p);

            while (r.next()){
                // storing the data's of the existing holders to check if there is a matching...
                int an = r.getInt("acc_num");
                String ana = r.getString("acc_name");
                int ap = r.getInt("acc_pin");
                int aa = r.getInt("acc_amount");

                if (an == acc_num){
                    System.out.println("Account number already in use!!!!");
                    return false;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
}
