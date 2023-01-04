package TestJeu;

import static org.junit.Assert.*;

import org.junit.Test;

public class carteTest {

	
	@Test
	public void testCarte() {
	for (int i = 1; i < 105;i++) {
		carte c = new carte(i, 0);
		 if(i % 11 == 0) {
			 if(i == 55) {
				 assertTrue(c.getVCarte() == 7);
			 }
			 else {
				 assertTrue(c.getVCarte() == 5);
			 }
		 }
		 if(i % 5 == 0 && i != 55) {
			 if(i % 10 == 0) {
				 assertTrue(c.getVCarte() == 3);
			 }
			 else {
				 assertTrue(c.getVCarte() == 2);
			 }
		 }
		 else if(i % 11 != 0 && i % 55 != 0 && i % 5 != 0 && i % 10 != 0) {
			 	assertTrue(c.getVCarte() == 1);
		 	}
		 assertTrue(c.getNCarte() == i);
		}
	}
}

