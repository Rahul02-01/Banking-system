package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class delacc {

    Scanner sc = new Scanner(System.in);
    delacc(){
        System.out.println("Enter the account number which needs to be deleted =");
        int ac = sc.nextInt();
        boolean b = acc_check(ac);
        if (b){
            try{
                Connection con = c.cc1();

                String q = "delete from customer_data where acc_num = ?;";

                PreparedStatement p = con.prepareStatement(q);
                p.setInt(1,ac);
                p.executeUpdate();
                System.out.println("Account deleted successfully!!!");
            }
            catch(Exception e){
                System.out.println("nope");
            }
        }
        else {
            System.out.println("Account not found!!!");
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
}
