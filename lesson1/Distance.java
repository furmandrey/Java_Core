package ru.geekbrains.lesson1;


public class Distance extends Obstacle {

    public Distance(int size) {
        super(size);
    }

        public void goChallenge(Animal a) {

        //System.out.print(size + " ");

        //System.out.println(a.getRunDistance());
        if (a.getRunDistance() >= size) a.setStatus(true);
        //System.out.println("s1 " + a.getStatus());
    }


}
