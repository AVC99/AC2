import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void showMenu(){
        System.out.println("\n--Party--\n\n1. Show characters\n2. Show average level\n3. Show character items\n4. Show character assets value\n5. Check character weight\n6. Add item to character\n7. Exit\n");
    }
    public int askForInteger(String message) {
        Scanner scanner= new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error, please input a number");
            } finally {
                scanner.nextLine();
            }
        }
    }

}
