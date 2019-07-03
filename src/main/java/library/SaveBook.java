package library;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SaveBook {

    public static void saveAsCsv(List<Book> listOfBooks, String path) {
        List<String> listOfBoksToSave = new ArrayList<>();

        listOfBoksToSave = DateBookHolder.getInstance().listOfBooks.stream()
                .map(book -> (book.getTitle() + ";" + book.getIsbnNumber() + ";" + book.getYear()))
                .collect(Collectors.toList());
        String writeToFive = String.join("\n", listOfBoksToSave);
        String csvFile = "src/Main/resources/newBooks.csv";

        try {
            FileWriter writer = new FileWriter(csvFile);
            writer.append(writeToFive);
            writer.flush();
            writer.close();

        } catch (
                IOException e) {
            System.out.println("Nie udało się zapisać pliku.");

        }
    }

}
