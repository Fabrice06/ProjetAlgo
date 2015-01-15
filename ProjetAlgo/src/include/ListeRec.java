/**
 * @file ListeRec.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxx
 */
	
	package include;

import objet.Aliment;

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
//		isListeVide = true;
	} // constructeur par défaut

	/**
	 * Constructeur avec tête en paramêtre seulement
	 * 
	 * @param Ingredient tete
	 */	
	public ListeRec(Object pTete) {
		this.construire(false, pTete, null);
//		isListeVide = false;
//		laTete = tete;
	} // constructeur

	/**
	 * Constructeur avec tête et liste en paramêtre
	 * 
	 * @param Ingredient tete, ListeIngredients liste
	 */	
	public ListeRec(Object pTete, ListeRec pReste) {
		this.construire(false, pTete, pReste);
		
//		laTete = tete;
//		leReste = liste;
//		listeVide = false;
	} // constructeur

	/**
	 * éviter une succession de constructeurs
	 * 
	 * @param boolean pIsVide, Object pTete, ListeRec pListe
	 */
	private void construire(boolean pIsVide, Object pTete, ListeRec pReste){
		this.isVide= pIsVide;
		this.laTete= pTete;
		this.leReste= pReste;
	} // procédure

	
	// ------------------------------------------------------
	// get/set	

	/**
	 * Retourne l'état de la liste
	 * 
	 * @return vrai, si la liste est vide
	 */
	public boolean isVide() {
		return this.isVide;
	} // boolean

	/**
	 * Modifier l'état de la liste
	 * 
	 * @param boolean listeVide
	 */
	private void setVide(boolean pIsVide) {
		this.isVide = pIsVide;
	} // setter

	/**
	 * Donner la valeur de la tête
	 * 
	 * @return object pour l'objet contenu dans la tête de la liste
	 */
	public Object getTete() {
		return laTete;
	} // object

	/**
	 * Modifier la tête de la liste
	 * 
	 * @param Object laTete
	 */
	private void setTete(Object pTete) {
		this.laTete = pTete;
	} // setter

	/**
	 * @return ListeRec pour renvoyer la liste restante
	 */	
	public ListeRec getReste() {
		return leReste;
	} // ListeRec

	/**
	 * Modifier la liste restante
	 * 
	 * @param ListeRec leReste
	 */
	private void setReste(ListeRec pReste) {
		this.leReste = pReste;
	} // setter

	
	// ------------------------------------------------------
	// méthodes
	
	/**
	 * Affiche une liste 
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
		String nReturn= "";

		if(!(this.isVide)){	
			nReturn+= this.getTete().toString()+"\n";
			
			if (this.getReste() != null){
				nReturn+= this.getReste().toString();
			} // if
		} // if
		
	return nReturn;
	} // String

	/**
	 * rechercher un produit ou une recette par son nom
	 * 
	 * @param ListeRec pListe, String pNomObjet
	 * 
	 * @return Object ou null si l'objet n'existe pas
	 */
	public Object rechercher(ListeRec pListe, String pNomObjet) {
		
		Object nReturn= null;
		
		if(!pListe.isVide()){
			if(pListe.getTete().equals(pNomObjet)) {
				nReturn= pListe.getTete();

			} else {
				if (pListe.getReste() != null)
					nReturn= this.rechercher(pListe.getReste(), pNomObjet);

			} // else
		} // if
		
	return nReturn;
	} // Object

	/**
	 * rechercher un produit ou une recette
	 * 
	 * @param ListeRec pListe, Object pObjet
	 * 
	 * @return Object ou null si l'objet n'existe pas
	 */
	public Object rechercher(ListeRec pListe, Object pObjet) {
		
		Object nReturn= null;
		
		if(!pListe.isVide()){
			if(pListe.getTete().equals(pObjet)) {
				nReturn= pListe.getTete();

			} else {
				if (pListe.getReste() != null)
					nReturn= this.rechercher(pListe.getReste(), pObjet);

			} // else
		} // if
		
	return nReturn;
	} // Object
	
	/**
	 * @return ListeRec pour renvoyer la liste obtenue après insertion d'un objet en tête
	 */	
	private ListeRec prefixer(Object val){
		ListeRec liste = new ListeRec(val, this);
		return liste;
	} // ListeRec

	/**
	 * @return ListeRec pour renvoyer la liste obtenue après insertion d'un objet en fin
	 */	
	public ListeRec insert(ListeRec liste, Object val){
		if (liste.isVide()){
			return liste.prefixer(val);
		}else{ 
			return liste.insert(liste.getReste(),val).prefixer(liste.getTete());
		}
	} // ListeRec

} // class
