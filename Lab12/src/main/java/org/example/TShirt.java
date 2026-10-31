package org.example;

// 2. Наследник "TShirt" (Футболка)
class TShirt extends Garment {
    private String print;

    public TShirt(String name, String id, String size, String print) {
        super(name, id, size);
        this.print = print;
    }

    public String getPrint() {
        return print;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Принт: %s [Футболка]", print);
    }
}
