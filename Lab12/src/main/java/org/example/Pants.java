package org.example;

// 3. Наследник "Pants" (Брюки)
class Pants extends Garment {
    private double length;

    public Pants(String name, String id, String size, double length) {
        super(name, id, size);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Длина: %.1f см [Брюки]", length);
    }
}
