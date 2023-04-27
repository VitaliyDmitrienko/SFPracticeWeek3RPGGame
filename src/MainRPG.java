// Main PRG

import java.util.Scanner;

public class MainRPG {
    public static void main(String[] args) {
        System.out.println ( "Hello world!" );
        startGame();

    }

    private static void startGame () {
        System.out.println("< Advanced D&D Role-Playing Game >");
        Scanner scanner = new Scanner(System.in);
        System.out.println("<1> Start new game.");
        System.out.println("<2> Exit game.");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("2")) {
                System.out.println("You exit a Game. See You later !!!");
                break;
            }
            else CreateWorld.main();

        }


    }
}