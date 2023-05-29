package com.addressbooks;

import java.util.Scanner;

public class Contact {
        private String NAME;

        private String COMPAYNY;

        private String EMAIL;

        private String PHONE_NUMBER;

        public Contact(int anInt, String NAME, String COMPAYNY, String EMAIL, String PHONE_NUMBER) {
            this.NAME = NAME;
            this.COMPAYNY = COMPAYNY;
            this.EMAIL = EMAIL;
            this.PHONE_NUMBER = PHONE_NUMBER;
        }

        public Contact() {

        }

        public String getNAME() {
            return NAME;
        }

        public String getCOMPAYNY() {
            return COMPAYNY;
        }

        public String getEMAIL() {
            return EMAIL;
        }

        public String getPHONE_NUMBER() {
            return PHONE_NUMBER;
        }
        public void inputData(){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Name:");
            this.NAME = input.nextLine();
            System.out.println("Enter Company:");
            this.COMPAYNY = input.nextLine();
            System.out.println("Enter Email:");
            this.EMAIL = input.nextLine();
            System.out.println("Enter Phone:");
            this.PHONE_NUMBER = input.nextLine();
        }
        public String toString() {
            return "Name: " + NAME + ", Company: " + COMPAYNY + ", Email: " + EMAIL + ", Phone: " + PHONE_NUMBER;
        }
}
