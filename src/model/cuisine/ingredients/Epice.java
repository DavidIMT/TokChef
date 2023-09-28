package model.cuisine.ingredients;

public class Epice extends Ingredient{
    private TypeEpice type;

    public Epice( String nom, int poids, boolean bio, TypeEpice type) {
        super(nom, poids, bio, 0);
        this.type = type;
    }

    public TypeEpice getType() {
        return type;
    }

    public void setType(TypeEpice type) {
        this.type = type;
    }

    @Override
    public void cuit() {
        System.out.println("une épice ne se faire pas cuire");
    }

    @Override
    public void decoupe() {
        System.out.println("une épice est déjà découpée");
    }

    @Override
    public void grille() {
        System.out.println("une épice ne se grille pas");
    }

    @Override
    public void lave() {
        System.out.println("Je lave mon " + this.getNom() + "... il ne va pas perdre en gout?? ");
    }

    @Override
    public String toString() {
        return super.toString() + ", Epice{" +
                "type=" + type +
                '}';
    }
}
