import java.util.ArrayList;

public class Party {
    private String name;
    private String description;
    private ArrayList<Character> members;

    public Party(String name, String description, ArrayList<Character> members) {
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

    /**
     * Funcion que muestra todos los characters y su nivel
     */
    public void showCharacters(){
        System.out.println();
        for(int i=0; i<this.members.size();i++){
            System.out.println(this.getMembers().get(i).getName()+" - lvl "+this.getMembers().get(i).getLevel());
        }
    }

    /**
     * Funcion que muestra el nivel medio de la party
     */
    public void showAvgLvl(){
        double total=0;
        for(int i=0; i<this.members.size();i++){
            total+=this.getMembers().get(i).getLevel();
        }
        System.out.println("\nThe party's average level is "+total/this.members.size());
    }

    /**
     *Funcion que muestra los items de personaje/s que coincida el nombre
     * @param name
     */
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

    /**
     *Funcion que muestra el oro que vale los items de los personaje/s con los que coincide el nombre
     * @param name
     */
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

    /**
     *Funcion que comprueba si los personajes pueden llevar mas items
     * @param name
     * @param extraWeight
     */
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
    /**
     * Funcion que mira si un personaje puede llevar mas peso y si puede llevar mas le añade el item al inventario
     * @param name
     * @param newItem
     */
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
