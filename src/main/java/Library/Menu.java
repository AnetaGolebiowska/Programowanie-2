package Library;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Methods methods = new Methods();

        System.out.println("Wybierz opcję: " +
                "\n 1. Lista książek " +
                "\n 2. Wyjdź " +
                "\n 3. Dodaj książkę " +
                "\n 4. Usuń książkę " +
                "\n 5. Edycja roku wydania książki " +
                "\n 6. Zapisz listę książek w csv");

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
                    System.out.println("Zapisz listę książek w csv");
                    break;
                default:
                    System.out.println("Błędny wybór, spróbuj jeszcze raz");
            }
            break;
        }
        System.out.println("Koniec działania programu.");
    }
}
