import java.util.ArrayList;

public class Character {
    private String name;
    private int level;
    private int gold;
    private double maxWheight;
    private ArrayList<Item> inventory;

    public Character(String name, int level, int gold, double maxWheight, ArrayList<Item> inventory) {
        this.name = name;
        this.level = level;
        this.gold = gold;
        this.maxWheight = maxWheight;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public double getMaxWheight() {
        return maxWheight;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
