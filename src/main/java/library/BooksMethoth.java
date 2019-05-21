package library;

import org.apache.commons.csv.CSVUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BooksMethoth {

    List<Book> listOfBooks = new ArrayList<Book>();
    Scanner scanner = new Scanner(System.in);

    public void printBook() {
        listOfBooks.forEach(System.out::println);
    }

    public void addBook() {
        System.out.println("Podaj tytuł książki: ");
        String newTitle = scanner.nextLine();
        System.out.println("Podaj numer ISBN książki: ");
        String newInbnNumber = scanner.nextLine();
        System.out.println("Podaj rok wydania książki: ");
        String newYear = scanner.nextLine();
        Book newBook = new Book(newTitle, Integer.valueOf(newInbnNumber), Integer.valueOf(newYear));
        listOfBooks.add(newBook);
    }

    public void removeBook() {
        System.out.println("Podaj tytuł książki");
        String removeTitle = scanner.nextLine().toLowerCase();
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getTitle().equalsIgnoreCase(removeTitle)) {
                listOfBooks.remove(i);
            } else {
                System.out.println("Książka o podanym tytule nie istnieje");
            }
        }
    }

    public void changeYear() {
        System.out.println("Podaj tytuł książki");
        String changeYear = scanner.nextLine().toLowerCase();
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getTitle().toLowerCase().equals(changeYear)) {
                System.out.println("Podaj prawidłowy rok");
                int correctYear = scanner.nextInt();
                listOfBooks.get(i).setYear(correctYear);
            } else {
                System.out.println("Książka o podanym tytule nie istnieje");
            }
        }
    }

    public void saveAsCsv() {
        List<String> listOfBokksToSave = new ArrayList<>();
        listOfBokksToSave = listOfBooks.stream()
                .map(book -> (book.getTitle() + ";" + book.getIsbnNumber() + ";" + book.getYear()))
                .collect(Collectors.toList());
        String writeToFive = String.join("\n", listOfBokksToSave);
        String csvFile = "src/Main/resources/newBooks.csv";
        try {
            FileWriter writer = new FileWriter(csvFile);
            writer.append(writeToFive);
            writer.flush();
            writer.close();

        } catch (
                IOException e) {
            System.out.println("Nie udało się zapisać pliku.");
        }
    }
}
