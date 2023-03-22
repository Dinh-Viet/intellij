package com.class2;

import java.util.Scanner;

public class sum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = input.nextInt();
        int sum = 0;

        for(int i = num; i > 0; i /=10){
            sum += i % 10;
        }
        System.out.println("Sum digit: " + sum);
    }
}
