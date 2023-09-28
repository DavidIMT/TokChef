package model.cuisine;

import model.cuisine.ingredients.Ingredient;

import java.util.Objects;

public class Instruction {
    private ActionCuisine actionCuisine;
    private Ingredient ingredient;
    private Ingredient ingredientAjoute;

    public Instruction(ActionCuisine actionCuisine, Ingredient ingredient, Ingredient ingredientAjoute) {
        this.actionCuisine = actionCuisine;
        this.ingredient = ingredient;
        this.ingredientAjoute = ingredientAjoute;
    }

    public ActionCuisine getActionCuisine() {
        return actionCuisine;
    }

    public void setActionCuisine(ActionCuisine actionCuisine) {
        this.actionCuisine = actionCuisine;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Ingredient getIngredientAjoute() {
        return ingredientAjoute;
    }

    public void setIngredientAjoute(Ingredient ingredientAjoute) {
        this.ingredientAjoute = ingredientAjoute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return actionCuisine == that.actionCuisine && Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionCuisine, ingredient);
    }
}
