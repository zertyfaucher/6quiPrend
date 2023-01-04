package TestJeu;


import java.util.ArrayList;

public class joueur {

    private String NomJoueur;
    private int pointJoueur;

    private static int nbPlayers = 0;
    private static final int JOUEUR_MAX = 10;
    private static final int JOUEUR_MIN = 2;

    static ArrayList<joueur> JoueurTest = new ArrayList<>();

    public joueur(String NomJ, int pointJ){
        this.NomJoueur = NomJ;
        this.pointJoueur = pointJ;
    }
    

    public static void addJoueur(String s){
        JoueurTest.add(new joueur(s, 0));
        nbPlayers++;
    }

    public static void verifJoueur(){
        if (nbPlayers > JOUEUR_MAX) {
            System.out.println("il y a trop de joueurs !");
            System.exit(0);
        }
        if (nbPlayers < JOUEUR_MIN) {
            System.out.println("il y a pas assez de joueurs !");
            System.exit(0);
        }
    }

    public static StringBuilder affichageNom(){
        int joueurDeb = 1;
        StringBuilder sb = new StringBuilder();
        while(joueurDeb < (nbPlayers - 1)){
            sb.append(", "+ JoueurTest.get(joueurDeb).NomJoueur);
            joueurDeb++;
        }
        sb.append(" et " + JoueurTest.get(joueurDeb).NomJoueur + ". Merci de jouer à 6 qui prend !");
        return sb;
    }

    public static int nbPlayers(){
        return nbPlayers;
    }

    public static String GetNomJoueur(int i){
        return JoueurTest.get(i).NomJoueur;
    }


    public static void getAjoutPointJoueur(int choix, int sum, int idJ) {
        JoueurTest.get(idJ).pointJoueur += seriesCartes.GetValSurCarteSerie(choix - 1, sum);
    }
    public static int getPointJoueur(int i) {
        return JoueurTest.get(i).pointJoueur;
    }

    public static void affJoueur(){
        String s =  "Les " + nbPlayers + " joueurs sont " + JoueurTest.get(0).NomJoueur;
        s += affichageNom();
        System.out.println(s);
    }

    public int comparerJoueurs(joueur j){
        if(this.pointJoueur == j.pointJoueur) return this.NomJoueur.compareTo(j.NomJoueur);
        return this.pointJoueur - j.pointJoueur;
    }
}

