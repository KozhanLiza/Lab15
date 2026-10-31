package org.example;

class Circle {
    private double radius;
    private int count;
    public int getCount()
    {
        return count;
    }
    public void setCount (int c)
    {
        count = c;
    }
    public Circle (double r, int c)
    {
        this(r);
        setCount(c);
    }


    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Ошибка: Радиус должен быть положительным числом!");
        }
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Окружность: Радиус: %.2f, Площадь: %.2f, Длина: %.2f", radius, area(), circumference());
    }
}
