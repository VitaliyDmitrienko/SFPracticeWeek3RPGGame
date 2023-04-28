import java.util.Scanner;

public class CreateHero {
     public static void main(String[] args) {}

     public static void startGame() {
         String inputName="";

         System.out.println("You start a big Adventure." +
                "You need create a new Hero." +
                "Choose a Name for Great Hero (enter 5-20 symbols).");
        Scanner scanner = new Scanner(System.in);

         do {
             inputName = scanner.nextLine().trim ();
             if ((inputName.length() <5) || (inputName.length() >20))
                 System.out.println("User name: " + inputName + " is out of range (5-20 symbols). Input length: "
                         + inputName.length() + ". Enter right name again.");
         }
         while ((inputName.length() < 5) || (inputName.length() > 20));


         Adventurer hero = new Adventurer(25,5,100,5,5, inputName);


    }
}
