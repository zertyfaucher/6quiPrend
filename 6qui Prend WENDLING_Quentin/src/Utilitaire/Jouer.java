package Utilitaire;

import java.util.Scanner;

public class Jouer {
    public static boolean isStringInteger(String stringToCheck) {
        Scanner sc = new Scanner(stringToCheck.trim());
        if(!sc.hasNextInt()) return false;
        sc.nextInt();
        return !sc.hasNext();
    }
}