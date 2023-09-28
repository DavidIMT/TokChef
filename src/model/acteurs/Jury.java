package model.acteurs;

import model.concours.Concours;
import model.concours.PlatConcours;
import model.cuisine.Plat;
import model.cuisine.ingredients.Ingredient;

import java.util.Random;

public class Jury extends Personne implements IConcours {
    private static int COMPTEUR_ID = 0;
    private int nbParticipationJury;

    private TypeBouffe typeBouffePreferee;

    public Jury(String nom, String prenom, Genre genre, String telephone, int nbParticipationJury,
                TypeBouffe typeBouffePreferee) {
        super(COMPTEUR_ID++, nom, prenom, genre, telephone);
        this.nbParticipationJury = nbParticipationJury;
        this.typeBouffePreferee = typeBouffePreferee;
    }

    public int getNbParticipationJury() {
        return nbParticipationJury;
    }

    public void setNbParticipatiobnJury(int nbParticipationJury) {
        this.nbParticipationJury = nbParticipationJury;
    }

    public int notationPlatAleatoire(Plat p){
        if(p.getIngredients().isEmpty()){
            System.out.println("euuuh y'a pas d'ingrédient dans le plat.. quel genre de chef êtes vous?");
            return 0;
        }
        return new Random().nextInt(10);
    }

    public int notationPlatBio(Plat p){
        if(p.getIngredients().isEmpty()){
            System.out.println("euuuh y'a pas d'ingrédient dans le plat.. quel genre de chef êtes vous?");
            return 0;
        }
        double compteurIngredientBio = 0;
        for(Ingredient i : p.getIngredients()){
            if(i.isBio()){
                compteurIngredientBio++;
            }
        }
        return Double.valueOf(compteurIngredientBio/p.getIngredients().size() * 10).intValue();
    }

    public int notationPlatFat(Plat p){
        if(p.getIngredients().isEmpty()){
            System.out.println("euuuh y'a pas d'ingrédient dans le plat.. quel genre de chef êtes vous?");
            return 0;
        }
        double compteurIngredientNonBio = 0;
        for(Ingredient i : p.getIngredients()){
            if(!i.isBio()){
                compteurIngredientNonBio++;
            }
        }
        return Double.valueOf(compteurIngredientNonBio/p.getIngredients().size() * 10).intValue();
    }

    public void setNbParticipationJury(int nbParticipationJury) {
        this.nbParticipationJury = nbParticipationJury;
    }

    public TypeBouffe getTypeBouffePreferee() {
        return typeBouffePreferee;
    }

    public void setTypeBouffePreferee(TypeBouffe typeBouffePreferee) {
        this.typeBouffePreferee = typeBouffePreferee;
    }

    @Override
    public void actionConcours(Concours c) {
        System.out.println("============");
        System.out.println("Le jury : " + this + " commence la notation des plats");
        for(PlatConcours pc : c.getPlatsPresentes()){
            Chef chefPlat = c.getChefs().stream().filter(data -> data.getId() == pc.getIdChef()).findFirst().orElse(null);
            Plat p = pc.getPlat();
            int note = 0;
            switch (this.typeBouffePreferee){
                case RANDOM -> note = this.notationPlatAleatoire(p);
                case SAIN -> note = this.notationPlatBio(p);
                case FAT -> note = this.notationPlatFat(p);
            }
            pc.setNote(pc.getNote() + note);
            System.out.println("Le plat " + p.getNom() + " de " + chefPlat + " a été noté : " + note);
        }

    }

    @Override
    public String toString() {
        return this.getPrenom() + " " + this.getNom();
    }
}
