/**
 * @file ListeRec.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxx
 */
	
package com.algo.marmiton.util;

/**
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 */
public class ListeRec {

	// ------------------------------------------------------
	// Attributs
	
	private boolean isVide;
	private Object laTete;
	private ListeRec leReste;
	
	// ------------------------------------------------------
	// Constructeurs
	
	public ListeRec() {
		this.construire(true, null, null);
	} // constructeur par défaut

	/**
	 * @brief Constructeur avec tête et liste en paramêtre
	 * 
	 * @param Ingredient tete, ListeIngredients liste
	 */	
	public ListeRec(Object pTete, ListeRec pReste) {
		this.construire(false, pTete, pReste);
	} // constructeur

	/**
	 * @brief Eviter une succession de constructeurs
	 * 
	 * @param boolean pIsVide, Object pTete, ListeRec pListe
	 */
	private void construire(boolean pIsVide, Object pTete, ListeRec pReste){
		this.isVide= pIsVide;
		this.laTete= pTete;
		this.leReste= pReste;
	} // void

	// ------------------------------------------------------
	// Accesseurs	

	/**
	 * @brief Retourne l'état de la liste
	 * 
	 * @return vrai, si la liste est vide
	 */
	public boolean isVide() {
		return this.isVide;
	} // boolean

	/**
	 * @brief Donner la valeur de la tête
	 * 
	 * @return Object pour le contenu dans la tête de la liste
	 */
	public Object getTete() {
		return laTete;
	} // object

	/**
	 * @return ListeRec pour renvoyer la liste restante
	 */	
	public ListeRec getReste() {
		return leReste;
	} // ListeRec

	// ------------------------------------------------------
	// méthodes

	/**
	 * @brief surcharge de fonction
	 * 
	 * @return description complète de l'objet
	 */
	public String toString() {
		String nReturn= "";

		if(!(this.isVide)){	
			//nReturn+= this.getTete().toString()+"\n";
			nReturn+= this.getTete()+"\n";
			
			if (this.getReste() != null){
				nReturn+= this.getReste();//.toString();
			} // if
		} // if
		
	return nReturn;
	} // String

	/**
	 * @brief Rechercher un objet par son nom
	 * 
	 * @param String pNomObjet
	 * 
	 * @return Object ou null si l'objet n'existe pas
	 */
	public Object rechercher(String pNomObjet) {
		
		Object nReturn= null;
		
		if(!this.isVide()){
			if(this.getTete().equals(pNomObjet)) {
				nReturn= this.getTete();

			} else {
				if (this.getReste() != null)
					nReturn= this.getReste().rechercher(pNomObjet);

			} // else
		} // if
		
	return nReturn;
	} // Object

	/**
	 * @brief Rechercher un objet
	 * 
	 * @param Object pObjet
	 * 
	 * @return Object ou null si l'objet n'existe pas
	 */
	public Object rechercher(Object pObjet) {
		
		Object nReturn= null;
		
		if(!this.isVide()){
			if(this.getTete().equals(pObjet)) {
				nReturn= this.getTete();

			} else {
				if(this.getReste() != null)
					nReturn= this.getReste().rechercher(pObjet);

			} // else
		} // if
		
	return nReturn;
	} // Object
	
	/**
	 * @param Object pObjet
	 * 
	 * @return ListeRec liste obtenue après insertion d'un objet en tête
	 */	
	private ListeRec prefixer(Object pObjet){
		ListeRec liste = new ListeRec(pObjet, this);
		return liste;
	} // ListeRec

	/**
	 * @param Object pObjet
	 * 
	 * @return ListeRec liste obtenue après insertion d'un objet en fin
	 */	
	public ListeRec insert(Object pObjet){
		if (this.isVide()){
			return this.prefixer(pObjet);
		}else{ 
			return this.getReste().insert(pObjet).prefixer(this.getTete());
		}
	} // ListeRec

} // class
