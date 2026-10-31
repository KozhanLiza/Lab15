package org.example;

// Базовый класс
class CelestialBody {
    private String name;
    private double mass;
    private double diameter;

    public CelestialBody(String name, double mass, double diameter) {
        this.name = name;
        this.mass = mass;
        this.diameter = diameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public String getType() {
        return "Небесное тело";
    }

    @Override
    public String toString() {
        return String.format("Тип: %s | Название: %s | Масса: %.2e кг | Диаметр: %.0f км",
                getType(), name, mass, diameter);
    }
}
