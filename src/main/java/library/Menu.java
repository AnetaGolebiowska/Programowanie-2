package library;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        BooksMethoth methods = new BooksMethoth();
        BookLoader bookLoader = new BookLoader();
        Start start = new Start();
        start.startMenu();

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();


                while (choice != 2) {
                    switch (choice) {
                        case 1:
                            bookLoader.fileLoadBook();
                            methods.printBook();
                            choice = scanner.nextInt();
                            break;
                        case 3:
                            methods.addBook();
                            choice = scanner.nextInt();
                            break;
                        case 4:
                            methods.removeBook();
                            choice = scanner.nextInt();
                            break;
                        case 5:
                            methods.changeYear();
                            choice = scanner.nextInt();
                            break;
                        case 6:
                            methods.saveAsCsv();
                            choice = scanner.nextInt();
                            break;
                        default:
                            System.out.println("Błędny wybór,róbuj jeszcze raz");
                            choice = scanner.nextInt();
                    }
                }
                System.out.println("Koniec działania programu.");
            }
        }
    }
}
