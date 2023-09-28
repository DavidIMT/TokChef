package model.acteurs;

public class Padawan extends Personne{
    private int idChef;
    private static int COMPTEUR_ID = 0;

    public Padawan(String nom, String prenom, Genre genre, String telephone, int idChef) {
        super(COMPTEUR_ID++, nom, prenom, genre, telephone);
        this.idChef = idChef;
    }

    public int getIdChef() {
        return idChef;
    }

    public void setIdChef(int idChef) {
        this.idChef = idChef;
    }

    @Override
    public String toString() {
        return this.getPrenom() + " " + this.getNom();
    }
}
