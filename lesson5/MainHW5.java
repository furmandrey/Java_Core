package ru.geekbrains.lesson5;

import java.util.Arrays;

public class MainHW5 {
    public static void main(String[] args) {
       AppData data = new AppData();
        data.readFromFile("source.csv");
        System.out.println(Arrays.toString(data.getHeader()));
        System.out.println(Arrays.deepToString(data.getData()));

        data.writeToCSV("new.csv");
    }
}
