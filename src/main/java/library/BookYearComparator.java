package library;

import java.util.Comparator;

public class BookYearComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
//        return Integer.compare(book1.getYear(), book2.getYear());
        if (book1.getYear() > book2.getYear()){
            return 1;
        } else if (book1.getYear() == book2.getYear()){
            return 0;
        } else {
            return -1;
        }
    }}
