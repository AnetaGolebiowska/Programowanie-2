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
    List<Authors> listOfAuthors = new ArrayList<Authors>();
    List<Categorie> listOfCategories = new ArrayList<Categorie>();


    public void fileLoadBook() {
        Stream<String> stream = null;
        try {
            stream = Files.lines(Paths.get("src/Main/resources/authors.csv"));
            listOfAuthors = stream.map(s -> s.split(";"))
                    .map(a -> new Authors(Integer.valueOf(a[0]), a[1], Integer.valueOf(a[2])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Nie udało się załadować książek z pliku");
        }


        try {
            Stream<String> stream2 = Files.lines(Paths.get("src/Main/resources/categories.csv"));
            listOfCategories = stream.map(s -> s.split(";"))
                    .map(a -> new Categorie(Integer.valueOf(a[0]), a[1], Integer.valueOf(a[2])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Nie udało się załadować książek z pliku");
        }


//        Stream<String> stream3 = Files.lines(Paths.get("src/Main/resources/books.csv"));

//            listOfBooks = stream.map(s -> s.split(";"))
//                    .map(a -> new Book(a[0], Integer.valueOf(a[1]), Integer.valueOf(a[2])))
//                    .collect(Collectors.toList());
//
//            System.out.println("Nie udało się załadować książek z pliku");
//        }
    }
}


