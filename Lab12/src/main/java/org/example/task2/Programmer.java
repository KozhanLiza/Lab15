package org.example.task2;

import java.util.List;

// Класс "Программист"
class Programmer {
    private String id;
    private String name;
    private String language;
    private String level; // Например: "Junior", "Middle", "Senior"
    private List<Integer> codeReviews; // Список оценок за код (от 1 до 5)

    public Programmer(String id, String name, String language, String level, List<Integer> codeReviews) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.level = level;
        this.codeReviews = codeReviews;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Integer> getCodeReviews() {
        return codeReviews;
    }

    // Метод для расчета среднего рейтинга
    public double getAverageReview() {
        if (codeReviews == null || codeReviews.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (Integer score : codeReviews) {
            sum += score;
        }
        return (double) sum / codeReviews.size();
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Имя: %-10s | Язык: %-10s | Уровень: %-8s | Ср. рейтинг: %.2f",
                id, name, language, level, getAverageReview());
    }
}
