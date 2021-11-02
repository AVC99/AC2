import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private Menu menu = new Menu();
    Party p;

    public void loadFiles(){
        Scanner scanner= new Scanner(System.in);
    try {
        System.out.println("Loading party file...\n");
        String name = "party.json";
        //String name = scanner.next();------------------------------------------------------------------------ Canviar al final
        p = new LoadFromFile().loadParty(name);
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
        switch (option) {
            case 1 -> p.showCharacters();
            case 2 -> p.showAvgLvl();
            case 3 -> p.showCharItems();
            case 4 -> p.showCharAsset();
            case 5 -> p.checkCharWheight();
            case 6 -> p.addItemToChar();
            case 7 -> new LoadFromFile().writeFile(p);
        }
    }

}
