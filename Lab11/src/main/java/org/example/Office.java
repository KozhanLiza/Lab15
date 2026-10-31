package org.example;

class Office extends Building {
    private int meetingRoomsCount;

    public Office(String address, int floors, double area, int meetingRoomsCount) {
        super(address, floors, area);
        this.meetingRoomsCount = meetingRoomsCount;
    }

    public int getMeetingRoomsCount() {
        return meetingRoomsCount;
    }

    // ДИНАМИЧЕСКИЙ ПОЛИМОРФИЗМ
    @Override
    public String getPurpose() {
        return "Офис";
    }

    // Собственный перегруженный метод в дочернем классе
    public void build(String material, boolean hasParking) {
        System.out.printf("Строю бизнес-центр (%s) из %s. Паркинг: %s.%n",
                getAddress(), material, hasParking ? "предусмотрен" : "отсутствует");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Переговорных: %d", meetingRoomsCount);
    }
}
