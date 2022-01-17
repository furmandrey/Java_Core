package ru.geekbrains.lesson1;

public  class Dog extends Animal {


    private boolean status = false;
    private boolean status2 = false;

    public Dog(String name, int canRunDistance, int canJumpWall) {
        super(name, canRunDistance, canJumpWall);

    }

    public void bark() {
        System.out.println(this.name + " makes bark!" );
    }

    @Override
    public String toString() {
        return " Dog " + name + " *";}

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public boolean getStatus2() {
        return status2;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public void setStatus2(boolean status2) {
        this.status2 = status2;
    }
}
