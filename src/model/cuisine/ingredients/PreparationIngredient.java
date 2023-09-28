package model.cuisine.ingredients;

public interface PreparationIngredient {

    void cuit();
    void decoupe();
    void grille();
    void lave();
    void melange(Ingredient i1);
}
