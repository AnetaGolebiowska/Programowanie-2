package library;

import java.util.Scanner;

public class Start {

    public void startMenu() {
        System.out.println("Wybierz opcję: " +
                "\n 1. Lista książek " +
                "\n 2. Wyjdź " +
                "\n 3. Dodaj książkę " +
                "\n 4. Usuń książkę " +
                "\n 5. Edycja roku wydania książki " +
                "\n 6. Zapisz listę książek w csv" +
                "\n 7. Sortowanie po roku wydania rosnąco" +
                "\n 8. Sortowanie po roku wydania malejąco" +
                "\n 9. Wyświetl książki wydane po 2007 roku" +
                "\n 10. Wyświetl wszystkie kategorie" +
                "\n 11. Wyświetl wszystkich autorów" +
                "\n 12. Usunięcie kategorii po identyfikatorze" +
                "\n 16. Wyświetl wszystkie książki autora." +
                "\n 17. Zapisz listę kategorii do pliku." +
                "\n 18. Zapisz stan.");
    }

    public void formatPrintBook() {
        System.out.println("Wybierz opcję wyświetlania: " +
                "\n 13. tytuł, rok, ISBN" +
                "\n 14. rok, tytuł, ISBN" +
                "\n 15. ISBN, rok, tytuł");
    }
}
