package model.cuisine.ingredients;

import java.util.Objects;

public abstract class Ingredient implements PreparationIngredient{
    private static int COMPTEUR_ID = 0;
    private int id;
    private String nom;
    private int poids; //poids en grammes, int pour arrondir
    private boolean bio;
    private int calories;

    public Ingredient(String nom, int poids, boolean bio, int calories) {
        this.id = COMPTEUR_ID;
        this.nom = nom;
        this.poids = poids;
        this.bio = bio;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public boolean isBio() {
        return bio;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id && poids == that.poids && bio == that.bio && calories == that.calories && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, poids, bio, calories);
    }

    @Override
    public void melange(Ingredient ingredient) {
        System.out.println("Je mélange mon ingrédient " + this.getNom() + " avec l'ingrédient " + ingredient.getNom());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", poids=" + poids +
                ", bio=" + bio +
                ", calories=" + calories +
                '}';
    }
}
