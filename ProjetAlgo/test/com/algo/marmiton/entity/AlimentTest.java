	
package com.algo.marmiton.entity;

import static org.junit.Assert.*;
import org.junit.Test;


	public class AlimentTest {
		Aliment nAlimentA = new Aliment(4,"oeuf");
		Aliment nAlimentB = new Aliment(1,"l","lait");
		Aliment nAlimentC = new Aliment(5,"cuillère à café","curry");			
		Aliment nAlimentD = new Aliment(2,"sachet ","sucre vanillé");
		Aliment nAlimentE = new Aliment(1," botte","radis");
		Aliment nAlimentF = new Aliment(2," botte","radis");
		Aliment nAlimentG = new Aliment(1," botte ","carotte");
		Aliment nAlimentH = new Aliment(2," botte ","carotte");
		Aliment nAlimentI = new Aliment(4,"poulet");
		Aliment nAlimentJ = new Aliment(40,"g","  poulet");
		Aliment nAlimentK = new Aliment(30,"g","beurre   ");
		Aliment nAlimentL = new Aliment(2,"noix","     beurre   ");
		Aliment nAlimentM = new Aliment(30,"cl","lait");
		Aliment nAlimentN = new Aliment(1,"kg","beurre");

		
		@Test
		public void testToString() {
			assertEquals(nAlimentA.toString(), " > 4 oeufs");
			assertEquals(nAlimentB.toString(), " > 1 l de lait");
		} // void
		
		@Test
		public void testEquals() {
			assertTrue(nAlimentA.equals("oeuf"));
		} // void

		@Test
		public void testEstContenuDans() {
			assertTrue(nAlimentG.estContenuDans(nAlimentH));
			assertTrue(nAlimentM.estContenuDans(nAlimentB));
			
			assertFalse(nAlimentH.estContenuDans(nAlimentG));
			assertFalse(nAlimentB.estContenuDans(nAlimentM));
		} // void

		@Test
		public void testRegexFind() {
//			assertTrue(nAlimentA.regexFind("^[aehiouy].*", "oeuf"));
//			
//			assertFalse(nAlimentA.regexFind("^[aehiouy].*", ""));
//			assertFalse(nAlimentA.regexFind("^[aehiouy].*", "banane"));
//			
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "kg"));	// 1000 g
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "hg"));	// 100 g
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "dag"));	// 10 g
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "g"));		// 1
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "dg"));	// 0.1 g
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "cg"));	// 0.01 g
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "mg"));	// 0.001 g
//			
//			assertFalse(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", ""));
//			assertFalse(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "kkg"));
//			assertFalse(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "xg"));
//			assertFalse(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "kgg"));
//			assertFalse(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}g$", "dadg"));
//			
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "kl"));	// 1000 l
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "hl"));	// 100 l
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "dal"));	// 10 l
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "l"));		// 1
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "dl"));	// 0.1 l
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "cl"));	// 0.01 l
//			assertTrue(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "ml"));	// 0.001 l
//			
//			assertFalse(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", ""));
//			assertFalse(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "kkl"));
//			assertFalse(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "xl"));
//			assertFalse(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "kll"));
//			assertFalse(nAlimentA.regexFind("^(k|h|da|d|c|m){0,1}l$", "dadl"));
		} // void

		@Test
		public void testConvertir() {
//			assertTrue(nAlimentA.convertir("kg") == 1000);
//			assertTrue(nAlimentA.convertir("hg") == 100);
//			assertTrue(nAlimentA.convertir("dag") == 10);
//			assertTrue(nAlimentA.convertir("g") == 1);
//			assertTrue(nAlimentA.convertir("dg") == 0.1);
//			assertTrue(nAlimentA.convertir("cg") == 0.01);
//			assertTrue(nAlimentA.convertir("mg") == 0.001);
//			
//			assertTrue(nAlimentA.convertir("kl") == 1000);
//			assertTrue(nAlimentA.convertir("hl") == 100);
//			assertTrue(nAlimentA.convertir("dal") == 10);
//			assertTrue(nAlimentA.convertir("l") == 1);
//			assertTrue(nAlimentA.convertir("dl") == 0.1);
//			assertTrue(nAlimentA.convertir("cl") == 0.01);
//			assertTrue(nAlimentA.convertir("ml") == 0.001);
		} // void
	} // class
