package Library;

import org.apache.commons.csv.CSVUtils;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Methods {

    List<Book> listOfBooks = new ArrayList<Book>();
    Scanner scanner = new Scanner(System.in);

    public void printBook (){
        System.out.println(listOfBooks.toString());
        }

    public void viewBook() {
        try (Stream<String> stream = Files.lines(Paths.get("src/Main/resources/books.csv"))) {
            listOfBooks = stream.map(s -> s.split(";"))
                    .map(a -> new Book(a[0], Integer.valueOf(a[1]), Integer.valueOf(a[2])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook() {

        System.out.println("Podaj tytuł książki: ");
        String newTitle = scanner.nextLine();
        System.out.println("Podaj numer ISBN książki: ");
        String newInbnNumber = scanner.nextLine();
        System.out.println("Podaj rok wydania książki: ");
        String newYear = scanner.nextLine();
        Book book = new Book(newTitle, Integer.valueOf(newInbnNumber), Integer.valueOf(newYear));
        listOfBooks.add(book);
    }

    public void removeBook() {
        System.out.println("Podaj tytuł książki");
        String removeTitle = scanner.nextLine().toLowerCase();
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getTitle().toLowerCase().equals(removeTitle)) {
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
        String csvFile = "src/Main/resources/books2.csv";
        FileWriter writer = null;
        try {
            writer = new FileWriter(csvFile);
            for (Book book : listOfBooks) {
                List<String> stringListOfBook = new ArrayList<>();
                stringListOfBook.add(book.getTitle());
                stringListOfBook.add(String.valueOf(book.getIsbnNumner()));
                stringListOfBook.add(String.valueOf(book.getYear()));

                CSVUtils.parseLine(String.valueOf(stringListOfBook));

                writer.flush();
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
