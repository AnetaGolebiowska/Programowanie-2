package Library;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Methods methods = new Methods();
        Start start = new Start();
        start.startMenu();

        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());

        while (choice != 2) {
            switch (choice) {
                case 1:
                    methods.viewBook();
                    methods.printBook();
                    break;
                case 3:
                    methods.addBook();
                    break;
                case 4:
                    methods.removeBook();
                    break;
                case 5:
                    methods.changeYear();
                    break;
                case 6:
                    methods.saveAsCsv();
                    break;
                default:
                    System.out.println("Błędny wybór, spróbuj jeszcze raz");
                    start.startMenu();
                    choice = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("Koniec działania programu.");
    }
}
