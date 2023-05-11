import java.lang.reflect.Array;

public class Adventurer extends Creature {

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

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }
    public void growl(){
        System.out.println(name + " crying <Chaaaaarge !!!>");
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
