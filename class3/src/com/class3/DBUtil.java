package com.class3;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=T2210M_JDBC","sa","1172004" );
        } catch ( Exception e) {
            throw new Exception(e.getMessage());
        }
        return conn;
    }
}
