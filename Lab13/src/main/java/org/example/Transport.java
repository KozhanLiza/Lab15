package org.example;

// Класс Transport
class Transport {
    private String type;
    private String brand;
    private int year;
    private int capacity;
    private double fuelConsumption; // расход топлива на 100 км

    // Конструктор теперь вызывает сеттеры для валидации данных
    public Transport(String type, String brand, int year, int capacity, double fuelConsumption)
            throws InvalidTransportDataException {
        this.type = type;
        this.brand = brand;
        setYear(year);                 // Вызываем сеттер с проверкой
        setCapacity(capacity);         // Вызываем сеттер с проверкой
        this.fuelConsumption = fuelConsumption;
    }

    public String getType() { return type; }
    public String getBrand() { return brand; }
    public int getYear() { return year; }
    public int getCapacity() { return capacity; }
    public double getFuelConsumption() { return fuelConsumption; }

    // Сеттеры с логикой проверки (выбрасывают Checked-исключение)
    public void setYear(int year) throws InvalidTransportDataException {
        if (year <= 1900) {
            throw new InvalidTransportDataException("Год выпуска должен быть больше 1900 (указано: " + year + ")");
        }
        this.year = year;
    }

    public void setCapacity(int capacity) throws InvalidTransportDataException {
        if (capacity <= 0) {
            throw new InvalidTransportDataException("Вместимость должна быть больше 0 (указано: " + capacity + ")");
        }
        this.capacity = capacity;
    }

    public void setType(String type) { this.type = type; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setFuelConsumption(double fuelConsumption) { this.fuelConsumption = fuelConsumption; }

    // Метод обслуживания (MaintenanceException для старой техники)
    public void service() throws MaintenanceException {
        if (year < 2010) {
            throw new MaintenanceException("Транспорт старше 2010 года требует капитального ремонта двигателя!", brand);
        }
        System.out.println("Техническое обслуживание транспорта " + brand + " успешно завершено.");
    }

    public double calculateFuel(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Дистанция не может быть отрицательной!");
        }
        return (distance / 100.0) * fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("[%s] Марка: %s | Год: %d | Вместимость: %d чел. | Расход: %.1f л/100км",
                type, brand, year, capacity, fuelConsumption);
    }
}
