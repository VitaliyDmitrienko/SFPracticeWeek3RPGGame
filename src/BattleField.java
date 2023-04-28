public class BattleField {
//    public static void main(String[] args) {
//        Ork ork = new Ork();
//        Elf elf = new Elf();
//        fight(ork, elf);
//    }
    private static void fight(Monster monster, Adventurer adventurer) {
        while (true) {
            if (!monster.isAlive() && adventurer.isAlive()) {
                System.out.println("Ork is dead. Elf win!");
                break;
            } else if (monster.isAlive() && !adventurer.isAlive()) {
                System.out.println("Elf is dead. Ork win!");
                break;
            } else if (!monster.isAlive () && !adventurer.isAlive()) {
                System.out.println("All is dead...");
                break;
            }
            if (adventurer.getHealth () < 0) {
                adventurer.setAlive(false);
            } else {
                adventurer.setHealth (-monster.attack ());
            }
            if (monster.getHealth() < 0) {
                monster.setAlive (false);
            } else {
                monster.setHealth (-adventurer.attack ());
            }
        }
    }

}
