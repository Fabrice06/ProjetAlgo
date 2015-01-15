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
	 * permets d'ajouter un produit alimentaire dans le garde manger
	 * 
	 * @param Aliment pProduit
	 */
	public void ajouterProduit(Aliment pProduit){
		this.liste = this.liste.insert(this.liste, pProduit);
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
		Aliment nAliment= this.rechercherProduit(this.liste, pNomProduit);
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
	 * rechercher un produit
	 * 
	 * @param ListeRec pListe, String pNomProduit
	 * 
	 * @return Aliment ou null si le produit n'existe pas
	 */
	private Aliment rechercherProduit(ListeRec pListe, String pNomProduit) {
		
		Aliment nReturn= null;
		
		if(!pListe.isVide()){
			if(pNomProduit.equals(((Aliment)pListe.getTete()).getNom())) {
				
				nReturn= (Aliment)pListe.getTete();

			} else {
				if (pListe.getReste() != null)
					nReturn= this.rechercherProduit(pListe.getReste(), pNomProduit);

			} // else
		} // if
		
	return nReturn;
	} // Aliment

	
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








