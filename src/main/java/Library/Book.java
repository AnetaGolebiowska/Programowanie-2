package Library;

public class Book {
    private String title;
    private int isbnNumner;
    private int year;

    public Book(String title, int isbnNumner, int year) {
        this.title = title;
        this.isbnNumner = isbnNumner;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbnNumner() {
        return isbnNumner;
    }

    public void setIsbnNumner(int isbnNumner) {
        this.isbnNumner = isbnNumner;
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
                ", isbnNumner:" + isbnNumner +
                ", year:" + year +
                '.';
    }
}
