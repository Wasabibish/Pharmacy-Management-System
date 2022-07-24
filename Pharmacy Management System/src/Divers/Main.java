package Divers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Medicament.MedicamentExterne;
import Medicament.MedicamentPrescrit;
import Personne.ClientLambda;
import Personne.ClientPermanent;
import Personne.Medecin;
import Produit.ProduitParapharmaceutique;

public class Main {


	public static void main(String[] args) {
		
		//Ajout des medicament à la pharmacie
		MedicamentExterne Doliprane = new MedicamentExterne("doliprane", 70, 5, "antibiotique", 
				"orale", false, 3,false, 50, 15687, 50, "BioPharm");
		Pharmacie.MedicamentExternes.add(Doliprane);
		ProduitParapharmaceutique Gel = new ProduitParapharmaceutique("gel",50,3, 50, "produit_hygienique", "aucun");
		Pharmacie.ProduitParapharmaceutiques.add(Gel);
		MedicamentExterne Clamoxyl = new MedicamentExterne("clamoxyl", 285, 5, "antibiotique", 
				"orale", true, 3,true, 50, 15687, 50, "BioPharm");
		Pharmacie.MedicamentExternes.add(Clamoxyl);
		
		//Faire une ordonnance
		Medecin m = new Medecin("djeghali","ikram",5546, false, "generaliste", "alger", false);
		List<MedicamentPrescrit> MP = new ArrayList<MedicamentPrescrit>();
		MedicamentPrescrit doliprane = new MedicamentPrescrit("doliprane",1,7);MP.add(doliprane);
		MedicamentPrescrit clamoxyl = new MedicamentPrescrit("clamoxyl",2,10);MP.add(clamoxyl);
		Ordonnance o = new Ordonnance("moussi", "samy", 19, m, MP);
		
		//L'achat des differents types de clients
		ClientLambda l = new ClientLambda(false); 
	    l.Acheter(); 
	    ClientPermanent c = new ClientPermanent();//Informations saisies au clavier
		c.AchaterAvecOrd(o);
		
		//Cas du medecin qui veut commander
		m.passerCommande();
		
		
		
	}

}
