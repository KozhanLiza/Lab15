package org.example;

// Производный класс Star
class Star extends CelestialBody {
    private double temperature; // Температура поверхности в Кельвинах

    public Star(String name, double mass, double diameter, double temperature) {
        super(name, mass, diameter);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String getType() {
        return "Звезда";
    }

    // Категория светимости по температуре
    public String getLuminosity() {
        if (temperature >= 10000) {
            return "Высокая (Голубой гигант)";
        } else if (temperature >= 5000) {
            return "Средняя (Желтый карлик)";
        } else {
            return "Низкая (Красный карлик)";
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Температура: %.0f K", temperature);
    }
}
