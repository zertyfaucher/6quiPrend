package TestJeu;

import java.util.ArrayList;

public class carte {

    private int numCarte;
    private int valeurCarte;

    static ArrayList<carte> cartesListe = new ArrayList<>();

    public carte(int numCarte, int valeurCarte){
        this.numCarte = numCarte;
        boolean tmpAucunChangement = false;
        this.valeurCarte = 0;
        if (numCarte % 5 == 0) { // si c'est divisible par 5 ajoute a la valeur temporaire 2
            this.valeurCarte = this.valeurCarte + 2;
            tmpAucunChangement = true;
        }
        if (numCarte % 10 == 0) { // si c'est divisible par 10 remplace sa valeur temporaire par 3
            this.valeurCarte = 3;
        }
        if (numCarte % 11 == 0) { //si c'est divisible par 11 ajoute a la valeur temporaire 5
            this.valeurCarte = this.valeurCarte + 5;
            tmpAucunChangement = true;
        }
        if (!tmpAucunChangement) // si aucune des instructions au dessus n'est realise remplace la valeur temporaire par 1
            this.valeurCarte = 1;
    }

    public static void addCarte(int numCarte, int valeurCarte){
        cartesListe.add(new carte(numCarte, valeurCarte));
    }

    public int getNCarte(){
        return numCarte;
    }
    public int getVCarte(){
        return valeurCarte;
    }

}
