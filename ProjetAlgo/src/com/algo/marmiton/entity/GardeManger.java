/**
 * @file GardeManger.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxxxxx
 */
	
package com.algo.marmiton.entity;

import com.algo.marmiton.util.ListeRec;

/**
 * @brief Le garde-manger référence l'ensemble des produits utilisables en cuisine (disponibles ou non).
 * 
 * @details Cette classe permet de manipuler l'objet garde-manger.<br/>
 * 			Cet objet est défini par l'élément suivant: une liste des produits (aliments).
 */
public class GardeManger {

	// ------------------------------------------------------
	// Attributs
	private ListeRec liste;

	// ------------------------------------------------------
	// Constructeurs
	public GardeManger() {
		this.liste= new ListeRec();
	} // constructeur par défaut

	// ------------------------------------------------------
	// Méthodes

	/**
	 * @details Si un produit alimentaire n'existe pas, il est ajouté au garde-manger;
	 * 			sinon sa quantité est mise à jour.
	 * 
	 * @param Aliment pProduit
	 */
	public void ajouterProduit(Aliment pProduit){
		Aliment nAliment= (Aliment)this.liste.rechercher(pProduit);
		
		if(nAliment == null) { // nouveau produit
			this.liste= this.liste.insert(pProduit);
			
		} else { 
			
			if(! nAliment.ajouterQuantite(pProduit)) {
				
				this.liste= this.liste.insert(pProduit);
			} // if
		} // else
	} // void
	
	/**
	 * @brief Afficher tous les produits du garde-manger
	 */
	public void afficher() {
		System.out.println(this);//.toString());
	} // void

	/**
	 * @brief Afficher un produit, s'il existe
	 * 
	 * @param String pNomProduit
	 */
	public void afficher(String pNomProduit) {
		//Aliment nAliment= (Aliment)this.liste.rechercher(this.liste, pNomProduit);
		Aliment nAliment= (Aliment)this.liste.rechercher(pNomProduit);
		String nMsg= "";
		
		if(nAliment == null){
			nMsg= "Ce produit n'est pas référencé dans le garde-manger !\n > "+pNomProduit;
			
		} else {
			nMsg= "Ce produit existe bien dans le garde-manger";
			if (nAliment.isVide()) nMsg+= ", mais... il faut l'approvisionner"; 
			nMsg+= " !\n";
			nMsg+= nAliment;//.toString();
		} // else
		
		System.out.println(nMsg);
	} // void
	
	/**
	 * @brief Afficher si le produit est présent en quantité suffisante
	 * 
	 * @param Aliment pProduit
	 */
	public void afficherQuantiteProduit(Aliment pProduit) {
		
		Aliment nAliment= (Aliment)this.liste.rechercher(pProduit);
		
		if(nAliment == null) {
			System.out.println("Ce produit n'est pas référencé dans le garde-manger !\n"+pProduit);//.toString());

		} else {
			if(pProduit.estContenuDans(nAliment)) {
				System.out.println("Ce produit est présent en quantité suffisante:\n"
						+pProduit+" pour "+nAliment.afficherQuantite()+" "+nAliment.afficherUnite()
						+" dans le garde-manger.");
				
			} else {
				System.out.println("Ce produit n'est pas présent en quantité suffisante, ou présente une unité différente:\n"
						+pProduit+" pour "+nAliment.afficherQuantite()+" "+nAliment.afficherUnite()
						+" dans le garde-manger.");
			} // else
		} // else
	} // void
	
	/**
	 * @brief Vérifier si un produit existe en quantité suffisante
	 * 
	 * @param Aliment pProduit
	 * 
	 * @return boolean vrai, si le produit existe en quantité suffisante dans une même unité de mesure
	 */
	private boolean verifierQuantiteProduit(Aliment pProduit) {

		Aliment nAliment= (Aliment)this.liste.rechercher(pProduit);
		
		if(nAliment == null) {
			return false;

		} else {
			return nAliment.estContenuDans(pProduit);
		} // else

	} // boolean

	
	/**
	 * @brief Vérifier si l'ensemble des ingrédients existent en quantité suffisante
	 * 
	 * @param ListeRec pIngredients
	 * 
	 * @return boolean vrai, si tous les ingrédients existent en quantité suffisante
	 */
	public boolean verifierIngredients(ListeRec pIngredients) {
		boolean nReturn= pIngredients.isVide();

		if(!nReturn){
			
			if(this.verifierQuantiteProduit((Aliment)pIngredients.getTete())){

				if (pIngredients.getReste() != null){
					nReturn= this.verifierIngredients(pIngredients.getReste());
				} // if
			} // if
		} // if
		
	return nReturn;
	} // boolean	
	
	/**
	 * @brief Trouver la première recette possible en fonction du garde manger
	 * 
	 * @param ListeRec pListe
	 * 
	 * @return Recette si tous les ingrédients existent en quantité suffisante, sinon null
	 */
	public Recette premiereRecette(ListeRec pListe) {
		Recette nReturn= null;
		
		if(!pListe.isVide()){
			ListeRec nIngredients= ((Recette)pListe.getTete()).getIngredients();
			
			if(this.verifierIngredients(nIngredients)) {
				nReturn= (Recette)pListe.getTete();
				
			} else {
				if (pListe.getReste() != null)
					nReturn= this.premiereRecette(pListe.getReste());

			} // else
		} // if
		
	return nReturn;
	} // Recette
	
	/**
	 * @brief surcharge de la fonction
	 * 
	 * @return description complète de l'objet
	 */
	public String toString() {
		String nReturn= "Inventaire du garde-manger:\n";
		nReturn+= this.liste;//.toString();

	return nReturn;
	} // String
	
} // class








