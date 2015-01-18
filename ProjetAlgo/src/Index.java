
/**
 * @file index.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx définir les grandes lignes sujet
 *
 */

import include.ListeRec;
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
		
		// créer un garde-manger
			GardeManger nGardeManger= creerGardeManger();
	
		// créer un livre de recettes
			LivreRecette nLivreRecette= creerLivreRecette();
	
			
		// --------------------------------------------------------------------------------------- 	
		// afficher une recette dont on précise le nom et qui appartient au livre de recettes
			
			// recette présente dans le livre de cuisine
			nLivreRecette.afficher("Poulet au curry");
			
			// recette absente du livre de recettes
			nLivreRecette.afficher("Sorbet de tomate"); 	
		
			
		// --------------------------------------------------------------------------------------- 	
		// afficher le contenu du garde-manger
			
			// globalement
		  	nGardeManger.afficher(); 						
		  	
		  	// ingrédient trouvé
		  	nGardeManger.afficher("sucre vanillé"); 		
		  	System.out.println();
		  	
		  	// ingrédient non référencé
		  	nGardeManger.afficher("sel de guérande"); 	
		  	System.out.println();
		  
		  	
		// --------------------------------------------------------------------------------------- 	
		// vérifier que le garde-manger est suffisant pour un ingrédient
		  	
		  	// ingrédient trouvé en quantité suffisante
		  	nGardeManger.afficherQuantiteProduit(new Aliment(50,"g","pomme")); 	
		  	System.out.println();
	
		  	
		// ---------------------------------------------------------------------------------------  	
		// vérifier que le garde-manger est suffisant pour tout les ingrédients d'une recette
		  	String nNomRecette= "Poulet au curry";
		  	ListeRec nIngredients = nLivreRecette.retournerIngredients(nNomRecette);
				if(nIngredients == null) {
					System.out.println("La recette "+nNomRecette+" n'est pas présente dans ce livre !");
					
				} else {
					if(nIngredients.isVide()) {
						System.out.println("Il est possible de réaliser la recette "+nNomRecette
								+", car elle ne comporte pas d'ingrédient.");
						
					} else {
						if(nGardeManger.verifierIngredients(nIngredients)) {
							System.out.println("Il est possible de réaliser la recette "+nNomRecette
									+", car tous les ingrédients sont présents dans le garde-manger.");
							
						} else {
							System.out.println("Il n'est pas possible de réaliser la recette "+nNomRecette
									+", car tous les ingrédients ne sont pas présents dans le garde-manger.");
						} // else
					} // else
				} // else
				System.out.println();
				
				
		// --------------------------------------------------------------------------------------- 
		// donner la première recette possible réalisable en fonction du garde manger
				nNomRecette= "Poulet au miel";
			  	nIngredients = nLivreRecette.retournerIngredients(nNomRecette);
					if(nIngredients == null) {
						System.out.println("La recette "+nNomRecette+" n'est pas présente dans ce livre !");
						
					} else {
						if(nIngredients.isVide()) {
							System.out.println("Il est possible de réaliser la recette "+nNomRecette
									+", car elle ne comporte pas d'ingrédient.");
							
						} else {
							if(nGardeManger.verifierIngredients(nIngredients)) {
								System.out.println("Il est possible de réaliser la recette "+nNomRecette
										+", car tous les ingrédients sont présents dans le garde-manger.");
								
							} else {
								System.out.println("Il n'est pas possible de réaliser la recette "+nNomRecette
										+", car tous les ingrédients ne sont pas présents dans le garde-manger.");
								
								Recette nRecette= nGardeManger.premiereRecette(nLivreRecette.getListe());
								if(nRecette == null) {
									System.out.println("Aucune recette ne peut-être réalisée avec ce garde-manger !");
									
								} else {
									System.out.println("\nVoici la première recette qui peut-être réalisée:\n"
											+nRecette.toString());
								} // else
							} // else
						} // else
					} // else
	} // main
	
	/**
	 * @brief créer un garde-manger
	 * 
	 * @return LivreRecette une nouveau garde-manger
	 */
	private static GardeManger creerGardeManger() {

		GardeManger nGardeManger= new GardeManger();
			nGardeManger.ajouterProduit(new Aliment(300,"g","farine"));
			nGardeManger.ajouterProduit(new Aliment(300,"g","sucre"));
			nGardeManger.ajouterProduit(new Aliment(30,"g","beurre"));			
			nGardeManger.ajouterProduit(new Aliment(4,"oeuf"));
			nGardeManger.ajouterProduit(new Aliment(1,"sachet","sucre vanillé"));
			nGardeManger.ajouterProduit(new Aliment(1,"l","lait"));
			nGardeManger.ajouterProduit(new Aliment(1,"poulet"));
			nGardeManger.ajouterProduit(new Aliment(5,"cuillère à café","curry"));
			nGardeManger.ajouterProduit(new Aliment(300,"g","carotte"));
			nGardeManger.ajouterProduit(new Aliment(200,"g","courgette"));
			nGardeManger.ajouterProduit(new Aliment(100,"g","épinard"));
			nGardeManger.ajouterProduit(new Aliment(1000,"g","pomme"));
			nGardeManger.ajouterProduit(new Aliment(500,"g","sucre"));
			nGardeManger.ajouterProduit(new Aliment(300,"g","café"));
			nGardeManger.ajouterProduit(new Aliment(1,"l","vinaigre"));
			
	return nGardeManger;
	} // GardeManger
	
	/**
	 * @brief créer un livre de recettes
	 * 
	 * @return LivreRecette une nouvelle recette
	 */
	private static LivreRecette creerLivreRecette() {
		String nNom= "Thermomix";

		LivreRecette nLivreRecette= new LivreRecette(nNom);
			nLivreRecette.ajouterRecette(creerRecetteA());
			nLivreRecette.ajouterRecette(creerRecetteB());
			nLivreRecette.ajouterRecette(creerRecetteC());
			nLivreRecette.ajouterRecette(creerRecetteD());
			nLivreRecette.ajouterRecette(creerRecetteE());
			nLivreRecette.ajouterRecette(creerRecetteF());
		
	return nLivreRecette;
	} // LivreRecette

	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteA() {
		String nNom= "Pates au beurre";
		String nDescription= " Faire chauffer les casseroles.\n Faire bouillir l'eau.\n Mettre les pates, quand c'est cuit mettre le beurre.";
		
		Recette nRecette= new Recette(nNom, nDescription);
			nRecette.ajouterIngredient(new Aliment(500,"g","pate"));
			nRecette.ajouterIngredient(new Aliment(30,"g","beurre"));
		
	return nRecette;
	} // Recette

	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteB() {
		String nNom= "Gateau au yaourt";
		String nDescription= " Mettre la farine, les oeufs, le sucre et le lait suivi du sucre vanillé, puis mettre au four.";
		
		Recette nRecette= new Recette(nNom, nDescription);
			nRecette.ajouterIngredient(new Aliment(300,"g","farine"));
			nRecette.ajouterIngredient(new Aliment(300,"g","sucre"));
			nRecette.ajouterIngredient(new Aliment(1,"l","lait"));
			nRecette.ajouterIngredient(new Aliment(4,"oeuf"));
			nRecette.ajouterIngredient(new Aliment(1,"sachet","sucre vanillé"));
		
	return nRecette;
	} // Recette
	
	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteC() {
		String nNom= "Poulet au curry";
		String nDescription= " Mettre au four le poulet saupoudré de curry.";
		
		Recette nRecette= new Recette(nNom, nDescription);
			nRecette.ajouterIngredient(new Aliment(1,"poulet"));
			nRecette.ajouterIngredient(new Aliment(5,"cuillère à café","curry"));
		
	return nRecette;
	} // Recette

	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteD() {
		String nNom= "Soupe de légumes";
		String nDescription= " Mixer tout les légumes et faire cuire puis ajouter le beurre.";
		
		Recette nRecette= new Recette(nNom, nDescription);
			nRecette.ajouterIngredient(new Aliment(300,"g","carotte"));
			nRecette.ajouterIngredient(new Aliment(200,"g","courgette"));
			nRecette.ajouterIngredient(new Aliment(100,"g","épinard"));
			nRecette.ajouterIngredient(new Aliment(1,"tomate"));
			nRecette.ajouterIngredient(new Aliment(30,"g","beurre"));
		
	return nRecette;
	} // Recette

	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteE() {
		String nNom= "Compote de pommes";
		String nDescription= " Mixer toutes les pommes et faire cuire puis ajouter le sucre.";
		
		Recette nRecette= new Recette(nNom, nDescription);
			nRecette.ajouterIngredient(new Aliment(1000,"g","pomme"));
			nRecette.ajouterIngredient(new Aliment(500,"g","sucre"));
		
	return nRecette;
	} // Recette

	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteF() {
		String nNom= "Poulet au miel";
		String nDescription= " Faire cuire le poulet et arroser de miel";
		
		Recette nRecette= new Recette(nNom, nDescription);
			nRecette.ajouterIngredient(new Aliment(1,"poulet"));
			nRecette.ajouterIngredient(new Aliment(1000,"g","miel"));
		
	return nRecette;
	} // Recette

	
//	// Création d'ingrédients
//	Aliment nAlimentA = new Aliment(1,"l","vinaigre");
//	Aliment nAlimentB = new Aliment(1,"l","miel");
//	Aliment nAlimentC = new Aliment(300,"g","café");
//	
//	// ça marche 
//	Recette nRecetteA = new Recette("Chouquettes", "Faire chauffer les casseroles.\n Ajouter l'ail, puis assaisonner.");
//		nRecetteA.ajouterIngredient(new Aliment(2,"gousse","ail"));
//		nRecetteA.ajouterIngredient(nAlimentA);
//		nRecetteA.ajouterIngredient(nAlimentB);
//		nRecetteA.ajouterIngredient(nAlimentC);
////	nRecetteA.afficher();
//
//	Recette nRecetteB = new Recette("Tofu à la mexicaine", "Faire pour le mieux.\n Ajouter le tofu, puis le tabasco.");
//		nRecetteB.ajouterIngredient(new Aliment(200,"g","tofu"));
////		nRecetteB.ajouterIngredient(new Aliment(1,"l","tabasco"));
//		nRecetteB.ajouterIngredient(new Aliment(200,"g","carotte"));
//		nRecetteB.ajouterIngredient(new Aliment(200,"g","tomate"));
////	nRecetteB.afficher();
//
//	Recette nRecetteC = new Recette("rezette", "Faire rissoler le tofu.\n Ajouter les carottes, puis assaisonner de soja.");
//	nRecetteC.ajouterIngredient(new Aliment(100,"g","raisin"));	
//		nRecetteC.ajouterIngredient(new Aliment(200,"g","tofu"));
//		nRecetteC.ajouterIngredient(new Aliment(200,"g","carotte"));
////	nRecetteC.ajouterIngredient(new Aliment(900,"g","carotte"));
//		nRecetteC.ajouterIngredient(new Aliment(200,"g","tomate"));
////	nRecetteC.ajouterIngredient(new Aliment(1,"l","tabasco"));
////	nRecetteC.afficher();	
//	
//	Recette nRecetteD = new Recette("Sorbet de crabe", "Faire mijoter les artichauts.\n Ajouter les crabes, puis assaisonner de soja.");
//		nRecetteD.ajouterIngredient(nAlimentA);
//		nRecetteD.ajouterIngredient(nAlimentB);
//		nRecetteD.ajouterIngredient(nAlimentC);
////		nRecetteD.afficher();
//
////		Recette nRecetteX= creerRecetteA();
//		
//	LivreRecette nLivreRecette = new LivreRecette("Thermomix");
//		nLivreRecette.ajouterRecette(nRecetteA);
//		nLivreRecette.ajouterRecette(nRecetteB);
//		nLivreRecette.ajouterRecette(nRecetteC);
//		nLivreRecette.ajouterRecette(nRecetteD);

	// test
//livreRecette.afficher();

	  
//	  // ingrédient trouvé en quantité insuffisante
//	  nGardeManger.afficherQuantiteProduit(new Aliment(1100,"g","pomme")); 
//	  System.out.println();
//	  
//	  // ingrédient trouvé dans une unité différente
//	  nGardeManger.afficherQuantiteProduit(new Aliment(2,"botte","carotte"));  
//	  System.out.println();
//
//	  // ingrédient non référencé
//	  nGardeManger.afficherQuantiteProduit(new Aliment(1,"poignée","cerise"));  
//	  System.out.println();



	
//	// créer un livre de recettes
//	this.creerLivreRecette();
//	
//	// créer un garde manger
//	this.creerGardeManger();
//	

//  livreRecette.afficher("Chouquettes");
//  }
//  catch (NullPointerException e) {
//	  System.out.println(e);
//  }
//livreRecette.afficher("Chouquettes");
//nLivreRecette.afficher("Sorbet de crabe");
//nLivreRecette.afficher("zzzz");


//GardeManger nGardeManger = new GardeManger();
//nGardeManger.ajouterProduit(new Aliment(1000,"g","farine"));
//nGardeManger.ajouterProduit(new Aliment(2000,"g","sucre"));
//nGardeManger.ajouterProduit(new Aliment(0,"l","lait"));
//nGardeManger.ajouterProduit(new Aliment(3000,"g","beurre"));
//nGardeManger.ajouterProduit(new Aliment(2,"g","safran"));
//nGardeManger.ajouterProduit(nAlimentC);
//
//nGardeManger.ajouterProduit(new Aliment(500,"g","farine"));
//
//nGardeManger.ajouterProduit(new Aliment(600,"g","tofu"));
//nGardeManger.ajouterProduit(new Aliment(300,"g","carotte"));
//nGardeManger.ajouterProduit(new Aliment(250,"g","tomate"));

// test
//nGardeManger.afficher();
//nGardeManger.afficher("farine");
//nGardeManger.afficher("safran");
//nGardeManger.afficher("jus de pomme");
//nGardeManger.afficher("lait");


//Aliment nAlimentM= new Aliment(1,"g","safran");
//if(gardeManger.verifierQuantiteProduit(nAlimentM)) {
//System.out.println("Assez : "+nAlimentM.toString());
//} else {
//System.out.println("Pas assez : "+nAlimentM.toString());
//}
//Aliment nAlimentN= new Aliment(2,"g","safran");
//if(gardeManger.verifierQuantiteProduit(nAlimentN)){
//System.out.println("Assez : "+nAlimentN.toString());
//} else {
//System.out.println("Pas assez : "+nAlimentN.toString());
//}
//Aliment nAlimentO= new Aliment(3,"g","safran");
//if(gardeManger.verifierQuantiteProduit(nAlimentO)){
//System.out.println("Assez : "+nAlimentO.toString());
//} else {
//System.out.println("Pas assez : "+nAlimentO.toString());
//}
//
//ListeRec nIngredientsA = nLivreRecette.retournerIngredients("rezette");
//if(nIngredientsA == null) {
//System.out.println("Pas de recette");
//
//} else {
//if(gardeManger.verifierIngredients(nIngredientsA)) {
//	System.out.println("Possible");
//}
//}

//Aliment nAlimentM= new Aliment(1,"g","safran");
//if(nGardeManger.verifierQuantiteProduit(nAlimentM)) {
//System.out.println("Assez : "+nAlimentM.toString());
//} else {
//System.out.println("Pas assez : "+nAlimentM.toString());
//}
//Aliment nAlimentN= new Aliment(2,"g","safran");
//if(nGardeManger.verifierQuantiteProduit(nAlimentN)){
//System.out.println("Assez : "+nAlimentN.toString());
//} else {
//System.out.println("Pas assez : "+nAlimentN.toString());
//}
//Aliment nAlimentO= new Aliment(3,"g","safran");
//if(nGardeManger.verifierQuantiteProduit(nAlimentO)){
//System.out.println("Assez : "+nAlimentO.toString());
//} else {
//System.out.println("Pas assez : "+nAlimentO.toString());
//}
//
//ListeRec nIngredients = nLivreRecette.retournerIngredients("rezette");
//if(nIngredients == null) {
//System.out.println("Pas de recette");
//
//} else {
//if(nGardeManger.verifierIngredients(nIngredients)) {
//	System.out.println("Possible");
//} else {
//	System.out.println("Pas possible");
//} // else
//} // else


//ListeRec nIngredientsB = nLivreRecette.retournerIngredients("rezette");
//if(nIngredientsB == null) {
//System.out.println("Pas de recette");
//
//} else {
//if(gardeManger.verifierIngredients(nIngredientsB)) {
//	System.out.println("Possible");
//	
//} else {
//	System.out.println("Pas possible !");
//	
//	Recette nRecette= nLivreRecette.premiereRecette(nLivreRecette.getListe(), gardeManger);
//	
//	if(nRecette == null) {
//		System.out.println("Aucune recette ne peut être réalisée avec ce garde manger !");
//	
//	} else {
//		System.out.println("Mais il existe une autre recette:");
//		nRecette.afficher();
//	} // else
//} // else
//} // else
	
} // class
