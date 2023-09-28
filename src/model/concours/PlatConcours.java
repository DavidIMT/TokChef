package model.concours;

import model.cuisine.Plat;

public class PlatConcours {
    private Plat plat;
    private int note;
    private int idChef;

    public PlatConcours(Plat plat, int note, int idChef) {
        this.plat = plat;
        this.note = note;
        this.idChef = idChef;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getIdChef() {
        return idChef;
    }

    public void setIdChef(int idChef) {
        this.idChef = idChef;
    }

    @Override
    public String toString() {
        return "PlatConcours{" +
                "plat=" + plat +
                ", note=" + note +
                ", idChef=" + idChef +
                '}';
    }
}
