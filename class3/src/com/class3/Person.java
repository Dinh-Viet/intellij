package com.class3;

import java.util.Scanner;

public class Person {
    int id;
    String name;
    String email;
    String address;
    String phone;

    public Person(int id, String name, String email, String address, String phone){
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Person() {

    }


    public void inputData(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name:");
        this.name = input.nextLine();
        System.out.println("Enter Email:");
        this.email = input.nextLine();
        System.out.println("Enter Address:");
        this.address = input.nextLine();
        System.out.println("Enter Phone:");
        this.phone = input.nextLine();
    }


    @Override
    public String toString(){
        return this.id + "," + this.name + "," + this.email + "," + this.address + "," + this.phone ;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone =phone;
    }
}
