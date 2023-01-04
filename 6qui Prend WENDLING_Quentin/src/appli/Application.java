package appli;

import TestJeu.Partie;
import TestJeu.joueur;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try {
            File F = new File("config.txt");
            Scanner scanner = new Scanner(F);

            String s;
            while (scanner.hasNextLine()) {
                s = scanner.nextLine();
                joueur.addJoueur(s);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        joueur.verifJoueur();
        joueur.affJoueur();
        Partie.CreationCarte();
        Partie.CreationMain();
        Partie.CreationSeries();
        Partie.Jeu();
    }
}