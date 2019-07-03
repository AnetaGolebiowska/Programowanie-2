package library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SaveBookTest {

    List<Authors> testAuthorList = new ArrayList<>();
    Authors authors1 = new Authors(1, "Abraham Lincoln", 88);
    Authors authors2 = new Authors(2, "Og Mandino", 54);

    List<Categorie> testCategorie = new ArrayList<>();
    Categorie categorie1 = new Categorie(22, "fun", 1);
    Categorie categorie2 = new Categorie(23, "drama", 2);

    List<Authors> authorsForFirstBook = new ArrayList<>();
    List<Authors> authorsForSecondBook = new ArrayList<>();

    List<Book> testBook = new ArrayList<>();
    Book book1 = new Book(100, "Be happy", 8825, 1898, Cover.M,
            authorsForFirstBook, categorie1);
    Book book2 = new Book(101, "Llama drama", 2588, 2011, Cover.T,
            authorsForSecondBook, categorie2);

    @Before
    public void addToTest() {
        testAuthorList.add(authors1);
        testAuthorList.add(authors1);

        testCategorie.add(categorie1);
        testCategorie.add(categorie2);

        testBook.add(book1);
        testBook.add(book2);

        authorsForFirstBook.add(authors1);
        authorsForSecondBook.add(authors2);

    }
    @Test
    public void saveBookToFileTest(){
        SaveBook.saveAsCsv(testBook, "src/test/java/booksTest.csv");
        Assert.assertEquals(testBook, BookLoader.loadBook("src/test/java/library/authorsTest.csv",
                "src/test/java/library/authorsTest.csv",
                "src/test/java/library/categoriesTest.csv"));
    }
}
