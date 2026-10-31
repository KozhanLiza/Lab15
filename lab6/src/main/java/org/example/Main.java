package org.example;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle(12.3);
        Circle c3 = new Circle(2.5);
        System.out.println("Параметры окружностей:");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println("Изменяем радиус первой окружности:");
        c1.setRadius(8.0);
        System.out.println(c1);
    }
}