package org.example;

public class Main {
    public static void main(String[] args) {
        CelestialBody[] spaceObjects = new CelestialBody[5];

        spaceObjects[0] = new Planet("Земля", 5.97e24, 12742, 1);
        spaceObjects[1] = new Planet("Марс", 6.42e23, 6779, 2);
        spaceObjects[2] = new Planet("Юпитер", 1.90e27, 139822, 95);

        spaceObjects[3] = new Star("Солнце", 1.99e30, 1392700, 5778);
        spaceObjects[4] = new Star("Сириус А", 4.02e30, 2380000, 9940);

        System.out.println("\nИНФОРМАЦИЯ О НЕБЕСНЫХ ТЕЛАХ\n");
        for (CelestialBody body : spaceObjects) {
            System.out.println(body);
        }
        System.out.println("\nДЕМОНСТРАЦИЯ УНИКАЛЬНЫХ МЕТОДОВ\n");
        for (CelestialBody body : spaceObjects) {
            if (body instanceof Planet) {
                Planet planet = (Planet) body;
                System.out.printf("Условный индекс гравитации планеты %s: %.2f%n",
                        planet.getName(), planet.getGravity());
            } else if (body instanceof Star) {
                Star star = (Star) body;
                System.out.printf("Категория светимости звезды %s: %s%n",
                        star.getName(), star.getLuminosity());
            }
        }
    }
}