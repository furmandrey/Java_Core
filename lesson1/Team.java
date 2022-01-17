package ru.geekbrains.lesson1;


public class Team {

    private final String nameTeam;
    private Animal[] membersAnimals;

    public Team(String nameTeam, Animal... membersAnimals) {
        this.nameTeam = nameTeam;
        this.membersAnimals = membersAnimals;
    }

    public Animal[] getMembersAnimals() {
        return membersAnimals;
    }

    public void showResults() {
        System.out.println(" The results of the challenge:");
        System.out.println("==================================");
        for (Animal member : getMembersAnimals()) {
            if (member.getStatus() && member.getStatus2())
                System.out.println(member + " Has passed the Obstacle Course");
        }

        System.out.println("==================================");
        System.out.println();
        System.out.println("The members of the Team " + "'" + nameTeam + "'" + " are: ");
        System.out.println("___________________________________");
        for (Animal member : getMembersAnimals()) {
            System.out.print(member + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");
    }
}
