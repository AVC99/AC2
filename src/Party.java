import java.util.ArrayList;

public class Party {
    private String name;
    private String description;
    private ArrayList<Character> members;

    private Party(String name, String description, ArrayList<Character> members) {
        this.name = name;
        this.description = description;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Character> getMembers() {
        return members;
    }

    public String getDescription() {
        return description;
    }

    public void showCharacters(){
        System.out.println();
        for(int i=0; i<this.members.size();i++){
            System.out.println(this.getMembers().get(i).getName()+" - lvl "+this.getMembers().get(i).getLevel());
        }
    }
    public void showAvgLvl(){
        double total=0;
        for(int i=0; i<this.members.size();i++){
            total+=this.getMembers().get(i).getLevel();
        }
        System.out.println("\nThe party's average level is "+total/this.members.size());
    }
    public void showCharItems(String name){
        boolean found=false;
            for (Character c : this.members) {
                if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println("\n"+c.getName()+" has the following items:\n");
                    for (Item i : c.getInventory()) {
                        System.out.println(i.getName());
                    }
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Couldn't find the character.");
            }

    }
    public void showCharAsset(String name){
        boolean found=false;

              for (Character c : this.members) {
                  int totalGold=0;
                if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                    for (Item i : c.getInventory()) {
                       totalGold+=i.getValue();
                    }
                    System.out.println(c.getName()+" holds assets for a total of "+totalGold+" gold pieces");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Couldn't find the character.");
            }
    }
    public void checkCharWeight(String name, Double extraWeight){
        boolean found=false;
        for (Character c : this.members) {
            double currentWeight = 0;
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                for (Item i : c.getInventory()) {
                    currentWeight+=i.getWeight();
                    //System.out.println(i.getName()+ i.getWeight()+" ---"+currentWeight+"/"+c.getMaxWeight());
                }
                if (currentWeight+extraWeight > c.getMaxWeight()){
                    System.out.println(c.getName()+" can't carry that much extra weight! ");
                }else{
                    System.out.println(c.getName()+" would be able to carry that weight.");
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("Couldn't find the character.");
        }

    }
    public void addItemToChar(String name, Item newItem){
        boolean found= false;

        for (Character c : this.members) {
            double currentWeight=0;
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                for (Item i : c.getInventory()) {
                    currentWeight+=i.getWeight();
                }
                if (currentWeight+newItem.getWeight() > c.getMaxWeight()){
                    System.out.println(c.getName()+" can't carry that much extra weight! ");
                }else{
                    c.addItem(newItem);
                    System.out.println(c.getName()+" now carries a "+newItem.getName());
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("Couldn't find the character.");
        }

    }
}
