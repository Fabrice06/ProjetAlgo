/**
 * @file ListeRec.java
 * 
 * @brief xxxxxxxxxxxxxxxxxxxx
 */
	
	package include;

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
	
//	/**
//	 * @return ListeRec pour renvoyer la liste obtenue après insertion d'un objet en fin
//	 */	
//	public void ajouter(Object pObject){
//		this.insert(this.leReste, pObject);
//	} // procédure
	
////	Affiche un ingrédient d'un liste par son nom
//	public void afficherIngredientSiPrésent(String nom){
//		if (!(this.listeVide)){
//			if (this.laTete.getNom().equals(nom)){
//				this.laTete.afficherIngredient();
//			}else{
//				if (this.getLeReste() != null) {
//					this.getLeReste().afficherIngredientSiPrésent(nom);
//				}else{
//					System.out.println("L'ingrédient n'est pas présent.");
//				}
//			}
//		}
//	}
	
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


//	/**
//	 * @return booléen vrai, si un ingrédient se trouve dans la liste en quantitée suffisante
//	 */	
//	public boolean appartenance(Object val){
//		if (this.isListeVide()){
//			return false;
//		}else{
//			if ((this.getLaTete().getNom() == val.getNom())&(this.getLaTete().getQte()>=val.getQte())){
//				return true;
//			}else{
//				return this.getLeReste().appartenance(val);
//			}
//		}
//	}

} // class
