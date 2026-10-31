package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nДЕМОНСТРАЦИЯ СТАТИЧЕСКОГО ПОЛИМОРФИЗМА (Перегрузка)\n");
        Building genericBuilding = new Building("ул. Ленина, 10", 5, 1200.0);

        genericBuilding.build();
        genericBuilding.build(9);
        genericBuilding.build("кирпич и бетон");

        System.out.println("\nДЕМОНСТРАЦИЯ ДИНАМИЧЕСКОГО ПОЛИМОРФИЗМА (Переопределение)\n");
        Building[] cityBuildings = new Building[3];
        cityBuildings[0] = new Building("ул. Центральная, 1", 3, 500.0);
        cityBuildings[1] = new Residential("пр. Независимости, 45", 16, 4500.0, 64);
        cityBuildings[2] = new Office("б. Победы, 12", 12, 8000.0, 15);

        for (Building b : cityBuildings) {
            System.out.println(b);
        }

        System.out.println("\nСОБСТВЕННЫЕ ПЕРЕГРУЖЕННЫЕ МЕТОДЫ В НАСЛЕДНИКАХ\n");
        Residential resHouse = new Residential("ул. Пушкина, 5", 9, 3000.0, 36);
        Office officeBuilding = new Office("ул. Свердлова, 20", 20, 12000.0, 25);

        resHouse.build(10, true);
        officeBuilding.build("стекло и металл", true);

        System.out.println("\nСРАВНЕНИЕ ВИДОВ ПОЛИМОРФИЗМА\n");
        System.out.println("• Статический полиморфизм (Overloading): разрешается на этапе КОМПИЛЯЦИИ " +
                "на основе сигнатуры методов (количества и типов аргументов).");
        System.out.println("• Динамический полиморфизм (Overriding): разрешается во время ВЫПОЛНЕНИЯ (Runtime) " +
                "на основе реального экземпляра объекта в памяти (благодаря таблице виртуальных методов).");
    }
}