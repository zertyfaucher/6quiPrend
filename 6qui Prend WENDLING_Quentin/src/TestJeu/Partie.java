package TestJeu;

import Utilitaire.Jouer;

import java.util.Collections;
import java.util.Scanner;

import static Utilitaire.Console.clearScreen;
import static Utilitaire.Console.pause;

public class Partie {
    private static final int nbrDeCarte = 104;
    private static final int nbrSeries = 4;
    private static int DistribCartes = 0;

    private static Scanner sc = new Scanner(System.in);

    public Partie(int DistribCartes){
        Partie.DistribCartes = DistribCartes;
    }

    public static void CreationCarte(){
        for(int tmpCarte = 1; tmpCarte < (nbrDeCarte + 1); tmpCarte++){
            carte.addCarte(tmpCarte,tmpCarte);
        }
        Collections.shuffle(carte.cartesListe);
    }

    public static void CreationMain() {
        for (int i = 0; i < joueur.nbPlayers(); i++) {
            MainJoueur.addCarteDansMain(i, DistribCartes);
            DistribCartes = 10 * (i + 1);
        }
    }

    public static void CreationSeries(){
        for(int i = 0; i < nbrSeries; i++){
            seriesCartes.addSerie(i, DistribCartes);
            DistribCartes++;
        }
    }

    public static void Jeu() {
        while (MainJoueur.cartesMain.get(MainJoueur.cartesMain.size() - 1).size() > 0) {
            for (int joueurActuelle = 0; joueurActuelle < joueur.nbPlayers(); joueurActuelle++) {
                System.out.println("A " + joueur.GetNomJoueur(joueurActuelle) + " de jouer.");
                pause();
                seriesCartes.affSerie();

                System.out.print("- Vos cartes : " + MainJoueur.GetNbrMainJoueur(joueurActuelle, 0));
                if (MainJoueur.GetValMainJoueur(joueurActuelle, 0) != 1)
                    System.out.print(" (" + MainJoueur.GetValMainJoueur(joueurActuelle,0) + ")");

                for (int i = 1; i < MainJoueur.cartesMain.get(joueurActuelle).size(); i++) {
                    System.out.print(", " + MainJoueur.GetNbrMainJoueur(joueurActuelle, i));
                    if (MainJoueur.GetValMainJoueur(joueurActuelle, i) != 1)
                        System.out.print(" (" + MainJoueur.GetValMainJoueur(joueurActuelle,i) + ")");
                }
                System.out.println();

                System.out.print("Saisissez votre choix : ");

                // verification si la carte existe
                String tmpjouer;
                boolean exist = false;
                int valueCard = 0;
                while (!exist) {
                    tmpjouer = sc.next();
                    while (Jouer.isStringInteger(tmpjouer) == false) { // verification si pas nombre (caractere)
                        System.out.print("Vous n'avez pas cette carte, saisissez votre choix : ");
                        tmpjouer = sc.next();
                    }
                    valueCard = Integer.parseInt(tmpjouer);
                    for (int avoir = 0; avoir < MainJoueur.cartesMain.get(joueurActuelle).size(); avoir++) {
                        if (valueCard == MainJoueur.GetNbrMainJoueur(joueurActuelle, avoir)) { // verification valeur existe
                            exist = true;
                            incrementation.addIncrementation(avoir, joueurActuelle);
                            MainJoueur.cartesMain.get(joueurActuelle).remove(avoir);
                            break;
                        }
                    }

                    if (!exist) {
                        System.out.print("Vous n'avez pas cette carte, saisissez votre choix : ");
                    }
                }
                clearScreen();
            }

            Collections.sort(incrementation.incrementationCarte);

            // incrementation des cartes
            for (int i = 0; i < joueur.nbPlayers(); i++) {
                int ValserieTmp = 0;
                int NumserieTmp = -1; // -1 en dehors des series
                boolean existS = false;
                for (int j = 0; j < nbrSeries; j++) {
                    if (seriesCartes.ListSerieCarte.get(j).get(seriesCartes.ListSerieCarte.get(j).size() - 1).getNCarte() < incrementation.GetNbrSurCarteIncrem(i)) {
                        if (seriesCartes.ListSerieCarte.get(j).get(seriesCartes.ListSerieCarte.get(j).size() - 1).getNCarte() > ValserieTmp) {
                            NumserieTmp = j;
                            ValserieTmp = seriesCartes.ListSerieCarte.get(j).get(seriesCartes.ListSerieCarte.get(j).size() - 1).getNCarte();
                            existS = true;
                        }
                    }
                }

                if (existS == true) {
                    if (seriesCartes.ListSerieCarte.get(NumserieTmp).size() == 5) { // si le joueur pose la 6eme carte
                        for (int sum = 0; sum < 5; sum++) {
                            joueur.getAjoutPointJoueur((NumserieTmp+1), sum,incrementation.GetNumJoueurIncrem(i));
                            int tmp = seriesCartes.GetValSurCarteSerie(NumserieTmp, sum);
                            incrementation.getPointIncrem(i, tmp);
                        }

                        for (int rmv = seriesCartes.ListSerieCarte.get(NumserieTmp).size() - 1; rmv > 0; rmv--) {
                            seriesCartes.ListSerieCarte.get(NumserieTmp).remove(rmv);
                        }
                        seriesCartes.ListSerieCarte.get(NumserieTmp).remove(0);
                    }
                    seriesCartes.addDansSerie(NumserieTmp, i);
                }

                else {
                    SelectCart(); // voir en bas
                    System.out.println(" et " + incrementation.GetNbrSurCarteIncrem(joueur.nbPlayers() - 1) + " (" + joueur.GetNomJoueur(incrementation.GetNumJoueurIncrem(joueur.nbPlayers() - 1)) + ")" + " vont être posées.");
                    System.out.println("Pour poser la carte " + incrementation.GetNbrSurCarteIncrem(i) + ", " + joueur.GetNomJoueur(incrementation.GetNumJoueurIncrem(0)) + " doit choisir la série qu'il va ramasser.");
                    seriesCartes.affSerie();
                    System.out.print("Saisissez votre choix : ");
                    int choix = -1; // pas valeur index d'une serie
                    String tmpChoix;

                    boolean exist = false;
                    while (!exist) {
                        tmpChoix = sc.next();
                        while (Jouer.isStringInteger(tmpChoix) == false) { // verif carac
                            System.out.print("Ce n'est pas une série valide, saisissez votre choix : ");
                            tmpChoix = sc.next();
                        }
                        choix = Integer.parseInt(tmpChoix);

                        if (choix > 0 && choix < 5) {
                                exist = true;
                        }
                        if (!exist) {
                            System.out.print("Ce n'est pas une série valide, saisissez votre choix : ");
                        }
                    }

                    for (int sum = 0; sum < seriesCartes.ListSerieCarte.get(choix - 1).size(); sum++) {
                        joueur.getAjoutPointJoueur(choix, sum, incrementation.GetNumJoueurIncrem(0));
                    }

                    for (int sum = 0; sum < seriesCartes.ListSerieCarte.get(choix - 1).size(); sum++) {
                        int tmp = seriesCartes.GetValSurCarteSerie(choix - 1, sum);
                        incrementation.getPointIncrem(0, tmp);
                    }

                    if (seriesCartes.ListSerieCarte.get(choix - 1).size() > 1) {
                        seriesCartes.ListSerieCarte.get(choix - 1).subList(1, seriesCartes.ListSerieCarte.get(choix - 1).size()).clear();
                    }
                    seriesCartes.addDansSerie(choix - 1, 0);
                    seriesCartes.ListSerieCarte.get(choix - 1).remove(0);
                }
            }

            Collections.sort(incrementation.incrementationCarte);

            SelectCart(); // voir en bas
            System.out.println(" et " + incrementation.GetNbrSurCarteIncrem(joueur.nbPlayers() - 1) + " (" + joueur.GetNomJoueur(incrementation.GetNumJoueurIncrem(joueur.nbPlayers() - 1)) + ")" + " ont été posées.");
            seriesCartes.affSerie();
            boolean ramasseOk = false;
            for (int ramasser = 0; ramasser < joueur.nbPlayers(); ramasser++) {
                if (incrementation.GetRamIncrem(ramasser) != 0) {
                    System.out.println(joueur.GetNomJoueur(incrementation.GetNumJoueurIncrem(ramasser)) + " a ramassé " + incrementation.GetRamIncrem(ramasser) + " têtes de boeufs");
                    ramasseOk = true;
                }
            }
            if (!ramasseOk) {
                System.out.println("Aucun joueur ne ramasse de tête de boeufs.");
            }
            incrementation.incrementationCarte.removeAll(incrementation.incrementationCarte);
        }
        // test point ect
        joueur.JoueurTest.sort(joueur::comparerJoueurs);
        System.out.println("** Score final");
        for (int i = 0; i < joueur.nbPlayers(); i++) {
            System.out.println(joueur.GetNomJoueur(i) + " a ramassé " + joueur.getPointJoueur(i) + " têtes de boeufs");
        }
    }

    private static void SelectCart() {
        System.out.print("Les cartes " + incrementation.GetNbrSurCarteIncrem(0) + " (" + joueur.GetNomJoueur(incrementation.GetNumJoueurIncrem(0)) + ")");
        for (int affJ = 1; affJ < (joueur.nbPlayers() - 1); affJ++) {
            System.out.print(", " + incrementation.GetNbrSurCarteIncrem(affJ) + " (" + joueur.GetNomJoueur(incrementation.GetNumJoueurIncrem(affJ)) + ")");
        }
    }
}