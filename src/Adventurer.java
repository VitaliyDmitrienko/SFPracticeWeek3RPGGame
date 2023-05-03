import java.lang.reflect.Array;

public class Adventurer extends Creature {

//    private int level;
    private int [] maxLevelHealthArray = {25,50,100,200,300,400,500,600,700,800,900,1000};
    private int [] experienceLevelCapArray = {25,50,100,200,300,400,500,600,700,800,900,1000};
//    private int health;


    private int maxLevelHealth = maxLevelHealthArray[level];
    private int maxLevelExperience = experienceLevelCapArray[level];
//    private int armour;
//    private int money;
//    private int strength;
//    private int agility;
//    private int experience=10;
//    private boolean isAlive = true;
    private int damage = strength + level;


//    private String name = "";

    public Adventurer(int level, int health, int armour, int strength, int agility, int money, int experience, String name){
        super (level, health, armour, strength, agility, money,experience, name);
//        this.experience = ex;
        System.out.println ("Great Adventurer " + name + " appear in the World!!!");
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
        return super.health;
    }

    public boolean getIsAlive() {
        return super.isAlive;
    }

    public void setHealth(int health) {
        super.health += health;
    }
    public void restoreHealth() {
        super.health = maxLevelHealth;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }
    public void growl(){
        System.out.println(name + " crying <Chaaaaarge !!!>");
    }

    public int attack() {
        System.out.println("Monster " + name + " attacked with damage " + damage);
        return damage;
    }
    @Override
    public void getStatus() {
        System.out.println("Hero of name: " + super.name + " of level: " + super.level + ". Hero status is: " + super.isAlive + ".");
        System.out.println("Health is: " + health + " of (max level health): " + maxLevelHealth + ".");
        System.out.println("Strength is: " + strength + ". Attack(damage) is: " + damage + ".");
        System.out.println("Agility is: " + agility + ". Armour is: " + armour + ".");
        System.out.println("Money is: " + money + " gold coins. Experience is: " + experience + " of (max level experience): " + maxLevelExperience + ".");
    }

    public int getMaxLevelHealth() {
        return maxLevelHealth;
    }

    public void setMaxLevelHealth() {
        maxLevelHealth = maxLevelHealthArray[level];
    }

    public int getMoney() {
        return super.money;
    }

    public void setMoney(int money) {
        super.money += money;
    }



}
