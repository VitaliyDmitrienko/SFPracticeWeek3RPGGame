public abstract class Monster extends Creature{
    private int health=0;
    private int armour=0;
    private int money=0;
    private int strength=0;
    private int agility=0;
    private boolean isAlive = true;


    int attack=0;
    String monsterName = "";

    public Monster(int health, int armour, int money, int strength, int agility, String monsterName){
        super (0,0,0,0,0, monsterName );
        System.out.println("Monster " + monsterName + " was created");
    }

    public void growl(){
        System.out.println(monsterName + " growled");
    }

    public void attack() {
        System.out.println("Monster " + monsterName + " attacked with damage " + attack);
    }


}
