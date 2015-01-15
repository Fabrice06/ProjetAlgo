
/**
 * @file index.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx définir les grandes lignes sujet
 *
 */

import objet.GardeManger;
import objet.Aliment;
import objet.LivreRecette;
import objet.Recette;

/**
 * Point d'entrée du programme
 */
public class Index {

	/**
	 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx donner les grandes lignes de ce qui va se passer dans ce main
	 */
	public static void main(String[] args) {
		
		// Création d'ingrédients
		Aliment nAlimentA = new Aliment(1,"l","vinaigre");
		Aliment nAlimentB = new Aliment(1,"l","miel");
		Aliment nAlimentC = new Aliment(300,"g","café");
		
			// ne marche pas (nullpointer exception): pourquoi ??
			//ListeRec nListeA = new ListeRec(nIngredientA);
			//ListeRec nListeB = new ListeRec(nIngredientB, nListeA);
			//ListeRec nListe = new ListeRec(nIngredientC, nListeB);
			//
			//Recette nRecette = new Recette("Chouquettes", "Faire chauffer les casseroles.\n Ajouter l'ail, puis assaisonner.", nListe);
			//nRecette.ajouterIngredient(new Ingredient(2,"gousse","ail"));
			//nRecette.afficher();
		
		// ça marche 
		Recette nRecetteA = new Recette("Chouquettes", "Faire chauffer les casseroles.\n Ajouter l'ail, puis assaisonner.");
			nRecetteA.ajouterIngredient(new Aliment(2,"gousse","ail"));
			nRecetteA.ajouterIngredient(nAlimentA);
			nRecetteA.ajouterIngredient(nAlimentB);
			nRecetteA.ajouterIngredient(nAlimentC);
//		nRecetteA.afficher();

		Recette nRecetteB = new Recette("Tofu à la mexicaine", "Faire pour le mieux.\n Ajouter le tofu, puis le tabasco.");
			nRecetteB.ajouterIngredient(new Aliment(200,"g","tofu"));
			nRecetteB.ajouterIngredient(new Aliment(1,"l","tabasco"));
			nRecetteB.ajouterIngredient(new Aliment(200,"g","carotte"));
			nRecetteB.ajouterIngredient(new Aliment(200,"g","tomate"));
//		nRecetteB.afficher();

		Recette nRecetteC = new Recette("Sorbet de crabe", "Faire mijoter les artichauts.\n Ajouter les crabes, puis assaisonner de soja.");
			nRecetteC.ajouterIngredient(nAlimentA);
			nRecetteC.ajouterIngredient(nAlimentB);
			nRecetteC.ajouterIngredient(nAlimentC);
//		nRecetteC.afficher();	
		
			
		LivreRecette nLivreRecette = new LivreRecette("Thermomix");
			nLivreRecette.ajouterRecette(nRecetteA);
			nLivreRecette.ajouterRecette(nRecetteB);
			nLivreRecette.ajouterRecette(nRecetteC);

		// test
//		nLivreRecette.afficher();
//		nLivreRecette.afficher("Chouquettes");
//		nLivreRecette.afficher("Sorbet de crabe");
//		nLivreRecette.afficher("zzzz");

		
		GardeManger nGardeManger = new GardeManger();
			nGardeManger.ajouterProduit(new Aliment(1000,"g","farine"));
			nGardeManger.ajouterProduit(new Aliment(2000,"g","sucre"));
			nGardeManger.ajouterProduit(new Aliment(0,"l","lait"));
			nGardeManger.ajouterProduit(new Aliment(3000,"g","beurre"));
			nGardeManger.ajouterProduit(new Aliment(2,"g","safran"));
			nGardeManger.ajouterProduit(nAlimentC);
			
			nGardeManger.ajouterProduit(new Aliment(500,"g","farine"));
		
		// test
//		nGardeManger.afficher();
		nGardeManger.afficher("farine");
//		nGardeManger.afficher("safran");
//		nGardeManger.afficher("jus de pomme");
//		nGardeManger.afficher("lait");
		
		Aliment nAlimentM= new Aliment(1,"g","safran");
		if(nGardeManger.verifierQuantiteProduit(nAlimentM)) {
			System.out.println("Assez : "+nAlimentM.toString());
		} else {
			System.out.println("Pas assez : "+nAlimentM.toString());
		}
		Aliment nAlimentN= new Aliment(2,"g","safran");
		if(nGardeManger.verifierQuantiteProduit(nAlimentN)){
			System.out.println("Assez : "+nAlimentN.toString());
		} else {
			System.out.println("Pas assez : "+nAlimentN.toString());
		}
		Aliment nAlimentO= new Aliment(3,"g","safran");
		if(nGardeManger.verifierQuantiteProduit(nAlimentO)){
			System.out.println("Assez : "+nAlimentO.toString());
		} else {
			System.out.println("Pas assez : "+nAlimentO.toString());
		}
	} // main
} // class
