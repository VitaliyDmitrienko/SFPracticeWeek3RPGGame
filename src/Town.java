import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Town {




    class Trader {
        int money = 1000;
        List<Item> inventory = new LinkedList<Item>();

        static void buyItem() {
            System.out.println("Buying item ...");
        }

        static void sellItem() {
            System.out.println("Selling item ...");
        }

        static void visitTrader(Adventurer hero) {
            System.out.println("You are inside General Store at trader desk.");
            System.out.println("Choose your goal.\n");
            System.out.println("<1> Buy item.");
            System.out.println("<2> Sell item.");
            System.out.println("<3> Check hero status.");
            System.out.println("<4> Exit store and return to town.");
            Scanner scanner = new Scanner(System.in);
            int choose;

            do { choose = scanner.nextInt();
                switch (choose) {
                    case (1): buyItem(); break;
                    case (2): sellItem(); break;
                    case (3): hero.getStatus(); break;
                    case (4): visitTown(hero); break;
                    default:
                        System.out.println("Wrong input. Try right again.");
                }

            } while (choose <1 || choose >3);
        }
    }

    class Inn {
        static void sleep(Adventurer hero) {
//            if (hero.getMoney() >= 15) {
//                Adventurer.setHealth(Adventurer.getMaxLevelHealth());
//                Adventurer.setMoney(-15);
//            } else System.out.println("Not enough money to sleep. Get more money somewhere in other place.");
        }

        static void visitInn(Adventurer hero) {
            System.out.println("You are inside local at bar desk.");
            System.out.println("Choose your goal.\n");
            System.out.println("<1> Sleep one night and restore health (cost 15 gold coins).");
            System.out.println("<2> Check hero status.");
            System.out.println("<3> Exit inn and return to town.");
            Scanner scanner = new Scanner(System.in);
            int choose;

            do { choose = scanner.nextInt();
                switch (choose) {
                    case (1): sleep(hero); break;
                    case (2): hero.getStatus(); break;
//                    case (3): visitTown(Adventurer hero); break;
                    default:  System.out.println("Wrong input. Try right again.");
                }

            } while (choose <1 || choose >2);


        }
    }

        class Temple {
            static void restoreHealth() {
            }
            static void removeCurses() {
                System.out.println("Removing curse ...");
            }
            static void prayGodsBless() {
                System.out.println("Praying All Gods fo Bless ...");
            }

            static void visitTemple(Adventurer hero) {
                System.out.println("You are inside Temple at All-Gods-Altar.");
                System.out.println("Choose your goal.\n");
                System.out.println("<1> Restore health (cost 20 gold coins).");
                System.out.println("<2> Remove all curses (cost 20 gold coins).");
                System.out.println("<3> Pray for Gods Bless (cost 30 gold coins).");
                System.out.println("<4> Check hero status.");
                System.out.println("<5> Exit store and return to town.");
                Scanner scanner = new Scanner(System.in);
                int choose;

                do { choose = scanner.nextInt();
                    switch (choose) {
                        case (1): restoreHealth(); break;
                        case (2): removeCurses(); break;
                        case (3): prayGodsBless(); break;
                        case (4): hero.getStatus(); break;
                        case (5): visitTown(hero); break;
                        default:
                            System.out.println("Wrong input. Try right again.");
                    }

                } while (choose <1 || choose >5);


            }
        }

        public static void main(String[] args) {

        }

        public static void visitTown(Adventurer hero) {
            System.out.println("You are enter into Great Town." +
                    "You can visit local shops and offices." +
                    "Choose your goal.\n");
            System.out.println("<1> Visit Trader.");
            System.out.println("<2> Visit Inn.");
            System.out.println("<3> Visit Temple.");
            System.out.println("<4> Check hero status.");
            System.out.println("<5> Exit town and return to crossroad.\n");
            Scanner scanner = new Scanner(System.in);
            int choose = 0;

            do {
                choose = scanner.nextInt();
                switch (choose) {
                    case (1): Trader.visitTrader(hero); break;
                    case (2): Inn.visitInn(hero); break;
                    case (3): Temple.visitTemple(hero); break;
                    case (4): hero.getStatus(); break;
                    case (5): StartPosition.onCrossRoads(hero); break;
                    default:
                        System.out.println("Wrong input. Try right again.");

                }
            } while ((choose < 1) || (choose > 5));

        }


    }
