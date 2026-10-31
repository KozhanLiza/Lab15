package org.example.task2;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Главный класс
public class Main2 {

    // 3. Метод для печати программистов определенного уровня
    public static void printProgrammers(List<Programmer> programmers, String targetLevel) {
        System.out.println("Список программистов с уровнем: " + targetLevel );
        boolean found = false;
        for (Programmer p : programmers) {
            if (p.getLevel().equalsIgnoreCase(targetLevel)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Нет программистов с таким уровнем.");
        }
    }

    public static void main(String[] args) {
        // Создаем список программистов
        List<Programmer> programmers = new ArrayList<>();

        programmers.add(new Programmer("P-01", "Алексей", "Java", "Junior", List.of(3, 4, 3, 2))); // ср. 3.0
        programmers.add(new Programmer("P-02", "Мария", "Python", "Middle", List.of(5, 5, 4, 5)));   // ср. 4.75
        programmers.add(new Programmer("P-03", "Иван", "C++", "Junior", List.of(2, 2, 1, 3)));      // ср. 2.0 (на удаление)
        programmers.add(new Programmer("P-04", "Ольга", "Java", "Senior", List.of(5, 4, 5, 5)));    // ср. 4.75
        programmers.add(new Programmer("P-05", "Дмитрий", "JavaScript", "Junior", List.of(4, 4, 4)));// ср. 4.0
        programmers.add(new Programmer("P-06", "Анна", "Python", "Middle", List.of(2, 3, 2)));      // ср. 2.33 (на удаление)

        System.out.println("ИСХОДНЫЙ СПИСОК ПРОГРАММИСТОВ");
        for (Programmer p : programmers) {
            System.out.println(p + " | Оценки: " + p.getCodeReviews());
        }

        // 1. Удалить программистов со средним рейтингом < 3
        // Используем метод removeIf с лямбда-выражением
        programmers.removeIf(p -> p.getAverageReview() < 3.0);

        System.out.println("\nПОСЛЕ УДАЛЕНИЯ СО СРЕДНИМ РЕЙТИНГОМ < 3");
        for (Programmer p : programmers) {
            System.out.println(p);
        }

        // 2. Повысить уровень программистов со средним рейтингом >= 4
        // (Логика повышения: Junior -> Middle, Middle -> Senior, Senior остается Senior)
        for (Programmer p : programmers) {
            if (p.getAverageReview() >= 4.0) {
                if (p.getLevel().equals("Junior")) {
                    p.setLevel("Middle");
                } else if (p.getLevel().equals("Middle")) {
                    p.setLevel("Senior");
                }
            }
        }

        System.out.println("\nПОСЛЕ ПОВЫШЕНИЯ УРОВНЯ (рейтинг >= 4.0)");
        for (Programmer p : programmers) {
            System.out.println(p);
        }

        // 3. Демонстрация метода печати по уровню
        System.out.println();
        printProgrammers(programmers, "Middle");

        // 4. Упорядочить всех программистов по убыванию среднего рейтинга.
        // При совпадении — в алфавитном порядке по имени. Вывести ID, имя и средний рейтинг.
        programmers.sort(new Comparator<Programmer>() {
            @Override
            public int compare(Programmer p1, Programmer p2) {
                // Сравнение по среднему рейтингу (по убыванию: p2 к p1)
                int result = Double.compare(p2.getAverageReview(), p1.getAverageReview());
                if (result == 0) {
                    // При совпадении — в алфавитном порядке по имени (по возрастанию)
                    return p2.getName().compareTo(p1.getName());
                }
                return result;
            }
        });

        System.out.println("\nОТСОРТИРОВАННЫЙ СПИСОК (по убыванию рейтинга, затем по имени)");
        System.out.println("ID   | Имя        | Средний рейтинг");
        System.out.println("-----------------------------------");
        for (Programmer p : programmers) {
            System.out.printf("%-4s | %-10s | %.2f%n", p.getId(), p.getName(), p.getAverageReview());
        }
    }
}