/**
 * @file LivreRecette.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxxxxx
 */
	
package objet;

import include.ListeRec;

/**
 * @brief Le livre de recette est une collection de recettes.
 * 
 * Cette classe permet de manipuler l'objet livre de recette.
 * Cet objet est défini par les éléments suivants:
 *  > un nom,
 *  > une liste de recettes.
 */
public class LivreRecette {

	// ------------------------------------------------------
	// Attributs
	
	private String nom;
	private ListeRec liste;

	
	// ------------------------------------------------------
	// Constructeurs
	
	public LivreRecette(){
		this.construire("", new ListeRec());
	} // constructeur par défaut

	/**
	 * @param ListeRec liste
	 */	
	public LivreRecette(String pNom){
		this.construire(pNom, new ListeRec());
	} // constructeur
	
	/**
	 * @param ListeRec liste
	 */	
	public LivreRecette(String pNom, ListeRec pListe){
		this.construire(pNom, pListe);
	} // constructeur

	/**
	 * éviter une succession de constructeurs
	 * 
	 * @param String pNom, ListeRec pListe
	 */
	private void construire(String pNom, ListeRec pListe){
		this.nom= pNom;
		this.liste= pListe;
	} // procédure
	
	
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
	 * @param Recette pRecette
	 */
	public void ajouterRecette(Recette pRecette) {
		this.liste = this.liste.insert(this.liste, pRecette);
	} // procédure

	/**
	 * afficher toutes les recettes
	 */
	public void afficher() {
		System.out.println(this.toString());
	} // procédure
	
	/**
	 * afficher une recette décrite par son nom, si elle existe
	 * 
	 * @param String pNomRecette
	 */
	public void afficher(String pNomRecette) {
		
		Recette nRecette= this.rechercherRecette(this.liste, pNomRecette);
		String nMsg= "";
		
		if(nRecette == null) {
			nMsg= "La recette "+pNomRecette+" n'est pas présente dans ce livre !";
			
		} else {
			nMsg= "La recette "+pNomRecette+" est présente dans ce livre !\n";
			nMsg+= nRecette.toString();
		} // else
		
		System.out.println(nMsg);
	} // procédure

	/**
	 * rechercher une recette
	 * 
	 * @param ListeRec pListe, String pNomRecette
	 * 
	 * @return Recette ou null si la recette n'existe pas
	 */
	private Recette rechercherRecette(ListeRec pListe, String pNomRecette) {

		Recette nReturn= null;
		
		if(!pListe.isVide()){

			if(pNomRecette.equals(((Recette)pListe.getTete()).getNom())){

				nReturn= (Recette)pListe.getTete();
						
			} else {
				if (pListe.getReste() != null)
					nReturn= this.rechercherRecette(pListe.getReste(), pNomRecette);
				
			} // else
		} // if
	return nReturn;
	} // Recette
	
	/**
	 * surcharge de fonction
	 * 
	 * @return String: description complète du livre de recette (nom du livre et description de chaque recette)
	 */
	public String toString() {
		String nReturn= "livre de recette: "+this.nom+":\n";
		nReturn+= this.liste.toString();

	return nReturn;
	} // String

} // class








