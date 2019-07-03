package library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookLoader {

    public static void fileLoadAuthors(String path) {
        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            List<Authors> authorsListLoad = stream.map(s -> s.split(";"))
                    .map(a -> new Authors(Integer.valueOf(a[0]), a[1], Integer.valueOf(a[2])))
                    .collect(Collectors.toList());
            DateBookHolder.getInstance().setListOfAuthors(authorsListLoad);

        } catch (IOException e) {
            System.out.println("Nie udało się załadować książek z pliku");
        }
    }

    public static void fileLoadCategories(String path) {
        try {
            Stream<String> stream2 = Files.lines(Paths.get(path));
            List <Categorie> categorieListLoad = stream2.map(s -> s.split(";"))
                    .map(a -> new Categorie(Integer.valueOf(a[0]), a[1], Integer.valueOf(a[2])))
                    .collect(Collectors.toList());
            DateBookHolder.getInstance().setListOfCategorie(categorieListLoad);
        } catch (IOException e) {
            System.out.println("Nie udało się załadować książek z pliku");
        }
    }

    public static void loadBook(String path, String pathAurhors, String pathCategories) {
        try {
            Stream<String> stream3 = Files.lines(Paths.get(path));
            List <Book> bookListLoad = stream3.map(s -> s.split(";"))
                    .map(a -> new Book(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2]),
                            Integer.parseInt(a[3]), Cover.valueOf(a[4]),
                            getAuthors(a[5]),
                            returnIdCtegories(Integer.parseInt(a[6]))))
                    .collect(Collectors.toList());
            DateBookHolder.getInstance().setListOfBooks(bookListLoad);
        } catch (IOException e) {
            System.out.println("Nie udało się załadować książek z pliku");
        }
    }


    private static List<Authors> getAuthors(String s) {
        return authorsIdList(Arrays.stream(s
                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public static Categorie returnIdCtegories(int id) {
        return DateBookHolder.getInstance().listOfCategorie.stream()
                .filter(cat -> cat.getCategorieID() == id)
                .findAny().orElse(null);
    }

    public static Authors findAuthor(int id) {
        return DateBookHolder.getInstance().listOfAuthors.stream()
                .filter(categorie -> categorie.getAuthorID() == id)
                .findAny().orElse(null);
    }

    public static List<Authors> authorsIdList(List<Integer> authorsID) {
        List<Authors> listAuthorsId = new ArrayList<>();
        for (int exampleAuthorId : authorsID) {
            DateBookHolder.getInstance().listOfAuthors.add(findAuthor(exampleAuthorId));
        }
        return listAuthorsId;
    }
}



