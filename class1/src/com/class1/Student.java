package com.class1;

import java.util.Scanner;

public class Student {
    int id;
    String name;
    String email;

    public void inputData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter id: ");
        this.id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter name: ");
        this.name = scanner.nextLine();


        System.out.println("Enter Email: ");
        this.email = scanner.nextLine();



    }
    public void displayData(){
        System.out.println("Id" +this.id);
        System.out.println("Name" +this.name);
        System.out.println("Email" +this.email);
    }
}
