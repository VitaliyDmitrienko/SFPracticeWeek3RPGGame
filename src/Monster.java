public abstract class Monster extends Creature{

    private int level=0;
    private int health=0;
    private int armour=0;
    private int money=0;
    private int strength=0;
    private int agility=0;
    private int experience=0;
    private boolean isAlive = true;
    private int attack=0;
    private String monsterName = "";

    public Monster(int health, int armour, int strength, int agility, int money, String monsterName){
        super (0,0,0,0,0, monsterName );
        System.out.println("Monster " + monsterName + " was created");
    }

    public void growl(){
        System.out.println(monsterName + " growled");
    }

    public int attack() {
        growl();
        System.out.println("Monster " + monsterName + " attacked with damage " + attack);
        return attack;
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
        return monsterName;
    }



}
