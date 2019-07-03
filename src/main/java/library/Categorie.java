package library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Categorie {

    private int categorieID;
    private String categorieName;
    private int priorytate;



    @Override
    public String toString() {
        return "Categorie - " +
                "categorieID =" + categorieID +
                ", categorieName ='" + categorieName + '\'' +
                ", priorytate =" + priorytate +
                '.';
    }
}
