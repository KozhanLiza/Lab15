package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // ЗАДАНИЕ 1: Создание файла, вывод информации и содержимого
        System.out.println("ЗАДАНИЕ 1: Информация о файле и чтение");
        String fileFood = "favorite_food.txt";

        try {
            //Файл и информация
            File file = new File(fileFood);
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println("Пицца Пепперони");
                writer.println("Свежие роллы Филадельфия");
                writer.println("Домашний борщ");
            }
            System.out.println("[Успех] Файл '" + fileFood + "' успешно создан и заполнен.");

            // информация о файле
            System.out.println("--- Свойства файла ---");
            System.out.println("Имя файла: " + file.getName());
            System.out.println("Путь: " + file.getPath());
            System.out.println("Абсолютный путь: " + file.getAbsolutePath());
            System.out.println("Размер файла: " + file.length() + " байт");
            System.out.println("Файл существует: " + file.exists());
            System.out.println("Разрешено чтение: " + file.canRead());
            System.out.println("Разрешена запись: " + file.canWrite());

            //содержимое
            System.out.println("--- Содержимое файла ---");
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("-> " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("[Ошибка в Задании 1]: " + e.getMessage());
        }
        System.out.println();


        // ЗАДАНИЕ 2: Ввод 10 чисел, запись в файл 'f', поиск не кратных 2
        System.out.println("ЗАДАНИЕ 2: Ввод 10 целых чисел и анализ нечетных");
        String fileF2 = "f_task2.txt";
        int[] numbers = new int[10];

        System.out.println("Введите 10 целых чисел (можно через пробел или Enter):");
        for (int i = 0; i < 10; i++) {
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Требуется ввести целое число.");
                scanner.next();
            }
            numbers[i] = scanner.nextInt();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileF2))) {
            for (int num : numbers) {
                writer.println(num);
            }
            System.out.println("[Успех] Числа записаны в файл " + fileF2);
        } catch (IOException e) {
            System.out.println("[Ошибка записи файла]: " + e.getMessage());
        }

        System.out.println("--- Чтение из файла и проверка ---");
        int notDivisibleBy2Count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileF2))) {
            String line;
            System.out.print("Числа в файле: ");
            while ((line = reader.readLine()) != null) {
                int val = Integer.parseInt(line);
                System.out.print(val + " ");
                if (val % 2 != 0) {
                    notDivisibleBy2Count++;
                }
            }
            System.out.println();
            System.out.println("Количество чисел, не кратных 2: " + notDivisibleBy2Count);
        } catch (IOException e) {
            System.out.println("[Ошибка чтения файла]: " + e.getMessage());
        }
        System.out.println();


        // ЗАДАНИЕ 3: Файл 'f' (случайные числа) -> 'g' (содержащие 5) и 'h' (остальные)
        System.out.println("ЗАДАНИЕ 3: Распределение чисел по файлам 'g' и 'h'");
        String fileF3 = "f_random.txt";
        String fileG = "g_with_5.txt";
        String fileH = "h_others.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileF3))) {
            for (int i = 0; i < 20; i++) {
                int num = random.nextInt(201) - 100; // [-100; 100]
                writer.println(num);
            }
            System.out.println("[Успех] Файл 'f' заполнен случайными числами.");
        } catch (IOException e) {
            System.out.println("[Ошибка создания файла f]: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileF3));
             PrintWriter writerG = new PrintWriter(new FileWriter(fileG));
             PrintWriter writerH = new PrintWriter(new FileWriter(fileH))) {

            String line;
            System.out.println("--- Распределение ---");
            while ((line = reader.readLine()) != null) {
                if (line.contains("5")) {
                    writerG.println(line);
                    System.out.println("Число " + line + " -> отправлено в файл 'g'");
                } else {
                    writerH.println(line);
                    System.out.println("Число " + line + " -> отправлено в файл 'h'");
                }
            }
            System.out.println("[Успех] Данные успешно распределены по файлам '" + fileG + "' и '" + fileH + "'.");
        } catch (IOException e) {
            System.out.println("[Ошибка обработки файлов]: " + e.getMessage());
        }
        System.out.println();


        // ЗАДАНИЕ 4: Ввод 15 вещественных значений объема жидкости, расчет среднего
        System.out.println("ЗАДАНИЕ 4: Средний объем жидкости");
        String fileVolumes = "volumes.txt";
        double[] volumes = new double[5];

        System.out.println("Введите 5 вещественных значений объема жидкости:");
        for (int i = 0; i < 5; i++) {
            while (!scanner.hasNextDouble()) {
                System.out.println("Ошибка! Требуется ввести вещественное число.");
                scanner.next();
            }
            volumes[i] = scanner.nextDouble();
            if (volumes[i] < 0) {
                System.out.println("Ошибка! Требуется ввести число > 0");
                volumes[i] = 0;
                i--;
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileVolumes))) {
            for (double v : volumes) {
                writer.println(v);
            }
            System.out.println("[Успех] Объемы записаны в файл " + fileVolumes);
        } catch (IOException e) {
            System.out.println("[Ошибка записи]: " + e.getMessage());
        }

        double sum = 0;
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileVolumes))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sum += Double.parseDouble(line);
                count++;
            }

            if (count > 0) {
                double average = sum / count;
                System.out.printf("[Результат] Средний объем жидкости: %.2f%n", average);
            } else {
                System.out.println("Файл пуст, невозможно вычислить среднее.");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("[Ошибка чтения или формата данных]: " + e.getMessage());
        }
        System.out.println();


        // ЗАДАНИЕ 5: Файл 'f' с 10 целыми числами, подсчет чисел в диапазоне [-50; 50]
        System.out.println("ЗАДАНИЕ 5: Подсчет чисел в диапазоне от -50 до 50");
        String fileRange = "f_range.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileRange))) {
            for (int i = 0; i < 10; i++) {
                int num = random.nextInt(201) - 100;
                writer.println(num);
            }
            System.out.println("[Успех] Файл '" + fileRange + "' создан.");
        } catch (IOException e) {
            System.out.println("[Ошибка создания файла]: " + e.getMessage());
        }

        int rangeCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileRange))) {
            String line;
            System.out.print("Сгенерированные числа: ");
            while ((line = reader.readLine()) != null) {
                int val = Integer.parseInt(line);
                System.out.print(val + " ");
                if (val >= -50 && val <= 50) {
                    rangeCount++;
                }
            }
            System.out.println();
            System.out.println("[Результат] Количество чисел в диапазоне от -50 до 50: " + rangeCount);
        } catch (IOException | NumberFormatException e) {
            System.out.println("[Ошибка при чтении файла]: " + e.getMessage());
        }
    }
}