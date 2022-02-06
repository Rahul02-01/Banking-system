package com.bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class dispacc {
    Scanner sc = new Scanner(System.in);

    dispacc(){
        // taking the account number which needs to be displayed...
        System.out.println("Enter the account number=");
        int acc_num = sc.nextInt();

        try{
            // Getting connection..
            Connection con = c.cc1();

            // query..
            String q = "select * from customer_data;";

            // Static query..
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(q);

            while (r.next()){
                int ac = r.getInt("acc_num");
                if (ac==acc_num){
                    System.out.println("The details of the user is given below :--");
                    String acc_name = r.getString("acc_name");
                    int acc_amount = r.getInt("acc_amount");
                    int acc_pin = r.getInt("acc_pin");

                    // displaying the data...
                    System.out.println("Account holder name = " + acc_name);
                    System.out.println("Account number = " + acc_num);
                    System.out.println("Account pin = " + acc_pin);
                    System.out.println("Amount present = " + acc_amount);

                    break; // Since the account needed is successfully found no need to search any further..
                }
            }
        }
        catch (Exception e){
            System.out.println("Sorry account not found...");
        }
    }

    dispacc(int acc){

        try{
            // Getting connection..
            Connection con = c.cc1();

            // query..
            String q = "select * from customer_data;";

            // Static query..
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(q);

            while (r.next()){
                int ac = r.getInt("acc_num");
                if (ac==acc){
                    System.out.println("The details of the user is given below :--");
                    String acc_name = r.getString("acc_name");
                    int acc_amount = r.getInt("acc_amount");
                    int acc_pin = r.getInt("acc_pin");

                    // displaying the data...
                    System.out.println("Account holder name = " + acc_name);
                    System.out.println("Account number = " + acc);
                    System.out.println("Account pin = " + acc_pin);
                    System.out.println("Amount present = " + acc_amount);

                    break; // Since the account needed is successfully found no need to search any further..
                }
            }
        }
        catch (Exception e){
            System.out.println("Sorry account not found...");
        }

    }
}
