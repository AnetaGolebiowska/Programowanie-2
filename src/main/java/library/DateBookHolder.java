package library;

import java.util.ArrayList;
import java.util.List;

public class DateBookHolder {

    private static DateBookHolder uniqInstance = new DateBookHolder();
    public List<Book> listOfBooks = new ArrayList<Book>();
    public List<Authors> listOfAuthors = new ArrayList<Authors>();
    public List<Categorie> listOfCategorie = new ArrayList<Categorie>();

    private DateBookHolder() {
    }

    public static DateBookHolder getInstance() {
        return uniqInstance;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public List<Authors> getListOfAuthors() {
        return listOfAuthors;
    }

    public void setListOfAuthors(List<Authors> listOfAuthors) {
        this.listOfAuthors = listOfAuthors;
    }

    public List<Categorie> getListOfCategorie() {
        return listOfCategorie;
    }

    public void setListOfCategorie(List<Categorie> listOfCategorie) {
        this.listOfCategorie = listOfCategorie;
    }
}
