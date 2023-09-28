package model.concours;

import com.sun.tools.javac.Main;
import model.acteurs.Chef;
import model.acteurs.Jury;
import model.acteurs.Padawan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Concours {
    private boolean over;
    private List<Jury> jures;
    private List<Chef> chefs;
    private LocalDate date;

    private List<PlatConcours> platsPresentes;

    public Concours(boolean over, List<Jury> jures, List<Chef> chefs, LocalDate date) {
        this.over = over;
        this.jures = jures;
        this.chefs = chefs;
        this.date = date;
        this.platsPresentes = new ArrayList<>();
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public List<Jury> getJures() {
        return jures;
    }

    public void setJures(List<Jury> jures) {
        this.jures = jures;
    }

    public List<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private boolean controleDemarrageConcours(){
        if(this.over){
            System.out.println("Ce concours est déjà fini, vous avez loupé votre chance");
            return false;
        }
        if(this.jures.size() < 2){
            System.out.println("il n'y a pas assez de jurés inscris au concours");
            return false;
        }
        if(this.chefs.size()<4){
            System.out.println("il n'y a pas assez de chefs inscris au concours");
            return false;
        }
        return true;
    }

    public Concours getProchainConcours(List<Concours> concoursList) throws Exception {
        if(concoursList.isEmpty()){
            throw new Exception("Il n'y a aucun concours");
        }
        return concoursList.stream().min((c1,c2) -> {
            if(c1.getDate().equals(c2.getDate())){
                return 0;
            }
            return c1.getDate().isBefore(c2.getDate()) ? -1 : 1;
        }).get();
    }

    public List<PlatConcours> getPlatsPresentes() {
        return platsPresentes;
    }

    public void setPlatsPresentes(List<PlatConcours> platsPresentes) {
        this.platsPresentes = platsPresentes;
    }

    /**
     *
     * @return l'identifiant du chef qui a gagné
     */
    public int executionConcours(){
        if(this.controleDemarrageConcours()) {
            // les chefs font les plats qui vont être notés
            for (Chef chef: this.chefs){
                chef.actionConcours(this);
                //oui j'ai mis un cheat code :):):):):):)
                if(chef.getNom().equals("Dupont") && chef.getPrenom().equals("David")){
                    System.out.println("Cheat code enclenché .... fin du concours car le participant a soudoyé le jury");
                    return chef.getId();
                }
            }
            // une fois les plats terminés, les jurés notent
            for(Jury jury : this.jures){
                jury.actionConcours(this);
            }
            PlatConcours platGagnant = this.platsPresentes.stream().max(Comparator.comparingInt(PlatConcours::getNote)).orElse(null);
            if(platGagnant == null){
                System.out.println("Un problème est survenu, aucun plat n'a gagné");
                return -1;
            }
            return platGagnant.getIdChef();
        }
        return -1;
    }

    /**
     * Dans cette méthode, on va gérer la fin de concours
     * cad on va ajouter une étoile au chef gagnant
     * transformer son padawan en chef
     * et augmenter le nb de participation des jures à des concours
     * @param idChefGagnant l'id généré dans la méthode executionConcours
     * @param chefs la liste de l'entièreté des chefs
     * @param padawans la liste de l'entièreté des padawans
     * @param jures la liste de l'entièreté des jurés
     */
    public void finDeConcours(int idChefGagnant, List<Chef> chefs, List<Padawan> padawans, List<Jury> jures){
        //Maj du chef
        Chef chefGagnant = chefs.stream().filter(data -> data.getId() == idChefGagnant).findFirst().orElse(null);
        System.out.println("le gagnant du concours est.... " + chefGagnant);
        if(chefGagnant == null){
            System.out.println("Ce chef n'existe pas.. c'est un fantôme?? ");
            return;
        }
        chefGagnant.setNbEtoiles(chefGagnant.getNbEtoiles() + 1);
        //maj des jurés
        //on récupère tous les jurés qui ont participé au concours et on incrémente de 1 leur nombre de participation
        for(Jury j : jures){
            for(Jury j2 : this.jures){
                if(j.getId() == j2.getId()){
                    j.setNbParticipatiobnJury(j.getNbParticipationJury() + 1);
                }
            }
        }

        //Maj des padawan
        //le plus vieux est le premier qu'on a inséré dans la liste de padawn du chef
        if(chefGagnant.getIdPadawans().isEmpty()){
            System.out.println("Le chef n'avait pas de padawan");
            return;
        }
        Padawan padawanPromu = padawans.stream().filter(data -> data.getId() == chefGagnant.getIdPadawans().get(0)).findFirst().orElse(null);
        System.out.println("Le padawan promu en chef est " + padawanPromu.getNom() + " " + padawanPromu.getPrenom());
        Chef padawanToChef = new Chef(padawanPromu.getNom(),
                    padawanPromu.getPrenom(),
                    padawanPromu.getGenre(),
                    padawanPromu.getTelephone(),
                    0,
                    chefGagnant.getSpecialite(), //le padawan a appris avec le chef donc il a récupéré sa spécialité
                    chefGagnant.getPlats(), //pareil pour les plats
                    chefGagnant.getTypeBouffePreferee() // pareil il récupère son type de bouffe
                );
        chefs.add(padawanToChef);
        chefGagnant.getIdPadawans().remove(0);
        padawans.remove(padawanPromu);
        padawanPromu = null; // on met a null le padawan, le garbage collector viendra supprimer l'objet de la heap à sa prochaine exécution
    }

    @Override
    public String toString() {
        return "Concours{" +
                "over=" + over +
                ", jures=" + jures +
                ", chefs=" + chefs +
                ", date=" + date +
                ", platsPresentes=" + platsPresentes +
                '}';
    }
}
