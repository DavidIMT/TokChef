package model.utils;

import model.acteurs.Chef;
import model.acteurs.Genre;
import model.cuisine.*;
import model.cuisine.ingredients.*;

import java.util.*;

public class PlatUtils {
    public static Plat createPouletCurry(){
        Ingredient poulet = new Viande( "poulet", 100, true, 1000, 30);
        Ingredient curry = new Epice( "curry", 20, false, TypeEpice.CURRY);
        Ingredient cremeFraiche = new AutreIngredient( "creme fraiche", 100, false, 1000);
        Ingredient poivron = new Legume( "poivron", 100, false, 50, 60);

        Queue<Instruction> instructionsPouletCurry = new LinkedList<>();
        instructionsPouletCurry.add(new Instruction(ActionCuisine.LAVER, poulet, null));
        instructionsPouletCurry.add(new Instruction(ActionCuisine.LAVER, poivron, null));
        instructionsPouletCurry.add(new Instruction(ActionCuisine.DECOUPER, poulet, null));
        instructionsPouletCurry.add(new Instruction(ActionCuisine.CUIRE, poulet, null));
        instructionsPouletCurry.add(new Instruction(ActionCuisine.MELANGER, poulet, cremeFraiche));
        instructionsPouletCurry.add(new Instruction(ActionCuisine.MELANGER, poulet,curry));
        instructionsPouletCurry.add(new Instruction(ActionCuisine.MELANGER, poulet, poivron));


        return new Plat("Poulet Curry", 1, Arrays.asList(poulet, curry, cremeFraiche,poivron), instructionsPouletCurry);

    }

    public static Plat createSaumonEnPapillote(){
        Ingredient saumon = new Poisson( "saumon", 100, true, 1500, 60);
        Ingredient sel = new Epice( "sel", 20, true, TypeEpice.SEL);
        Ingredient patate = new AutreIngredient( "pomme de terre", 50, true, 100);
        Ingredient cremeFraiche = new AutreIngredient("creme fraiche", 100, false, 1000);

        Queue<Instruction> instructions = new LinkedList<>();
        instructions.add(new Instruction(ActionCuisine.LAVER, patate, null));
        instructions.add(new Instruction(ActionCuisine.CUIRE, patate, null));
        instructions.add(new Instruction(ActionCuisine.CUIRE, saumon, null));
        instructions.add(new Instruction(ActionCuisine.MELANGER, patate, cremeFraiche));
        instructions.add(new Instruction(ActionCuisine.MELANGER, saumon, sel));

        return new Plat("Saumon Papillote", 1, Arrays.asList(saumon, sel, cremeFraiche,patate), instructions);

    }
    public static Plat createSteackPateKetchup(){
        Ingredient steack = new Viande( "steack haché", 100, true, 1500, 60);
        Ingredient sel = new Epice( "sel", 20, true, TypeEpice.SEL);
        Ingredient poivre = new Epice("poivre", 20, true, TypeEpice.POIVRE);
        Ingredient ketchup = new AutreIngredient( "ketchuuuuuup", 30, false, 300);
        Ingredient pates = new AutreIngredient( "pates", 50, true, 100);

        Queue<Instruction> instructions = new LinkedList<>();
        instructions.add(new Instruction(ActionCuisine.CUIRE, pates, null));
        instructions.add(new Instruction(ActionCuisine.CUIRE, steack, null));
        instructions.add(new Instruction(ActionCuisine.MELANGER, pates, sel));
        instructions.add(new Instruction(ActionCuisine.MELANGER, pates, poivre));
        instructions.add(new Instruction(ActionCuisine.MELANGER, pates, ketchup));
        instructions.add(new Instruction(ActionCuisine.MELANGER, pates, steack));

        return new Plat("Steack pates Ketchup", 1, Arrays.asList(pates, sel, poivre,steack, ketchup), instructions);

    }

    public static Plat createSushis(){
        Ingredient saumon = new Poisson( "saumon", 100, true, 1500, 60);
        Ingredient avocat = new Legume("avocat", 100, true, 50, 60);
        Ingredient riz = new AutreIngredient( "riz", 50, true, 100);
        Ingredient feuilleAlgue = new AutreIngredient( "feuilles d'algue", 50, true, 100);

        Queue<Instruction> instructions = new LinkedList<>();
        instructions.add(new Instruction(ActionCuisine.CUIRE, riz, null));
        instructions.add(new Instruction(ActionCuisine.DECOUPER, saumon, null));
        instructions.add(new Instruction(ActionCuisine.DECOUPER, avocat, null));
        instructions.add(new Instruction(ActionCuisine.MELANGER, riz, saumon));
        instructions.add(new Instruction(ActionCuisine.MELANGER, riz, avocat));
        instructions.add(new Instruction(ActionCuisine.MELANGER, riz, feuilleAlgue));
        instructions.add(new Instruction(ActionCuisine.DECOUPER, feuilleAlgue, null));

        return new Plat("Y'a pas de sushis", 1, Arrays.asList(saumon, avocat, riz, feuilleAlgue), instructions);

    }

    public static Plat createPizza(){
        Ingredient jambon = new Viande( "jambon", 100, false, 1500, 60);
        Ingredient chorizo = new Viande( "chorizo", 100, false, 1500, 60);
        Ingredient tomate = new Legume("tomate", 100, false, 50, 60);
        Ingredient poivron = new Legume("poivron", 100, false, 50, 60);
        Ingredient pateAPizza = new AutreIngredient( "pate a pizza", 50, false, 100);
        Ingredient gruyere = new AutreIngredient( "gruyere", 50, false, 100);

        Queue<Instruction> instructions = new LinkedList<>();
        instructions.add(new Instruction(ActionCuisine.DECOUPER, jambon, null));
        instructions.add(new Instruction(ActionCuisine.DECOUPER, chorizo, null));
        instructions.add(new Instruction(ActionCuisine.DECOUPER, tomate, null));
        instructions.add(new Instruction(ActionCuisine.DECOUPER, poivron, null));
        instructions.add(new Instruction(ActionCuisine.DECOUPER, gruyere, null));
        instructions.add(new Instruction(ActionCuisine.MELANGER, pateAPizza, tomate));
        instructions.add(new Instruction(ActionCuisine.MELANGER, pateAPizza, jambon));
        instructions.add(new Instruction(ActionCuisine.MELANGER, pateAPizza, chorizo));
        instructions.add(new Instruction(ActionCuisine.MELANGER, pateAPizza, poivron));
        instructions.add(new Instruction(ActionCuisine.MELANGER, pateAPizza, gruyere));
        instructions.add(new Instruction(ActionCuisine.CUIRE, pateAPizza, null));

        return new Plat("Pizza Reine", 1, Arrays.asList(pateAPizza, jambon, chorizo, tomate, poivron, gruyere), instructions);

    }
}
