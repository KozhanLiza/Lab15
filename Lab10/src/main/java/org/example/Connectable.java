package org.example;

// Подключение
interface Connectable {
     final int nameM=6;
    void connect();

    void disconnect();

    boolean isConnected();

    // Опциональный статический метод интерфейса
    static void printConnectableInfo() {
        System.out.println("[Справка]: Устройство поддерживает сетевое подключение.");
    }
}
