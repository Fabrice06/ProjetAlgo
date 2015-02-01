/**
 * @file Aliment.java
 * 
 * @brief triplet constitué d'un nom, d'une quantité et d'une unité
 */
	
package com.algo.marmiton.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @brief Cette classe permet de manipuler un aliment.
 * 
 * @details	Cet objet est défini par les éléments suivants:
 *  		<ul>
 *  			<li>une quantité,
 *  			<li>une unité,
 *  			<li>un nom.
 *  		</ul>
 */
public class Aliment {

	// ------------------------------------------------------
	// Constantes
	
	private final static String REGEX_MASSE= "^(k|h|da|d|c|m){0,1}g$";
	private final static String REGEX_VOLUME= "^(k|h|da|d|c|m){0,1}l$";
	// les deux listes suivantes ne sont pas exhaustives
	private final static String REGEX_MASSE_OPIF= "^(cuillère à café|cuillère à soupe|verre|doigt|pincée|noix|livre)$";
	private final static String REGEX_VOLUME_OPIF= "^(cuillère à café|cuillère à soupe|verre|doigt|zeste)$";
	
	// ------------------------------------------------------
	// Attributs
	
	private double quantite;
	private String unite;
	private String nom;

	// ------------------------------------------------------
	// Constructeurs

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
	 * @brief Eviter une succession de constructeurs
	 * 
	 * @param int pQuantite, String pUnite, String pNom
	 */
	private void construire(int pQuantite, String pUnite, String pNom){
		this.quantite= pQuantite;
		this.unite= pUnite.trim().toLowerCase();
		this.nom= pNom.trim();
	} // procédure
	
	
	// ------------------------------------------------------
	// Accesseurs
	
	/**
	 * @return integer pour la quantité
	 */
	public double getQuantite() {
		return quantite;
	} // double
	/**
	 * @param int pQuantite
	 */
	private void setQuantite(double pQuantite) {
		this.quantite = pQuantite;
	} // setter

	/**
	 * @return String pour l'unité de l'ingrédient
	 */
	public String getUnite() {
		return unite;
	} // String
	
	
	// ------------------------------------------------------
	// Méthodes

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
	 * @details Cette implémentation bien que correcte sur le plan technique, n'est pas la plus élégante ni la plus efficace.
	 * 			Cependant, elle nous semble suffisante pour respecter le périmètre de ce projet.
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
				nReturn= (this.regexFind("^[aehiouy].*", this.nom))? "d'" : "de ";
				nReturn+= this.nom;
				
				// affichage du pluriel
				nReturn= this.accorder(nReturn);
			} // else
		} // if

	return nReturn;
	} // String
	
	/**
	 * @param Aliment pAliment
	 * 
	 * @return boolean vrai, si la quantité a été mise à jour
	 */
	public boolean ajouterQuantite(Aliment pAliment) {
		
		// pas de recherche d'unité, ni de conversion
		if (this.unite.equals(pAliment.unite)) {
			
			this.quantite+= pAliment.quantite;
			return true;
		} // if
		
		
		
	return false;
	} // boolean
	
	/**
	 * @brief  XXXXXXXXXX
	 * 
	 * @detail Les aliments dont la quantité est exprimée à la pièce, seront comparés entre eux.  
	 * 			Les aliments solides dont la quantité est exprimée en unités de masse, seront comparés entre eux.
	 * 			Les aliments liquides dont la quantité est exprimée en unités de volume, seront comparés entre eux.<br/>
	 * 			Voici ce que l'on propose de comparer:
	 * 			<ul>
	 * 				<li> 1 oeuf avec 10 oeufs,
	 * 				<li> 1 botte de carottes avec 2 bottes de carottes,
	 * 				<li> 30cl de lait avec 1l de lait,
	 * 				<li> 1g de sucre avec 2kg de sucre.
	 * 			</ul>
	 * 			Mais encore:
	 * 			<ul>
	 * 				<li> 500g de beurre avec une livre de beurre,
	 * 				<li> 1 cuillère à soupe de moutarde avec 125g de moutarde,
	 * 				<li> 1 cuillère à soupe d'huile avec 200cl d'huile.
	 * 			</ul>
	 * 			Enfin, voici des exemples qui ne seront pas pris en compte:
	 * 			<ul>
	 * 				<li> 20g de poulet avec 1 poulet,
	 * 				<li> 1 carotte avec 2 bottes de carottes,
	 * 				<li> 30g de lait avec 1l de lait,
	 * 				<li> 1g de sucre avec 2l de sucre,
	 * 			</ul>
	 * 
	 * @param Aliment pAliment
	 * 
	 * @return boolean vrai, si l'aliment est contenu dans le pAliment
	 */
	public boolean estContenuDans(Aliment pAliment) {

		// pas de recherche d'unité, ni de conversion
		if (this.unite.equals(pAliment.unite)) {
			
			return (this.quantite <= pAliment.quantite);
		} // if
		
		if((this.regexFind(REGEX_MASSE, this.unite)) && (this.regexFind(REGEX_VOLUME, this.unite))) {
			return false;
		}
		if((this.regexFind(REGEX_VOLUME, this.unite)) && (this.regexFind(REGEX_MASSE, this.unite))) {
			return false;
		}
		
		// la première unité à comparer est une masse
		if(this.regexFind(REGEX_MASSE, this.unite)) {
			
			// la seconde unité à comparer est une masse
			if(pAliment.regexFind(REGEX_MASSE, pAliment.unite)) {
				
				return ((this.quantite*this.convertir(this.unite)) <= (pAliment.quantite*pAliment.convertir(pAliment.unite)));
			} // if
			
			// la seconde unité à comparer est une masse à estimer 
			if(pAliment.regexFind(REGEX_MASSE_OPIF, pAliment.unite)) {
				
				return ((this.quantite*this.convertir(this.unite)) <= (pAliment.quantite*pAliment.estimerMasse(pAliment.unite)));
			} // if
		} // if

		// la première unité à comparer est un volume
		if(this.regexFind(REGEX_VOLUME, this.unite)) {
			
			// la seconde unité à comparer est un volume
			if(pAliment.regexFind(REGEX_VOLUME, pAliment.unite)) {
				
				return ((this.quantite*this.convertir(this.unite)) <= (pAliment.quantite*pAliment.convertir(pAliment.unite)));
			} // if
			
			// la seconde unité à comparer est un volume à estimer
			if(pAliment.regexFind(REGEX_VOLUME_OPIF, pAliment.unite)) {
				
				return ((this.quantite*this.convertir(this.unite)) <= (pAliment.quantite*pAliment.estimerVolume(pAliment.unite)));
			} // if
		} // if
		
		// la première unité à comparer est une masse à estimer
		if(this.regexFind(REGEX_MASSE_OPIF, this.unite)) {

			// la seconde unité à comparer est une masse
			if(pAliment.regexFind(REGEX_MASSE, pAliment.unite)) {
				
				return ((this.quantite*this.estimerMasse(this.unite)) <= (pAliment.quantite*pAliment.convertir(pAliment.unite)));
			} // if

			// la seconde unité à comparer est une masse à estimer 
			if(pAliment.regexFind(REGEX_MASSE_OPIF, pAliment.unite)) {
				
				return ((this.quantite*this.estimerMasse(this.unite)) <= (pAliment.quantite*pAliment.estimerMasse(pAliment.unite)));
			} // if
		} // if

		// la première unité à comparer est un volume à estimer
		if(this.regexFind(REGEX_VOLUME_OPIF, this.unite)) {

			// la seconde unité à comparer est un volume
			if(pAliment.regexFind(REGEX_VOLUME, pAliment.unite)) {
				
				return ((this.quantite*this.estimerVolume(this.unite)) <= (pAliment.quantite*pAliment.convertir(pAliment.unite)));
			} // if

			// la seconde unité à comparer est un volume à estimer
			if(pAliment.regexFind(REGEX_VOLUME_OPIF, pAliment.unite)) {
				
				return ((this.quantite*this.estimerVolume(this.unite)) <= (pAliment.quantite*pAliment.estimerVolume(pAliment.unite)));
			} // if
		} // if
		
	return false; // valeur par défaut
	} // boolean

	/**
	 * @param String pUnite
	 * 
	 * @return double, utilisé dans la conversion en gramme
	 */
	private double estimerMasse(String pUnite) {
		double nReturn= 1.00;

		switch(pUnite) {
			case "cuillère à café":		nReturn= 5;		break; 
			case "cuillère à soupe":	nReturn= 15;	break; 
			case "pincée":				nReturn= 0.4;	break; 
			case "verre":				nReturn= 200;	break; 
			case "doigt":				nReturn= 20;	break; 
			case "noix":				nReturn= 15;	break; 
			case "livre":				nReturn= 500;	break; 
		} // switch

	return nReturn;
	} // double	

	/**
	 * @param String pUnite
	 * 
	 * @return double, utilisé dans la conversion en litre
	 */
	private double estimerVolume(String pUnite) {
		double nReturn= 1.00;

		switch(pUnite) {
			case "cuillère à café":		nReturn= 0.005;	break; 
			case "cuillère à soupe":	nReturn= 0.015;	break; 
			case "zeste":				nReturn= 0.015;	break;
			case "verre":				nReturn= 0.25;	break; 
			case "doigt":				nReturn= 0.025;	break;
		} // switch

	return nReturn;
	} // double	
	
	/**
	 * @param String pUnite
	 * 
	 * @return double, utilisé dans la conversion en gramme ou en litre
	 */
	private double convertir(String pUnite) {
		double nReturn= 1.00;
		String nUnite= pUnite.substring(0, pUnite.length()-1);
		
		switch(nUnite) {
			case "k":	nReturn= 1000;	break;
			case "h":	nReturn= 100;	break;
			case "da":	nReturn= 10;	break;
			case "d":	nReturn= 0.1;	break;
			case "c":	nReturn= 0.01;	break;
			case "m":	nReturn= 0.001;	break;
		} // switch

	return nReturn;
	} // double	
	
	/**
	 * @param String pPattern, String pString
	 * 
	 * @return boolean vrai, si la chaîne de caractère pString correspond à l'expression régulière pPattern
	 */
	private boolean regexFind(String pPattern, String pString) {
		Pattern nPattern = Pattern.compile(pPattern);  
		Matcher nMatcher = nPattern.matcher(pString);
	return nMatcher.find();
	} // boolean
	
	/**
	 * @brief surcharge de la fonction
	 * 
	 * @details Pour que deux objets de cette classe soient égaux, il faut réunir les conditions suivantes:
	 *   		<ul>
	 *   			<li> être de même type (pObj instanceof Aliment),
	 *   			<li> avoir le même nom.
	 *   		</ul>
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
		if(pObj instanceof Aliment) return this.nom.equals(((Aliment)pObj).nom);

		return false;
    } // boolean

	/**
	 * @brief surcharge de la fonction
	 * 
	 * @details Comme la méthode equals() est redéfinie, il est nécessaire de redéfinir la méthode hashCode()
	 * 			pour respecter le contrat qui précise que deux objets égaux doivent avoir le même hashcode.
	 *   
	 * @return int valeur de hash calculée
	 */
	public int hashCode() {
		
		final int nPremier= 31; // nombre premier
	    int nReturn= 1;
	    
	    nReturn = nPremier * nReturn + ((nom == null)? 0 : nom.hashCode());
	    // attention si quantite n'est pas un double il faut le caster
	    nReturn = nPremier * nReturn + (int)(quantite);

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

} // class
