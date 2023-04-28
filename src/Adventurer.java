public class Adventurer extends Creature {

    private int health=0;
    private int armour=0;
    private int money=0;
    private int strength=0;
    private int agility=0;
    private int experience=0;
    private boolean isAlive = true;
    private int attack=0;
    private String adventurerName = "";

    public Adventurer(int health, int armour, int money, int strength, int agility, String adventurerName){
        super (0,0,0,0,0, adventurerName);
        this.experience=0;
        System.out.println ("Great Adventurer " + adventurerName + " appear in the World!!!");
    }
    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public void growl(){
        System.out.println(adventurerName + " growled");
    }

    public int attack() {
        System.out.println("Monster " + adventurerName + " attacked with damage " + attack);
        return strength;
    }

}
