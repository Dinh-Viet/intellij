package com.JSON;

public class MainJson{
    public static void main(String[] args) {

        try {
            JSONManegement jsonManegement = new JSONManegement();
            jsonManegement.readJSONFromAPI();
            UserManegement userManegement = new UserManegement();
            userManegement.readUserFromAPI();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
