package library;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksMethoth {

    Scanner scanner = new Scanner(System.in);
    BookLoader bookLoader = new BookLoader();

    public void printBook() {
        DateBookHolder.getInstance().listOfBooks.forEach(System.out::println);
    }

    public void loadAllFiles() {
        bookLoader.fileLoadCategories(PathToCsvFile.categoriesPath);
        bookLoader.fileLoadAuthors(PathToCsvFile.authorsPath);
        bookLoader.loadBook(PathToCsvFile.booksPath, PathToCsvFile.authorsPath, PathToCsvFile.categoriesPath);
    }

    public void addBook() {
        System.out.println("Podaj tytuł książki: ");
        String newTitle = scanner.nextLine();
        System.out.println("Podaj numer ISBN książki: ");
        String newInbnNumber = scanner.nextLine();
        System.out.println("Podaj rok wydania książki: ");
        String newYear = scanner.nextLine();
        System.out.println("Podaj typ okładki twarda - T, miękka - M: ");
        String coverType = scanner.nextLine();
        CoverChechinkg.checkCoverType(coverType);
        System.out.println("Podaj imię i nazwisko autora: ");
        String newAuthorsName = scanner.nextLine();
        System.out.println("Podaj wiek autora: ");
        String newAuthorsAge = scanner.nextLine();
        NumberChecking.checkIfIsNumber(newAuthorsAge);
        AuthorFunction.addAuthors(newAuthorsName, Integer.valueOf(newAuthorsAge));
        System.out.println("Podaj kategorię książki: ");
        String newCategorie = scanner.nextLine();
        System.out.println("Podaj proprytet wyświetlania: ");
        String newPriorytate = scanner.nextLine();
        NumberChecking.checkIfIsNumber(newPriorytate);
        CategorieFunction.addCategorie(newCategorie, Integer.valueOf(newPriorytate));
        Book newBook = new Book(
                CreateID.cerateBookId(),
                newTitle,
                Integer.valueOf(newInbnNumber),
                Integer.valueOf(newYear),
                Cover.valueOf(coverType),
                AuthorFunction.backListOfAuthors(newAuthorsName, Integer.valueOf(newAuthorsAge)),
                CategorieFunction.backCategorie(newCategorie));                ;
        DateBookHolder.getInstance().listOfBooks.add(newBook);
    }

    public void removeBook() {
        System.out.println("Podaj tytuł książki");
        String removeTitle = scanner.nextLine().toLowerCase();
        for (int i = 0; i < DateBookHolder.getInstance().listOfBooks.size(); i++) {
            if (DateBookHolder.getInstance().listOfBooks.get(i).getTitle().equalsIgnoreCase(removeTitle)) {
                DateBookHolder.getInstance().listOfBooks.remove(i);
            } else {
                System.out.println("Książka o podanym tytule nie istnieje");
            }
        }
    }

    public void changeYear() {
        System.out.println("Podaj tytuł książki");
        String changeYear = scanner.nextLine().toLowerCase();
        for (int i = 0; i < DateBookHolder.getInstance().listOfBooks.size(); i++) {
            if (DateBookHolder.getInstance().listOfBooks.get(i).getTitle().toLowerCase().equals(changeYear)) {
                System.out.println("Podaj prawidłowy rok");
                int correctYear = scanner.nextInt();
                DateBookHolder.getInstance().listOfBooks.get(i).setYear(correctYear);
            } else {
                System.out.println("Książka o podanym tytule nie istnieje");
            }
        }
    }
}
