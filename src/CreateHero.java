import java.util.Scanner;

public class CreateHero {
     public static void main(String[] args) {}

     public static String createHero() {
         String inputName="";

         System.out.println("You start a big Adventure.\n" +
                "You need create a new Hero.\n" +
                "Choose a Name for Great Hero (enter 5-20 symbols).\n");
        Scanner scanner = new Scanner(System.in);

         do {
             inputName = scanner.nextLine().trim ();
             if ((inputName.length() <5) || (inputName.length() >20))
                 System.out.println("User name: " + inputName + " is out of range (5-20 symbols). Input length: "
                         + inputName.length() + ". Enter right name again.");
         }
         while ((inputName.length() < 5) || (inputName.length() > 20));


         return inputName;


    }
}
