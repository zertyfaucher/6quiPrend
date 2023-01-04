package TestJeu;

import java.util.ArrayList;

public class seriesCartes {

    static ArrayList<ArrayList<carte>> ListSerieCarte = new ArrayList<>();

    public static void addSerie(int i, int DistribCartes) {
        ListSerieCarte.add(new ArrayList<carte>(i));
        ListSerieCarte.get(i).add(new carte(carte.cartesListe.get(DistribCartes).getNCarte(),carte.cartesListe.get(DistribCartes).getVCarte()));
    }
    public static void affSerie(){
        for(int SerieCAff = 0; SerieCAff < 4;SerieCAff++){
            System.out.print("- série n° " + (SerieCAff + 1) + " :");
            System.out.print(" " + ListSerieCarte.get(SerieCAff).get(0).getNCarte());
            if(ListSerieCarte.get(SerieCAff).get(0).getVCarte() != 1)
                System.out.print(" (" + ListSerieCarte.get(SerieCAff).get(0).getVCarte() + ")");
            for (int j = 1; j < ListSerieCarte.get(SerieCAff).size(); j++) {
                System.out.print(", " + ListSerieCarte.get(SerieCAff).get(j).getNCarte());
                if(ListSerieCarte.get(SerieCAff).get(j).getVCarte() != 1)
                    System.out.print(" (" + ListSerieCarte.get(SerieCAff).get(j).getVCarte() + ")");
            }
            System.out.println();
        }
    }
    public static void addDansSerie(int NumSerie ,int i){
        ListSerieCarte.get(NumSerie).add(new carte(incrementation.GetNbrSurCarteIncrem(i), incrementation.GetValSurCarteIncrem(i)));
    }

    public static int GetValSurCarteSerie (int Serie, int i){
        return ListSerieCarte.get(Serie).get(i).getVCarte();
    }
}