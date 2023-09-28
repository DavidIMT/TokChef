package model.acteurs;

import java.util.function.Function;

// En vrai pas besoin de tous les arguments, c'est un exemple que j'ai donné en cours
// Je le laisse pour que vous vous en inspirez
public enum Genre {
    MR(1, "Monsieur", (data) -> "Je suis un homme et je dis "+data),
    MME(1, "Madame", (data) -> "Je suis une femme et je dis "+data),
    AUTRE(1, "Autre",  (data) -> "Je suis non binaire et je dis "+data);


    private int code;
    private String libelle;
    private Function<String, String> function;

    Genre(int code, String libelle, Function<String, String> function) {
        this.code = code;
        this.libelle = libelle;
        this.function = function;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Function<String, String> getFunction() {
        return function;
    }

    public void setFunction(Function<String, String> function) {
        this.function = function;
    }

}
