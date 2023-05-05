import static java.lang.Thread.sleep;

public class BattleField {

    public static void fight(Monster monster, Adventurer adventurer)  {
        System.out.println ("Suddenly on your way appear " + monster.getMonsterName () + ". He is attack you. Battle begin !!!");
        monster.growl();

        while (true) {
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
            if (adventurer.getHealth () <= 0) {
                adventurer.setIsAlive(false);
            } else {
                adventurer.changeHealth (-monster.attack ());
                System.out.println ("Hero wounded. Your health is: " + adventurer.health + " of (max level health): " + adventurer.getMaxLevelHealth () + ".");
            }
            if (monster.getHealth() <= 0) {
                monster.setIsAlive (false);
            } else {
                monster.changeHealth ( -adventurer.attack ());
                System.out.println ("Monster wounded. His health is: " + monster.getHealth () + " of (max level health): " + monster.getMaxLevelHealth () + ".");
            }
        } if (adventurer.getIsAlive ()) {
            adventurer.setMoney( monster.money );
            System.out.println ("You collect "+ monster.money + " gold coins from defeated " + monster.name + ".");
            adventurer.setExperience ( monster.getExperience () );
            System.out.println ("You earned "+ monster.getExperience () + " experience points for defeated " + monster.name + ".");
            System.out.println();
        }
    }

}
