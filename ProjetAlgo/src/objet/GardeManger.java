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
			this.liste= this.liste.insert(this.liste, pProduit);
			
		} else { 
			if(pProduit.getUnite().equals(nAliment.getUnite())) { // mise à jour produit
				nAliment.setQuantite(nAliment.getQuantite()+pProduit.getQuantite());
				
			} else { // nouveau produit avec une unité différente (carottes en gramme ou en botte)
				this.liste= this.liste.insert(this.liste, pProduit);
			}
		} // else
	} // void
	
	/**
	 * afficher tous les produits du garde-manger
	 */
	public void afficher() {
		System.out.println(this.toString());
	} // void

	/**
	 * afficher un produit, s'il existe
	 * 
	 * @param String pNomProduit
	 */
	public void afficher(String pNomProduit) {
		Aliment nAliment= (Aliment)this.liste.rechercher(this.liste, pNomProduit);
		String nMsg= "";
		
		if(nAliment == null){
			nMsg= "Ce produit n'est pas référencé dans le garde-manger !\n > "+pNomProduit;
			
		} else {
			nMsg= "Ce produit existe bien dans le garde-manger";
			if (nAliment.isVide()) nMsg+= ", mais... il faut l'approvisionner"; 
			nMsg+= " !\n";
			nMsg+= nAliment.toString();
		} // else
		
		System.out.println(nMsg);
	} // void
	
	/**
	 * @brief afficher si le produit est présent en quantité suffisante
	 * 
	 * @param Aliment pProduit
	 */
	public void afficherQuantiteProduit(Aliment pProduit) {
		
		Aliment nAliment= (Aliment)this.liste.rechercher(this.liste, pProduit);
		
		if(nAliment == null) {
			System.out.println("Ce produit n'est pas référencé dans le garde-manger !\n"+pProduit.toString());

		} else {
			if(pProduit.getUnite().equals(nAliment.getUnite())) {
				
				if(pProduit.getQuantite() <= nAliment.getQuantite()) {
					System.out.println("Ce produit est présent en quantité suffisante:\n"
							+pProduit.toString()+" pour "+nAliment.getQuantite()+" "+nAliment.afficherUnite()
							+" dans le garde-manger.");
					
				} else {
					System.out.println("Ce produit n'est pas présent en quantité suffisante:\n"
							+pProduit.toString()+" pour "+nAliment.getQuantite()+" "+nAliment.afficherUnite()
							+" dans le garde-manger.");
				} // else
					
			} else {
				System.out.println("Ce produit est référencé avec une unité différente:\n"
						+pProduit.toString()+" pour "+nAliment.getQuantite()+" "+nAliment.afficherUnite()
						+" dans le garde-manger.");
			} // else
		} // else
	} // void
	
	/**
	 * vérifier si un produit existe en quantité suffisante
	 * 
	 * @param Aliment pProduit
	 * 
	 * @return boolean vrai, si le produit existe en quantité suffisante dans une même unité de mesure
	 */
	private boolean verifierQuantiteProduit(Aliment pProduit) {

		Aliment nAliment= (Aliment)this.liste.rechercher(this.liste, pProduit);
		
		if(nAliment == null) {
			return false;

		} else {
			return (pProduit.getUnite().equals(nAliment.getUnite()) & (pProduit.getQuantite() <= nAliment.getQuantite()));
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
	 * @brief Cette fonction main() est utilisée uniquement pour la réalisation de tests unitaires.
	 * 
	 * Le périmètre observé est limité à l'ensemble des opérations de cette classe.
	 */
	public static void main(String[] args) {

		// créer un garde-manger
			System.out.println("création d'un garde-manger");
			GardeManger nGardeManger= creerGardeManger();

		// afficher l'ensemble du garde-manger
			System.out.println();
			nGardeManger.afficher();
				
		// afficher un ingrédient présent dans le garde-manger
			System.out.println("afficher un ingrédient présent dans le garde-manger:");
			nGardeManger.afficher("sucre");

		// afficher tous les ingrédients présents dans le garde-manger (carotte en gramme et en botte)
			System.out.println("\nafficher tous les ingrédients présents dans le garde-manger:");
			nGardeManger.afficher("carotte");
			
		// afficher un ingrédient absent du garde-manger
			System.out.println("\nafficher un ingrédient absent du garde-manger:");
			nGardeManger.afficher("safran");

			
		// créer un livre de recettes
			System.out.println("\ncréation d'un livre de recette");
			LivreRecette nLivreRecette= creerLivreRecette();
		

		System.out.print("\ntest pour un aliment en quantité suffisante:\n");
		if (nGardeManger.verifierQuantiteProduit(new Aliment(800,"g","café"))){
			System.out.println("Suffisant");
		}else{
			System.out.println("Insuffisant");
		}

		System.out.print("\ntest pour un aliment en quantité insuffisante:\n");
		if (nGardeManger.verifierQuantiteProduit(new Aliment(1000,"g","café"))){
			System.out.println("Suffisant");
		}else{
			System.out.println("Insuffisant");
		}

		System.out.print("\nafficher la quantité d'un produit:\n");
		//afficherQuantiteProduit
		
		Recette nRecetteA= creerRecetteB();
		System.out.print("\ntest pour une liste d'aliments en quantité suffisante:\n ");
		if (nGardeManger.verifierIngredients(nRecetteA.getIngredients())){
			System.out.println("Suffisant");
		}else{
			System.out.println("Insuffisant");
		}
		
		Recette nRecetteB= creerRecetteA();
		System.out.print("\ntest pour une liste d'aliments en quantité insuffisante:\n");
		if (nGardeManger.verifierIngredients(nRecetteB.getIngredients())){
			System.out.println("Suffisant");
		}else{
			System.out.println("Insuffisant");
		}
		
		System.out.print("\ntest pour une trouver la première recette réalisable:\n");
		Recette nRecette= nGardeManger.premiereRecette(nLivreRecette.getListe());
		if(nRecette == null) {
			System.out.println("Aucune recette ne peut-être réalisée avec ce garde-manger !");
			
		} else {
			System.out.println("\nVoici la première recette qui peut-être réalisée:\n"
					+nRecette.toString());
		} // else

		
	} // main

	/**
	 * @brief créer un garde-manger (à utiliser pour les tests uniquement)
	 * 
	 * @return LivreRecette une nouveau garde-manger
	 */
	private static GardeManger creerGardeManger() {

		GardeManger nGardeManger= new GardeManger();
			nGardeManger.ajouterProduit(new Aliment(300,"g","farine"));
			nGardeManger.ajouterProduit(new Aliment(300,"g","sucre"));
			nGardeManger.ajouterProduit(new Aliment(30,"g","beurre"));			
			nGardeManger.ajouterProduit(new Aliment(4,"oeuf"));
			nGardeManger.ajouterProduit(new Aliment(1,"sachet","sucre vanillé"));
			nGardeManger.ajouterProduit(new Aliment(1,"l","lait"));
			nGardeManger.ajouterProduit(new Aliment(30,"g","carotte"));
			nGardeManger.ajouterProduit(new Aliment(1,"botte","carotte"));
			
	return nGardeManger;
	} // GardeManger

	/**
	 * @brief créer un livre de recettes (à utiliser pour les tests uniquement)
	 * 
	 * @return LivreRecette une nouvelle recette
	 */
	private static LivreRecette creerLivreRecette() {
		String nNom= "Thermomix";

		LivreRecette nLivreRecette= new LivreRecette(nNom);
			nLivreRecette.ajouterRecette(creerRecetteA());
			nLivreRecette.ajouterRecette(creerRecetteB());
			nLivreRecette.ajouterRecette(creerRecetteC());
		
	return nLivreRecette;
	} // LivreRecette

	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes (à utiliser pour les tests uniquement)
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteA() {
		String nNom= "Pates au beurre";
		String nDescription= " Faire chauffer les casseroles.\n Faire bouillir l'eau.\n Mettre les pates, quand c'est cuit mettre le beurre.";
		
		Recette nRecette= new Recette(nNom, nDescription);
			nRecette.ajouterIngredient(new Aliment(500,"g","pate"));
			nRecette.ajouterIngredient(new Aliment(30,"g","beurre"));
		
	return nRecette;
	} // Recette

	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes (à utiliser pour les tests uniquement)
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteB() {
		String nNom= "Gateau au yaourt";
		String nDescription= " Mettre la farine, les oeufs, le sucre et le lait suivi du sucre vanillé, puis mettre au four.";
		
		Recette nRecette= new Recette(nNom, nDescription);
			nRecette.ajouterIngredient(new Aliment(300,"g","farine"));
			nRecette.ajouterIngredient(new Aliment(300,"g","sucre"));
			nRecette.ajouterIngredient(new Aliment(1,"l","lait"));
			nRecette.ajouterIngredient(new Aliment(4,"oeuf"));
			nRecette.ajouterIngredient(new Aliment(1,"sachet","sucre vanillé"));
		
	return nRecette;
	} // Recette
	
	/**
	 * @brief créer une nouvelle recette pour alimenter le livre de recettes (à utiliser pour les tests uniquement)
	 * 
	 * @return Recette une nouvelle recette
	 */
	private static Recette creerRecetteC() {
		String nNom= "Poulet au curry";
		String nDescription= " Mettre au four le poulet saupoudré de curry.";
		
		Recette nRecette= new Recette(nNom, nDescription);
			nRecette.ajouterIngredient(new Aliment(1,"poulet"));
			nRecette.ajouterIngredient(new Aliment(5,"cuillère à café","curry"));
		
	return nRecette;
	} // Recette
	
} // class








