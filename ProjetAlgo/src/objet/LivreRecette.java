/**

 * @file LivreRecette.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxxxxx
 */
	
package objet;

import include.ListeRec;

/**
 * @brief Le livre de recette est une collection de recettes.
 * 
 * Cette classe permet de manipuler l'objet livre de recette.
 * Cet objet est défini par les éléments suivants:
 *  > un nom,
 *  > une liste de recettes.
 */
public class LivreRecette {

	// ------------------------------------------------------
	// Attributs
	
	private String nom;
	private ListeRec liste;

	
	// ------------------------------------------------------
	// Constructeurs
	
	public LivreRecette(){
		this.construire("", new ListeRec());
	} // constructeur par défaut

	/**
	 * @param ListeRec liste
	 */	
	public LivreRecette(String pNom){
		this.construire(pNom, new ListeRec());
	} // constructeur
	
	/**
	 * @param ListeRec liste
	 */	
	public LivreRecette(String pNom, ListeRec pListe){
		this.construire(pNom, pListe);
	} // constructeur

	/**
	 * éviter une succession de constructeurs
	 * 
	 * @param String pNom, ListeRec pListe
	 */
	private void construire(String pNom, ListeRec pListe){
		this.nom= pNom;
		this.liste= pListe;
	} // void
	
	
	// ------------------------------------------------------
	// get/set

	/**
	 * @return ListeRec pour renvoyer la liste
	 */	
	public ListeRec getListe() {
		return liste;
	} // ListeRec
	
	
	// ------------------------------------------------------
	// méthodes

	/**
	 * permets l'ajout d'une recette dans le livre de recettes
	 * 
	 * @param Recette pRecette
	 */
	public void ajouterRecette(Recette pRecette) {
		this.liste = this.liste.insert(this.liste, pRecette);
	} // void

	/**
	 * afficher toutes les recettes
	 */
	public void afficher() {
		System.out.println(this.toString());
	} // void
	
	/**
	 * afficher une recette décrite par son nom, si elle existe
	 * 
	 * @param String pNomRecette
	 */
	public void afficher(String pNomRecette) {
		
		Recette nRecette= (Recette)this.liste.rechercher(this.liste, pNomRecette);
		String nMsg= "";
		
		if(nRecette == null) {
			nMsg= "La recette "+pNomRecette+" n'est pas présente dans ce livre !";
			
		} else {
			nMsg= "La recette "+pNomRecette+" est présente dans ce livre !\n";
			nMsg+= nRecette.toString();
		} // else
		
		System.out.println(nMsg);
	} // void
	
	/**
	 * renvoyer la liste des ingrédients de la recette
	 * 
	 * @param String pNomRecette
	 * 
	 * @return ListeRec pour renvoyer la liste des ingrédients de la recette, sinon null
	 */
	public ListeRec retournerIngredients(String pNomRecette) {
		
		Recette nRecette= (Recette)this.liste.rechercher(this.liste, pNomRecette);

		if(nRecette == null) {
			return null;
			
		} else {
			return nRecette.getIngredients();

		} // else
	} // ListeRec
	
	/**
	 * @brief surcharge de la fonction
	 * 
	 * @return String: description complète du livre de recettes (nom du livre et description de chaque recette)
	 */
	public String toString() {
		String nReturn= "livre de recette: "+this.nom+":\n";
		nReturn+= this.liste.toString();

	return nReturn;
	} // String
	
	/**
	 * @brief Cette fonction main() est utilisée uniquement pour la réalisation de tests unitaires.
	 * 
	 * Le périmètre observé est limité à l'ensemble des opérations de cette classe.
	 */
	public static void main(String[] args) {
		
		// créer un livre de recettes
			System.out.println("création d'un livre de recette");
			LivreRecette nLivreRecette= creerLivreRecette();
		
		// afficher l'ensemble du livre de recettes
			System.out.println();
			nLivreRecette.afficher();
				
		// afficher une recette présente dans le livre de recette
			System.out.println("\nafficher une recette présente dans le livre de recette:");
			nLivreRecette.afficher("Compote de pomme");
		
		// afficher une recette absente du livre de recette
			System.out.println("\nafficher une recette absente du livre de recette:");
			nLivreRecette.afficher("Compote");
		
		// afficher la liste des ingrédients d'une recette présente
			System.out.println("\nafficher la liste des ingrédients d'une recette présente:");
			testerListeIngredients(nLivreRecette, "Poulet au curry");

		// afficher la liste des ingrédients d'une recette vide
			System.out.println("\nafficher la liste des ingrédients d'une recette vide:");
			testerListeIngredients(nLivreRecette, "Recette vide");
			
		// afficher la liste des ingrédients d'une recette inconnue
			System.out.println("\nafficher la liste des ingrédients d'une recette inconnue:");
			testerListeIngredients(nLivreRecette, "Recette inconnue");
			
	} // main
	
	/**
	 * @brief créer un livre de recettes (à utiliser pour les tests uniquement)
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
		
	return nLivreRecette;
	} // LivreRecette

	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes (à utiliser pour les tests uniquement)
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
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes (à utiliser pour les tests uniquement)
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
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes (à utiliser pour les tests uniquement)
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
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes (à utiliser pour les tests uniquement)
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteD() {
		String nNom= "Recette vide";
		String nDescription= " Le but est de tester une recette sans ingrédient.";
		
		Recette nRecette= new Recette(nNom, nDescription);

	return nRecette;
	} // Recette

	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes (à utiliser pour les tests uniquement)
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static void testerListeIngredients(LivreRecette pLivreRecette, String pNomRecette) {
		
	  	ListeRec nIngredients = pLivreRecette.retournerIngredients(pNomRecette);
	  	
		if(nIngredients == null) {
			System.out.println("La recette "+pNomRecette+" n'est pas présente dans ce livre !");
			
		} else {
			if(nIngredients.isVide()) {
				System.out.println("La recette "+pNomRecette+" ne comporte pas d'ingrédient.");
				
			} else {
				System.out.println("La recette "+pNomRecette+" comporte les ingrédients suivants:\n"
						+nIngredients.toString());
				
			} // else
		} // else
	} // void
	
} // class








