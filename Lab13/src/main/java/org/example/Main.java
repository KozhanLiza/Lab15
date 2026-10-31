package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Вспомогательный метод для поиска транспорта в автопарке
    public static Transport findTransportByBrand(List<Transport> fleet, String brand) {
        for (Transport t : fleet) {
            if (t.getBrand().equalsIgnoreCase(brand)) {
                return t;
            }
        }
        // RuntimeException при отсутствии элемента
        throw new TransportNotFoundException("Транспорт с маркой '" + brand + "' не найден в автопарке.");
    }

    public static void main(String[] args) {
        List<Transport> fleet = new ArrayList<>();

        System.out.println("\nСОЗДАНИЕ АВТОПАРКА И ПРОВЕРКА ДАННЫХ\n");
        try {
            fleet.add(new Transport("Автобус", "Mercedes", 2020, 45, 28.5));
            fleet.add(new Transport("Легковой", "Toyota", 2008, 5, 7.5)); // Старый транспорт
            fleet.add(new Transport("Грузовик", "Volvo", 2023, 2, 35.0));

            System.out.println("Успешно добавлено транспортных средств: " + fleet.size());

            System.out.println("\nПопытка добавить транспорт с некорректным годом\n");
            fleet.add(new Transport("Ретро", "Ford", 1895, 4, 15.0));

        } catch (InvalidTransportDataException e) {
            System.err.println("ИСКЛЮЧЕНИЕ: " + e.getMessage());
        }

        System.out.println("\nТЕКУЩИЙ УСПЕШНЫЙ АВТОПАРК\n");
        for (Transport t : fleet) {
            System.out.println(t);
        }

        System.out.println("\nВЫПОЛНЕНИЕ ОБСЛУЖИВАНИЯ\n");
        for (Transport t : fleet) {
            try {
                System.out.println("Начало обслуживания: " + t.getBrand());
                t.service();
            } catch (MaintenanceException e) {
                System.out.println("ОШИБКА Модель " + e.getBrand() + ": " + e.getMessage());
            } finally {
                // Для каждого объекта
                System.out.println("-> Статус проверки для " + t.getBrand() + " закрыт.\n");
            }
        }

        System.out.println("\nПОИСК ТРАНСПОРТА И РАСЧЕТ ТОПЛИВА\n");
        try {
            Transport target = findTransportByBrand(fleet, "Mercedes");
            System.out.println("Найден транспорт: " + target);
            double fuel = target.calculateFuel(450.0);
            System.out.printf("Для поездки на 450 км потребуется %.1f л топлива.%n", fuel);

            // Поиск несуществующего транспорта
            System.out.println("\nПоиск несуществующего транспорта\n");
            findTransportByBrand(fleet, "Tesla");

        } catch (TransportNotFoundException e) {
            System.out.println("ИСКЛЮЧЕНИЕ: " + e.getMessage());
        }
    }
}