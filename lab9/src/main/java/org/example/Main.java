package org.example;

public class Main {
    public static void main(String[] args) {

        // Clothing c = new Clothing("Nike", "M", "Красный"); // Ошибка компиляции!

        Clothing[] wardrobe = new Clothing[5];
        wardrobe[0] = new Jacket("Zara", "L", "Черный", "Кожа");
        wardrobe[1] = new Jacket("Columbia", "XL", "Синий", "Мембрана");
        wardrobe[2] = new Jacket("Mango", "M", "Бежевый", "Замша");
        wardrobe[3] = new TShirt("Puma", "S", "Белый", "Logo Print");
        wardrobe[4] = new TShirt("Adidas", "M", "Зеленый", "Vintage Graphic");
        System.out.println("\nСПИСОК ОДЕЖДЫ И ХАРАКТЕРИСТИКИ\n");
        for (Clothing item : wardrobe) {
            System.out.println(item);
        }
        System.out.println("\nВЫВОД ТОЛЬКО СЕЗОНА И МАТЕРИАЛА\n");
        for (Clothing item : wardrobe) {
            System.out.printf("%s (%s): Сезон — %s, Материал — %s%n",
                    item.getBrand(),
                    item.getClass().getSimpleName(),
                    item.getSeason(),
                    item.getMaterial());
        }
    }
}