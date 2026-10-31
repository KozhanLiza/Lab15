package org.example;

// Абстрактный класс
abstract class Clothing {
    private String brand;
    private String size;
    private String color;

    public Clothing(String brand, String size, String color) {
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Абстрактные методы (без реализации)
    public abstract String getSeason();

    public abstract String getMaterial();

    // Конкретный метод
    public String getBasicInfo() {
        return String.format("Бренд: %s | Размер: %s | Цвет: %s", brand, size, color);
    }

    @Override
    public String toString() {
        return String.format("%s | Сезон: %s | Материал: %s", getBasicInfo(), getSeason(), getMaterial());
    }
}
