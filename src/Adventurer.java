import java.lang.reflect.Array;

public class Adventurer extends Creature {

    private int level=1;
    private int [] maxLevelHealthArray = {25,50,100,200,300,400,500,600,700,800,900,1000};
//    private int health;


    private int maxLevelHealth=50;
//    private int armour;
//    private int money;
//    private int strength;
//    private int agility;
    private int experience;
    private boolean isAlive = true;
    private int attack;


//    private String name = "";

    public Adventurer(int health, int armour, int strength, int agility, int money, String adventurerName){
        super (0,0,0,0,0, adventurerName);
        this.experience=0;
        System.out.println ("Great Adventurer " + adventurerName + " appear in the World!!!");
        System.out.println();
        getStatus();
    }
    public int getStrength() {
        return super.getStrength();
    }

    public int getAgility() {
        return super.getAgility();
    }



    public String getAdventurerName() {
        return super.name;
    }
    public int getArmour() {
        return super.armour;
    }

    public int getHealth() {
        return super.health;
    }

    public boolean getIsAlive() {
        return super.isAlive;
    }

    public void setHealth(int health) {
        super.setHealth(health);
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }
    public void growl(){
        System.out.println(name + "Chaaaaarge !!!");
    }

    public int attack() {
        System.out.println("Monster " + name + " attacked with damage " + attack);
        return attack;
    }
    @Override
    public void getStatus() {
        System.out.println("Hero of name: " + super.name + " of level: " + level + ".");
        System.out.println("Health is: " + super.health + " of health (max level): " + maxLevelHealth + ".");
        System.out.println("Strength is: " + super.strength + ". Attack is: " + super.attack + ".");
        System.out.println("Agility is: " + super.agility + ". Armour is: " + super.armour + ".");
        System.out.println("Money is: " + super.money + ".");
    }

//    public static int getMaxLevelHealth() {
//        return maxLevelHealth;
//    }

//    public static void setMaxLevelHealth() {
//        maxLevelHealth = maxLevelHealthArray[level];
//    }
//
//    public static int getMoney() {
//        return money;
//    }

//    public static void setMoney(int money) {
//        Adventurer.money += money;
//    }



}
