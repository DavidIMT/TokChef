package model.cuisine.ingredients;

public class AutreIngredient extends Ingredient {

    public AutreIngredient(String nom, int poids, boolean bio, int calories) {
        super(nom, poids, bio, calories);
    }

    @Override
    public int getCalories() {
        return super.getCalories() / 2; //apporte moins de calories
    }

    @Override
    public void cuit() {
        System.out.println("Je fais cuire mon " + this.getNom());
    }

    @Override
    public void decoupe() {
        System.out.println("Je découpe mon " + this.getNom() );
    }

    @Override
    public void grille() {
        System.out.println("J'assaisonne mon " + this.getNom());
    }

    @Override
    public void lave() {
        System.out.println("Je lave mon " + this.getNom());
    }

}
