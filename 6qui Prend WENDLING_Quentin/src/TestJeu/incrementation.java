package TestJeu;


import java.util.ArrayList;

import static TestJeu.MainJoueur.*;

public class incrementation implements Comparable<incrementation> {
    static ArrayList<incrementation> incrementationCarte = new ArrayList<>();


    private int nbrSurCartes;
    private int ValeurCartes;
    private int NumJoueur;
    private int ramasser;


    public static void addIncrementation(int avoir, int joueurActuelle){
        incrementationCarte.add(new incrementation(GetNbrMainJoueur(joueurActuelle, avoir), GetValMainJoueur(joueurActuelle, avoir),joueurActuelle, 0));
    }

    public incrementation(int nbrSurCartes, int ValeurCartes, int NumJoueur,int ramasser) {
        this.nbrSurCartes = nbrSurCartes;
        this.ValeurCartes = ValeurCartes;
        this.NumJoueur = NumJoueur;
        this.ramasser = ramasser;
    }

    public static int GetNbrSurCarteIncrem (int nbr){
        return incrementationCarte.get(nbr).nbrSurCartes;
    }
    public static int GetRamIncrem (int nbr){
        return incrementationCarte.get(nbr).ramasser;
    }

    public static int GetValSurCarteIncrem (int Val){
        return incrementationCarte.get(Val).ValeurCartes;
    }

    public static int GetNumJoueurIncrem (int joueur){
        return incrementationCarte.get(joueur).NumJoueur;
    }

    public static void getPointIncrem(int i, int tmp) {
        incrementationCarte.get(i).ramasser += tmp;
    }


    @Override
    public int compareTo(incrementation o) {
        return (this.nbrSurCartes - o.nbrSurCartes);
    }
}
