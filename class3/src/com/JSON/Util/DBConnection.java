package com.JSON.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsonAPI", "Doanhviet", "1172004Viet@");
            return connection;
        } catch (Exception e) {
            throw new Exception("Connection failure!");
        }
    }
}
