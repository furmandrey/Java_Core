package ru.geekbrains.lesson1;

public class Wall extends Obstacle {

    public Wall(int size) {
        super(size);

    }

    public void goChallenge(Animal a) {
       /* System.out.print(a.getStatus2());
        System.out.print(size + " ");
        System.out.print(a.getCanJumpWall() + " ");
        System.out.print(a.getCanJumpWall() - size);*/

        if (a.getCanJumpWall() >= size) a.setStatus2(true);
        //System.out.println(a.getStatus2());

    }


}
