/**
 * @file Recette.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 */
	
package objet;

import include.ListeRec;

/**
 * Cette classe permet de manipuler l'objet recette.
 * Cet objet est défini par les éléments suivants:
 *  > un nom,
 *  > une liste d'ingrédients,
 *  > une description de la réalisation.
 */
public class Recette {

	// ------------------------------------------------------
	// Attributs

	private String nom;
	private ListeRec liste;
	private String realisation;
	
	
	// ------------------------------------------------------
	// Constructeurs
	
	public Recette(){
		this.construire("", "", new ListeRec());
	} // constructeur par défaut

	/**
	 * Constructeur avec un nom et les étapes
	 * 
	 * @param String nom, String realisation
	 */	
	public Recette(String pNom, String pRealisation){
		this.construire(pNom, pRealisation, new ListeRec());
	} // constructeur
	
	/**
	 * éviter une succession de constructeurs
	 * 
	 * @param String pNom, String pDescription, ListeRec pListe
	 */
	private void construire(String pNom, String pRealisation, ListeRec pListe){
		this.nom= pNom;
		this.realisation= pRealisation;
		this.liste= pListe;
	} // void
	
	
	// ------------------------------------------------------
	// get/set

	/**
	 * @return String pour le nom
	 */
	private String getNom() {
		return nom;
	} // String

	/**
	 * @return ListeRec pour la liste des ingrédients
	 */
	public ListeRec getIngredients() {
		return liste;
	} // ListeRec
	
	
	// ------------------------------------------------------
	// méthodes

	/**
	 * permets d'ajouter un ingrédient dans la recette
	 * 
	 * @param Aliment pIngredient
	 */
	public void ajouterIngredient(Aliment pIngredient){
		this.liste = this.liste.insert(this.liste, pIngredient);
	} // void
	
	/**
	 * afficher la recette
	 */
	public void afficher() {
		System.out.println(this.toString());	
	} // void

	/**
	 * @brief surcharge de la fonction
	 * 
	 * Pour que deux objets de cette classe soient égaux, il faut réunir les conditions suivantes:
	 *   > être de même type (pObj instanceof Aliment),
	 *   > avoir le même nom.
	 *   
	 * @return boolean vrai, si les deux objets ont le même nom
	 */
	public boolean equals(Object pObj) {
		
		// implémentation par défaut
		if (this == pObj) return true;
		
		// utilisation de la fonction equals entre deux String
		if(pObj instanceof String) return this.nom.equals(pObj);
		
		// utilisation de la fonction equals entre deux String
		if(pObj instanceof Recette) return this.nom.equals(((Recette)pObj).getNom());

		return false;
    } // boolean

	/**
	 * @brief surcharge de la fonction
	 * 
	 * Comme la méthode equals() est redéfinie, il est nécessaire de redéfinir la méthode hashCode()
	 * pour respecter le contrat qui précise que deux objets égaux doivent avoir le même hashcode.
	 *   
	 * @return int valeur de hash calculée
	 */
	public int hashCode() {
		
		final int nPremier= 31; // nombre premier
	    int nReturn= 1;
	    
	    nReturn = nPremier * nReturn + ((nom == null)? 0 : nom.hashCode());
	    nReturn = nPremier * nReturn + ((realisation == null)? 0 : realisation.hashCode());
	    // pas sûr à 100% sur le code suivant:
	    nReturn = nPremier * nReturn + ((liste == null)? 0 : liste.hashCode()); 

	    return nReturn;
	} // int

	/**
	 * @brief surcharge de la fonction
	 * 
	 * @return description complète de l'objet
	 */
	public String toString() {
		String nReturn= "recette: "+this.nom+"\n\n";
		nReturn+= "liste des ingrédients:\n";
		nReturn+= this.liste.toString()+"\n";
		nReturn+= "réalisation:\n";
		nReturn+= this.realisation+"\n";

	return nReturn;
	} // String

	
	/**
	 * @brief Cette fonction main() est utilisée uniquement pour la réalisation de tests unitaires.
	 * 
	 * Le périmètre observé est limité à l'ensemble des opérations de cette classe.
	 */
	public static void main(String[] args) {
		
		// créer une recette
			System.out.println("création d'une recette");
			Recette nRecetteA= creerRecetteA();
			
		// afficher	une recette
			System.out.println();
			nRecetteA.afficher();

		// ---------------------------------------------------------------------------------------
		// test equals
			System.out.println("\ntests de la fonction equals() =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
			if(nRecetteA.equals("Pommes à la vanille")) System.out.println(" > l'objet " +nRecetteA.getNom()+ " est égal à la recette nommée Pommes à la vanille.");
			if(!nRecetteA.equals("Recette X")) System.out.println(" > l'objet " +nRecetteA.getNom()+ " n'est pas égal à la recette nommée Recette X.");
		
			Recette nRecetteX= nRecetteA;
			if(nRecetteA.equals(nRecetteX)) System.out.println(" > l'objet "+nRecetteA.getNom()+" est égal à l'objet "+nRecetteX.getNom());
			
			Recette nRecetteY= creerRecetteY();
			if(!nRecetteA.equals(nRecetteY)) System.out.println(" > l'objet "+nRecetteA.getNom()+" n'est pas égal à l'objet "+nRecetteY.getNom());

	} // main

	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes (à utiliser pour les tests uniquement)
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteA() {
		String nNom= "Pommes à la vanille";
		String nDescription= " Faire la recette !";
		
		Recette nRecette= new Recette(nNom, nDescription);
			nRecette.ajouterIngredient(new Aliment(500,"g","pomme"));
			nRecette.ajouterIngredient(new Aliment(3,"gousse","vanille"));
		
	return nRecette;
	} // Recette
	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes (à utiliser pour les tests uniquement)
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteY() {
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
} // class
