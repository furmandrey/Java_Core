package ru.geekbrains.lesson1;

public class Main {
    public static void main(String[] args) {
        Team petsTeam = new Team("PetsTeam",
                new Dog("Boddy", 100, 5),
                new Dog("Rex", 90, 3),
                new Cat("Tom", 80, 4),
                new Cat("Leo", 60, 6));

        Course c = new Course(new Distance(70), new Wall(4));
        c.doIt(petsTeam);

        petsTeam.showResults();
    }
}
