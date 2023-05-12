import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BattleField {

    public static int fight(Monster monster, Adventurer adventurer)  {
        Scanner scanner = new Scanner(System.in);
        int input;
        int firstAttackHero=0;
        int criticalDamage;
        int stepBattleCounter=1;

        monster.growl();
        System.out.println ("Suddenly on your way appear " + monster.getMonsterName () + ". He is attack you. Battle begin !!!");
        System.out.println();

        if (adventurer.getAgility() >= monster.getAgility()) {
            System.out.println("Your hero faster, than monster and can attack first.");
            System.out.println("Hero agility: " + adventurer.getAgility() + ". Monster agility: " + monster.getAgility() + ".");
            firstAttackHero=1;
        }


        do {
            System.out.println(" === Step battle is: " + stepBattleCounter + " ===");

            if (!monster.getIsAlive() && adventurer.getIsAlive()) {
                System.out.println("Monster " + monster.getMonsterName () + " is dead. Hero win!");
                System.out.println();
                break;
            } else if (monster.getIsAlive() && !adventurer.getIsAlive()) {
                System.out.println("Hero is dead. Monster " + monster.getMonsterName () + "win!");
                System.out.println();
                break;
            } else if (!monster.getIsAlive () && !adventurer.getIsAlive()) {
                System.out.println("All is dead...");
                System.out.println();
                break;
            }

            if (monster.getHealth() <= 0) {
                monster.setIsAlive (false);
            } else if (adventurer.getIsAlive()){
                try {
                    TimeUnit.SECONDS.sleep(1);
//                    System.out.println("Battle pause ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (firstAttackHero > 0 ) {
                    criticalDamage = isCriticalStrike(adventurer);
                    if (criticalDamage > 0) {
                        monster.changeHealth(-adventurer.attack(criticalDamage));
                        System.out.println("Monster wounded. His health is: " + monster.getHealth() + " of (max level health): " + monster.getMaxLevelHealth() + ".");
                        if (monster.getHealth() <= 0) monster.setIsAlive (false);
                    } else {
                        System.out.println("Your Hero is missed and can't deal damage to monster.");
                        System.out.println("Monster is unwounded. His health is: " + monster.getHealth() + " of (max level health): " + monster.getMaxLevelHealth() + ".");
                    }
                }
            }

             if (adventurer.getHealth () <= 0) {
                adventurer.setIsAlive(false);
            } else if (monster.getIsAlive()){
                try {
                    TimeUnit.SECONDS.sleep(1);
//                    System.out.println("Battle pause ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                 criticalDamage = isCriticalStrike(monster);
                 if (criticalDamage > 0) {
                     adventurer.changeHealth(-monster.attack(criticalDamage));
                     System.out.println("Hero wounded. Your health is: " + adventurer.health + " of (max level health): " + adventurer.getMaxLevelHealth() + ".");
                     firstAttackHero = 1;
                     if (adventurer.getHealth () <= 0) adventurer.setIsAlive(false);
                 } else {
                     System.out.println("Monster " + monster.getMonsterName() + " is missed and can't deal damage to Hero.");
                     System.out.println("Hero is unwounded. Your health is: " + adventurer.health + " of (max level health): " + adventurer.getMaxLevelHealth() + ".");
                 }
            }


            do {
                System.out.println("At the end of " + stepBattleCounter + " step of battle you can take a breath and set pause.\n");
                do {
                      System.out.println ( "<1> Check hero status.");
                      System.out.println ( "<2> Check hero quick item(s).");
                      if (!adventurer.isEmptyQuickItemsInventory()) System.out.println( "<3> Use hero quick item(s).");
                      System.out.println ( "<4> Cancel pause and return to battle.\n" );

                      input = scanner.nextInt();
                     switch (input) {
                         case (1) -> adventurer.getStatus();
                         case (2) -> adventurer.checkQuickSlotInventory ();
                         case (3) -> {if (!adventurer.isEmptyQuickItemsInventory()) adventurer.useQuickItemsInventory();}
                         case (4) -> System.out.println("Get ready !!! Battle is resume !!!");
                         default -> System.out.println("Wrong choose. Try right input again.");
                     }

                 } while (input != 4);


             } while (input != 4 && monster.getIsAlive());

             stepBattleCounter++;

         } while (adventurer.getIsAlive() && monster.getIsAlive());

        if (adventurer.getIsAlive ()) {
            System.out.println();
            adventurer.setMoney( monster.money );
            System.out.println ("You collect "+ monster.money + " gold coins from defeated " + monster.name + ".");
            adventurer.setExperience ( monster.getExperience () );
            System.out.println ("You receive " + monster.getExperience () + " experience points for defeated " + monster.name + ".");
            System.out.println();

            return 1;
        } else return -1;


    }

    private static int isCriticalStrike(Creature creature) {
        Random random = new Random();
        int x = random.nextInt(30)+1;

        if (x <= creature.getAgility()) return 2;
        if (x <= creature.getAgility()*3 && x > creature.getAgility()) return 1;
        else return 0;

    }

}
