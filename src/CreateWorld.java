import java.util.Scanner;

public class CreateWorld {
     public static void main() {
         String inputName="";

         System.out.println("You start a big Adventure." +
                "You need create a new Hero." +
                "Enter a Name for Hero (8-20 symbols).");
        Scanner scanner = new Scanner(System.in);
        while (inputName.length() <8 || inputName.length() >20) {
            inputName = scanner.nextLine().trim();
        }

        Adventurer hero = new Adventurer(25,5,100,5,5, inputName);

    }
}
