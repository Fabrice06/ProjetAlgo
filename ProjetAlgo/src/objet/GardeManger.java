/**
 * @file GardeManger.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxxxxx
 */
	
package objet;

import include.ListeRec;

/**
 * @brief Le garde manger référence l'ensemble des produits utilisables en cuisine (disponibles ou non).
 * 
 * Cette classe permet de manipuler l'objet garde manger.
 * Cet objet est défini par l'élément suivant:
 *  > une liste des produits (aliments).
 */
public class GardeManger {

	// ------------------------------------------------------
	// Attributs
	
	private ListeRec liste;

	
	// ------------------------------------------------------
	// Constructeurs
	
	public GardeManger(){
		this.liste= new ListeRec();
	} // constructeur par défaut

	/**
	 * @param ListeRec liste
	 */	
	public GardeManger(ListeRec liste){
		this.liste= liste;
	} // constructeur

	
	// ------------------------------------------------------
	// get/set

	/**
	 * @return ListeRec pour renvoyer la liste
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
	 * si un produit alimentaire n'existe pas, il est ajouté au garde manger;
	 * sinon sa quantité est mise à jour
	 * 
	 * @param Aliment pProduit
	 */
	public void ajouterProduit(Aliment pProduit){
		Aliment nAliment= (Aliment)this.liste.rechercher(this.liste, pProduit);
		
		if(nAliment == null) { // nouveau produit
			this.liste = this.liste.insert(this.liste, pProduit);
			
		} else { // mise à jour produit
			nAliment.setQuantite(nAliment.getQuantite()+pProduit.getQuantite());
		} // else
	} // procédure
	
	/**
	 * afficher tous les produits du garde-manger
	 */
	public void afficher() {
		System.out.println(this.toString());
	} // procédure

	/**
	 * afficher un produit, s'il existe
	 * 
	 * @param String pNomProduit
	 */
	public void afficher(String pNomProduit) {
		Aliment nAliment= (Aliment)this.liste.rechercher(this.liste, pNomProduit);
		String nMsg= "";
		
		if(nAliment == null){
			nMsg= pNomProduit+": ce produit n'est pas référencé dans le garde-manger !";
			
		} else {
			nMsg= pNomProduit+": ce produit existe dans le garde-manger";
			if (nAliment.isVide()) nMsg+= ", mais... il faut l'approvisionner"; 
			nMsg+= " !\n";
			nMsg+= nAliment.toString();
		} // else
		
		System.out.println(nMsg);
	} // procédure

	/**
	 * vérifier si un produit existe en quantité suffisante
	 * 
	 * @param Aliment pProduit
	 * 
	 * @return boolean vrai, si le produit existe en quantité suffisante
	 */
	public boolean verifierQuantiteProduit(Aliment pProduit) {

		Aliment nAliment= (Aliment)this.liste.rechercher(this.liste, pProduit);
		
		if(nAliment == null) {
			return false;

		} else {
			return (pProduit.getQuantite() <= nAliment.getQuantite());
		} // else

	} // boolean

	/**
	 * vérifier si l'ensemble des ingrédients existent en quantité suffisante
	 * 
	 * @param ListeRec pIngredients
	 * 
	 * @return boolean vrai, si tous les ingrédients existent en quantité suffisante
	 */
	public boolean verifierIngredients(ListeRec pIngredients) {
		boolean nReturn= false;

		if(!(pIngredients.isVide())){
			
			if(this.verifierQuantiteProduit((Aliment)pIngredients.getTete())){
				nReturn= this.verifierIngredients(pIngredients.getReste());
			
			} else {
				nReturn= false;
			}

			if (pIngredients.getReste() != null){
				nReturn= this.verifierIngredients(pIngredients.getReste());
			} // if
		} // if
		
	return nReturn;
	} // boolean
	
	/**
	 * surcharge de fonction
	 * 
	 * @return description complète de l'objet
	 */
	public String toString() {
		String nReturn= "Inventaire du garde-manger:\n";
		nReturn+= this.liste.toString();

	return nReturn;
	} // String
} // class








