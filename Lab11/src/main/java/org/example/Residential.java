package org.example;

class Residential extends Building {
    private int apartmentsCount;

    public Residential(String address, int floors, double area, int apartmentsCount) {
        super(address, floors, area);
        this.apartmentsCount = apartmentsCount;
    }

    public int getApartmentsCount() {
        return apartmentsCount;
    }

    // ДИНАМИЧЕСКИЙ ПОЛИМОРФИЗМ
    @Override
    public String getPurpose() {
        return "Жилой дом";
    }

    // Собственный перегруженный метод в дочернем классе
    public void build(int floors, boolean hasElevator) {
        System.out.printf("Строю жилой дом (%s) на %d этажей. Лифт: %s.%n",
                getAddress(), floors, hasElevator ? "есть" : "нет");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Квартир: %d", apartmentsCount);
    }
}
