public class BattleField {
//    public static void main(String[] args) {
//        Ork ork = new Ork();
//        Elf elf = new Elf();
//        fight(ork, elf);
//    }

    public static void fight(Monster monster, Adventurer adventurer) {
        System.out.println ("Suddenly on your way appear " + monster.getMonsterName () + ". He is attack you. Battle begin !!!");

        while (true) {
            if (!monster.getIsAlive() && adventurer.getIsAlive()) {
                System.out.println("Monster " + monster.getMonsterName () + " is dead. Hero win!");
                break;
            } else if (monster.getIsAlive() && !adventurer.getIsAlive()) {
                System.out.println("Hero is dead. Monster " + monster.getMonsterName () + "win!");
                break;
            } else if (!monster.getIsAlive () && !adventurer.getIsAlive()) {
                System.out.println("All is dead...");
                break;
            }
            if (adventurer.getHealth () < 0) {
                adventurer.setAlive(false);
            } else {
                adventurer.changeHealth (-monster.attack ());
                System.out.println ("Hero wounded. Your health is:" + adventurer.health + " of (max level health): " + adventurer.getMaxLevelHealth () + ".");
            }
            if (monster.getHealth() < 0) {
                monster.setAlive (false);
            } else {
                monster.changeHealth ( -adventurer.attack ());
                System.out.println ("Monster wounded. His health is:" + monster.getHealth () + " of (max level health): " + monster.getMaxLevelHealth () + ".");
            }
        } if (adventurer.getIsAlive ()) {
            adventurer.setMoney( monster.money );
            System.out.println ("You collect "+ monster.money + " gold coins from defeated " + monster.name + ".");
            adventurer.setExperience ( monster.getExperience () );
            System.out.println ("You earned "+ monster.getExperience () + " experience points for defeated " + monster.name + ".");
        }
    }

}
