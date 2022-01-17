package ru.geekbrains.lesson1;

public abstract class Animal implements GetStatus {
    protected String name;
    protected int canJumpWall;
    protected int canRunDistance;

    public Animal(String name, int canRunDistance, int canJumpWall) {
        this.name = name;
        this.canRunDistance = canRunDistance;
        this.canJumpWall = canJumpWall;
    }

    public void eat(CatFood catFood) {
        System.out.println(this.name + " eat " + catFood.getTitle());
    }

    public String getName() {
        return name;
    }

    public int getRunDistance() {
        return canRunDistance;
    }

    public int getCanJumpWall() {
        return canJumpWall;
    }



    //public abstract boolean getStatus2();

    public abstract void setStatus(boolean status);
    public abstract void setStatus2(boolean status);
}

interface GetStatus {
    boolean getStatus();
    boolean getStatus2();
}