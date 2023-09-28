import model.acteurs.*;
import model.concours.Concours;
import model.cuisine.*;
import model.utils.PlatUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Plat platPouletCurry = PlatUtils.createPouletCurry();
        Plat platSaumonPapillote = PlatUtils.createSaumonEnPapillote();
        Plat platSteackPates = PlatUtils.createSteackPateKetchup();
        Plat sushis = PlatUtils.createSushis();
        Plat pizza = PlatUtils.createPizza();

        Chef chef1 = new Chef( "Dupont", "Davi", Genre.MR, "0606060606", 0, "généraliste", List.of(platPouletCurry), TypeBouffe.FAT);
        Chef chef2 = new Chef( "Bob", "Bob", Genre.MME, "0606060606", 0, "généraliste", List.of(platSaumonPapillote), TypeBouffe.SAIN);
        Chef chef3 = new Chef("John", "John", Genre.AUTRE, "0606060606", 0, "foodDeLaStreet", List.of(platSteackPates), TypeBouffe.RANDOM);
        Chef chef4 = new Chef("marty", "marty", Genre.AUTRE, "0606060606", 0, "foodDeLaStreet", List.of(sushis), TypeBouffe.RANDOM);
        Chef chef5 = new Chef("billy", "billy", Genre.AUTRE, "0606060606", 0, "foodDeLaStreet", List.of(pizza), TypeBouffe.RANDOM);

        List<Chef> chefs = new ArrayList<>();
        chefs.add(chef1);
        chefs.add(chef2);
        chefs.add(chef3);
        chefs.add(chef4);
        chefs.add(chef5);

        Jury jury1 = new Jury("michel", "michel", Genre.MR, "0606060606", 0, TypeBouffe.FAT);
        Jury jury2 = new Jury("ginette", "ginette", Genre.MME, "0606060606", 0, TypeBouffe.SAIN);
        Jury jury3 = new Jury("jean", "jean", Genre.AUTRE, "0606060606", 0, TypeBouffe.RANDOM);
        List<Jury> jures = new ArrayList<>();
        jures.add(jury1);
        jures.add(jury2);
        jures.add(jury3);

        Padawan p1 = new Padawan("anakin", "skywalker", Genre.MR, "0606060606", 0);
        Padawan p2 = new Padawan("sarah", "conor", Genre.MME, "0606060606", 2);
        Padawan p3 = new Padawan("bilbon", "saké", Genre.AUTRE, "0606060606", 0);
        List<Padawan> padawans = new ArrayList<>();
        padawans.add(p1);
        padawans.add(p2);
        padawans.add(p3);
        //maj des chefs pour prendre en compte les padawans
        for(Padawan p : padawans){
            Chef chefToUpdate = chefs.stream().filter(data -> data.getId() == p.getIdChef()).findFirst().orElse(null);
            if(chefToUpdate != null){
                chefToUpdate.getIdPadawans().add(p.getId());
            }
        }

        Scanner sc = new Scanner(System.in);
        print("Bienvenue dans TokChef, voici le menu principal, tapez un des chiffres suivant pour déclencher l'action associée");
        while (true){
            print("1 - Lancer le concours");
            print("2 - afficher les chefs");
            print("3 - afficher les jurés");
            print("4 - afficher les padawans");
            print("9 - quitter le programme");
            int choix = sc.nextInt();
            switch (choix) {
                case 1 -> {
                    Concours concours = new Concours(false, jures,chefs, LocalDate.now());
                    int idChefGagnant = concours.executionConcours();
                    if( idChefGagnant != -1){
                        concours.finDeConcours(idChefGagnant, chefs, padawans, jures);
                    }
                }
                case 2 -> {
                    for(Chef c : chefs){
                        print(c.toString());
                    }
                }
                case 3 -> {
                    for(Jury j : jures){
                        print(j.toString());
                    }
                }
                case 4 -> {
                    for(Padawan p : padawans){
                        print(p.toString());
                    }
                }
                case 9 -> System.exit(0);
                default -> print("Commande inconnue, recommencez");
            }

        }
    }

    public static void print(String message){
        System.out.println(message);
    }
}