package include;

import objet.Aliment;
import objet.LivreRecette;
import objet.Recette;

public class Creation {
	
	public void creationAliments(){

// Création d'ingrédients
		
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
		Aliment nAlimentO = new Aliment(300,"g","café");
		Aliment nAlimentP = new Aliment(1,"l","vinaigre");
		Aliment nAlimentQ = new Aliment(1,"l","miel");
		Aliment nAlimentR = new Aliment(300,"g","café");
		Aliment nAlimentS = new Aliment(1,"l","vinaigre");
		Aliment nAlimentT = new Aliment(1,"l","miel");
		Aliment nAlimentU = new Aliment(300,"g","café");
		Aliment nAlimentV = new Aliment(1,"l","vinaigre");
		Aliment nAlimentW = new Aliment(1,"l","miel");
		Aliment nAlimentX = new Aliment(1,"l","vinaigre");
		Aliment nAlimentY = new Aliment(1,"l","miel");
		Aliment nAlimentZ = new Aliment(300,"g","café");		
	
		
// Création des recettes

		// Pates au beurre
		String nomA = "Pates au beurre";
		String descriptifA =  "Faire chauffer les casseroles.\n Faire bouillir l'eau. \n Mettre les pates, quand c'est cuit mettre le beurre.";
		
		Recette nRecetteA = new Recette(nomA, descriptifA);
		nRecetteA.ajouterIngredient(nAlimentG);
		nRecetteA.ajouterIngredient(nAlimentC);
		
		// Gateau au yaourt
		String nomB = "Gateau au yaourt";
		String descriptifB =  "Mettre la farine, les oeufs, le sucre et le lait suivi du sucre vanillé, puis mettre au four. ";
				
		Recette nRecetteB = new Recette(nomB, descriptifB);
		nRecetteA.ajouterIngredient(nAlimentA);
		nRecetteA.ajouterIngredient(nAlimentB);
		nRecetteA.ajouterIngredient(nAlimentF);
		nRecetteA.ajouterIngredient(nAlimentD);
		nRecetteA.ajouterIngredient(nAlimentE);
		
		// Poulet au curry
		String nomC = "Poulet au curry";
		String descriptifC =  "Mettre au four le poulet soupoudré de curry.";
						
		Recette nRecetteC = new Recette(nomC, descriptifC);
		nRecetteA.ajouterIngredient(nAlimentG);
		nRecetteA.ajouterIngredient(nAlimentH);
		
		// Soupe de légumes
		String nomD = "Soupe de légumes";
		String descriptifD =  "Mixer tout les légumes et faire cuire puis ajouter le beurre.";
						
		Recette nRecetteD = new Recette(nomD, descriptifD);
		nRecetteA.ajouterIngredient(nAlimentI);
		nRecetteA.ajouterIngredient(nAlimentJ);
		nRecetteA.ajouterIngredient(nAlimentK);
		nRecetteA.ajouterIngredient(nAlimentC);
		
		// Compotte de pomme
		String nomE = "Compotte de pomme";
		String descriptifE =  "Mixer toutes les pommes et faire cuire puis ajouter le sucre.";
						
		Recette nRecetteE = new Recette(nomE, descriptifE);
		nRecetteA.ajouterIngredient(nAlimentL);
		nRecetteA.ajouterIngredient(nAlimentM);
		
		// Poulet au miel
		String nomF = "Poulet au miel";
		String descriptifF =  "Faire cuire le poulet et arroser de miel";
						
		Recette nRecetteF = new Recette(nomF, descriptifF);
		nRecetteA.ajouterIngredient(nAlimentG);
		nRecetteA.ajouterIngredient(nAlimentN);
		
// Création du livre de recette
		
		LivreRecette nLivreRecette = new LivreRecette("Thermomix");
		nLivreRecette.ajouterRecette(nRecetteA);
		nLivreRecette.ajouterRecette(nRecetteB);
		nLivreRecette.ajouterRecette(nRecetteC);
		nLivreRecette.ajouterRecette(nRecetteD);
		nLivreRecette.ajouterRecette(nRecetteE);
		nLivreRecette.ajouterRecette(nRecetteF);
		
		
		
		
	}
	
}
