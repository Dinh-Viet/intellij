package com.JSON;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONManegement {
    public void readJSONFromAPI() throws Exception{
        try{
            String apiURL = "https://jsonplaceholder.typicode.com/posts";
            URL url = new URL(apiURL);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());

            org.json.JSONArray jsonArray = new JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Post post = new Post();
                post.setId(Integer.parseInt(jsonObject.get("id").toString()));
                post.setUserId(Integer.parseInt(jsonObject.get("userId").toString()));
                post.setTitle(jsonObject.get("title").toString());
                post.setBody(jsonObject.get("body").toString());

                System.out.println(post.toString());
            }
            con.disconnect();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

