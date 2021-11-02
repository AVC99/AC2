import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Party {
    private String name;
    private String description;
    private ArrayList<Character> members;

    public String getName() {
        return name;
    }

    public Party(String name, String description, ArrayList<Character> members) {
        this.name = name;
        this.description = description;
        this.members = members;
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
    public void showCharItems(){
        boolean found=false;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Which character? ");
        String name=scanner.next();
        try {
            for (Character c : this.members) {
                if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(c.getName()+" has the following items:\n");
                    for (Item i : c.getInventory()) {
                        System.out.println(i.getName());
                    }
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Couldn't find the character.");
            }
        }catch (InputMismatchException e){
            System.out.println("Please enter a correct value");
            e.printStackTrace();
        }
    }
    public void showCharAsset(){
        boolean found=false;
        int totalgold=0;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Which character? ");
        String name=scanner.next();
        try {
            for (Character c : this.members) {
                if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                    for (Item i : c.getInventory()) {
                       totalgold+=i.getValue();
                    }
                    System.out.println(c.getName()+" holds assets for a total of "+totalgold+" gold pieces");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Couldn't find the character.");
            }
        }catch (InputMismatchException e){
            System.out.println("Please enter a correct value");
            e.printStackTrace();
        }
    }
    public void checkCharWheight(){
        boolean found=false;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Which character? ");
        String name=scanner.next();
        System.out.println("How much extra weight? ");
        double extraWeight = scanner.nextDouble();
        double currentWheight = 0;
        try {
            for (Character c : this.members) {
                if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                    for (Item i : c.getInventory()) {
                        currentWheight+=i.getWeight();
                        System.out.println(i.getName()+ i.getWeight()+" ---"+currentWheight+"/"+c.getMaxWeight());
                    }
                    if (currentWheight+extraWeight > c.getMaxWeight()){
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
        }catch (InputMismatchException e){
            System.out.println("Please enter a correct value");
            e.printStackTrace();
        }
    }
    public void addItemToChar(){
        boolean found= false;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Who will get the item? ");
        String name=scanner.next();
        System.out.println("Enter the item's name: ");
        String newItemName= scanner.next();
        System.out.println("Enter the item's value: ");
        int newItemValue=scanner.nextInt();
        System.out.println("Enter the item's weight: ");
        double newItemWeight= scanner.nextDouble();
        Item newItem= new Item(newItemName,newItemValue,newItemWeight);
        double currentWheight=0;
        try {
            for (Character c : this.members) {
                if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                    for (Item i : c.getInventory()) {
                        currentWheight+=i.getWeight();
                    }
                    if (currentWheight+newItemWeight > c.getMaxWeight()){
                        System.out.println(c.getName()+" can't carry that much extra weight! ");
                    }else{
                        c.addItem(newItem);
                        System.out.println(c.getName()+" now carries a "+newItemName);
                    }
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Couldn't find the character.");
            }
        }catch (InputMismatchException e){
            System.out.println("Please enter a correct value");
            e.printStackTrace();
        }
    }
}
