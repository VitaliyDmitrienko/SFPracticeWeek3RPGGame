public class Trader extends Creature {
    private int health=0;
    private int armour=0;
    private int money=0;
    private int strength=0;
    private int agility=0;
    private String traderName = "";

    public Trader(int health, int armour, int money, int strength, int agility, String traderName){
        super (0,0,0,0,0, traderName);
     }
}
