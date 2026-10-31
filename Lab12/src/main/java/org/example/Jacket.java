package org.example;

// 1. Наследник "Jacket" (Куртка)
class Jacket extends Garment {
    private String material;

    public Jacket(String name, String id, String size, String material) {
        super(name, id, size);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Материал: %s [Куртка]", material);
    }
}
