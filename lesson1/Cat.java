package ru.geekbrains.lesson1;

public class Cat extends Animal {

    private boolean status = false;
    private boolean status2 = false;

    public Cat(String name, int canRunDistance, int canJumpWall) {
        super(name, canRunDistance, canJumpWall);

    }

    public void meow() {
        System.out.println(this.name + " makes meow!");
    }

    @Override
    public String toString() {
        return " Cat " + name + " *";
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public boolean getStatus2() {
        return status2;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public void setStatus2(boolean status2) {
        this.status2 = status2;
    }

}