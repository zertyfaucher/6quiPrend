package TestJeu;

import static org.junit.Assert.*;

import org.junit.Test;

public class joueurTest {

	
	@Test
	public void testGetNomJoueur() {
		joueur.addJoueur("alpha");
		joueur.addJoueur("beta");
		joueur.addJoueur("charlie");
        String s1 = "alpha";
        String s2 = "beta";
        String s3 = "charlie";
        assertEquals(joueur.GetNomJoueur(0), s1);
        assertEquals(joueur.GetNomJoueur(1), s2);
        assertEquals(joueur.GetNomJoueur(2), s3);
    }
	
	@Test
	public void testStringBuilder() {
		joueur.addJoueur("alpha");
		joueur.addJoueur("beta");
		joueur.addJoueur("charlie");
		
        StringBuilder s1 = new StringBuilder(", beta et charlie. Merci de jouer à 6 qui prend !");
        System.out.println(joueur.affichageNom() + s1.toString());
        assertEquals(joueur.affichageNom().toString(), s1.toString());
	}
}