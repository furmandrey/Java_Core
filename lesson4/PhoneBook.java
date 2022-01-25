package ru.geekbrains.lesson4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneBook {
    private HashMap<String, HashSet<Integer>> phoneBook = new HashMap<>();

    public void addElementPhoneBook (String name, int phone){
        HashSet<Integer> phones;
        if (phoneBook.containsKey(name)){
            phones = phoneBook.get(name);
        }
        else {
            phones = new HashSet<>();
        }
        phones.add(phone);
        phoneBook.put(name,phones);
    }

    public Set<Integer> getPhonesByName (String name){
        return phoneBook.get(name);
    }


    public void getPhones(String name){
        int a = 1;
        for (Integer n : phoneBook.get(name)) {
            System.out.println(name + ": "+ "(" + a + ")"+ " " + n);
            a++;
        }
    }
}
