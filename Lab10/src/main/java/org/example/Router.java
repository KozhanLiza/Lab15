package org.example;

// Роутер
class Router implements Connectable, Configurable {
    private String model;
    private boolean connected;
    private String settings;

    public Router(String model) {
        this.model = model;
        this.connected = false;
        this.settings = "По умолчанию";
    }

    public String getModel() {
        return model;
    }

    // Реализация методов Connectable
    @Override
    public void connect() {
        this.connected = true;
        System.out.println("Роутер " + model + " подключен к провайдеру.");
    }

    @Override
    public void disconnect() {
        this.connected = false;
        System.out.println("Роутер " + model + " отключен.");
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    // Реализация методов Configurable
    @Override
    public void configure(String settings) {
        this.settings = settings;
        System.out.println("Роутер " + model + " настроен: " + settings);
    }

    @Override
    public void reset() {
        this.settings = "По умолчанию";
        System.out.println("Настройки роутера " + model + " сброшены.");
    }

    @Override
    public String toString() {
        return String.format("Роутер [%s | Статус: %s | Настройки: %s]",
                model, connected ? "Подключен" : "Отключен", settings);
    }
}
