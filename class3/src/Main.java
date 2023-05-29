import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {
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
                System.out.println("----Food----");

                String isvalues = food.getAttribute("id");
                System.out.println("Values id: " + isvalues);

                //Get Name
                NodeList nameList = food.getElementsByTagName("name");
                if (nameList != null) {
                    String name = nameList.item(0).getTextContent();
                    System.out.println("\tName: " + name);
                }

                NodeList priceList = food.getElementsByTagName("price");
                if (priceList != null) {
                    String price = priceList.item(0).getTextContent();
                    System.out.println("\tPrice: " + price);
                }

                NodeList descriptionList = food.getElementsByTagName("description");
                if (descriptionList != null) {
                    String description = descriptionList.item(0).getTextContent();
                    System.out.println("\tDescription: " + description);
                }

                NodeList caloriesList = food.getElementsByTagName("calories");
                if (caloriesList != null) {
                    String calories = caloriesList.item(0).getTextContent();
                    System.out.println("\tCalories: " + calories);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //students
        try {
            File inputFile = new File("student.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root Name " + doc.getDocumentElement().getNodeName());

            NodeList students = doc.getElementsByTagName("student");
            for (int i = 0; i < students.getLength(); i++) {
                Element food = (Element) students.item(i);
                System.out.println("----Student----");
                String isvalues = food.getAttribute("id");
                System.out.println("Values id: " + isvalues);

                //Get Name
                NodeList nameList = food.getElementsByTagName("firstname");
                if (nameList != null) {
                    String firstname = nameList.item(0).getTextContent();
                    System.out.println("\tFirstname: " + firstname);
                }

                NodeList priceList = food.getElementsByTagName("lastname");
                if (priceList != null) {
                    String lastname = priceList.item(0).getTextContent();
                    System.out.println("\tLastname: " + lastname);
                }

                NodeList descriptionList = food.getElementsByTagName("age");
                if (descriptionList != null) {
                    String age = descriptionList.item(0).getTextContent();
                    System.out.println("\tAge: " + age);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}