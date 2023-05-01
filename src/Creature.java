public abstract class Creature {
    private int level;


    protected int health;
    protected int maxLevelHealth;

    protected int armour;
    protected int money;
    protected int strength;


    protected int agility;
    protected int attack;

    protected String name = "";

    protected boolean isAlive = true;


    public Creature (int health, int armour, int strength, int agility, int money, String name){
        this.health = health;
        this.armour = armour;
        this.strength = strength;
        this.agility = agility;
        this.money = money;
        this.name = name;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public boolean getIsAlive() {
        return isAlive;
    }

    public  void setHealth(int health) {
        this.health = health;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    public void getStatus() {
        System.out.println("Hero of name: " + this.name + " of level: " + this.level + ".");
        System.out.println("Health is: " + this.health + " of health (max level): " + this.maxLevelHealth + ".");
        System.out.println("Strength is: " + this.strength + ". Attack is: " + this.attack + ".");
        System.out.println("Agility is: " + this.agility + ". Armour is: " + this.armour + ".");
        System.out.println("Money is: " + this.money + ".");
    }






}
