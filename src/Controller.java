import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private Menu menu = new Menu();
    Party p;

    public void loadFiles(){
        Scanner scanner= new Scanner(System.in);
    try {
        System.out.println("Loading party file...");
        System.out.println("Party name: ");
        String name = "party.json";
        //String name = scanner.next();------------------------------------------------------------------------ Canviar al final
        p = new LoadFromFile().loadParty(name);
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
            case 1:
                p.showCharacters();
                break;
            case 2:
                p.showAvgLvl();
                break;
            case 3:
                p.showCharItems();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;

        }
    }

}
