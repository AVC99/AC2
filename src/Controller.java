import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    private Menu menu = new Menu();
    private Party p;
    private Scanner scanner= new Scanner(System.in);


    /**
     * carga los json a una party
     */
    public void loadFiles(){
        try {
            System.out.println("Loading party file...\n");
            p = new ReadWriteFile().loadParty("party.json");
            System.out.println("Party name: "+ p.getName());
            System.out.println("Party description: " + p.getDescription());
        }catch (InputMismatchException e){
            System.out.println("Please enter a correct input");
            e.printStackTrace();
        }

    }

    /**
     * Funcion que repite el programa hasta que el usuario inserta el 7
     */
    public void run() {
        int option;
        loadFiles();
        try {
            do {
                menu.showMenu();
                option = menu.askForInteger("Enter an option: ");
                if(option>=1 && option<=7){
                    executeOption(option);
                }else {
                    System.out.println("Introduce a correct option");
                }
            } while (option != 7);
        }catch (InputMismatchException e){
            System.out.println("Please enter a correct input");
            e.printStackTrace();
        }
    }

    /**
     * Funcion que llama a todas las funciones que ofrece el menu
     * @param option
     */
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
                }finally {
                    scanner.nextLine();
                }
            }
            case 4 ->{
                try {
                    System.out.println("Which character? ");
                     name = scanner.next();
                    p.showCharAsset(name);
                }catch (NoSuchElementException e){
                    e.printStackTrace();
                }finally {
                    scanner.nextLine();
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
                }finally {
                    scanner.nextLine();
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
                }finally {
                    scanner.nextLine();
                }
            }
            case 7 -> new ReadWriteFile().writeFile(p);
        }
    }

}
