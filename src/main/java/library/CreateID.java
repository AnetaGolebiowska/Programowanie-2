package library;

import java.util.Comparator;

public class CreateID {

    public static Integer createAuthorId() {
        Authors authorsNewId = DateBookHolder.getInstance().listOfAuthors
                .stream()
                .max(Comparator.comparing(Authors::getAuthorID))
                .orElseThrow(() -> new IllegalArgumentException("Nie można utworzyć nowego ID"));
        return authorsNewId.getAuthorID() + 1;
    }

    public static Integer createCategorieId() {
        Categorie categorieNewId = DateBookHolder.getInstance().listOfCategorie
                .stream()
                .max(Comparator.comparing(Categorie::getCategorieID))
                .orElseThrow(() -> new IllegalArgumentException("Nie można utworzyć nowego ID"));
        return categorieNewId.getCategorieID() + 1;
    }

    public static Integer cerateBookId() {
        Book bookNewId = DateBookHolder.getInstance().listOfBooks
                .stream()
                .max(Comparator.comparing(Book::getBookId))
                .orElseThrow(() -> new IllegalArgumentException("Nie można utworzyć nowego ID"));
        return bookNewId.getBookId() + 1;
    }
}
