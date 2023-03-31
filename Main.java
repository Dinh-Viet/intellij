package shape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, answer;
        Shape1[] arrShape;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of shape to be calculated:");

        n = in.nextInt();
        arrShape = new Shape1[n];

        for (int i = 0; i < n; i++) {
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            System.out.println("3. Triangle");
            answer = in.nextInt();
            switch (answer) {
                case 1:
                    arrShape[i] = new Rectangle();
                    arrShape[i].input(in);
                    break;
                case 2:
                    arrShape[i] = new Circle();
                    arrShape[i].input(in);
                    break;
                case 3:
                    arrShape[i] = new Triangle();
                    arrShape[i].input(in);
                    break;
                default:
                    break;
            }
        }

        System.out.println("---Result---");
        for (int i = 0; i < n; i++) {
            System.out.println(arrShape[i]);
            System.out.println("-->");
        }
    }
}
