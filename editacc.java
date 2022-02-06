package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class editacc {
    Scanner sc = new Scanner(System.in);
    int acc_num, acc_amount;
    int fp = 0;

    editacc() {
        // taking the account number which needs to be edited...
        System.out.println("Enter the account number=");
        acc_num = sc.nextInt();
        boolean l = acc_check(acc_num);
        if (l){
            boolean b = update_name(acc_num);
            boolean c = update_pin(acc_num);

            if (b && c){
                System.out.println("Changes have been made successfully...");
            }
            else if (b && !c) {
                System.out.println("Name has been successfully changed...");
            }
            else if (!b && c) {
                System.out.println("Pin has been successfully changed...");
            }
            else {
                System.out.println("Sorry couldn't make the changes..");
            }
        }
    }

    // Checking whether account exists in database or not...
    public boolean acc_check(int ac){
        try{
            Connection con = c.cc1();

            String j = "select * from customer_data;";

            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(j);

            while (r.next()){
                int a_num = r.getInt("acc_num");
                if (ac==a_num){
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    // Method for changing the name of the account holder...
    public boolean update_name(int acc_num){
        try{
            System.out.println("Enter the new name =");
            String name = sc.nextLine();
            name+=sc.nextLine();

            Connection con = c.cc1();

            String k = "update customer_data\n" +
                    "set acc_name = ?\n" +
                    "where acc_num = ?;";

            PreparedStatement p = con.prepareStatement(k);
            p.setString(1, name);
            p.setInt(2,acc_num);

            p.executeUpdate();

            return true;
        }
        catch (Exception e)
        {
            System.out.println("Error while making the changes in name...");
        }
        return false;
    }

    // Method for changing the pin of the account holder...
    public boolean update_pin(int acc_num){
        try{
            System.out.println("Enter the new pin =");
            int pin = sc.nextInt();

            Connection con = c.cc1();

            String k = "update customer_data\n" +
                    "set acc_pin = ?\n" +
                    "where acc_num = ?;";

            PreparedStatement p = con.prepareStatement(k);
            p.setInt(1, pin);
            p.setInt(2,acc_num);

            p.executeUpdate();

            return true;
        }
        catch (Exception e)
        {
            System.out.println("Error while making the changes in pin...");
        }
        return false;
    }

}

