package library;

import java.util.List;

public class PrintFormatTitleYearIsbn implements FormatFunction{

    @Override
    public void printBook(List<Book> bookList) {
        for (Book book : bookList){
            System.out.println(book.getTitle() + "  " + book.getYear() + " " + book.getIsbnNumber());
        }
    }
}
