package ru.geekbrains.lesson1;


public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team petsTeam) {
        //System.out.println("#");
        //System.out.println(obstacles[0].getSize());
        for (Obstacle o : obstacles) {
            for (Animal a : petsTeam.getMembersAnimals()) {
                o.goChallenge(a);
                //o.goChallenge1(a);
                //a.getStatus() = true;
                //System.out.println(a.getStatus());


            }
        }
    }
}
