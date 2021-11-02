import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Party {
    private String name;
    private String description;
    private ArrayList<Character> members;

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
}
