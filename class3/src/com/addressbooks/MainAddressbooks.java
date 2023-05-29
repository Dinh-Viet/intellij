package com.addressbooks;

import java.util.Scanner;


public class MainAddressbooks {

    public static void main(String[] args) throws Exception {

        ContactManagement cm = new ContactManagement();
        Scanner scanner = new Scanner(System.in);
        boolean isMenu = false;


        while (!isMenu) {
            System.out.println();
            System.out.println("*".repeat(11) + " Welcome to Address Book program " + "*".repeat(11));
            System.out.println("""
                    1. Add new contact
                    2. Find a contact by name
                    3. Display contacts 
                    4. Exit """);
            System.out.print("Enter your selection: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println();
                    System.out.println("-".repeat(11) + " Add new contact " + "-".repeat(11));
                    try {
                        cm.addContact();
                        System.out.println("Add new contact successfully");
                    } catch (ArithmeticException e) {
                        System.out.println("Add new contact failed" + e.getMessage());
                    }
                }

                case "2" -> {
                    System.out.println();
                    System.out.println("-".repeat(11) + " Find a contact by name " + "-".repeat(11));
                    cm.FindContact();
                }
                case "3" -> {
                    System.out.println();
                    System.out.println("-".repeat(11) + " Find a contact by name " + "-".repeat(11));
                    cm.DisplayContacts();
                }
                case "4" -> {
                    isMenu = true;
                }
            }
        }
    }
}
