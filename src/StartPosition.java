import java.util.Scanner;

public class StartPosition {
    public static void onCrossRoads() {
        System.out.println ( "You appear on big crossroads." );
        System.out.println ( "Not so far you can see a Big Town." );
        System.out.println ( "At your back are big Dark Wood." );
        System.out.println ( "Choose your goal." );

        System.out.println ( "<1> Enter in Big Town." );
        System.out.println ( "<2> Enter in big Dark Wood." );
        System.out.println ( "<3> Exit game." );

        Scanner scanner = new Scanner ( System.in );

        while (true) {
            String input = scanner.nextLine ();
            if (input.equals ( "3" )) {
                System.out.println ( "You exit a Game. See You later !!!" );
                break;
            } else if (input.equals ( "1" )) Town.enterTown ();
            else if (input.equals ( "2" )) DarkWood.enterWood ();

        }

    }
}
