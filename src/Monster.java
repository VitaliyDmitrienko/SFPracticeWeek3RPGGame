public class Monster extends Creature{

//    private int level=0;
//    private int health=0;
//    private int armour=0;
//    private int money=0;
//    private int strength=0;
//    private int agility=0;
//    private int experience=0;
//    private boolean isAlive = true;
//    private int attack=0;
//    private String monsterName = "";
    private int damage = strength + level;
    private int maxLevelHealth;


    public Monster(int level, int health, int armour, int strength, int agility, int money, int experience, String monsterName){
        super (level, health, armour, strength, agility, money , experience, monsterName );
        this.maxLevelHealth = health;
        System.out.println("Monster " + monsterName + " was created");
    }

    public void growl(){
        System.out.println(super.name + " growled");
    }

    public int attack() {
        growl();
        System.out.println("Monster " + super.name + " attacked with damage " + damage);
        return damage;
    }

    public int getHealth() {
        return super.getHealth();
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void changeHealth(int changeHealth) {
        super.health += changeHealth;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getMonsterName() {
        return name;
    }


    public int getMaxLevelHealth() {
        return maxLevelHealth;
    }
    public int getExperience() {
        return experience;
    }

    public void setExperience(int exp) {
        experience += exp;
    }

}
