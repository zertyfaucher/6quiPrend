package TestJeu;

import java.util.ArrayList;
import java.util.Collections;

public class MainJoueur{
    static ArrayList<ArrayList<carte>> cartesMain = new ArrayList<>();
    private int nbrSurCartes;

    public static void addCarteDansMain(int idJoueur, int DistribCartes){
        cartesMain.add(new ArrayList<>(idJoueur));
        for (int j = 0; j < 10; j++) {
            cartesMain.get(idJoueur).add(new carte(carte.cartesListe.get(DistribCartes).getNCarte(),carte.cartesListe.get(DistribCartes).getVCarte()));
            DistribCartes++;
        }
    }

    public static int GetNbrMainJoueur (int joueur,int indexC){
        return cartesMain.get(joueur).get(indexC).getNCarte();
    }
    public static int GetValMainJoueur (int joueur,int indexC){
        return cartesMain.get(joueur).get(indexC).getVCarte();
    }
}