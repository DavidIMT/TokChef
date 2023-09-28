package model.cuisine.ingredients;

public class Poisson extends Ingredient {
    private int tauxGras; //représente un pourcentage de graisse

    public Poisson(String nom, int poids, boolean bio, int calories, int tauxGras) {
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
        System.out.println("Mon poisson " + this.getNom() + " cuit en papillote");
    }

    @Override
    public void decoupe() {
        System.out.println("Je découpe mon poisson " + this.getNom());
    }

    @Override
    public void grille() {
        System.out.println("Mon poisson " + this.getNom() + " cuit en grillade");
    }
    @Override
    public void lave() {
        System.out.println("Je lave mon poisson " + this.getNom() + " pour enlever le sel de la mer");
    }

    @Override
    public String toString() {
        return super.toString() + ", Poisson{" +
                "tauxGras=" + tauxGras +
                '}';
    }
}
