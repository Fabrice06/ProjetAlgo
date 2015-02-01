/**
 * @file LivreRecette.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxxxxx
 */
	
package com.algo.marmiton.entity;

import com.algo.marmiton.util.ListeRec;

/**
 * @brief Le livre de recette est une collection de recettes.
 * 
 * @brief Cette classe permet de manipuler l'objet livre de recette.
 * 			
 * @details Cet objet est défini par les éléments suivants:
 *  		<ul>
 *  			<li>un nom,
 *  			<li>une liste de recettes.
 *  		</ul>
 */
public class LivreRecette {

	// ------------------------------------------------------
	// Attributs
	
	private String nom;
	private ListeRec liste;

	// ------------------------------------------------------
	// Constructeurs
	
	/**
	 * @param ListeRec liste
	 */	
	public LivreRecette(String pNom){
		this.nom= pNom;
		this.liste= new ListeRec();
	} // constructeur

	// ------------------------------------------------------
	// Accesseurs
	
	/**
	 * @return ListeRec pour renvoyer la liste
	 */	
	public ListeRec getListe() {
		return liste;
	} // ListeRec
	
	// ------------------------------------------------------
	// Méthodes

	/**
	 * @brief Permets l'ajout d'une recette dans le livre de recettes
	 * 
	 * @param Recette pRecette
	 */
	public void ajouterRecette(Recette pRecette) {
		this.liste = this.liste.insert(pRecette);
	} // void

	/**
	 * @brief Afficher toutes les recettes
	 */
	public void afficher() {
		System.out.println(this);
	} // void
	
	/**
	 * @brief Afficher une recette décrite par son nom, si elle existe
	 * 
	 * @param String pNomRecette
	 */
	public void afficher(String pNomRecette) {
		
		Recette nRecette= (Recette)this.liste.rechercher(pNomRecette);
		String nMsg= "";
		
		if(nRecette == null) {
			nMsg= "La recette "+pNomRecette+" n'est pas présente dans ce livre !";
			
		} else {
			nMsg= "La recette "+pNomRecette+" est présente dans ce livre !\n";
			nMsg+= nRecette;
		} // else
		
		System.out.println(nMsg);
	} // void
	
	/**
	 * @brief Renvoyer la liste des ingrédients de la recette
	 * 
	 * @param String pNomRecette
	 * 
	 * @return ListeRec pour renvoyer la liste des ingrédients de la recette, sinon null
	 */
	public ListeRec retournerIngredients(String pNomRecette) {

		Recette nRecette= (Recette)this.liste.rechercher(pNomRecette);
		
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
		nReturn+= this.liste;

	return nReturn;
	} // String

} // class








