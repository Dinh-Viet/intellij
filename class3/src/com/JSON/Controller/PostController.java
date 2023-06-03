package com.JSON.Controller;

import com.JSON.Post;
import com.JSON.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PostController {
    String INSERT_POST = "INSERT INTO post VALUES(?,?,?,?)";

    public boolean insertNewPost(Post[] posts) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBConnection.getConnection();
            for (Post post: posts){
                preparedStatement
                        = connection.prepareStatement(INSERT_POST);
                preparedStatement.setInt(1, post.getId());
                preparedStatement.setInt(2, post.getUserId());
                preparedStatement.setString(3, post.getTitle());
                preparedStatement.setString(4, post.getBody());

                if(preparedStatement.executeUpdate() > 0) {
                    System.out.println("Post addecd");
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
