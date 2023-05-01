// Main PRG

import java.util.Scanner;

public class MainRPG {

    public static void main(String[] args) {
        System.out.println ( "Hello world!" );
        startGame();
    }

    private static void startGame () {
        System.out.println("< Advanced D&D Role-Playing Game >");
        System.out.println("<1> Start new game.");
        System.out.println("<2> Exit game.");
        Scanner scanner = new Scanner(System.in);
        int choose;

        do {
            choose = scanner.nextInt();
            switch (choose) {
                case (2)-> System.out.println("You exit a Game. See You later !!!");
                case (1)-> {String heroName = CreateHero.startGame();
                    Adventurer hero = new Adventurer(50,5,5,5,100, heroName);
//                    StartPosition.onCrossRoads(Adventurer hero);
                    }
                default -> System.out.println("Wrong input. Try right again.");
            }

        }
        while (choose <1 || choose >2);


    }

}