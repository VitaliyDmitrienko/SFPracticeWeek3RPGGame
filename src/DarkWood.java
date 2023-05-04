import java.util.Random;
import java.util.Scanner;

public class DarkWood {

    private static int[] monsterDeepForestArray = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10};


    public static void visitWood(Adventurer hero) {
        Scanner scanner = new Scanner ( System.in );
        int choose;

        do {
            System.out.println ( "\nYou are at edge of wood." );
            System.out.println ( "Choose your goal.\n" );
            System.out.println ( "<1> Enter deep into the forest." );
            System.out.println ( "<2> Check hero status." );
            System.out.println ( "<3> Exit wood and return to crossroad.\n" );

            do {
                choose = scanner.nextInt ();
                switch (choose) {
                    case (1) -> moveDeepForest ( hero );
                    case (2) -> hero.getStatus ();
                    case (3) -> StartPosition.onCrossRoads ( hero );
                    default -> System.out.println ( "Wrong input. Try right again." );
                }

            } while (choose < 1 || choose > 3);
        } while (choose != 3);


    }

    private static void moveDeepForest(Adventurer hero) {
        int currentForestPosition = 0;
        Scanner scanner = new Scanner ( System.in );
        int choose;

        do {
            if (monsterDeepForestArray[currentForestPosition] == 0) {
                System.out.println ("Silence around. You can wait.\n");
                System.out.println ( "<1> Continue deep forest." );
                System.out.println ( "<2> Check hero status." );
                System.out.println ( "<3> Exit wood and return to crossroad." );

                do {
                    choose = scanner.nextInt ();
                    switch (choose) {
                        case (1) -> currentForestPosition++;
                        case (2) -> hero.getStatus ();
                        case (3) -> StartPosition.onCrossRoads ( hero );
                        default -> System.out.println ( "Wrong input. Try right again." );
                    }

                } while (choose < 1 || choose > 3);

            } else {

                Monster monster = generateMonster ( monsterDeepForestArray[currentForestPosition] );
                BattleField.fight ( monster, hero );
                if (hero.getIsAlive ()) monsterDeepForestArray[currentForestPosition] = 0;

            }

        } while (hero.getIsAlive ());

    }

    private static Monster generateMonster(int levelMonster) {
        Random random = new Random ();
        int x = random.nextInt ( 2 );

        switch (levelMonster) {
            case (1) -> {
                if (x > 0) return (new Monster ( 1, 15, 3, 3, 3, 20, 10, "Skeleton" ));
                else return (new Monster ( 1, 20, 4, 3, 2, 25, 15, "Orc" ));
            }
            case (2) -> {
                if (x > 0) return (new Monster ( 2, 25, 3, 3, 3, 30, 20, "Skeleton" ));
                else return (new Monster ( 2, 30, 4, 3, 2, 35, 25, "Orc" ));

            }
            case (10) -> {
                if (x > 0) return (new Monster ( 5, 50, 5, 5, 5, 100, 50, "Skeleton Boss" ));
                else return (new Monster ( 5, 50, 6, 6, 3, 100, 50, "Orc Boss" ));
            }
        }
        return null;

    }


}
