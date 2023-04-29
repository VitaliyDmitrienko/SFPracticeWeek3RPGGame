import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Town {


    class Trader {
        int money = 1000;
        List<Item> inventory = new LinkedList<Item>();

        void buyItem() {
        }

        void sellItem() {
        }

        static void visitTrader() {
            System.out.println("You are inside General Store at trader desk.");
            System.out.println("Choose your goal.\n");
        }
    }

    class Inn {
        void sleep() {
        }

        static void visitInn() {
            System.out.println("You are inside local at bar desk.");
            System.out.println("Choose your goal.\n");

        }

        class Temple {
            void restoreHealth() {
            }

            static void visitTemple() {
                System.out.println("You are inside Temple at All-Gods-Altar.");
                System.out.println("Choose your goal.\n");

            }
        }

        public static void main(String[] args) {

        }

        public static void enterTown() {
            System.out.println("You are enter into Great Town." +
                    "You can visit local shops and offices." +
                    "Choose your goal.\n");
            System.out.println("<1> Visit Trader.");
            System.out.println("<2> Visit Inn.");
            System.out.println("<3> Visit Temple.");
            System.out.println("<4> Exit town and return to crossroad.\n");
            Scanner scanner = new Scanner(System.in);
            int choose = 0;

            do {
                choose = scanner.nextInt();
                switch (choose) {
                    case (1):
                        Trader.visitTrader();
                        break;
                    case (2):
                        Inn.visitInn();
                        break;
                    case (3):
                        Temple.visitTemple();
                        break;
                    case (4):
                        StartPosition.onCrossRoads();
                        break;

                }
            } while ((choose < 1) || (choose > 4));

        }


    }
}
