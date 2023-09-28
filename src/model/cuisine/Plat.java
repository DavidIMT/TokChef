package model.cuisine;

import model.cuisine.ingredients.Epice;
import model.cuisine.ingredients.Ingredient;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class Plat {

    private String nom;
    private int id;
    private List<Ingredient> ingredients;

    private Queue<Instruction> instructions = new LinkedList<>(); // ici on utilise Queue pour avoir un ordre précis d'instructions

    public Plat(String nom, int id, List<Ingredient> ingredients, Queue<Instruction> instructions) {
        this.nom = nom;
        this.id = id;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void preparePlat(){
        for (Instruction instruction : instructions){
            Optional<Ingredient> optionalIngredient = this.ingredients.stream().filter((data) -> data.equals(instruction.getIngredient())).findFirst();
            if(optionalIngredient.isPresent()) {
                Ingredient ingredient = optionalIngredient.get();
                try {
                    prepareIngredients(instruction, ingredient);
                } catch(Exception e){
                    System.out.println("Je ne connais pas l'action de l'instruction ¯\\_(ツ)_/¯, recommencez");
                    return;
                }
            } else {
                System.out.println("Il manque l'ingrédient "+ instruction.getIngredient().getNom() +" pour réaliser ce plat, recommencez.");
                return;
            }
        }
        System.out.println("Mon plat " + this.nom + " est prêt à être dégusté, j'ai la dalle!");
    }

    private void prepareIngredients(Instruction instruction, Ingredient ingredient) throws Exception {

        switch (instruction.getActionCuisine()) {
            case CUIRE -> {
                ingredient.cuit();
                break;
            }
            case LAVER -> {
                ingredient.lave();
                break;
            }
            case DECOUPER -> {
                ingredient.decoupe();
                break;
            }
            case GRILLE -> {
                ingredient.grille();
                break;
            }
            case MELANGER -> {
                ingredient.melange(instruction.getIngredientAjoute());
            }
            default -> {
                throw new Exception("Action inconnue dans la recette");
            }
        }
    }

    private Optional<Epice> chercheEpiceDansIngredient() {
        return Optional.of((Epice) this.ingredients.stream().filter(data -> (data instanceof Epice)).findFirst().get());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Queue<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(Queue<Instruction> instructions) {
        this.instructions = instructions;
    }

    public int getCalories(){
        int calories = 0;
        for(Ingredient i : this.getIngredients()){
            calories+= i.getCalories();
        }
        return calories;
    }

    @Override
    public String toString() {
        return "Plat{" +
                "nom='" + nom + '\'' +
                ", id=" + id +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }
}
