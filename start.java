package com.bank;

import java.sql.SQLOutput;
import java.util.Scanner;

public class start {

    // Starting point of the program...
    public static void sp() {
        Scanner sc = new Scanner(System.in);

        // k is taken for looping the manager part...
        boolean k = false;
        // j is taken for looping the customer part...
        boolean j = false;
        // this is done for looping the entire switch case ...
        boolean signal = false;
        while (!signal) {

            System.out.println("Press 1 to login as a manager");
            System.out.println("Press 2 to login as a customer");
            System.out.println("Press 3 to exit");

            try{
                System.out.println("Enter the way you want to login=");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        // Manager part..

                        // Taking the inputs from the user...
                        System.out.printf("Enter the Id = ");
                        int i = sc.nextInt();
                        System.out.printf("Enter the Password = ");
                        int password = sc.nextInt();
                        manager m = new manager();
                        m.man(i,password);
                        break;

                    case 2:
                        // Customer part

                        // Taking the inputs from the customer..
                        System.out.println("Enter the account number = ");
                        int cust_num = sc.nextInt();
                        System.out.println("Enter the pin = ");
                        int cust_pin = sc.nextInt();
                        // making the object for customer..
                        customer o = new customer();
                        o.cust(cust_num,cust_pin);

                        break;

                    case 3:
                        System.out.println("Thank you for using our system");
                        signal = true;
                        break;

                    default:
                        System.out.println("Enter the correct option number..");
                }

            }catch (Exception e){
                System.out.println("Please enter the correct option...");
            }
                    }
    }
}
