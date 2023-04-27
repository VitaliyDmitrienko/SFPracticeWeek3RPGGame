public abstract class Creature {
    private int health=0;
    private int armour=0;
    private int money=0;
    private int strength=0;
    private int agility=0;
    private String creatureName = "";

    public Creature (int health, int armour, int money, int strength, int agility, String creatureName){
        this.health = health;
        this.armour = armour;
        this.money = money;
        this.strength = strength;
        this.agility = agility;
        this.creatureName = creatureName;
    }
}
