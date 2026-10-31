package org.example;

class Building {
    private String address;
    private int floors;
    private double area;

    public Building(String address, int floors, double area) {
        this.address = address;
        this.floors = floors;
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public int getFloors() {
        return floors;
    }

    public double getArea() {
        return area;
    }

    // СТАТИЧЕСКИЙ ПОЛИМОРФИЗМ
    public void build() {
        System.out.println("Строю здание по адресу: " + address);
    }

    public void build(int customFloors) {
        System.out.println("Строю здание по адресу " + address + " с " + customFloors + " этажами.");
    }

    public void build(String material) {
        System.out.println("Строю здание по адресу " + address + " из материала: " + material);
    }

    // Метод для динамического полиморфизма
    public String getPurpose() {
        return "Неизвестно";
    }

    @Override
    public String toString() {
        return String.format("Здание [Адрес: %s | Этажей: %d | Площадь: %.1f кв.м | Назначение: %s]",
                address, floors, area, getPurpose());
    }
}
