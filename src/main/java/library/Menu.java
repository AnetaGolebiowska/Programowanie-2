package library;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        BooksMethoth methods = new BooksMethoth();
        methods.loadAllFiles();
        BookLoader bookLoader = new BookLoader();
        BookFunctions bookFunctions = new BookFunctions();
        FormatFunction printStrategy = new PrintFormatTitleYearIsbn();
        CategorieFunction categorieFunction = new CategorieFunction();
        AuthorFunction authorFunction = new AuthorFunction();
        SaveBook saveBook = new SaveBook();
        Start start = new Start();
        start.startMenu();

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                while (choice != 2) {
                    switch (choice) {
                        case 1:
                            printStrategy.printBook(DateBookHolder.getInstance().listOfBooks);
                            start.formatPrintBook();
                            choice = scanner.nextInt();
                            break;
                        case 3:
                            methods.addBook();
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 4:
                            methods.removeBook();
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 5:
                            methods.changeYear();
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 6:
                            saveBook.saveAsCsv(DateBookHolder.getInstance().listOfBooks,
                                    "C:\\Users\\hp\\IdeaProjects\\Programowanie2\\src\\main\\resources\\newBooks.csv");
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 7:
                            bookFunctions.startedTillYoungest(DateBookHolder.getInstance().listOfBooks);
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 8:
                            bookFunctions.startedTillOldest(DateBookHolder.getInstance().listOfBooks);
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 9:
                            bookFunctions.booksAfter2007(DateBookHolder.getInstance().listOfBooks);
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 10:
                            categorieFunction.showAllCategorie();
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 11:
                            authorFunction.showAuthors();
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 12:
                            categorieFunction.removeCategorie();
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 13:
                            printStrategy = new PrintFormatTitleYearIsbn();
                            System.out.println("Wybrano format: tytuł, rok, ISBN");
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 14:
                            printStrategy = new PrintFormatYearTitleIsbn();
                            System.out.println("Wybrano format: rok, tytuł, ISBN");
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 15:
                            printStrategy = new PrintFormatIsbnRokTitle();
                            System.out.println("Wybrano format: ISBN, rok, tytuł");
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 16:
                            authorFunction.findBookForAuthorName();
                            start.startMenu();
                            choice = scanner.nextInt();
                            break;
                        case 17:

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
