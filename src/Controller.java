import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    private Menu menu = new Menu();
    private Party p;
    private Scanner scanner= new Scanner(System.in);



    public void loadFiles(){
        try {
            System.out.println("Loading party file...\n");
            String name = "party.json";
            //String name = scanner.next();------------------------------------------------------------------------ Canviar al final
            p = new ReadWriteFile().loadParty(name);
            System.out.println("Party name: "+ p.getName());
            System.out.println("Party description: " + p.getDescription());
        }catch (InputMismatchException e){
            System.out.println("Please enter a correct input");
            e.printStackTrace();
        }

    }

    public void run() {
        int option;
        loadFiles();
        try {
            do {
                menu.showMenu();
                option = menu.askForInteger("Enter an option: ");
                executeOption(option);
            } while (option != 7);
        }catch (InputMismatchException e){
            System.out.println("Please enter a correct input");
            e.printStackTrace();
        }
    }

    private void executeOption(int option) {
        String name;
        switch (option) {
            case 1 -> p.showCharacters();
            case 2 -> p.showAvgLvl();
            case 3 -> {
                try{
                    System.out.println("Which character? ");
                     name=scanner.next();
                    p.showCharItems(name);
                }catch (NoSuchElementException e){
                 e.printStackTrace();
                }
            }
            case 4 ->{
                try {
                    System.out.println("Which character? ");
                     name = scanner.next();
                    p.showCharAsset(name);
                }catch (NoSuchElementException e){
                    e.printStackTrace();
                }
            }
            case 5 -> {
                try{
                    System.out.println("Which character? ");
                    name= scanner.next();
                    Scanner scanner=new Scanner(System.in);
                    System.out.println("How much extra weight? ");
                    double extraWeight = scanner.nextDouble();
                    p.checkCharWeight(name,extraWeight);
                }catch (InputMismatchException e){
                    System.out.println("Please enter a correct value");
                    e.printStackTrace();
                }
            }
            case 6 -> {
                try {
                    System.out.println("Who will get the item? ");
                     name=scanner.next();
                    System.out.println("Enter the item's name: ");
                    String newItemName= scanner.next();
                    System.out.println("Enter the item's value: ");
                    int newItemValue=scanner.nextInt();
                    System.out.println("Enter the item's weight: ");
                    double newItemWeight= scanner.nextDouble();
                    Item newItem= new Item(newItemName,newItemValue,newItemWeight);
                    p.addItemToChar(name,newItem);
                }catch (InputMismatchException e){
                    System.out.println("Please enter a correct value");
                    e.printStackTrace();
                }
            }
            case 7 -> new ReadWriteFile().writeFile(p);
        }
    }

}
