package com.bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class customer {

    Scanner sc = new Scanner(System.in);

    // Customer work...
    public void cust(int cn,int cp){ // cn here and everywhere related to customer
        // is the account number and cp is customer pin..

        boolean b = false;   // used for the looping process if incorrect data is provided...
        // Verification..
        int flag=0;
        do {
            if (flag==0){
                b = check2(cn,cp);
                flag=1;
            }
            else {
                System.out.printf("Enter the Id = ");
                int i = sc.nextInt();
                b = check2(cn,cp);
            }
        }while (!b);

        // if user exits the customer portal once and again enters
        // and gives wrong info then the entire
        // thing can work again
        flag = 0;

        try{
            boolean p = false;
            while (!p){
                System.out.println("1. View account details" +
                        "\n2. Deposit cash" +
                        "\n3. Withdraw cash" +
                        "\n4. Exit");
                System.out.println("\nWhat work do you want to perform = ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        // View account details..
                        dispacc obj1 = new dispacc(cn);
                        break;

                    case 2:
                        // Deposit cash..
                        deposit obj2 = new deposit(cn);
                        break;

                    case 3:
                        // Withdraw cash..
                        withdraw obj3 = new withdraw(cn);
                        break;

                    case 4:
                        // Exit
                        System.out.println("Exiting from the customer portal...");
                        p = true;
                        break;

                    default:
                        System.out.println("Enter the correct option...");
                }
            }
        }
        catch (Exception e){
            System.out.println("Please enter the correct option...");
        }
    }

    // Customer details checking...
    public boolean check2(int cn,int cp){
        try{
            // Getting the connection..
            Connection con = c.cc1();

            // Query that needs to be fired..
            String q = "select * from customer_data;";

            // Statement(static query)..
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(q);

            while (r.next()){
                int acc_num = r.getInt("acc_num");
                if (acc_num == cn){
                    System.out.println("\nAccess granted..");
                    System.out.println("\nWelcome "+ r.getString("acc_name"));
                    return true;
                }
            }
        }
        catch (Exception e){
            System.out.println("\nSorry couldn't perform your operation...");
        }
        return false;
    }



}
