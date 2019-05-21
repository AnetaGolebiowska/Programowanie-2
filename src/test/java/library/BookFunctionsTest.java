package library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BookFunctionsTest {

    BookFunctions bookFunctions = new BookFunctions();

    Book book1 = new Book("Jaś i Małgosia", 11223, 2010);
    Book book2 = new Book("Muminki", 52630, 2011);
    Book book3 = new Book("Miś Koralgol", 8852, 1979);
    Book book4 = new Book("Calineczka", 89893, 1932);
    Book book5 = new Book("Swinka Pepa", 88967, 1999);
    Book book6 = new Book("Timon i Pumba", 63521, 2001);

    List<Book> testbooks = new ArrayList<>();

    @Before
    public void addingBooksToList() {
        testbooks.add(book1);
        testbooks.add(book2);
        testbooks.add(book3);
        testbooks.add(book4);
        testbooks.add(book5);
        testbooks.add(book6);
    }

    @Test
    public void schouldShowBookByISBN() {
        Optional<Book> book = bookFunctions.findBook(testbooks, 8852);
        Assert.assertEquals("Miś Koralgol", book.get().getTitle());
    }

    @Test
    public void shouldNotShowBookByISBN() {
        Optional<Book> optionalBook = bookFunctions.findBook(testbooks, 852);
        Assert.assertFalse(optionalBook.isPresent());
    }

    @Test
    public void schouldShowBookWithISBN2() {
        Assert.assertEquals(book5.getTitle(), bookFunctions.findBook2(testbooks, 88967).getTitle());
    }

    @Test
    public void schouldShowTwoLastBook() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(4));
        testList.add(testbooks.get(5));
        Assert.assertEquals(testList, bookFunctions.twoLastBook(testbooks));
    }

    @Test
    public void schouldShowTwoLastBook2() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(4));
        testList.add(testbooks.get(5));
        Assert.assertEquals(testList, bookFunctions.twoLastBook2(testbooks));
    }

    @Test
    public void schouldShowErlierYear() {
        Assert.assertEquals(testbooks.get(3), bookFunctions.erlierBook(testbooks));
    }

    @Test
    public void schouldShowErlierYear2() {
        Assert.assertEquals(testbooks.get(3), bookFunctions.erlierBook2(testbooks));
    }

    @Test
    public void schouldShowLastElement() {
        Assert.assertEquals(testbooks.get(1), bookFunctions.lastBook(testbooks));
    }

    @Test
    public void schouldShowLastElement2() {
        Assert.assertEquals(testbooks.get(1), bookFunctions.lastBook2(testbooks));
    }

    @Test
    public void schouldShowYwarSum() {
        Assert.assertEquals(11932, bookFunctions.sumYear(testbooks));
    }

    @Test
    public void schouldShowYwarSum2() {
        Assert.assertEquals(11932, bookFunctions.sumYear2(testbooks));
    }

    @Test
    public void schouldShowBooksAfter2007() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(0));
        testList.add(testbooks.get(1));
        Assert.assertEquals(testList, bookFunctions.booksAfter2007(testbooks));
    }

    @Test
    public void schouldShowBooksAfter20072() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(0));
        testList.add(testbooks.get(1));
        Assert.assertEquals(testList, bookFunctions.booksAfter20072(testbooks));
    }

    @Test
    public void schouldShowFalse() {
        Assert.assertFalse(bookFunctions.isEveryBookAfter2000(testbooks));
    }

    @Test
    public void schouldShowFalse2() {
        Assert.assertFalse(bookFunctions.isEveryBookAfter20002(testbooks));
    }

    @Test
    public void schouldShowYwarAvarage() {
        Assert.assertEquals(1988, bookFunctions.averageYear(testbooks));
    }

    @Test
    public void schouldShowYwarAvarage2() {
        Assert.assertEquals(1988, bookFunctions.averageYear2(testbooks));
    }

    @Test
    public void schouldShowTrue() {
        Assert.assertTrue(bookFunctions.isEveryBookBeefore2003(testbooks));
    }

    @Test
    public void schouldShowTrue2() {
        Assert.assertTrue(bookFunctions.isEveryBookBefore20032(testbooks));
    }

    @Test
    public void schouldShowEmptyList() {
        Assert.assertTrue(bookFunctions.startedByC(testbooks).isEmpty());
    }

    @Test
    public void schouldShowEmptyList2() {
        Assert.assertTrue(bookFunctions.startedByC2(testbooks).isEmpty());
    }

    @Test
    public void schouldShowTitleForYear() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(0));
        testList.add(testbooks.get(3));
        Assert.assertEquals(testList, bookFunctions.bookTitle(testbooks));
    }

    @Test
    public void schouldShowTitleForYear2() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(0));
        testList.add(testbooks.get(3));
        Assert.assertEquals(testList, bookFunctions.bookTitle2(testbooks));
    }

    @Test
    public void schouldShowBooksMap() {
        Map<String, Book> mapBooks = new HashMap<>();
        mapBooks.put(String.valueOf(book1.getIsbnNumber()), book1);
        mapBooks.put(String.valueOf(book2.getIsbnNumber()), book2);
        mapBooks.put(String.valueOf(book3.getIsbnNumber()), book3);
        mapBooks.put(String.valueOf(book4.getIsbnNumber()), book4);
        mapBooks.put(String.valueOf(book5.getIsbnNumber()), book5);
        mapBooks.put(String.valueOf(book6.getIsbnNumber()), book6);
        Assert.assertEquals(mapBooks, bookFunctions.booksMap(testbooks));
    }

    @Test
    public void schouldShowBooksMap2() {
        Map<String, Book> mapBooks = new HashMap<>();
        mapBooks.put(String.valueOf(book1.getIsbnNumber()), book1);
        mapBooks.put(String.valueOf(book2.getIsbnNumber()), book2);
        mapBooks.put(String.valueOf(book3.getIsbnNumber()), book3);
        mapBooks.put(String.valueOf(book4.getIsbnNumber()), book4);
        mapBooks.put(String.valueOf(book5.getIsbnNumber()), book5);
        mapBooks.put(String.valueOf(book6.getIsbnNumber()), book6);
        Assert.assertEquals(mapBooks, bookFunctions.booksMap2(testbooks));
    }

    @Test
    public void schouldShowTheYoungest() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(1));
        testList.add(testbooks.get(0));
        testList.add(testbooks.get(5));
        testList.add(testbooks.get(4));
        testList.add(testbooks.get(2));
        testList.add(testbooks.get(3));
        Assert.assertEquals(testList, bookFunctions.startedTillYoungest(testbooks));
    }

    @Test
    public void schouldShowTheYoungest2() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(1));
        testList.add(testbooks.get(0));
        testList.add(testbooks.get(5));
        testList.add(testbooks.get(4));
        testList.add(testbooks.get(2));
        testList.add(testbooks.get(3));
        Assert.assertEquals(testList, bookFunctions.startedTillYoungest2(testbooks));
    }

    @Test
    public void schouldShowTheOldest() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(3));
        testList.add(testbooks.get(2));
        testList.add(testbooks.get(4));
        testList.add(testbooks.get(5));
        testList.add(testbooks.get(0));
        testList.add(testbooks.get(1));
        Assert.assertEquals(testList, bookFunctions.startedTillOldest(testbooks));
    }

    @Test
    public void schouldShowTheOldest2() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(3));
        testList.add(testbooks.get(2));
        testList.add(testbooks.get(4));
        testList.add(testbooks.get(5));
        testList.add(testbooks.get(0));
        testList.add(testbooks.get(1));
        Assert.assertEquals(testList, bookFunctions.startedTillOldest2(testbooks));
    }

    @Test
    public void schouldShowListOfList() {
        List<Book> testList = new ArrayList<>();
        testList.add(testbooks.get(0));
        testList.add(testbooks.get(1));
        List<Book> testList1 = new ArrayList<>();
        testList1.add(testbooks.get(2));
        testList1.add(testbooks.get(3));
        List<Book> testList2 = new ArrayList<>();
        testList2.add(testbooks.get(4));
        testList2.add(testbooks.get(5));
        List<List<Book>> finaleList = new ArrayList<>();
        finaleList.add(testList);
        finaleList.add(testList1);
        finaleList.add(testList2);
        Assert.assertEquals(finaleList, bookFunctions.listOfBookList(testbooks));
    }

    @Test
    public void schouldShowmappingYearList() {
        List<Book> testList = new ArrayList<>();
        List<Book> testList1 = new ArrayList<>();
        List<Book> testList2 = new ArrayList<>();
        List<Book> testList3 = new ArrayList<>();
        List<Book> testList4 = new ArrayList<>();
        List<Book> testList5 = new ArrayList<>();
        testList.add(testbooks.get(0));
        testList1.add(testbooks.get(1));
        testList2.add(testbooks.get(2));
        testList3.add(testbooks.get(3));
        testList4.add(testbooks.get(4));
        testList5.add(testbooks.get(5));

        Map<Integer, List<Book>> bookMap = new HashMap<>();
        bookMap.put(book1.getYear(), testList);
        bookMap.put(book2.getYear(), testList1);
        bookMap.put(book3.getYear(), testList2);
        bookMap.put(book4.getYear(), testList3);
        bookMap.put(book5.getYear(), testList4);
        bookMap.put(book6.getYear(), testList5);

        Assert.assertEquals(bookMap, bookFunctions.listOfYear(testbooks));
    }

    @Test
    public void schouldShowmappingYearList2() {
        List<Book> testList0 = new ArrayList<>();
        List<Book> testList1 = new ArrayList<>();
        List<Book> testList2 = new ArrayList<>();
        List<Book> testList3 = new ArrayList<>();
        List<Book> testList4 = new ArrayList<>();
        List<Book> testList5 = new ArrayList<>();
        testList0.add(testbooks.get(0));
        testList1.add(testbooks.get(1));
        testList2.add(testbooks.get(2));
        testList3.add(testbooks.get(3));
        testList4.add(testbooks.get(4));
        testList5.add(testbooks.get(5));

        Map<Integer, List<Book>> bookMap = new HashMap<>();
        bookMap.put(book1.getYear(), testList0);
        bookMap.put(book2.getYear(), testList1);
        bookMap.put(book3.getYear(), testList2);
        bookMap.put(book4.getYear(), testList3);
        bookMap.put(book5.getYear(), testList4);
        bookMap.put(book6.getYear(), testList5);

        Assert.assertEquals(bookMap, bookFunctions.listOfYear2(testbooks));
    }

    @Test
    public void schouldShowMapBeforeAddAfter2009() {
        List<Book> testList1 = new ArrayList<>();
        List<Book> testList2 = new ArrayList<>();
        testList2.add(testbooks.get(0));
        testList2.add(testbooks.get(1));
        testList1.add(testbooks.get(2));
        testList1.add(testbooks.get(3));
        testList1.add(testbooks.get(4));
        testList1.add(testbooks.get(5));

        Map<Boolean, List<Book>> bookMap = new HashMap<>();
        bookMap.put(true, testList2);
        bookMap.put(false, testList1);

        Assert.assertEquals(bookMap, bookFunctions.beforeAndAfrter2009(testbooks));
    }
    @Test
    public void schouldShowMapBeforeAddAfter20092() {
        List<Book> testList1 = new ArrayList<>();
        List<Book> testList2 = new ArrayList<>();
        testList2.add(testbooks.get(0));
        testList2.add(testbooks.get(1));
        testList1.add(testbooks.get(2));
        testList1.add(testbooks.get(3));
        testList1.add(testbooks.get(4));
        testList1.add(testbooks.get(5));

        Map<Boolean, List<Book>> bookMap = new HashMap<>();
        bookMap.put(false, testList1);
        bookMap.put(true, testList2);

        Assert.assertEquals(bookMap, bookFunctions.beforeAndAfrter20092(testbooks));
    }
}
