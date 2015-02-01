/**
 * @file Recette.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 */
	
package com.algo.marmiton.entity;

import com.algo.marmiton.util.ListeRec;

/**
 * @brief Cette classe permet de manipuler l'objet recette.
 * 			
 * @details Cet objet est défini par les éléments suivants:
 *  		<ul> 
 *  			<li>un nom,
 *  			<li>une liste d'ingrédients,
 *  			<li>une description de la réalisation.
 *  		</ul>
 */
public class Recette {

	// ------------------------------------------------------
	// Attributs

	private String nom;
	private ListeRec liste;
	private String realisation;
	
	// ------------------------------------------------------
	// Constructeurs

	/**
	 * @brief Constructeur avec un nom et les étapes
	 * 
	 * @param String nom, String realisation
	 */	
	public Recette(String pNom, String pRealisation){
		this.nom= pNom;
		this.realisation= pRealisation;
		this.liste= new ListeRec();
	} // constructeur
		
	// ------------------------------------------------------
	// Accesseurs

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
	// Méthodes

	/**
	 * @brief Permets d'ajouter un ingrédient dans la recette
	 * 
	 * @param Aliment pIngredient
	 */
	public void ajouterIngredient(Aliment pIngredient){
		this.liste = this.liste.insert(pIngredient);
	} // void
	
	/**
	 * @brief Afficher la recette
	 */
	public void afficher() {
		System.out.println(this);	
	} // void

	/**
	 * @brief surcharge de la fonction
	 * 
	 * @detail Pour que deux objets de cette classe soient égaux, il faut réunir les conditions suivantes:
	 * 			<ul>
	 * 				<li>être de même type (pObj instanceof Aliment),
	 * 				<li>avoir le même nom.
	 * 			</ul>
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
	 * @detail Comme la méthode equals() est redéfinie, il est nécessaire de redéfinir la méthode hashCode()
	 * 			pour respecter le contrat qui précise que deux objets égaux doivent avoir le même hashcode.
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
		nReturn+= this.liste+"\n";
		nReturn+= "réalisation:\n";
		nReturn+= this.realisation+"\n";

	return nReturn;
	} // String
	
} // class
