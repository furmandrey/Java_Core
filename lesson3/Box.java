package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.Collection;

public class Box<T extends Fruit> {
    ArrayList<T> fruits = new ArrayList<>();

    public void addOneFruits(T fruit) {
        fruits.add(fruit);
    }

    public void addFruits(T fruit, int qty) {

        for (int i = 0; i < qty; i++) {
            fruits.add(fruit);
        }
    }

    public float getBoxWeight() {
        float w = 0.0f;
        for (Fruit i : fruits) {
            w += i.getWeight();
        }
        return w;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(getBoxWeight() - box.getBoxWeight()) < 0.01;
    }

    public void changeFruits(Box<?> box) {
        System.out.println("States before merging");
        System.out.println("Quantity of fruits in first box" + fruits.size() + "psc");
        System.out.println("Quantity of fruits in second box" + box.fruits.size() + "psc");
        fruits.addAll((Collection<? extends T>) box.fruits);
        box.fruits.clear();
        box.fruits.trimToSize();
        System.out.println("States after merging");
        System.out.println("Quantity of fruits in first box" + fruits.size() + "psc");
        System.out.println("Quantity of fruits in second box" + box.fruits.size() + "psc");
    }
}
