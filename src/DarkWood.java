import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DarkWood {

    static List<Integer> monsterDeepForestArray = new ArrayList<>();
    static List<Integer> monsterDeepForestArrayDefault = Arrays.asList(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,2,2,2,2,10);

    // List initialiser for cause, if you current hero fall,so you need create a new hero ...
    public static void monsterDeepForestArraySetter() {
        monsterDeepForestArray = monsterDeepForestArrayDefault;
    }


    public static void visitWood(Adventurer adventurer) {
        Scanner scanner = new Scanner ( System.in );
        int choose1;

        do {
            System.out.println ( "\nYou are at edge of wood." );
            System.out.println ( "Choose your goal.\n" );
            System.out.println ( "<1> Enter deep into the forest." );
            System.out.println ( "<2> Check hero status." );
            System.out.println ( "<3> Check hero quick item(s).");

            System.out.println ( "<4> Exit wood and return to crossroad.\n" );

            do {
                choose1 = scanner.nextInt ();
                switch (choose1) {
                    case (1) -> {
                        try {
                            moveDeepForest ( adventurer );
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    case (2) -> adventurer.getStatus ();
                    case (3) -> adventurer.checkQuickSlotInventory ();
                    case (4) -> StartPosition.onCrossRoads ( adventurer );
                    default -> System.out.println ( "Wrong input. Try right again." );
                }

            } while (choose1 < 1 || choose1 > 4);
        } while (choose1 != 4);


    }

    private static void moveDeepForest(Adventurer adventurer) throws InterruptedException {
        int currentForestPosition = monsterDeepForestArray.lastIndexOf(0);
        Scanner scanner = new Scanner ( System.in );
        int choose2;
        AtomicInteger battleResult = new AtomicInteger();
//        int battleResult=0;

        do {
            if (monsterDeepForestArray.get(currentForestPosition) == 0) {
                System.out.println("You move at " + currentForestPosition + " step(s) into deep forest.");
                System.out.println("Silence around. You can wait.\n");
                System.out.println("<1> Continue deep forest.");
                System.out.println("<2> Check hero status.");
                System.out.println ( "<3> Check hero quick item(s).");
                if (!adventurer.isEmptyQuickItemsInventory()) System.out.println( "<4> Use hero quick item(s).");
                System.out.println ( "<4> Exit wood and return to crossroad.\n" );

                do {
                    choose2 = scanner.nextInt();
                    switch (choose2) {
                        case (1) -> currentForestPosition++;
                        case (2) -> adventurer.getStatus();
                        case (3) -> adventurer.checkQuickSlotInventory ();
                        case (4) -> {
                            if (!adventurer.isEmptyQuickItemsInventory()) adventurer.useQuickItemsInventory();;
                        }
                        case (5) -> StartPosition.onCrossRoads(adventurer);
                        default -> System.out.println("Wrong choose. Try right input again.");
                    }

                } while (choose2 < 1 || choose2 > 5);

            } else {

                Monster monster = generateMonster(monsterDeepForestArray.get(currentForestPosition));

                //Creating new Thread
                // this method will run in side thread
                Thread battle = new Thread(() -> {
//  Debug logging
//                    System.out.println("Привет из побочного потока!");
//                    Thread currentThread = Thread.currentThread();
//                    ThreadGroup threadGroup = currentThread.getThreadGroup();
//                    System.out.println("Thread: " + currentThread.getName());
//                    System.out.println("Thread Group: " + threadGroup.getName());
//                    System.out.println("Parent Group: " + threadGroup.getParent().getName());

//  single-Thread version
//                battleResult = BattleField.fight(monster,hero);

//  multi-Thread version
                    battleResult.set(BattleField.fight(monster, adventurer));
                });
                battle.start();    //new side Thread run
                battle.join();    //sync main Thread / new side Thread

                if (battleResult.get() > 0) monsterDeepForestArray.set(currentForestPosition, 0);


                if (battleResult.get() < 0) {
                    System.out.println();
                    System.out.println("Your Hero fall in battle at deep forest trying clear heart of wood from Ancient Evil.");
                    System.out.println("Call a new Hero to finish that Great Mission.");
                    System.out.println();
                    MainRPG.startGame();
                } else if (battleResult.get() > 0) {
                    System.out.println();
                    System.out.println("Your Hero win the battle and ready to continue raid into deep forest.");
                    System.out.println();
                }


            }


        } while (battleResult.get() >= 0);



    }

    private static Monster generateMonster(int levelMonster) {
        Random random = new Random ();
        int x = random.nextInt ( 2 );
        
        Monster generatedMonster;

        switch (levelMonster) {
            case (1) -> {
                if (x > 0) generatedMonster = new Monster ( 1, 15, 3, 3, 4, 20, 10, "Skeleton" );
                else generatedMonster = new Monster ( 1, 20, 4, 4, 3, 25, 15, "Orc" );
            }
            case (2) -> {
                if (x > 0) generatedMonster = new Monster ( 2, 30, 4, 4, 5, 30, 20, "Skeleton" );
                else generatedMonster = new Monster ( 2, 35, 4, 5, 4, 35, 25, "Orc" );

            }
            case (10) -> {
                if (x > 0) generatedMonster = new Monster ( 5, 50, 5, 5, 5, 100, 50, "Skeleton Boss" );
                else generatedMonster = new Monster ( 5, 50, 6, 6, 3, 100, 50, "Orc Boss" );
            }
            default -> throw new IllegalStateException("Unexpected value: " + levelMonster);
        }
        return generatedMonster;

    }


}
