package org.example;

public class Main {
    public static void main(String[] args) {
        Computer pc1 = new Computer("ASUS", "Intel Core i5", 16);
        Computer pc2 = new Computer("Lenovo", "AMD Ryzen 7", 32);
        Computer pc3 = new Computer("Apple", "M2", 8);
        Computer pc4 = new Computer("HP", "Intel Core i7", 16);
        Computer pc5 = new Computer("MSI", "Intel Core i9", 64);
        System.out.println("Список компьютеров");
        System.out.println(pc1);
        System.out.println(pc2);
        System.out.println(pc3);
        System.out.println(pc4);
        System.out.println(pc5);

        System.out.println("Статистика");
        System.out.println("Всего компьютеров: " + Computer.getTotalComputers());
        System.out.println("Суммарный объем ОЗУ: " + Computer.getTotalRAM() + " ГБ");

        System.out.printf("Средняя память (ОЗУ): %.2f ГБ%n", Computer.getAverageRAM());
    }
}