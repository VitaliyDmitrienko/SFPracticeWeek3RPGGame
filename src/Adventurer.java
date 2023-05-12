import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Adventurer extends Creature {

    // GoF-Pattern "Singletone" still is under construction
//    private static Adventurer instance;
//
//    public static synchronized Adventurer getInstance() {
//        if (instance == null) {
//            instance = new Adventurer (int level, int health, int armour, int strength, int agility, int money, int experience, String name) {
//        super (level, health, armour, strength, agility, money, experience, name);
//        System.out.println ("Great Adventurer " + name + " appear in the World!!!");
//        System.out.println();
//        getStatus();
//    }
//        }
//        return instance;
//    }


    private int [] maxLevelHealthArray = {25,50,75,100,125,150,200,250,300,400,500,600};
    private int [] experienceLevelCapArray = {25,50,100,150,200,300,500,600,700,800,900,1000};
    private int maxLevelHealth = maxLevelHealthArray[level];
    private int maxLevelExperience = experienceLevelCapArray[level];

//    0-reserved, 1-Small healing potion, 2-Middle healing potion, 3-Great healing potion
    private int [] quickItemsInventory = {0,0,0,0,0,0};
    private int damage = strength + level;


//    private String name = "";

    public Adventurer(int level, int health, int armour, int strength, int agility, int money, int experience, String name){
        super (level, health, armour, strength, agility, money, experience, name);
        System.out.println ("Great Adventurer " + name + " appear in the World!!!");
        System.out.println();
        getStatus();
    }

    public void checkQuickSlotInventory() {
        if (quickItemsInventory[1] > 0 )
            System.out.println("You have " + quickItemsInventory[1] + " small healing potion (+10 hp) to can instant restore your health in battle.");
        if (quickItemsInventory[2] > 0 )
            System.out.println("You have " + quickItemsInventory[2] + " middle healing potion (+25 hp) to can instant restore your health in battle.");
        if (quickItemsInventory[3] > 0 )
            System.out.println("You have " + quickItemsInventory[3] + " great healing potion (+50 hp) to can instant restore your health in battle.");
        if (isEmptyQuickItemsInventory())
            System.out.println("You have no more quick item(s) to instant use in battle. Time to visit Trader in Big Town.");
        System.out.println();
    }
    public boolean isEmptyQuickItemsInventory () {
        int isEmpty= Arrays.stream(quickItemsInventory).sum();
        return isEmpty <= 0;
    }
    public void useQuickItemsInventory() {
        System.out.println();
        checkQuickSlotInventory();
        System.out.println();
        System.out.println("Choose quick item(s) to instant use in battle.\n");
        System.out.println("<1> Small healing potion (+10 hp).");
        System.out.println("<2> Middle healing potion (+25 hp).");
        System.out.println("<3> Great healing potion (+50 hp).");

        Scanner scanner = new Scanner(System.in);
        int chooseQuickItemSlot;
        chooseQuickItemSlot = scanner.nextInt();

        if (chooseQuickItemSlot == 1 && (quickItemsInventory[1] > 0) ) {
            setHealth(10);
            quickItemsInventory[1]--;
            System.out.println("You spent small healing potion to restore 10 hit points to your hero.");
            System.out.println("You have " + quickItemsInventory[1] + " small healing potion (+10 hp) to can instant restore your health in battle.");
        }
        if (chooseQuickItemSlot == 1 && quickItemsInventory[2] > 0 ) {
            setHealth(25);
            quickItemsInventory[2]--;
            System.out.println("You spent middle healing potion to restore 25 hit points to your hero.");
            System.out.println("You have " + quickItemsInventory[2] + " middle healing potion (+25 hp) to can instant restore your health in battle.");
        }
        if (quickItemsInventory[3] > 0 ) {
            setHealth(50);
            quickItemsInventory[3]--;
            System.out.println("You spent great healing potion to restore 50 hit points to your hero.");
            System.out.println("You have " + quickItemsInventory[3] + " great healing potion (+50 hp) to can instant restore your health in battle.");
        }
        if (isEmptyQuickItemsInventory())
            System.out.println("You have no more quick item(s) to instant use in battle. Time to visit Trader in Big Town.");
        System.out.println();

    }

    public int getQuickItemsInventory(int inventorySlot) {
        return this.quickItemsInventory[inventorySlot];
    }

    public void setQuickItemsInventory(int inventorySlot, int inventorySlotCount) {
        this.quickItemsInventory[inventorySlot] = inventorySlotCount;
    }


    public void setMaxLevelExperience() {
        this.maxLevelExperience = experienceLevelCapArray[level];
    }

    public int getStrength() {
        return (super.strength + super.level);
    }

    public int getAgility() {
        return (super.agility + super.level);
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

    public void changeHealth(int changeHealth) {
        super.health += changeHealth;
    }
    public void restoreHealth() {
        super.health = maxLevelHealth;
    }

    public void setIsAlive(boolean aliveStatus) {
        this.isAlive = aliveStatus;
    }
    public void growl(){
        System.out.println(name + " crying \"Chaaaaarge !!!\"");
    }

    public int attack(int critical) {
        System.out.println("Hero " + name + " attacked with damage " + damage*critical);
        return damage*critical;
    }
    @Override
    public void getStatus() {
        System.out.println("Hero of name: " + super.name + " of level: " + super.level + ". Hero status is: " + super.isAlive + ".");
        System.out.println("Health is: " + super.health + " of (max level health): " + maxLevelHealth + ".");
        System.out.println("Strength is: " + super.strength + ". Attack(damage) is: " + damage + ".");
        System.out.println("Agility is: " + super.agility + ". Armour is: " + super.armour + ".");
        System.out.println("Money is: " + super.money + " gold coins. Experience is: " + super.experience + " of (max level experience): " + maxLevelExperience + ".");
        if (getExperience() >= getMaxLevelExperience())
            System.out.println("Your Hero can level up.");
        System.out.println();
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

    public int getExperience() {
        return super.experience;
    }
    public int getMaxLevelExperience() {
        return experienceLevelCapArray[level];
    }

    public void setExperience(int experience) {
        super.experience += experience;
    }
    public void setLevelUpHero () {
        super.level++;
        setMaxLevelHealth();
        restoreHealth();
        setMaxLevelExperience();
    }


    public int getLevel() {
        return super.level;
    }
}
