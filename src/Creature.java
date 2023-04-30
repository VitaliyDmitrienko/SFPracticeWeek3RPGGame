public abstract class Creature {
    private static int level;
    private static int health;
    private static int maxLevelHealth=50;

    protected static int armour;
    private static int money;
    protected static int strength;
    protected static int agility;
    private static int attack;

    protected static String name = "";

    boolean isAlive = true;


    public Creature (int health, int armour, int strength, int agility, int money, String name){
        this.health = health;
        this.armour = armour;
        this.strength = strength;
        this.agility = agility;
        this.money = money;
        this.name =name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public static void setHealth(int health) {
        Creature.health = health;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void getStatus() {
        System.out.println("Hero of name: " + this.name + " of level: " + this.level + ".");
        System.out.println("Health is: " + health + " of health (max level): " + maxLevelHealth + ".");
        System.out.println("Strength is: " + strength + ". Attack is: " + attack + ".");
        System.out.println("Agility is: " + agility + ". Armour is: " + armour + ".");
        System.out.println("Money is: " + money + ".");
    }






}
