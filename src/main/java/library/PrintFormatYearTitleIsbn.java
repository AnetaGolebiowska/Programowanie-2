package library;

import java.util.List;

public class PrintFormatYearTitleIsbn implements FormatFunction{

    @Override
    public void printBook(List<Book> bookList) {
        for (Book book : bookList){
            System.out.println(book.getYear() + "  " + book.getTitle() + " " + book.getIsbnNumber());
        }
    }
}
