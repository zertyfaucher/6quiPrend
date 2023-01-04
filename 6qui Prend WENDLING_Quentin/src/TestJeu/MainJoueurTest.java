package TestJeu;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

public class MainJoueurTest {

	@Test
	public void testCarteMainJoueur() {
		for(int a = 0; a < 104 ; a++) {
			carte.addCarte(a, 0);
		}
		Collections.shuffle(carte.cartesListe);
		int nb = 0;
		for(int joueur = 0; joueur < 2;joueur++) {
			MainJoueur.addCarteDansMain(joueur, (nb));
			nb = nb + 10;
		}
		for(int c = 0; c< 10 ; c++) {
			for(int c2 = 0;c2 < 10;c2++) {
				assertTrue(MainJoueur.GetNbrMainJoueur(0, c) != MainJoueur.GetNbrMainJoueur(1, (c2)));
			}
		}
	}
}