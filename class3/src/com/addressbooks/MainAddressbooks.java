package com.addressbooks;

import java.util.ArrayList;
import java.util.Scanner;


public class MainAddressbooks {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        ContactManagement cm = new ContactManagement();
        Scanner scanner = new Scanner(System.in);
        int Menu;
        do {
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by id");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");

            Menu = scanner.nextInt();

            switch (Menu) {
                case 1:
                    Contact ct = new Contact();
                    ct.inputData();
                    cm.addContact(ct);
                    break;

                case 2:
                    System.out.println(" Enter id");
                    int id=scanner.nextInt();

                    Contact ps=ContactManagement.getContactById(id);
                    if (ps!=null){
                        System.out.println(ps.toString());
                    }else{
                        System.out.println("Not found");
                    }
                    break;

                case 3:
                    ContactManagement.DisplayContact();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (Menu != 4);
    }
}
