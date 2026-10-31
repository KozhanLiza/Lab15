package org.example;

// Производный класс Planet
class Planet extends CelestialBody {
    private int moons; // Количество спутников

    public Planet(String name, double mass, double diameter, int moons) {
        super(name, mass, diameter);
        this.moons = moons;
    }

    public int getMoons() {
        return moons;
    }

    public void setMoons(int moons) {
        this.moons = moons;
    }

    @Override
    public String getType() {
        return "Планета";
    }

    // Рассчитывает относительный индекс гравитации
    public double getGravity() {
        return getMass() / (getDiameter() * 1e20);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Спутников: %d", moons);
    }
}
