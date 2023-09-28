package model.cuisine.ingredients;

public class Legume extends Ingredient{
    private int tauxFibre; //représente un pourcentage de graisse

    public Legume(String nom, int poids, boolean bio, int calories, int tauxFibre) {
        super(nom, poids, bio, calories);
        this.tauxFibre = tauxFibre;
    }

    public int getTauxFibre() {
        return tauxFibre;
    }

    public void setTauxFibre(int tauxFibre) {
        this.tauxFibre = tauxFibre;
    }

    public int getGrammageFibre() {
        return tauxFibre * getPoids() / 100;
    }

    @Override
    public void cuit() {
        System.out.println("Mon légume " + this.getNom() + " cuit.");
    }

    @Override
    public void decoupe() {
        System.out.println("Je découpe mon légume " + this.getNom());
    }

    @Override
    public void grille() {
        System.out.println("Je mets mon légume " + this.getNom() + " sur la plancha");
    }
    @Override
    public void lave() {
        System.out.println("Je lave mon légume " + this.getNom());
    }

    @Override
    public String toString() {
        return super.toString() + ", Legume{" +
                "tauxFibre=" + tauxFibre +
                '}';
    }
}
