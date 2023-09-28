package model.cuisine.ingredients;

public class Viande extends Ingredient {
    private int tauxGras; //représente un pourcentage de graisse

    public Viande(String nom, int poids, boolean bio, int calories, int tauxGras) {
        super(nom, poids, bio, calories);
        this.tauxGras = tauxGras;
    }

    public int getTauxGras() {
        return tauxGras;
    }

    public void setTauxGras(int tauxGras) {
        this.tauxGras = tauxGras;
    }

    public int getGrammageGraisse() {
        return tauxGras * getPoids() / 100;
    }

    @Override
    public void cuit() {
        System.out.println("Ma viande " + this.getNom() + " cuit sur le moteur d'une voiture");
    }

    @Override
    public void decoupe() {
        System.out.println("Je découpe ma viande " + this.getNom() + " en petits morceaux");
    }

    @Override
    public void grille() {
        System.out.println("Je mets ma viande " + this.getNom() + " sur les flammes du barbecue");
    }

    @Override
    public void lave() {
        System.out.println("Je lave ma viande " + this.getNom() + ", miam je m'en lèche les babines");
    }

    @Override
    public String toString() {
        return super.toString() + ", Viande{" +
                "tauxGras=" + tauxGras +
                '}';
    }
}
