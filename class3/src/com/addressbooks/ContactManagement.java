package com.addressbooks;

import com.addressbooks.Controller.ContactController;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactManagement {

    private static List<Contact> contacts;
    public ContactManagement(){

        refreshcontacts();
    }


    public static void addContact() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            throw new Exception("Name must not be empty");
        }

        System.out.print("Enter company: ");
        String company = scanner.nextLine();
        if (company.isEmpty()) {
            throw new Exception("Company must not be empty");
        }

        // Validate email
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";;
        if (!validate(email, emailRegex)) {
            throw new Exception("Invalid email");
        }
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        String phoneRegex = "0[0-9]+";
        if (!validate(phone, phoneRegex)) {
            throw new Exception("Invalid phone number");
        }

        Contact contact = new Contact(name, company, email, phone);
        ContactController.addContact(contact);
        refreshcontacts();
    }

        public static void FindContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        Contact result = null;
        for (Contact contact : contacts) {
            if (contact.getNAME().equalsIgnoreCase(name)) {
                result = contact;
                break;
            }
        }
        if (result != null) {
            System.out.printf("%-15s %-15s %-25s %-25s%n", "Contact Name", "Company", "Email", "Phone Number");
            System.out.printf("%-15s %-15s %-25s %-25s%n", result.getNAME(), result.getCOMPANY(), result.getEMAIL(), result.getPHONE_NUMBER());
        } else {
            System.out.println("Not found");
        }
    }
    public static void DisplayContacts() {
        System.out.println(" ".repeat(25) + " Address Book " + " ".repeat(35));
        System.out.printf("%-15s %-15s %-25s %-25s%n", "Contact Name", "Company", "Email", "Phone Number");
        for (Contact contact : contacts) {
            System.out.printf("%-15s %-15s %-25s %-25s%n", contact.getNAME(), contact.getCOMPANY(), contact.getEMAIL(), contact.getPHONE_NUMBER());
        }
    }
    private static void refreshcontacts() {
        contacts = ContactController.getContacts();
    }
    private static boolean validate(String input, String rawPattern) {
        Pattern pattern = Pattern.compile(rawPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
