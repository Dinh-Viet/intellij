package com.JSON;

import com.JSON.Controller.PostController;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONManegement {

    PostController postController = new PostController();
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



            org.json.JSONArray jsonArray = new JSONArray(response.toString());
            Post[] posts = new Post[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Post post = new Post(
                        Integer.parseInt(jsonObject.get("id").toString()),
                        Integer.parseInt(jsonObject.get("userId").toString()),
                        jsonObject.get("title").toString(),
                        jsonObject.get("body").toString()
                );
                posts[i] = post;
            }
            postController.insertNewPost(posts);
            con.disconnect();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

