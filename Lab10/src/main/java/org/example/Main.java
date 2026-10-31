package org.example;

public class Main {
    public static void main(String[] args) {
        // Вызов статического метода интерфейса
        Connectable.printConnectableInfo();
        System.out.println();

        Connectable[] devices = new Connectable[5];

        devices[0] = new Router("TP-Link Archer");
        devices[1] = new Router("ASUS RT-AX88U");
        devices[2] = new Router("Keenetic Giga");
        devices[3] = new Computer("MacBook Pro", "macOS");
        devices[4] = new Computer("Lenovo ThinkPad", "Windows 11");

        System.out.println("\nПОДКЛЮЧЕНИЕ УСТРОЙСТВ\n");
        for (Connectable device : devices) {
            device.connect();
        }

        System.out.println("\nКОНФИГУРАЦИЯ УСТРОЙСТВ\n");
        for (Connectable device : devices) {
            if (device instanceof Configurable) {
                Configurable configurableDevice = (Configurable) device;
                configurableDevice.configure("IP: 192.168.1.x, Subnet: 255.255.255.0");
            }
        }

        System.out.println("\nТЕКУЩЕЕ СОСТОЯНИЕ УСТРОЙСТВ\n");
        for (Connectable device : devices) {
            System.out.println(device);
        }
    }
}