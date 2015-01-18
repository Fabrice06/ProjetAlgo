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

	/**
	 * @return String pour l'unité de l'ingrédient
	 */
	public String getUnite() {
		return unite;
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
	 * @param String pString
	 * 
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
	public String afficherUnite() {
		String nReturn= "";
		
		if (!this.unite.isEmpty()) {
			nReturn= this.unite;
			
			// affichage du pluriel
			if((this.quantite <= -2) || (this.quantite >= 2)) {
				nReturn= this.accorder(nReturn);
			} // if
		} // if

	return nReturn;
	} // String
	/** 
	 * Cette implémentation bien que correcte sur le plan technique, n'est pas la plus élégante ni la plus efficace.
	 * Cependant, elle nous semble suffisante pour respecter le périmètre de ce projet.
	 * 
	 * @param String pString
	 * 
	 * @return String le terme accordé au pluriel
	 */
	private String accorder(String pString) {
		String nReturn= pString;
		
		switch(nReturn) { // cette liste n'est pas exhaustive
			case "beurre":			case "de beurre":
			case "de curry":
			case "eau":				case "d'eau":
			case "g":
			case "l":
			case "de lait":
			case "de levure":
			case "de moutarde":
			case "noix":
			case "d'oeuf":
			case "de poivre":
			case "de poulet":
			case "radis":			case "de radis":
			case "riz":				case "de riz":
			case "safran":			case "de safran":
			case "sel":				case "de sel":
			case "sucre":			case "de sucre":
			case "sucre vanillé":	case "de sucre vanillé":
			case "de vanille":
				break;
				
			case "cuillère à café":
				nReturn= "cuillères à café";
				break;
			case "cuillère à soupe":
				nReturn= "cuillères à café";
				break;
				
			default: nReturn+= "s";
		} // switch
		
	return nReturn;
	} // String
	
	/** 
	 * @return String le nom destiné à l'affichage
	 */
	private String afficherNom() {

		String nReturn= "";
		if(!this.nom.isEmpty()) {
			
			if (this.unite.isEmpty()) {
				nReturn= this.nom;
				// affichage du pluriel
				if((this.quantite <= -2) || (this.quantite >= 2)) {
					nReturn= this.accorder(nReturn);
				} // if
				
			} else {
				// si le nom commence par aehiouy alors on apostrophe l'article partitif de
				Pattern nPatternA = Pattern.compile("^[aehiouy].*");  
				Matcher nMatcherA = nPatternA.matcher(this.nom);
				nReturn= (nMatcherA.find())? "d'" : "de ";
				nReturn+= this.nom;
				
				// affichage du pluriel
				nReturn= this.accorder(nReturn);
			} // else
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
	return " > " + this.nettoyerEspace(this.quantite + " " + this.afficherUnite() + " " + this.afficherNom());
	} // String

	/**
	 * @brief Cette fonction main() est utilisée uniquement pour la réalisation de tests unitaires.
	 * 
	 * Le périmètre observé est limité à l'ensemble des opérations de cette classe.
	 */
	public static void main(String[] args) {
		
		// ---------------------------------------------------------------------------------------
		// jeu de test
			System.out.println("création d'un jeu de test");
			Aliment nAlimentA = new Aliment(4,"oeuf");
			Aliment nAlimentB = new Aliment(1,"l","lait");
			Aliment nAlimentC = new Aliment(5,"cuillère à café","curry");			
			Aliment nAlimentD = new Aliment(2,"sachet ","sucre vanillé");
			Aliment nAlimentE = new Aliment(1," botte","radis");
			Aliment nAlimentF = new Aliment(2," botte","radis");
			Aliment nAlimentG = new Aliment(1," botte ","carotte");
			Aliment nAlimentH = new Aliment(2," botte ","carotte");
			Aliment nAlimentI = new Aliment(4,"poulet");
			Aliment nAlimentJ = new Aliment(40,"g","  poulet");
			Aliment nAlimentK = new Aliment(30,"g","beurre   ");
			Aliment nAlimentL = new Aliment(2,"noix","     beurre   ");
		
		// ---------------------------------------------------------------------------------------
		// test toString
			System.out.println("\ntest de la fonction toString() =-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=");
			
			System.out.println(" > nAlimentA.toString() retourne : "+ nAlimentA.toString());
			System.out.println(" > nAlimentB.toString() retourne : "+ nAlimentB.toString());
			System.out.println(" > nAlimentC.toString() retourne : "+ nAlimentC.toString());
			System.out.println(" > nAlimentD.toString() retourne : "+ nAlimentD.toString());
			System.out.println(" > nAlimentE.toString() retourne : "+ nAlimentE.toString());
			System.out.println(" > nAlimentF.toString() retourne : "+ nAlimentF.toString());
			System.out.println(" > nAlimentG.toString() retourne : "+ nAlimentG.toString());
			System.out.println(" > nAlimentH.toString() retourne : "+ nAlimentH.toString());
			System.out.println(" > nAlimentI.toString() retourne : "+ nAlimentI.toString());
			System.out.println(" > nAlimentJ.toString() retourne : "+ nAlimentJ.toString());
			System.out.println(" > nAlimentK.toString() retourne : "+ nAlimentK.toString());
			System.out.println(" > nAlimentL.toString() retourne : "+ nAlimentL.toString());
		
		// ---------------------------------------------------------------------------------------
		// test equals
			System.out.println("\ntest de la fonction equals() =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
			if(nAlimentA.equals("oeuf")) System.out.println(" > l'objet " +nAlimentA.getNom()+ " est égal à l'aliment nommé oeuf");
			if(!nAlimentA.equals("lait")) System.out.println(" > l'objet " +nAlimentA.getNom()+ " n'est pas égal à l'aliment nommé lait");
		
			Aliment nAlimentX= nAlimentA;
			if(nAlimentA.equals(nAlimentX)) System.out.println(" > l'objet "+nAlimentA.getNom()+" est égal à l'objet "+nAlimentX.getNom());
			
			Aliment nAlimentY= new Aliment(8,"tomate");
			if(!nAlimentA.equals(nAlimentY)) System.out.println(" > l'objet "+nAlimentA.getNom()+" n'est pas égal à l'objet "+nAlimentY.getNom());

	} // main
} // class
