package library;

import java.util.List;

public class Book {

    private List<Authors> authorsList;
    private Categorie categorie;
    private String title;
    private int isbnNumber;
    private int year;

    public Book(List<Authors> authorsList, Categorie categorie, String title, int isbnNumner, int year) {
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.year = year;
        this.authorsList = authorsList;
        this.categorie = categorie;
    }

    public List<Authors> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Authors> authorsList) {
        this.authorsList = authorsList;
    }
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
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
