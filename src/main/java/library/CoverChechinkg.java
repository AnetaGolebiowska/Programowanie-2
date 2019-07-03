package library;

import java.util.Scanner;

public class CoverChechinkg {

        static Scanner scanner = new Scanner(System.in);

    public static void checkCoverType(String coverType) {

        if (coverType.equalsIgnoreCase("M") || coverType.equalsIgnoreCase("T")) {
        } else {
            System.out.println("Nieprawidłowy wpis. Spróbuj jeszcze raz.");
            coverType = scanner.nextLine();
        }
    }
}
