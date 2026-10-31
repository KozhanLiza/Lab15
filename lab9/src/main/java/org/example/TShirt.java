package org.example;

// Футболка
class TShirt extends Clothing {
    private String print;

    public TShirt(String brand, String size, String color, String print) {
        super(brand, size, color);
        this.print = print;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    @Override
    public String getSeason() {
        return "Весна/Лето";
    }

    @Override
    public String getMaterial() {
        return "Хлопок";
    }

    @Override
    public String toString() {
        return String.format("[Футболка] %s | Принт: \"%s\"", super.toString(), print);
    }
}
