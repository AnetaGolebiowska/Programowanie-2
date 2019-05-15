package Library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Methods {

    List<Book> listOfBooks = new ArrayList<Book>();
     Scanner scanner = new Scanner(System.in);


    public void printBook(){
        listOfBooks.forEach(System.out::println);
    }
    public void viewBook() {
        try (Stream<String> stream = Files.lines(Paths.get("src/Main/resources/books.csv"))) {
            listOfBooks = stream.map(s->s.split(";")).map(a->new Book(a[0],Integer.valueOf(a[1]),Integer.valueOf(a[2]))).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook() {

        System.out.println("Podaj tytuł książki: ");
        String newTitle = (scanner.nextLine());
        System.out.println("Podaj numer ISBN książki: ");
        String newInbnNumber = (scanner.nextLine());
        System.out.println("Podaj rok wydania książki: ");
        String newYear = (scanner.nextLine());
        Book book = new Book(newTitle, Integer.valueOf(newInbnNumber), Integer.valueOf(newYear));
        listOfBooks.add(book);
    }

    public void removeBook(){
        System.out.println("Podaj tytuł książki");
        String removeTitle = scanner.nextLine().toLowerCase();
        for (int i = 0; i < listOfBooks.size(); i++){
            if (listOfBooks.get(i).getTitle().toLowerCase().equals(removeTitle)){
                listOfBooks.remove(i);
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
            }
        }
    }
    public void saveAsCsv(){
        
    }
}
