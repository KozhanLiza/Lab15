package org.example;

// Компьютер
class Computer implements Connectable, Configurable {
    private String model;
    private boolean connected;
    private String os;

    public Computer(String model, String os) {
        this.model = model;
        this.os = os;
        this.connected = false;
    }

    public String getModel() {
        return model;
    }

    public String getOs() {
        return os;
    }

    // Реализация методов Connectable
    @Override
    public void connect() {
        this.connected = true;
        System.out.println("Компьютер " + model + " (" + os + ") подключен к сети.");
    }

    @Override
    public void disconnect() {
        this.connected = false;
        System.out.println("Компьютер " + model + " отключен от сети.");
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    // Реализация методов Configurable
    @Override
    public void configure(String settings) {
        System.out.println("На ПК " + model + " применена сетевая конфигурация: " + settings);
    }

    @Override
    public void reset() {
        System.out.println("Сетевые настройки ПК " + model + " сброшены к исходным.");
    }

    @Override
    public String toString() {
        return String.format("Компьютер [%s | ОС: %s | Статус: %s]",
                model, os, connected ? "В сети" : "Не в сети");
    }
}
