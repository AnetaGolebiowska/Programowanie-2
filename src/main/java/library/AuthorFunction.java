package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AuthorFunction {

    List<Book> booksOfTheSameAutor = new ArrayList<>();

    public void showAuthors() {
        DateBookHolder.getInstance().listOfAuthors.forEach(System.out::println);
    }

    public static void addAuthors(String authorName, int authorAge) {
        if (DateBookHolder.getInstance().listOfAuthors.stream()
                .noneMatch(authors -> authors.getAuthorName()
                        .equalsIgnoreCase(authorName)
                        && authors.getAge()
                        == authorAge)) {
            DateBookHolder.getInstance().listOfAuthors.add(new Authors(CreateID.createAuthorId(), authorName, authorAge));
        }
    }

    public static List<Authors> backListOfAuthors(String authorName, int authorAge) {
        return DateBookHolder.getInstance().listOfAuthors
                .stream()
                .filter(authors -> authors.getAuthorName().equalsIgnoreCase(authorName))
                .filter(authors -> authors.getAge() == authorAge)
                .collect(Collectors.toList());
    }

    public List<Book> authorOfBooks(String authorName) {
    for (Book bookTemp : DateBookHolder.getInstance().listOfBooks){
        for (Authors authorsTemp : bookTemp.getListAuthors()){
            if (DateBookHolder.getInstance().listOfAuthors.equals(authorName)){
                booksOfTheSameAutor.add(bookTemp);
            }
        }
    }
    return booksOfTheSameAutor;
    }

    public void findBookForAuthorName (){
        System.out.println("Podaj inię i nazwisko autora.");
        Scanner scanner = new Scanner(System.in);
        String authorName = scanner.nextLine();
        if (!authorOfBooks(authorName).isEmpty()){
            authorOfBooks(authorName).forEach(System.out::println);
        }else {
            System.out.println("Nie znaleziono żadnej książki.");
        }
    }
}
