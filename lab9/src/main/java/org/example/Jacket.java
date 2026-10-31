package org.example;

// Куртка
class Jacket extends Clothing {
    private String material;

    public Jacket(String brand, String size, String color, String material) {
        super(brand, size, color);
        this.material = material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getSeason() {
        return "Осень/Зима";
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    @Override
    public String toString() {
        return "[Куртка] " + super.toString();
    }
}
