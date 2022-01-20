package ru.geekbrains.lesson2;

class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super("!Wrong array Data! " + message);
    }
}
