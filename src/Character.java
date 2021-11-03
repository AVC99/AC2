import java.util.ArrayList;

public class Character {
    private String name;
    private int level;
    private int gold;
    private double maxWeight;
    private ArrayList<Item> inventory;

    private Character(String name, int level, int gold, double maxWeight, ArrayList<Item> inventory) {
        this.name = name;
        this.level = level;
        this.gold = gold;
        this.maxWeight = maxWeight;
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

    public double getMaxWeight() {
        return maxWeight;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item){
        this.inventory.add(item);
    }
}
