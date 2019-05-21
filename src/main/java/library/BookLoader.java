package library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookLoader {

    List<Book> listOfBooks = new ArrayList<Book>();

    public void fileLoadBook() {
        try (Stream<String> stream = Files.lines(Paths.get("src/Main/resources/books.csv"))) {
            listOfBooks = stream.map(s -> s.split(";"))
                    .map(a -> new Book(a[0], Integer.valueOf(a[1]), Integer.valueOf(a[2])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Nie udało się załadować książek z pliku");
        }
    }

//    public void fileLoadAuthors() {
//        try (Stream<String> stream = Files.lines(Paths.get("src/Main/resources/authors.csv"))) {
//            listOfAuthots = stream.map(s -> s.split(";"))
//                    .map(a -> new Authors(Integer.valueOf(a[0]), a[1], Integer.valueOf(a[2])))
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            System.out.println(("Nie udało się załadować książek z pliku"));
//        }
//    }

}
