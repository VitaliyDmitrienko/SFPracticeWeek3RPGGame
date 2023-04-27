public class Adventurer extends Monster {
    private int health=0;
    private int armour=0;
    private int money=0;
    private int strength=0;
    private int agility=0;
    private int experience=0;
    private String adventurerName = "";
    private boolean isAlive = true;


    public Adventurer(int health, int armour, int money, int strength, int agility, String adventurerName){
        super (0,0,0,0,0, adventurerName);
        this.experience=0;
    }

}
