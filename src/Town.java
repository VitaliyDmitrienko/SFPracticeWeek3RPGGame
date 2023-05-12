import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Town {


    class Trader {
        int money = 1000;
        List<Item> inventory = new LinkedList<Item>();

        static void buyItem(Adventurer adventurer) {
            Scanner scanner = new Scanner(System.in);
            int choosePurchase = 0;

            do {
                System.out.println();
                System.out.println("Buying item ...");
                System.out.println("Choose item to purchase:");
                System.out.println("<1> Small healing potion (+10 hp) for 10 gold coins.");
                System.out.println("<2> Middle healing potion (+25 hp) for 30 gold coins.");
                System.out.println("<3> Great healing potion (+50 hp) for 70 gold coins.");
                System.out.println("<4> Exit purchase item(s).");

                do { choosePurchase = scanner.nextInt();
                    switch (choosePurchase) {
                        case (1) -> {
                            if (adventurer.getMoney() >= 10) {
                                adventurer.setQuickItemsInventory(1,+1);
                                adventurer.setMoney(-10);
                                System.out.println("You spent 10 gold coins and purchase small healing potion (+10 hp) to instant restore your health.");
                            } else System.out.println("Not enough money to purchase small healing potion. Get more money somewhere in other place.\n");
                            System.out.println("You have only " + adventurer.getMoney() + " gold coins.\n");
                        }
                        case (2) -> {
                            if (adventurer.getMoney() >= 30) {
                                adventurer.setQuickItemsInventory(2,+1);
                                adventurer.setMoney(-20);
                                System.out.println("You spent 30 gold coins and purchase middle healing potion (+25 hp) to instant restore your health.");
                            } else System.out.println("Not enough money to purchase middle healing potion. Get more money somewhere in other place.\n");
                            System.out.println("You have only " + adventurer.getMoney() + " gold coins.\n");
                        }
                        case (3) -> {
                            if (adventurer.getMoney() >= 50) {
                            adventurer.setQuickItemsInventory(3,+1);
                            adventurer.setMoney(-20);
                            System.out.println("You spent 50 gold coins and purchase great healing potion (+50 hp) to instant restore your health.");
                        } else System.out.println("Not enough money to purchase great healing potion. Get more money somewhere in other place.\n");
                            System.out.println("You have only " + adventurer.getMoney() + " gold coins.\n");
                        }
                        default -> System.out.println("Wrong choose. Try right input again.");
                    }

                } while (choosePurchase <1 || choosePurchase >4);
            } while (choosePurchase != 4);

        }

        static void sellItem(Adventurer adventurer) {
            System.out.println("Selling item ...");
        }

        static void visitTrader(Adventurer adventurer) {
            Scanner scanner = new Scanner(System.in);
            int choose;

            do {
                System.out.println("You are inside General Store at trader desk.");
                System.out.println("Choose your goal.\n");
                System.out.println("<1> Buy item.");
                System.out.println("<2> Sell item.");
                System.out.println("<3> Check hero status.");
                System.out.println("<4> Check hero quick item(s).");
                System.out.println("<5> Exit store and return to town.\n");

                do { choose = scanner.nextInt();
                    switch (choose) {
                        case (1) -> buyItem(adventurer);
                        case (2) -> sellItem(adventurer);
                        case (3) -> adventurer.getStatus();
                        case (4) -> adventurer.checkQuickSlotInventory();
                        case (5) -> visitTown(adventurer);
                        default -> System.out.println("Wrong choose. Try right input again.");
                    }
                } while (choose <1 || choose >5);
            } while (choose != 5);
            visitTown(adventurer);
        }
    }

    class Inn {
        private static int innSleepCost = 15;

        static void sleepInn(Adventurer adventurer) {
            if (adventurer.getHealth() >= adventurer.getMaxLevelHealth()) {
                System.out.println("No need to restore health. Your health ("+ adventurer.getHealth()
                        +") is maximum of ("+ adventurer.getMaxLevelHealth()+").");
            } else {
                if (adventurer.getMoney() >= innSleepCost) {
                    adventurer.restoreHealth();
                    adventurer.setMoney(-innSleepCost);
                    System.out.println("You spent "+ innSleepCost +" gold coins and sleep one night and full restore your health.");
                    System.out.println("Your health is: " + adventurer.getHealth() + " of (max level health): " + adventurer.getMaxLevelHealth() + ".\n");
                } else System.out.println("Not enough money to sleep. Get more money somewhere in other place.\n");
            }
        }

        static void visitInn(Adventurer adventurer) {
            Scanner scanner = new Scanner(System.in);
            int choose;

            do {
                System.out.println();
                System.out.println("You are inside local inn at bar desk.");
                System.out.println("Choose your goal.\n");
                System.out.println("<1> Sleep one night and restore health (cost " + innSleepCost + " gold coins).");
                System.out.println("<2> Check hero status.");
                System.out.println("<3> Check hero quick item(s).");
                System.out.println("<4> Exit inn and return to town.\n");

                do {
                    choose = scanner.nextInt();
                    switch (choose) {
                        case (1) -> sleepInn(adventurer);
                        case (2) -> adventurer.getStatus();
                        case (3) -> visitTown(adventurer);
                        case (4) -> adventurer.checkQuickSlotInventory();
                        default -> System.out.println("Wrong choose. Try right input again.");
                    }

                } while (choose < 1 || choose > 4);
            } while (choose !=4);
            visitTown(adventurer);


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
                        hero.setMoney(-templeLevelUpCost);
                        hero.setLevelUpHero();
                        System.out.println("God bless your Hero to leveled up.");
                        System.out.println("You spent "+ templeLevelUpCost +" gold coins and Gods full restore your health.");
                        System.out.println("Hero of name: " + hero.getAdventurerName() + " of level: " + hero.getLevel() + ". Hero status is: " + hero.getIsAlive() + ".");
                        System.out.println("Health is: " + hero.getHealth() + " of (max level health): " + hero.getMaxLevelHealth() + ".");
                        System.out.println("Money is: " + hero.getMoney() + " gold coins. Experience is: " + hero.getExperience() + " of (max level experience): " + hero.getMaxLevelExperience() + ".");

                    }
                } else System.out.println("Not enough money to sleep. Get more money somewhere in other place.\n");
            }

            static void visitTemple(Adventurer adventurer) {
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
                    System.out.println("<6> Check hero quick item(s).");
                    System.out.println("<7> Exit store and return to town.\n");

                    do { choose = scanner.nextInt();
                        switch (choose) {
                            case (1) -> restoreHealthTemple(adventurer);
                            case (2) -> removeCursesTemple(adventurer);
                            case (3) -> prayGodsBlessTemple(adventurer);
                            case (4) -> levelUpHero(adventurer);
                            case (5) -> adventurer.getStatus();
                            case (6) -> adventurer.checkQuickSlotInventory();
                            case (7) -> visitTown(adventurer);
                            default ->  System.out.println("Wrong input. Try right again.");
                        }

                    } while (choose <1 || choose >7);
                } while (choose !=7);


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
                System.out.println("<5> Check hero quick item(s).");
                System.out.println("<6> Exit town and return to crossroad.\n");

                do {
                    choose = scanner.nextInt();
                    switch (choose) {
                        case (1) -> Trader.visitTrader(hero);
                        case (2) -> Inn.visitInn(hero);
                        case (3) -> Temple.visitTemple(hero);
                        case (4) -> hero.getStatus();
                        case (5) -> hero.checkQuickSlotInventory();
                        case (6) -> StartPosition.onCrossRoads(hero);
                        default -> System.out.println("Wrong choose. Try right input again.");
                    }
                } while ((choose < 1) || (choose > 6));
            } while (choose != 6);

        }


    }
