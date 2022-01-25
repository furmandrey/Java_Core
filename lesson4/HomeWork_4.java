package ru.geekbrains.lesson4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HomeWork_4 {
    public static void main(String[] args) {
        System.out.println("          *1*");
        String[] s = {"Joel", "Musa", "Ebony", "Ivan", "Kira", "Mitchell", "Eugene", "Jim", "Frederick", "Ivan", "Jim", "Niall", "Kira", "Niall", "Musa"};

        System.out.println("Array before: " + Arrays.toString(s));
        findUnique(s);
        System.out.println("************************************************");
        System.out.println("          *2*");
        //task 2
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addElementPhoneBook("Smith", 100);
        phoneBook.addElementPhoneBook("Brown", 101);
        phoneBook.addElementPhoneBook("Ivanov", 456);
        phoneBook.getPhones("Smith");
        phoneBook.getPhones("Brown");
        phoneBook.getPhones("Ivanov");
        System.out.println();

        phoneBook.addElementPhoneBook("Ivanov", 123);
        phoneBook.addElementPhoneBook("Ivanov", 456);
        phoneBook.addElementPhoneBook("Ivanov", 333);
        phoneBook.addElementPhoneBook("Ivanov", 444);
        phoneBook.addElementPhoneBook("Ivanov", 555);
        phoneBook.addElementPhoneBook("Ivanov", 123);
        phoneBook.getPhones("Ivanov");


    }

    static void findUnique(String[] s) {
        Set<String> set = new HashSet<String>();
        for (String a : s) set.add(a);

        System.out.println("Array after: " + set);

        HashMap<String, Integer> map = new HashMap<>();

        for (String b : set) {
            int count = 0;
            for (String a : s) {

                if (b.hashCode() == a.hashCode()) count++;
            }

            if (count <= 1) System.out.println("The word " + b + " appear " + count + " time");
            else System.out.println("The word " + b + " appear " + count + " times");
        }


    }
}
