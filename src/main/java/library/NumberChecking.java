package library;

import java.util.Scanner;

public class NumberChecking {

    private static Scanner scanner = new Scanner(System.in);

    static int checkIfIsNumber(String numberAsString) {
        if (!numberAsString.matches("\\d+")) {
            System.out.println("To nie liczba! Wpisz Liczbę.");

            String newAuthorsAge = scanner.nextLine();
        }
        return Integer.parseInt(numberAsString);
    }
}
