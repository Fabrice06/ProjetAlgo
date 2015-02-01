/**
 * @mainpage voici la main page
 * 
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 * définir les grandes lignes de la main page
 * 
 * on a supposé que:
 *
 */

/**
 * @file Marmiton.java
 * 
 * @brief Point d'entrée du programme
 * 
 * @details xxxxxxxxxxxxx détails
 */

package com.algo.marmiton;

import com.algo.marmiton.entity.*;
import com.algo.marmiton.util.ListeRec;



public class Marmiton {

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
			System.out.println();
		  	nGardeManger.afficher(); 						
		  	
		  	// ingrédient trouvé
		  	nGardeManger.afficher("sucre vanillé"); 		
		  	
		  	
		  	// ingrédient non référencé
		  	System.out.println();
		  	nGardeManger.afficher("sel de guérande"); 	
		  	
		  
		  	
		// --------------------------------------------------------------------------------------- 	
		// vérifier que le garde-manger est suffisant pour un ingrédient
		  	
		  	// ingrédient trouvé en quantité suffisante
		  	System.out.println();
		  	nGardeManger.afficherQuantiteProduit(new Aliment(50,"g","pomme")); 	
		  	
	
		  	
		// ---------------------------------------------------------------------------------------  	
		// vérifier que le garde-manger est suffisant pour tout les ingrédients d'une recette
		  	System.out.println();
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
				
				
				
		// --------------------------------------------------------------------------------------- 
		// donner la première recette possible réalisable en fonction du garde manger
				System.out.println();
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
	 * @brief Créer un garde-manger
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
			nGardeManger.ajouterProduit(new Aliment(1,"kg","pomme"));
			nGardeManger.ajouterProduit(new Aliment(500,"g","sucre"));
			nGardeManger.ajouterProduit(new Aliment(300,"g","café"));
			nGardeManger.ajouterProduit(new Aliment(1,"l","vinaigre"));
			nGardeManger.ajouterProduit(new Aliment(500,"g","pomme"));
			
	return nGardeManger;
	} // GardeManger
	
	/**
	 * @brief Créer un livre de recettes
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
	 * @brief Créer une nouvelle recette pour alimenter le livre de recettes
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
	 * @brief Créer une nouvelle recette pour alimenter le livre de recettes
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
	 * @brief Créer une nouvelle recette pour alimenter le livre de recettes
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
	 * @brief Créer une nouvelle recette pour alimenter le livre de recettes
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
	 * @brief Créer une nouvelle recette pour alimenter le livre de recettes
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
	 * @brief Créer une nouvelle recette pour alimenter le livre de recettes
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

} // class
