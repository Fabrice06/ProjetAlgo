/**
 * @file Aliment.java
 * 
 * @brief triplet constitué d'un nom, d'une quantité et d'une unité
 */
	
package objet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		this.construire(0, "", "");
	} // constructeur par défaut

	/**
	 * @param int pQuantite, String pNom
	 */	
	public Aliment(int pQuantite, String pNom) {
		this.construire(pQuantite, "", pNom);
	} // constructeur
	
	/**
	 * @param int pQuantite, String pUnite, String pNom
	 */	
	public Aliment(int pQuantite, String pUnite, String pNom) {
		this.construire(pQuantite, pUnite, pNom);
	} // constructeur

	/**
	 * éviter une succession de constructeurs
	 * 
	 * @param int pQuantite, String pUnite, String pNom
	 */
	private void construire(int pQuantite, String pUnite, String pNom){
		this.quantite= pQuantite;
		this.unite= pUnite.trim();
		this.nom= pNom.trim();
	} // procédure
	
	
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
	 * @return String pour le nom de l'ingrédient
	 */
	private String getNom() {
		return nom;
	} // String

	
	// ------------------------------------------------------
	// méthodes

	/**
	 * @return boolean vrai, si l'aliment n'est plus disponible
	 */
	public boolean isVide() {
		return (this.quantite <= 0);
	} // boolean

	/**
	 * @return String une chaîne sans espace en double, sans espace au début et sans espace à la fin 
	 */
	private String nettoyerEspace(String pString) {
		
		// remplace tous les espaces multiples consécutifs par un seul
		String nReturn= pString.replaceAll(" {2,}", " "); 

	return nReturn.trim(); 
	} // String

	/** 
	 * @return String l'unité telle qu'elle doit être affichée
	 */
	private String afficherUnite() {
		
		String nReturn= "";
		if (!this.unite.isEmpty()){
			nReturn= this.unite;
			
			// si l'unité est g ou l alors on n'accorde pas l'unité en fonction de la quantité
			Pattern nPattern = Pattern.compile("^[gl]$");  
			Matcher nMatcher = nPattern.matcher(this.unite);
			
			if(!nMatcher.find()) {
				if((this.quantite <= -2) || (this.quantite >= 2))  nReturn+= "s";
			} // if
		} // if

	return nReturn;
	} // String
	/** 
	 * @return String le nom destiné à l'affichage
	 */
	private String afficherNom() {
		String nAliment= "beurre|lait|poivre|radis|riz|sel|sucre vanillé";
		String nConteneur= "botte|cuillère à café|cuillère à soupe|motte|noix|paquet|pincée|poignée|sachet";
		
		String nReturn= "";
		if(!this.nom.isEmpty()) {
			
			if (this.unite.isEmpty()) {
				if(!nAliment.toLowerCase().contains(this.nom.toLowerCase())) {
					if((this.quantite <= -2) || (this.quantite >= 2))  nReturn= this.nom+"s";
				} // if
				
			} else {
				// si le nom commence par aehiouy alors on apostrophe l'article partitif de
				Pattern nPatternA = Pattern.compile("^[aehiouy].*");  
				Matcher nMatcherA = nPatternA.matcher(this.nom);
				nReturn= (nMatcherA.find())? "d'" : "de ";
				nReturn+= this.nom;
				
				// si l'unité est un contenant
				if(nConteneur.toLowerCase().contains(this.unite.toLowerCase())) {
					if(!nAliment.toLowerCase().contains(this.nom.toLowerCase())) {
						if((this.quantite <= -2) || (this.quantite >= 2)) nReturn+= "s";
					} // if
				} // if

			} // if	
		} // if

	return nReturn;
	} // String
	
	/**
	 * @brief surcharge de la fonction
	 * 
	 * Pour que deux objets de cette classe soient égaux, il faut réunir les conditions suivantes:
	 *   > être de même type (pObj instanceof Aliment),
	 *   > avoir le même nom.
	 *   
	 * @note La quantité n'est pas prise en compte dans cette comparaison.
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
		// cette approche n'est pas des plus élégante, mais c'est la plus maintenable
	return this.nettoyerEspace(this.quantite + " " + this.afficherUnite() + " " + this.afficherNom());
	} // String

	
	public static void main(String[] args) {
			
		Aliment nAlimentA = new Aliment(4,"oeuf");
		Aliment nAlimentB = new Aliment(1,"l","lait");
		Aliment nAlimentC = new Aliment(30,"g","beurre");			
		Aliment nAlimentD = new Aliment(2,"sachet","sucre vanillé");
		Aliment nAlimentE = new Aliment(1,"botte","radis");
		Aliment nAlimentF = new Aliment(2,"botte","carotte");
		
		// test fonction toString()
		System.out.println("nAlimentA.toString() retourne : "+ nAlimentA.toString());
		System.out.println("nAlimentB.toString() retourne : "+ nAlimentB.toString());
		System.out.println("nAlimentC.toString() retourne : "+ nAlimentC.toString());
		System.out.println("nAlimentD.toString() retourne : "+ nAlimentD.toString());
		System.out.println("nAlimentE.toString() retourne : "+ nAlimentE.toString());
		System.out.println("nAlimentF.toString() retourne : "+ nAlimentF.toString());
		
		// test fonction equals()
		if(nAlimentA.equals("oeuf")) System.out.println("l'aliment " +nAlimentA.getNom()+ " est égal à l'aliment oeuf");
		if(!nAlimentA.equals("lait")) System.out.println("l'aliment " +nAlimentA.getNom()+ " n'est pas égal à l'aliment lait");
		
		Aliment nAlimentG= nAlimentA;
		if(nAlimentA.equals(nAlimentG)) System.out.println("l'objet "+nAlimentA.getNom()+" est égal à l'objet "+nAlimentG.getNom());

		if(nAlimentA.equals(new Aliment(8,"oeuf"))) System.out.println("l'aliment "+nAlimentA.getNom()+" est égal à l'objet oeuf");

	} // main

} // class
