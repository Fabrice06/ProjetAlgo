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
		boolean nReturn= pIngredients.isVide();

		if(!nReturn){
			
			if(this.verifierQuantiteProduit((Aliment)pIngredients.getTete())){

				if (pIngredients.getReste() != null){
					nReturn= this.verifierIngredients(pIngredients.getReste());
				} // if
				
//			} else {
//				nReturn= false;
			}
		} // if
		
	return nReturn;
	} // boolean
	
	/**
	 * @brief surcharge de la fonction
	 * 
	 * @return description complète de l'objet
	 */
	public String toString() {
		String nReturn= "Inventaire du garde-manger:\n";
		nReturn+= this.liste.toString();

	return nReturn;
	} // String
	
	
	/**
	 * Trouver la première recette possible en fonction du garde manger
	 * 
	 * @param ListeRec pListe
	 * 
	 * @return Recette si tous les ingrédients existent en quantité suffisante, sinon null
	 */
	public Recette premiereRecette(ListeRec pListe) {
		Recette nReturn= null;
		
		if(!pListe.isVide()){
			ListeRec nIngredients= ((Recette)pListe.getTete()).getIngredients();
			
			if(this.verifierIngredients(nIngredients)) {
				nReturn= (Recette)pListe.getTete();
				
			} else {
				if (pListe.getReste() != null)
					nReturn= this.premiereRecette(pListe.getReste());

			} // else
		} // if
		
	return nReturn;
	} // Recette
	
	
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
		
		
		
		
		Aliment nAlimentP = new Aliment(800,"g","café");
		Aliment nAlimentQ = new Aliment(300,"g","café");
		
		GardeManger nGardeManger = new GardeManger();
		nGardeManger.ajouterProduit(new Aliment(1000,"g","farine"));
		nGardeManger.ajouterProduit(new Aliment(2000,"g","sucre"));
		nGardeManger.ajouterProduit(new Aliment(0,"l","lait"));
		nGardeManger.ajouterProduit(new Aliment(3000,"g","beurre"));
		nGardeManger.ajouterProduit(new Aliment(2,"g","safran"));	
		nGardeManger.ajouterProduit(new Aliment(500,"g","farine"));
		nGardeManger.ajouterProduit(new Aliment(600,"g","tofu"));
		nGardeManger.ajouterProduit(new Aliment(300,"g","carotte"));
		nGardeManger.ajouterProduit(new Aliment(250,"g","tomate"));
		nGardeManger.ajouterProduit(nAlimentC);
		nGardeManger.ajouterProduit(nAlimentO);
		
		Recette nRecetteP = new Recette("TestA","Test de recette A");
		nRecetteA.ajouterIngredient(new Aliment(1000,"g","farine"));
		nRecetteA.ajouterIngredient(new Aliment(2000,"g","sucre"));
		
		Recette nRecetteQ = new Recette("TestB","Test de recette B");
		nRecetteB.ajouterIngredient(new Aliment(2000,"g","farine"));
		nRecetteB.ajouterIngredient(new Aliment(1000,"g","sucre"));
	
		// test
		nGardeManger.afficher();
		
		System.out.println("Test d'affichage d'un ingrédient du garde mangé :");
		nGardeManger.afficher("café");
		
		System.out.println();
		System.out.println("Test pour un aliment non présent :");
		nGardeManger.afficher("miel");
		
		System.out.println();
		System.out.print("Test pour un aliment en quantité suffisante : ");
		if (nGardeManger.verifierQuantiteProduit(nAlimentC)){
			System.out.println("Suffisant");
		}else{
			System.out.println("Insuffisant");
		}
		
		System.out.println();
		System.out.print("Test pour un aliment en quantité insuffisante : ");
		if (nGardeManger.verifierQuantiteProduit(nAlimentA)){
			System.out.println("Suffisant");
		}else{
			System.out.println("Insuffisant");
		}
		
		System.out.println();
		System.out.print("Test pour une liste d'aliments en quantité suffisante : ");
		if (nGardeManger.verifierIngredients(nRecetteA.getIngredients())){
			System.out.println("Suffisant");
		}else{
			System.out.println("Insuffisant");
		}
		
		System.out.println();
		System.out.print("Test pour une liste d'aliments en quantité insuffisante : ");
		if (nGardeManger.verifierIngredients(nRecetteB.getIngredients())){
			System.out.println("Suffisant");
		}else{
			System.out.println("Insuffisant");
		}
		
		System.out.println();
		
		if (nGardeManger.premiereRecette(nLivreRecette.getListe()) != null){
			System.out.println("Première recette possible !!!");
			nGardeManger.premiereRecette(nLivreRecette.getListe()).afficher();
		}else{
			System.out.println("Aucune rectte possible");
		}
		
	}
} // class








