package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Ключ — String (название), а значение — Garment (объект одежды)
        Map<String, Garment> wardrobe = new HashMap<>();

        wardrobe.put("Кожаная куртка", new Jacket("Кожаная куртка", "J-01", "M", "Кожа"));
        wardrobe.put("Зимний пуховик", new Jacket("Зимний пуховик", "J-02", "L", "Нейлон"));
        wardrobe.put("Джинсовая куртка", new Jacket("Джинсовая куртка", "J-03", "S", "Деним"));

        wardrobe.put("Белая классическая", new TShirt("Белая классическая", "T-01", "M", "Нет"));
        wardrobe.put("Черная с принтом", new TShirt("Черная с принтом", "T-02", "L", "Рок-группа"));
        wardrobe.put("Спортивная футболка", new TShirt("Спортивная футболка", "T-03", "XL", "Логотип бренда"));

        wardrobe.put("Синие джинсы", new Pants("Синие джинсы", "P-01", "32/32", 102.5));
        wardrobe.put("Классические брюки", new Pants("Классические брюки", "P-02", "34/32", 106.0));

        System.out.println("ВЫВОД ВСЕХ КЛЮЧЕЙ И ЗНАЧЕНИЙ В MAP");

        // Проходим по всем элементам коллекции Map с помощью entrySet()
        for (Map.Entry<String, Garment> entry : wardrobe.entrySet()) {
            String key = entry.getKey();
            Garment garment = entry.getValue();
            System.out.println("Ключ (Название): \"" + key + "\" --> Значение: " + garment);
        }
    }
}