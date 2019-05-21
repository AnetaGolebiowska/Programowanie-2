package library;

public class Categorie {

    private int categorieID;
    private String categorieName;
    private int priorytate;

    public Categorie(int categorieID, String categorieName, int priorytate) {
        this.categorieID = categorieID;
        this.categorieName = categorieName;
        this.priorytate = priorytate;
    }

    public int getCategorieID() {
        return categorieID;
    }

    public void setCategorieID(int categorieID) {
        this.categorieID = categorieID;
    }

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
    }

    public int getPriorytate() {
        return priorytate;
    }

    public void setPriorytate(int priorytate) {
        this.priorytate = priorytate;
    }
}
