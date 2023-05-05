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
            Scanner scanner = new Scanner(System.in);
            int choose;

            do {
                System.out.println("You are inside General Store at trader desk.");
                System.out.println("Choose your goal.\n");
                System.out.println("<1> Buy item.");
                System.out.println("<2> Sell item.");
                System.out.println("<3> Check hero status.");
                System.out.println("<4> Exit store and return to town.\n");

                do { choose = scanner.nextInt();
                    switch (choose) {
                        case (1) -> buyItem();
                        case (2) -> sellItem();
                        case (3) -> hero.getStatus();
                        case (4) -> visitTown(hero);
                        default -> System.out.println("Wrong input. Try right again.");
                    }

                } while (choose <1 || choose >4);
            } while (choose != 4);
            visitTown(hero);
        }
    }

    class Inn {
        private static int innSleepCost = 15;

        static void sleepInn(Adventurer hero) {
            if (hero.getHealth() >= hero.getMaxLevelHealth()) {
                System.out.println("No need to restore health. Your health ("+ hero.getHealth()
                        +") is maximum of ("+ hero.getMaxLevelHealth()+").");
            } else {
                if (hero.getMoney() >= innSleepCost) {
                    hero.restoreHealth();
                    hero.setMoney(-innSleepCost);
                    System.out.println("You spent "+ innSleepCost +" gold coins and sleep one night and full restore your health.");
                    System.out.println("Your health is: " + hero.getHealth() + " of (max level health): " + hero.getMaxLevelHealth() + ".\n");
                } else System.out.println("Not enough money to sleep. Get more money somewhere in other place.\n");
            }
        }

        static void visitInn(Adventurer hero) {
            Scanner scanner = new Scanner(System.in);
            int choose;

            do {
                System.out.println();
                System.out.println("You are inside local inn at bar desk.");
                System.out.println("Choose your goal.\n");
                System.out.println("<1> Sleep one night and restore health (cost " + innSleepCost + " gold coins).");
                System.out.println("<2> Check hero status.");
                System.out.println("<3> Exit inn and return to town.\n");

                do {
                    choose = scanner.nextInt();
                    switch (choose) {
                        case (1) -> sleepInn(hero);
                        case (2) -> hero.getStatus();
                        case (3) -> visitTown(hero);
                        default -> System.out.println("Wrong input. Try right again.");
                    }

                } while (choose < 1 || choose > 3);
            } while (choose !=3);
            visitTown(hero);


        }
    }

        class Temple {
            private static int templeRestoreHealthCost = 20;
            private static int templeRemoveCurseCost = 30;
            private static int templeBlessOfGodsCost = 50;
            private static int templeLevelUpCost = 10;


            static void restoreHealthTemple(Adventurer hero) {
                if (hero.getHealth() >= hero.getMaxLevelHealth()) {
                    System.out.println("No need to restore health. Your health ("+
                            hero.getHealth() +") is maximum of ("+ hero.getMaxLevelHealth()+").");
                } else {
                    if (hero.getMoney() >= templeRestoreHealthCost) {
                        hero.restoreHealth();
                        hero.setMoney(-templeRestoreHealthCost);
                        System.out.println("You spent "+ templeRestoreHealthCost +" gold coins and Gods full restore your health.");
                        System.out.println("Your health is: " + hero.getHealth() + " of (max level health): " + hero.getMaxLevelHealth() + ".\n");
                    } else System.out.println("Not enough money to sleep. Get more money somewhere in other place.\n");
                }
            }
            static void removeCursesTemple(Adventurer hero) {
                System.out.println("Removing curse ...\n");
            }
            static void prayGodsBlessTemple(Adventurer hero) {
                System.out.println("Praying All Gods fo Bless ...\n");
            }
            static void levelUpHero (Adventurer hero) {
                if (hero.getMoney() >= templeLevelUpCost) {
                    if (hero.getExperience() >= hero.getMaxLevelExperience()) {
                        hero.setLevelUpHero();
                        hero.setMoney(-templeLevelUpCost);
                        hero.setMaxLevelHealth();
                        hero.restoreHealth();
                        System.out.println("God bless your Hero to leveled up.");
                        System.out.println("You spent "+ templeLevelUpCost +" gold coins and Gods full restore your health.");
                        System.out.println("Hero of name: " + hero.getAdventurerName() + " of level: " + hero.getLevel() + ". Hero status is: " + hero.getIsAlive() + ".");
                        System.out.println("Health is: " + hero.getHealth() + " of (max level health): " + hero.getMaxLevelHealth() + ".");

                    }
                } else System.out.println("Not enough money to sleep. Get more money somewhere in other place.\n");
            }

            static void visitTemple(Adventurer hero) {
                Scanner scanner = new Scanner(System.in);
                int choose;

                do {
                    System.out.println();
                    System.out.println("You are inside Temple at All-Gods-Altar.");
                    System.out.println("Choose your goal.\n");
                    System.out.println("<1> Restore health (cost " + templeRestoreHealthCost + " gold coins).");
                    System.out.println("<2> Remove all curses (cost " + templeRemoveCurseCost + " gold coins).");
                    System.out.println("<3> Pray for Gods Bless (cost " + templeBlessOfGodsCost + " gold coins).");
                    System.out.println("<4> Level Up Hero (cost " + templeLevelUpCost + " gold coins).");
                    System.out.println("<5> Check hero status.");
                    System.out.println("<6> Exit store and return to town.\n");

                    do { choose = scanner.nextInt();
                        switch (choose) {
                            case (1): restoreHealthTemple(hero); break;
                            case (2): removeCursesTemple(hero); break;
                            case (3): prayGodsBlessTemple(hero); break;
                            case (4): levelUpHero(hero); break;
                            case (5): hero.getStatus(); break;
                            case (6): visitTown(hero); break;
                            default:
                                System.out.println("Wrong input. Try right again.");
                        }

                    } while (choose <1 || choose >6);
                } while (choose !=6);


            }
        }

        public static void main(String[] args) {

        }

        public static void visitTown(Adventurer hero) {
            Scanner scanner = new Scanner(System.in);
            int choose = 0;

            do {
                System.out.println();
                System.out.println("You are enter into Great Town. You can visit local shops and offices. Choose your goal.\n");
                System.out.println("<1> Visit Trader.");
                System.out.println("<2> Visit Inn.");
                System.out.println("<3> Visit Temple.");
                System.out.println("<4> Check hero status.");
                System.out.println("<5> Exit town and return to crossroad.\n");

                do {
                    choose = scanner.nextInt();
                    switch (choose) {
                        case (1) -> Trader.visitTrader(hero);
                        case (2) -> Inn.visitInn(hero);
                        case (3) -> Temple.visitTemple(hero);
                        case (4) -> hero.getStatus();
                        case (5) -> StartPosition.onCrossRoads(hero);
                        default -> System.out.println("Wrong input. Try right again.");
                    }
                } while ((choose < 1) || (choose > 5));
            } while (choose != 5);

        }


    }
