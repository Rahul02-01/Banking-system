package com.bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class manager {

    // Manager verification...

    public boolean check1(int id, int password){

        try {
            // Getting the connection
            Connection con = c.cc();

            // Giving the orders...
            String p = "select * from manager_data;";

            // Statement for static query..
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(p);
            while (r.next()){
                int i = r.getInt("man_id");
                int pass = r.getInt("man_pass");

                // Checking the id and password for verification..
                if (id == i && password == pass){
                    System.out.println("Access granted...");
                    return true;
                }
                else {
                    System.out.println("Info not matched...Access denied");
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    // Manager work...

    public void man(int id, int password){

        Scanner sc = new Scanner(System.in);
        boolean b = false;   // used for the looping process if incorrect data is provided...
        // Verification..
        int flag=0;
        do {
            if (flag==0){
                b = check1(id,password);
                flag=1;
            }
            else {
                System.out.printf("Enter the Id = ");
                int i = sc.nextInt();
                System.out.printf("Enter the Password = ");
                int pass = sc.nextInt();
                b = check1(i,pass);
            }
        }while (b == false);

        // if user exits the manager portal once and again enters
        // and gives wrong info then the entire
        // thing can work again
        flag = 0;

        boolean l = false;
        do {
            // Things manager can do..

            System.out.println(" 1.Add an account" +
                    "\n 2.Edit existing account" +
                    "\n 3.Delete an account" +
                    "\n 4.Display account" +
                    "\n 5.Display the entire database" +
                    "\n 6.Exit ");
            try{
                System.out.println("What work do you want to do=");
                int ch = sc.nextInt();
                switch (ch){
                    case 1:
                        // Object creation and constuctor invoking done here...
                        addacc obj1 = new addacc();
                        break;

                    case 2:
                        // Editing the account...
                        editacc obj2 = new editacc();
                        break;

                    case 3:
                        // Delete an account...
                        delacc obj3 = new delacc();
                        break;

                    case 4:
                        // Displaying a specific account details...
                        dispacc obj4 = new dispacc();
                        break;

                    case 5:
                        // Displaying the entire database....
                        dispdat obj5 = new dispdat();
                        break;

                    case 6:
                        // Return to the home menu...
                        System.out.println("Exiting the manager portal...");
                        l = true;


                }
            }catch (Exception e){
                System.out.println("Please enter correct option...");
            }
        }while (!l);

    }
}
