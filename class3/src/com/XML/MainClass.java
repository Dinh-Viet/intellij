package com.XML;

import com.task.Util.DBConnection;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MainClass {
    public static void main(String[] args) {
        try {
            File inputFile = new File("breakfast_menu.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root Name " + doc.getDocumentElement().getNodeName());

            NodeList foods = doc.getElementsByTagName("food");
            for (int i = 0; i < foods.getLength(); i++) {
                Element food = (Element) foods.item(i);
                Food food1 = new Food();
                System.out.println("----Food----");

                String isvalues = food.getAttribute("id");
                System.out.println("Values id: " + isvalues);

                //Get Name
                NodeList nameList = food.getElementsByTagName("name");
                if (nameList != null) {
                    String name = nameList.item(0).getTextContent();
                    System.out.println("\tName: " + name);
                    food1.setName(name);
                }

                NodeList priceList = food.getElementsByTagName("price");
                if (priceList != null) {
                    String price = priceList.item(0).getTextContent();
                    System.out.println("\tPrice: " + price);
                    food1.setPrice(price);
                }

                NodeList descriptionList = food.getElementsByTagName("description");
                if (descriptionList != null) {
                    String description = descriptionList.item(0).getTextContent();
                    System.out.println("\tDescription: " + description);
                    food1.setDescription(description);
                }

                NodeList caloriesList = food.getElementsByTagName("calories");
                if (caloriesList != null) {
                    String calories = caloriesList.item(0).getTextContent();
                    System.out.println("\tCalories: " + calories);
                    food1.setCalories(calories);
                }
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into breakfast(Name, Price, Desriprion, Calories) VALUES (?, ?, ?,?)");
                preparedStatement.setString(1, food1.getName());
                preparedStatement.setString(2, food1.getPrice());
                preparedStatement.setString(3, food1.getDescription());
                preparedStatement.setString(4, food1.getCalories());

                if(preparedStatement.executeUpdate() > 0){
                    System.out.println("Food addecd");
                }
                preparedStatement.close();
                connection.close();
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
