package com.addressbooks;

import com.addressbooks.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContactManagement {
    public void addContact(Contact contact) throws Exception{
        try {
            Connection conn = com.addressbooks.Util.DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Contacts(NAME,COMPANY, EMAIL,PHONE_NUMBER) VALUES (?,?,?,?)");
            pstmt.setString(1,contact.getNAME());
            pstmt.setString(2,contact.getCOMPAYNY());
            pstmt.setString(3,contact.getEMAIL());
            pstmt.setString(4,contact.getPHONE_NUMBER());

            int updated = pstmt.executeUpdate();
            if(updated > 0) {
                System.out.println("Insert Contact success!!!");
            }

            pstmt.close();
            conn.close();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public static Contact getContactById(int id) throws Exception {

        Contact contact = null;

        try {
            Connection conn =  DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT ID, NAME, COMPANY, EMAIL,PHONE_NUMBER FROM Contacts WHERE Id = ?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                contact = new Contact(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return contact;
    }
    public static void DisplayContact() throws Exception{
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT ID, NAME, COMPANY, Email, PHONE_NUMBER FROM Contacts");

            while(rs.next()) {
                Contact contact = new Contact(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );

                System.out.println(contact.toString());
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
