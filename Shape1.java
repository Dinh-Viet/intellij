package shape;

import java.util.Scanner;

abstract class Shape1 {
    abstract double getArea();

    abstract double getPerimeter();

    abstract void input(Scanner in);

    public abstract String toString();
}
class Circle extends Shape1{
    double r;

    @Override
    double getArea() {
        return Math.PI * r * r;
    }

    @Override
    double getPerimeter() {
        return Math.PI * 2 * r;
    }

    @Override
    void input(Scanner in) {
        System.out.println("Please input radius of Circle ");
        r = in.nextDouble();
    }

    @Override
    public String toString() {
        return "Circle (r=" + r + ")" +
                " : P= " + getPerimeter() + ";S= " + getArea();
    }

}
class Triangle extends Shape1 {
    double a;
    double b;
    double c;

    @Override
    double getArea() {
        double p = this.getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    void input(Scanner in) {
        System.out.println("Please input side A of Triangle: ");
        a = in.nextDouble();
        System.out.println("Please input side B of Triangle: ");
        b = in.nextDouble();
        System.out.println("Please input side C of Triangle: ");
        c = in.nextDouble();
    }

    @Override
    public String toString() {
        return "Triangle (a=" + a + ";b=" + b + ";c=" + c +")" +
                " : P= " + getPerimeter() + ";S= " + getArea();
    }

}

class Rectangle extends Shape1 {
    double a;
    double b;

    @Override
    double getArea() {
        return a * b;
    }

    @Override
    double getPerimeter() {
        return (a + b) * 2;
    }

    @Override
    void input(Scanner in) {
        System.out.println("Please input length of Rectangle: ");
        a = in.nextDouble();
        System.out.println("Please input side width of Rectangle: ");
        b = in.nextDouble();
    }

    @Override
    public String toString() {
        return "Rectangle (a=" + a + ";b=" + b + ")" +
                " : P= " + getPerimeter() + ";S= " + getArea();
    }
}

