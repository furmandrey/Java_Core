package ru.geekbrains.lesson3;


import java.util.Arrays;

public class HomeWork_3 {
    public static void main(String[] args) {
        // 1 task
        System.out.println("*1*");
        String[] box = {"apple", "orange", "mellow", "banana", "pumpkin"};
        System.out.print("Array before:  ");
        System.out.println(Arrays.toString(box));
        doChange(box, 2, 5);
        System.out.print("Array after:   ");
        System.out.println(Arrays.toString(box));

        // 2 task
        System.out.println("*2*");

        float appleWeight = 1.0f;
        float orangeWeight = 1.5f;
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.addFruits(new Apple(appleWeight), 30);
        orangeBox.addFruits(new Orange(orangeWeight), 20);

        System.out.println("        *COMPARISON 1*");
        System.out.println("Weight of Apple Box: " + appleBox.getBoxWeight());
        System.out.println("Weight of Orange Box: " + orangeBox.getBoxWeight());
        System.out.println("The boxes are igual. It is " + appleBox.compare(orangeBox));

        System.out.println("        *COMPARISON 2*");
        orangeBox.addOneFruits(new Orange(2.0f));
        System.out.println("Weight of Apple Box: " + appleBox.getBoxWeight());
        System.out.println("Weight of Orange Box: " + orangeBox.getBoxWeight());
        System.out.println("The boxes are igual. It is " + appleBox.compare(orangeBox));

        Box<Orange> orangeBox2 = new Box<>();

        System.out.println("        *Changing fruits in the boxes*");
        orangeBox2.changeFruits(orangeBox);

    }

    static void doChange(Object[] array, int fist, int second) {
        Object temp = array[fist - 1];
        array[fist - 1] = array[second - 1];
        array[second - 1] = temp;

    }
}
