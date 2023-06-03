package com.JSON.Controller;

import com.JSON.User;
import com.JSON.Util.DBConnection;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserController {
    String INSERT_User = "INSERT INTO user VALUES(?,?,?,?,?,?,?,?)";

    public boolean insertNewUser(User[] users) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBConnection.getConnection();
            for (User user: users){
                preparedStatement
                        = connection.prepareStatement(INSERT_User);
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getUsername());
                preparedStatement.setString(4, user.getEmail());
                JSONObject addressJson = new JSONObject();
                addressJson.put("street", user.getAddress().getStreet());
                addressJson.put("suite", user.getAddress().getSuite());
                addressJson.put("city", user.getAddress().getCity());
                addressJson.put("zipcode", user.getAddress().getZipcode());
                JSONObject geoJson = new JSONObject();
                geoJson.put("lat", user.getAddress().getGeo().getLat());
                geoJson.put("lng", user.getAddress().getGeo().getLng());

                addressJson.put("geo", geoJson);
                preparedStatement.setString(5, addressJson.toString());
                preparedStatement.setString(6, user.getPhone());
                preparedStatement.setString(7, user.getWebsite());
                JSONObject companyOject = new JSONObject();
                companyOject.put("name", user.getCompany().getName());
                companyOject.put("catchPhrase", user.getCompany().getCatchPhrase());
                companyOject.put("bs", user.getCompany().getBs());
                preparedStatement.setString(8, companyOject.toString());

                if(preparedStatement.executeUpdate() > 0) {
                    System.out.println("User addecd");
                }
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}

