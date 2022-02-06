package com.bank;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class dispdat {

    Scanner sc = new Scanner(System.in);
    dispdat(){
        try{
            Connection con = c.cc1();

            String p = "select * from customer_data;";

            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(p);

            System.out.println("Showing the entire database....");
            while (r.next()){

                // Getting the data...
                String acc_name = r.getString("acc_name");
                int acc_num = r.getInt("acc_num");
                int acc_amount = r.getInt("acc_amount");
                int acc_pin = r.getInt("acc_pin");

                // displaying the data...
                System.out.println("\n\nAccount holder name = " + acc_name);
                System.out.println("Account number = " + acc_num);
                System.out.println("Account pin = " + acc_pin);
                System.out.println("Amount present = " + acc_amount);
            }
        }
        catch (Exception e){
            System.out.println("Operation cannot be performed....");
        }
    }
}
