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
	public ListeRec getIngredients() {
		return liste;
	} // ListeRec
	
	/**
	 * @param ListeRec liste
	 */
	public void setIngredients(ListeRec nListeIngredients) {
		this.liste = nListeIngredients;
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
	
} // class
