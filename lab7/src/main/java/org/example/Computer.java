package org.example;

class Computer {
    private String brand;
    private String processor;
    private int ram;

    private static int totalComputers = 0;
    private static int totalRAM = 0;

    public static String Print() {
        return String.format("Компьютер: %d, ОЗУ: %d ГБ", totalComputers, totalRAM);
    }

    public Computer(String brand, String processor, int ram) {
        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        totalComputers++;
        totalRAM += ram;
    }

    public String getBrand() {
        return brand;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public static double getAverageRAM() {
        if (totalComputers == 0) {
            return 0;
        }
        return (double) totalRAM / totalComputers;
    }

    public static int getTotalComputers() {
        return totalComputers;
    }

    public static int getTotalRAM() {
        return totalRAM;
    }

    @Override
    public String toString() {
        return String.format("Компьютер: %s, Процессор: %s, ОЗУ: %d ГБ", brand, processor, ram);
    }
}
