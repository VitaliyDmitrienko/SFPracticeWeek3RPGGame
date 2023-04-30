import java.util.Scanner;

public class StartPosition {
    public static void onCrossRoads(Adventurer hero) {
        System.out.println();
        System.out.println ( "You appear on big crossroads." );
        System.out.println ( "Not so far you can see a Big Town." );
        System.out.println ( "At your back are big Dark Wood." );
        System.out.println ( "Choose your goal.\n" );

        System.out.println ( "<1> Enter in Big Town." );
        System.out.println ( "<2> Enter in big Dark Wood." );
        System.out.println ( "<3> Exit game." );

        Scanner scanner = new Scanner ( System.in );
        int choose;

        do {
            choose = scanner.nextInt();
            switch (choose) {
                case (1) -> Town.visitTown(Adventurer hero);
                case (2) -> DarkWood.visitWood(Adventurer hero);
                case (3) -> System.out.println("You exit a Game. See You later !!!");
                default -> System.out.println("Wrong input. Try right again.");
            }
        }
            while (choose <1 || choose >3);

    }
}
