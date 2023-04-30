import java.lang.reflect.Array;

public class Adventurer extends Creature {

    private static int level=1;
    private static int [] maxLevelHealthArray = {0,50,100,200,300,400,500,600,700,800,900,1000};
    private static int health;


    private static int maxLevelHealth=50;
    private static int armour;
    private static int money;
    private static int strength;
    private static int agility;
    private int experience;
    private boolean isAlive = true;
    private static int attack;


    private static String name = "";

    public Adventurer(int health, int armour, int strength, int agility, int money, String adventurerName){
        super (0,0,0,0,0, adventurerName);
        this.experience=0;
        System.out.println ("Great Adventurer " + adventurerName + " appear in the World!!!");
        System.out.println();
        getStatus();
    }
    public int getStrength() {
        return super.strength;
    }

    public int getAgility() {
        return super.agility;
    }



    public String getAdventurerName() {
        return super.name;
    }
    public int getArmour() {
        return super.armour;
    }

    public int getHealth() {
        return super.health();
    }

    public boolean getIsAlive() {
        return super.isAlive;
    }

    public static void setHealth(int health) {
        Adventurer.health = health ;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public void growl(){
        System.out.println(name + "Chaaaaarge !!!");
    }

    public int attack() {
        System.out.println("Monster " + name + " attacked with damage " + attack);
        return attack;
    }
    public void getStatus() {
        System.out.println("Hero of name: " + name + " of level: " + level + ".");
        System.out.println("Health is: " + health + " of health (max level): " + maxLevelHealth + ".");
        System.out.println("Strength is: " + strength + ". Attack is: " + attack + ".");
        System.out.println("Agility is: " + agility + ". Armour is: " + armour + ".");
        System.out.println("Money is: " + money + ".");
    }

    public static int getMaxLevelHealth() {
        return maxLevelHealth;
    }

    public static void setMaxLevelHealth() {
        maxLevelHealth = maxLevelHealthArray[level];
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Adventurer.money += money;
    }



}
