package library;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private int isbnNumber;
    private int year;
//    List <> authors = new ArrayList<>();

    public Book(String title, int isbnNumner, int year) {
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(int isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book - " +
                "title:" + title + '\'' +
                ", isbnNumner:" + isbnNumber +
                ", year:" + year +
                '.';
    }
}
