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
	 * Constructeur avec un nom et une liste d'ingrédients
	 * 
	 * @param String nom, ListeRec liste
	 */	
	public Recette(String nom, ListeRec liste){
		this.construire(nom, "", liste);
	} // constructeur

	/**
	 * Constructeur avec un nom et les étapes
	 * 
	 * @param String nom, String realisation
	 */	
	public Recette(String pNom, String pRealisation){
		this.construire(pNom, pRealisation, new ListeRec());
	} // constructeur
	
	/**
	 * Constructeur avec un nom, les étapes et une liste d'ingrédients
	 * 
	 * @param String pNom, String pDescription, ListeRec pListe
	 */	
	public Recette(String pNom, String pRealisation, ListeRec pListe){
		this.construire(pNom, pRealisation, pListe);
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
	} // procédure
	
	
	// ------------------------------------------------------
	// get/set

	/**
	 * @return String pour le nom
	 */
	public String getNom() {
		return nom;
	} // String
	/**
	 * @param String nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	} // setter
	/**
	 * @return String pour la réalisation
	 */
	public String getRealisation() {
		return realisation;
	} // String

	/**
	 * @param String realisation
	 */
	public void setRealisation(String realisation) {
		this.realisation = realisation;
	} // setter

	/**
	 * @return ListeRec pour la liste des ingrédients
	 */
	public ListeRec getListe() {
		return liste;
	} // ListeRec
	
	/**
	 * @param ListeRec liste
	 */
	public void setListe(ListeRec liste) {
		this.liste = liste;
	} // setter
	
	
	// ------------------------------------------------------
	// méthodes

	/**
	 * permets d'ajouter un ingrédient dans la recette
	 * 
	 * @param Aliment pIngredient
	 */
	public void ajouterIngredient(Aliment pIngredient){
		this.liste = this.liste.insert(this.liste, pIngredient);
	} // procédure
	
	/**
	 * afficher la recette
	 */
	public void afficher() {
		System.out.println(this.toString());	
	} // procédure

	/**
	 * surcharge de fonction
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
} // class
