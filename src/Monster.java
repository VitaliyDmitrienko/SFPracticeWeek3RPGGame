public abstract class Monster extends Creature{

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

    public Monster(int level, int health, int armour, int strength, int agility, int money, int experience, String monsterName){
        super (level, health, armour, strength, agility, money , experience, monsterName );
        System.out.println("Monster " + monsterName + " was created");
    }

    public void growl(){
        System.out.println(name + " growled");
    }

    public int attack() {
        growl();
        System.out.println("Monster " + name + " attacked with damage " + damage);
        return damage;
    }

    public int getHealth() {
        return super.getHealth();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setHealth(int health) {
        super.setHealth(health);
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getMonsterName() {
        return name;
    }



}
