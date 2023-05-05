// Main PRG

import java.util.Scanner;

public class MainRPG {

    public static void main(String[] args) {

//        System.out.println("Привет из основного потока!");
//        Thread currentThread = Thread.currentThread();
//        ThreadGroup threadGroup = currentThread.getThreadGroup();
//        System.out.println("Thread: " + currentThread.getName());
//        System.out.println("Thread Group: " + threadGroup.getName());
//        System.out.println("Parent Group: " + threadGroup.getParent().getName());

        System.out.println ( "\nHello Player !!!" );
        System.out.println ( "Now you must overcome all obstacles and rid the World from the Ancient Evil in the Heart of Dark Wood !!!" );
        System.out.println ( "Ready Player One!!!\n" );
        startGame();
    }

    static void startGame () {
        System.out.println("< Skill Factory Student's Team present >");
        System.out.println("< \"There And Back Again\" Role-Playing Game >");
        System.out.println("< Spirited by Advanced D&D Role-Playing Game's and many other Old School's God-Old-Games >\n");
        System.out.println("<1> Start new game.");
        System.out.println("<2> Exit game.\n");
        Scanner scanner = new Scanner(System.in);
        int choose;

        do {
            choose = scanner.nextInt();
            switch (choose) {
                case (2)-> System.out.println("You exit a Game. See You later !!!");
                case (1)-> {String heroName = CreateHero.createHero();
                    Adventurer hero = new Adventurer(0,25,5,5,5,100, 0, heroName);
//                    hero.getStatus();
                    StartPosition.onCrossRoads(hero);
                    }
                default -> System.out.println("Wrong input. Try right again.");
            }

        }
        while (choose <1 || choose >2);


    }

}