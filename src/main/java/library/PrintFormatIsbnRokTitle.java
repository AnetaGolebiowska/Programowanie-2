package library;

import java.util.List;

public class PrintFormatIsbnRokTitle implements FormatFunction {
    @Override
    public void printBook(List<Book> bookList) {
                    for (Book book : bookList){
                System.out.println(book.getIsbnNumber() + "  " + book.getYear() + " " + book.getTitle());
            }
        }
    }

