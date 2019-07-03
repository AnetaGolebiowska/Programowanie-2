package library;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CategorieFunction {

       Scanner scanner = new Scanner(System.in);

    public void showAllCategorie() {
        DateBookHolder.getInstance().listOfCategorie.forEach(System.out::println);
    }



    public void removeCategorie() {

        System.out.println("Podaj identyfikator kategorii");
        int removeCategorie = scanner.nextInt();
        for (int i = 0; i < DateBookHolder.getInstance().listOfCategorie.size(); i++) {
            if (DateBookHolder.getInstance().listOfCategorie.get(i).getCategorieID() == removeCategorie) {
                DateBookHolder.getInstance().listOfCategorie.remove(i);
            } else {
                System.out.println("Kategoria o podanym ID nie istnieje");
            }
        }
    }
    public static void addCategorie(String categorieName, int priotytate) {
        if (DateBookHolder.getInstance().listOfCategorie.stream()
                .noneMatch(categorie -> categorie.getCategorieName()
                        .equalsIgnoreCase(categorieName)
                        && categorie.getPriorytate()
                        == priotytate)) {
            DateBookHolder.getInstance().listOfCategorie.add(new Categorie(CreateID.createCategorieId(),categorieName, priotytate));
        }
    }
    public static Categorie backCategorie (String categorieName){
        return DateBookHolder.getInstance().listOfCategorie
                .stream()
                .filter(categorie -> categorie.getCategorieName().equalsIgnoreCase(categorieName))
                .findAny()
                .orElse(null);
    }
}
