package model.acteurs;

import model.concours.Concours;
import model.concours.PlatConcours;
import model.cuisine.Plat;
import model.cuisine.ingredients.Ingredient;

import java.util.*;

public class Chef extends Personne implements IConcours{
    private static int COMPTEUR_ID = 0;
    private int nbEtoiles;
    private String specialite;
    private List<Plat> plats;
    private List<Integer> idPadawans;
    private TypeBouffe typeBouffePreferee;

    public Chef(String nom, String prenom, Genre genre, String telephone, int nbEtoiles,
                String specialite, List<Plat> plats, TypeBouffe typeBouffePreferee) {
        super(COMPTEUR_ID ++, nom, prenom, genre, telephone);
        this.nbEtoiles = nbEtoiles;
        this.specialite = specialite;
        this.plats = plats;
        this.idPadawans = new ArrayList<>();
        this.typeBouffePreferee = typeBouffePreferee;
    }

    public int getNbEtoiles() {
        return nbEtoiles;
    }

    public void setNbEtoiles(int nbEtoiles) {
        this.nbEtoiles = nbEtoiles;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<Plat> getPlats() {
        return plats;
    }

    public void setPlats(List<Plat> plats) {
        this.plats = plats;
    }

    public List<Integer> getIdPadawans() {
        return idPadawans;
    }

    public void setIdPadawans(List<Integer> idPadawans) {
        this.idPadawans = idPadawans;
    }

    public TypeBouffe getTypeBouffePreferee() {
        return typeBouffePreferee;
    }

    public void setTypeBouffePreferee(TypeBouffe typeBouffePreferee) {
        this.typeBouffePreferee = typeBouffePreferee;
    }

    public Plat choisisPlatAleatoire() {
        if(this.plats.isEmpty()){
            System.out.println("le Chef ne connait aucun plat.. le naze..");
            return null;
        }
        return this.plats.get(new Random().nextInt(this.plats.size()));
    }

    public Plat choisisPlatMoinsCalorique() {
        Optional<Plat> plat = this.plats.stream().min(Comparator.comparingInt(Plat::getCalories));
        if(plat.isPresent()){
            return plat.get();
        }
        System.out.println("le Chef ne connait aucun plat.. le naze..");
        return null;
    }

    public Plat choisisPlatPlusCaloriquePourLesGourmands() {
        Optional<Plat> plat = this.plats.stream().max(Comparator.comparingInt(Plat::getCalories));
        if(plat.isPresent()){
            return plat.get();
        }
        System.out.println("le Chef ne connait aucun plat.. le naze..");
        return null;
    }

    @Override
    public void actionConcours(Concours c) {
        Plat platChoisiConcours = null;
        switch (this.typeBouffePreferee){
            case RANDOM -> platChoisiConcours = this.choisisPlatAleatoire();
            case SAIN -> platChoisiConcours = this.choisisPlatMoinsCalorique();
            case FAT -> platChoisiConcours = this.choisisPlatPlusCaloriquePourLesGourmands();
        }
        if(platChoisiConcours != null){
            System.out.println("Le plat choisis par le chef " + this.getNom() + " " + this.getPrenom() + " est : " + platChoisiConcours.getNom());
            System.out.println("Préparation de ce plat \n==========================" );
            platChoisiConcours.preparePlat();
            System.out.println("==========================" );
        }

        c.getPlatsPresentes().add(new PlatConcours(platChoisiConcours, -1, super.getId())); // le -1 signifie que le plat n'a pas encore été noté
    }

    @Override
    public String toString() {
        return this.getPrenom() + " " + this.getNom();
    }
}
