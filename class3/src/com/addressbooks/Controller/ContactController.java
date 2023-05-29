package com.addressbooks.Controller;

import com.addressbooks.Contact;
import com.task.Util.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactController {
    public static boolean addContact(Contact Contacts){

        Connection conn = null;
        CallableStatement stmt = null;
        boolean isSuccessful = false;

        try {
            conn = DBConnection.getConnection();
            stmt = (CallableStatement) conn.prepareStatement("INSERT INTO Contact(NAME, COMPANY, EMAIL, PHONE_NUMBER) VALUES(?, ?, ?, ?)");
            stmt.setString(1, Contacts.getNAME());
            stmt.setString(2, Contacts.getCOMPANY());
            stmt.setString(3, Contacts.getEMAIL());
            stmt.setString(4, Contacts.getPHONE_NUMBER());

            if (stmt.executeUpdate() > 0) {
                isSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccessful;
    }
    public static List<Contact> getContacts() {

        List<Contact> contacts = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Contacts");

            while (resultSet.next()) {
                String NAME = resultSet.getString(2);
                String COMPANY = resultSet.getString(3);
                String EMAIL = resultSet.getString(4);
                String PHONE_NUMBER = resultSet.getString(5);
                Contact contact = new Contact(NAME, COMPANY, EMAIL, PHONE_NUMBER);
                contacts.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contacts;
    }
}
