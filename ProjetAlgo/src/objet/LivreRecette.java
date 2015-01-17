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
		
		Recette nRecette= (Recette)this.liste.rechercher(this.liste, pNomRecette);
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
	 * vérifier si l'ensemble des ingrédients existent en quantité suffisante pour réaliser la première recette
	 * 
	 * @param ListeRec pListe, GardeManger pGardeManger
	 * 
	 * @return Recette si tous les ingrédients existent en quantité suffisante, sinon null
	 */
	public Recette premiereRecette(ListeRec pListe, GardeManger pGardeManger) {
		Recette nReturn= null;
		
		if(!pListe.isVide()){
			ListeRec nIngredients= ((Recette)pListe.getTete()).getIngredients();
			
			if(pGardeManger.verifierIngredients(nIngredients)) {
				nReturn= (Recette)pListe.getTete();
				
			} else {
				if (pListe.getReste() != null)
					nReturn= this.premiereRecette(pListe.getReste(), pGardeManger);

			} // else
		} // if
		
	return nReturn;
	} // Recette
	
	/**
	 * renvoyer la liste des ingrédients de la recette
	 * 
	 * @param String pNomRecette
	 * 
	 * @return ListeRec pour renvoyer la liste des ingrédients de la recette, sinon null
	 */
	public ListeRec retournerIngredients(String pNomRecette) {
		
		Recette nRecette= (Recette)this.liste.rechercher(this.liste, pNomRecette);

		if(nRecette == null) {
			return null;
			
		} else {
			return nRecette.getIngredients();

		} // else
	} // ListeRec
	
	/**
	 * @brief surcharge de la fonction
	 * 
	 * @return String: description complète du livre de recette (nom du livre et description de chaque recette)
	 */
	public String toString() {
		String nReturn= "livre de recette: "+this.nom+":\n";
		nReturn+= this.liste.toString();

	return nReturn;
	} // String
public static void main(String[] args) {
		

		Aliment nAlimentA = new Aliment(300,"g","farine");
		Aliment nAlimentB = new Aliment(300,"g","sucre");
		Aliment nAlimentC = new Aliment(30,"g","beurre");			
		Aliment nAlimentD = new Aliment(4,"","oeuf");
		Aliment nAlimentE = new Aliment(1,"sachet","sucre vanillé");
		Aliment nAlimentF = new Aliment(1,"l","lait");
		Aliment nAlimentG = new Aliment(1,"","poulet");
		Aliment nAlimentH = new Aliment(5,"c","curry");
		Aliment nAlimentI = new Aliment(300,"g","carottes");
		Aliment nAlimentJ = new Aliment(200,"g","courgettes");
		Aliment nAlimentK = new Aliment(100,"g","épinards");
		Aliment nAlimentL = new Aliment(1000,"g","pommes");
		Aliment nAlimentM = new Aliment(500,"g","sucre");
		Aliment nAlimentN = new Aliment(1000,"g","miel");
		Aliment nAlimentO = new Aliment(500,"g","pate");
		
		// Pates au beurre
		String nomA = "Pates au beurre";
		String descriptifA =  "Faire chauffer les casseroles.\n Faire bouillir l'eau. \n Mettre les pates, quand c'est cuit mettre le beurre.";
				
		Recette nRecetteA = new Recette(nomA, descriptifA);
		nRecetteA.ajouterIngredient(nAlimentO);
		nRecetteA.ajouterIngredient(nAlimentC);
				
		// Gateau au yaourt
		String nomB = "Gateau au yaourt";
		String descriptifB =  "Mettre la farine, les oeufs, le sucre et le lait suivi du sucre vanillé, puis mettre au four. ";
						
		Recette nRecetteB = new Recette(nomB, descriptifB);
		nRecetteB.ajouterIngredient(nAlimentA);
		nRecetteB.ajouterIngredient(nAlimentB);
		nRecetteB.ajouterIngredient(nAlimentF);
		nRecetteB.ajouterIngredient(nAlimentD);
		nRecetteB.ajouterIngredient(nAlimentE);
				
		// Poulet au curry
		String nomC = "Poulet au curry";
		String descriptifC =  "Mettre au four le poulet soupoudré de curry.";
								
		Recette nRecetteC = new Recette(nomC, descriptifC);
		nRecetteC.ajouterIngredient(nAlimentG);
		nRecetteC.ajouterIngredient(nAlimentH);
				
		// Soupe de légumes
		String nomD = "Soupe de légumes";
		String descriptifD =  "Mixer tout les légumes et faire cuire puis ajouter le beurre.";
								
		Recette nRecetteD = new Recette(nomD, descriptifD);
		nRecetteD.ajouterIngredient(nAlimentI);
		nRecetteD.ajouterIngredient(nAlimentJ);
		nRecetteD.ajouterIngredient(nAlimentK);
		nRecetteD.ajouterIngredient(nAlimentC);
				
		// Compotte de pomme
		String nomE = "Compotte de pomme";
		String descriptifE =  "Mixer toutes les pommes et faire cuire puis ajouter le sucre.";
								
		Recette nRecetteE = new Recette(nomE, descriptifE);
		nRecetteE.ajouterIngredient(nAlimentL);
		nRecetteE.ajouterIngredient(nAlimentM);
				
		// Poulet au miel
		String nomF = "Poulet au miel";
		String descriptifF =  "Faire cuire le poulet et arroser de miel";
								
		Recette nRecetteF = new Recette(nomF, descriptifF);
		nRecetteF.ajouterIngredient(nAlimentG);
		nRecetteF.ajouterIngredient(nAlimentN);
				
		// Création du livre de recette
				
		LivreRecette nLivreRecette = new LivreRecette("Thermomix");
		nLivreRecette.ajouterRecette(nRecetteA);
		nLivreRecette.ajouterRecette(nRecetteB);
		nLivreRecette.ajouterRecette(nRecetteC);
		nLivreRecette.ajouterRecette(nRecetteD);
		nLivreRecette.ajouterRecette(nRecetteE);
		nLivreRecette.ajouterRecette(nRecetteF);		
		
		nLivreRecette.afficher();
	
		System.out.println("Afficher une recette présente par son nom");
		nLivreRecette.afficher("Compotte de pomme");
		
		System.out.println("Afficher une recette non présente par son nom");
		nLivreRecette.afficher("Compotte");
		
		
	}
} // class








