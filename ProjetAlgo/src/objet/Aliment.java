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
	
	private int qte;
	private String unite;
	private String nom;
	
	
	// ------------------------------------------------------
	// Constructeurs
	
	public Aliment() {		
	} // constructeur par défaut

	/**
	 * @param int qte, String unite, String nom
	 */	
	public Aliment(int qte, String unite, String nom) {
		this.qte=qte;
		this.unite=unite;
		this.nom=nom;
	} // constructeur

	
	// ------------------------------------------------------
	// get/set
	
	/**
	 * @return integer pour la quantité
	 */
	public int getQuantite() {
		return qte;
	} // int
	/**
	 * @param int qte
	 */
	public void setQuantite(int qte) {
		this.qte = qte;
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
		return (qte <= 0);
	} // boolean
	
	/**
	 * @brief surcharge de fonction
	 * 
	 * @return description complète de l'objet
	 */
	public String toString() {
		
	return this.qte + " " + this.unite + " " + this.nom;
	} // String

	/**
	 * @brief surcharge de fonction
	 * 
	 * Pour que deux objets de cette classe soient égaux, il faut réunir les conditions suivantes:
	 *   > être de même type (pObj instanceof Aliment),
	 *   > avoir le même nom.
	 *   
	 * @return boolean vrai, si les deux objets ont le même nom
	 */
	public boolean equals(Object pObj) {
		if(pObj instanceof String) {
			return nom.equals(pObj);
			
		} else if(pObj instanceof Aliment) {
			return nom.equals(((Aliment)pObj).getNom());
			
		} else {
			return this.equals(pObj);
		} // else
    } // boolean
	
} // class
