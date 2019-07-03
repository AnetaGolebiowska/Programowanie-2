package library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor

public class Book {

    private int bookId;
    private String title;
    private int isbnNumber;
    private int year;
    private Cover cover;
    private List <Authors> listAuthors;
    private Categorie categorie;


    @Override
    public String toString() {
        return
                "id=" + bookId +
                        ", title=" + title +
                        ", isbn=" + isbnNumber +
                        ", year=" + year +
                        ", cover=" + cover +
                        ", authorsList=" + listAuthors +
                        ", categories=" + categorie;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(isbnNumber, book.isbnNumber) &&
                Objects.equals(listAuthors, book.listAuthors) &&
                Objects.equals(categorie, book.categorie) &&
                cover == book.cover;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, isbnNumber, year, listAuthors, categorie, cover);
    }
}
