/**
 * @file Aliment.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 */
	
	package objet;

/**
 * cette classe permet de manipuler un aliment.
 * Cet objet est défini par les éléments suivants:
 *  > une quantité,
 *  > une unité,
 *  > un nom.
 */
public class Aliment {
	
	// ------------------------------------------------------
	// Attributs
	
	private int quantite; // float ??
	private String unite;
	private String nom;
	
	
	// ------------------------------------------------------
	// Constructeurs
	
	public Aliment() {		
	} // constructeur par défaut

	/**
	 * @param int pQuantite, String pUnite, String pNom
	 */	
	public Aliment(int pQuantite, String pUnite, String pNom) {
		this.quantite= pQuantite;
		this.unite= pUnite;
		this.nom= pNom;
	} // constructeur

	
	// ------------------------------------------------------
	// get/set
	
	/**
	 * @return integer pour la quantité
	 */
	public int getQuantite() {
		return quantite;
	} // int
	/**
	 * @param int pQuantite
	 */
	public void setQuantite(int pQuantite) {
		this.quantite = pQuantite;
	} // setter

	/**
	 * @return String pour l'unité de mesure
	 */
	public String getUnite() {
		return unite;
	} // String
	/**
	 * @param String unite
	 */
	public void setUnite(String unite) {
		this.unite = unite;
	} // setter

	/**
	 * @return String pour le nom de l'ingrédient
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

	
	// ------------------------------------------------------
	// méthodes

	/**
	 * @return boolean vrai, si l'aliment n'est plus disponible
	 */
	public boolean isVide() {
		return (quantite <= 0);
	} // boolean
	
	/**
	 * @brief @brief surcharge de la fonction
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
		if(pObj instanceof Aliment) return this.nom.equals(((Aliment)pObj).getNom());

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
	    // attention si quantite n'est pas un integer il faut le caster
	    nReturn = nPremier * nReturn + quantite;

	    return nReturn;
	} // int

	/**
	 * @brief surcharge de la fonction
	 * 
	 * @return description complète de l'objet
	 */
	public String toString() {
		
	return this.quantite + " " + this.unite + " " + this.nom;
	} // String
	
} // class
