package org.example;

// Checked-исключение для ошибок обслуживания
class MaintenanceException extends Exception {
    private String brand;

    public MaintenanceException(String message, String brand) {
        super(message);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
