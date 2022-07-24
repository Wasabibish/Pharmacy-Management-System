package Divers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Medicament.MedicamentExterne;
import Medicament.MedicamentInterne;
import Personne.ClientPermanent;
import Personne.Fournisseur;
import Produit.ProduitParapharmaceutique;

public  class Pharmacie {
	public static List<ProduitParapharmaceutique> ProduitParapharmaceutiques = new ArrayList<ProduitParapharmaceutique>();
	public static List<ProduitParapharmaceutique> ProduitParapharmaceutiquesPetiteQtt = new ArrayList<ProduitParapharmaceutique>();
	public static List<MedicamentInterne> MedicamentInternes = new ArrayList<MedicamentInterne>();
	public static List<MedicamentExterne> MedicamentExternes = new ArrayList<MedicamentExterne>();
	public static List<MedicamentExterne> MedicamentExternesPetiteQtt = new ArrayList<MedicamentExterne>();
	public static List<ClientPermanent> ClientPermanents = new ArrayList<ClientPermanent>();
	public static List<String> ProduitParaMajStock = new ArrayList<String>();
	public static List<String> ProduitExtMajStock = new ArrayList<String>();
	List<Fournisseur> Fournisseurs = new ArrayList<Fournisseur>();
	public static List<Ordonnance> Ordonnances = new ArrayList<Ordonnance>();
	  
    public Pharmacie() {
    }

public static int VerifListeParapharmaceutique(String Nom)
{
	 for(int i=0;i<ProduitParapharmaceutiques.size();i++) 
	 {
		 if(ProduitParapharmaceutiques.get(i).getNom().equals(Nom) )   return i ;
			 
	 }
	 return -1 ;
}
public static int VerifListeParapharmaceutiquePetiteQtt(String Nom)
{
	 for(int i=0;i<ProduitParapharmaceutiquesPetiteQtt.size();i++) 
	 {
		 if(ProduitParapharmaceutiquesPetiteQtt.get(i).getNom().equals(Nom) )   return i ;
			 
	 }
	 return -1 ;
}
public static int VerifeMedicamentInterne(String Nom)
{
	 for(int i=0;i<MedicamentInternes.size();i++) 
	 {
		 if(MedicamentInternes.get(i).getNom().equals(Nom)  )   return i;
			 
	 }
	 return -1 ;
}
public static int VerifMedicamentExterne(String Nom)
{
	 for(int i=0;i<MedicamentExternes.size();i++) 
	 {
		 if(MedicamentExternes.get(i).getNom().equals(Nom) )   return i ;
			 
	 }
	 return -1 ;
}

public static int VerifMedicamentExternePetiteQtt(String Nom)
{
	 for(int i=0;i<MedicamentExternesPetiteQtt.size();i++) 
	 {
		 if(MedicamentExternesPetiteQtt.get(i).getNom().equals(Nom))    return i ;
			 
	 }
	 return -1 ;
}
   
    	
    public static double CalculMontant(String nom) {
    	double PrixOrd = 0.0;Boolean B = false ;
    	int indice = VerifListeParapharmaceutique(nom);
   	     if (indice != -1) {
   	    	 
   		     B=true ;
   		     PrixOrd=PrixOrd+ProduitParapharmaceutiques.get(indice).getPrix() ;
   		}
   	 
   	 indice = VerifeMedicamentInterne(nom);
   	 if (indice != -1 ) {
   		    B= true ;
            PrixOrd=PrixOrd+ (MedicamentInternes.get(indice).getPrix());
   			 }
   	 
   	indice = VerifMedicamentExterne(nom);	
   	 if (indice != -1 ) {
   		   B= true ;
           PrixOrd=PrixOrd+ (MedicamentExternes.get(indice).getPrix()) ;
   			 }
   	 if (B== false) { System.out.println("\nLe produit : "+nom+" n'est pas disponnible ") ;   } 
	 
   return PrixOrd;
    	
    }
    public static double CalculMontantAffilié(String nom) {
    	double PrixOrd = 0.0;Boolean B = false ;
    	int indice = VerifListeParapharmaceutique(nom);
   	     if (indice != -1) {
   	    	 
   		     B=true ;
   		     PrixOrd=PrixOrd+ProduitParapharmaceutiques.get(indice).getPrix() ;
   		}
   	 
   	 indice = VerifeMedicamentInterne(nom);
   	 if (indice != -1 ) {
   		    B= true ;
            PrixOrd=PrixOrd+ (MedicamentInternes.get(indice).getPrix()*(100-(MedicamentInternes.get(indice).GetTaux()+MedicamentInternes.get(indice).GetPourcentageRembour()))/100) ;
   			 }
   	 
   	indice = VerifMedicamentExterne(nom);	
   	 if (indice != -1 ) {
   		   B= true ;
           PrixOrd=PrixOrd+ (MedicamentExternes.get(indice).getPrix()*(100-(MedicamentExternes.get(indice).GetTaux()+MedicamentExternes.get(indice).GetPourcentageRembour()))/100) ;
   			 }
   	 if (B== false) { System.out.println("\nLe produit : "+nom+" n'est pas disponnible ") ;   } 
	 
   return PrixOrd;
    	
    }   
    public static void AjouterPatient(){ 
    	ClientPermanent c= new ClientPermanent() ;
    	Pharmacie.ClientPermanents.add(c) ;
    	System.out.println("\n---AJOUT AVEC SUCCES !--- ");
    }
    public void AjouterProduitParapharmaceutique() { 
    	System.out.print("\nComien de produit voulez vous ajouter ? ");
    	Scanner e = new Scanner(System.in); int n = e.nextInt();
    	for(int i=0;i<n;i++) {
    	ProduitParapharmaceutique p= new ProduitParapharmaceutique() ;
    	Pharmacie.ProduitParapharmaceutiques.add(p) ;
    	System.out.println("\n---AJOUT AVEC SUCCES !--- ");
    	}
    	
    }
    public void afficherMedicFrequent(ClientPermanent c)
    { System.out.println("\n-Liste Medicaments Frequents Achetés par "+c.GetNom()+" :"+c.MedicamentsFrequents);}
    
    
    public  void AjouterMedicamentInterne() {
    	System.out.print("\nComien de medicament voulez vous ajouter ? ");
    	Scanner e = new Scanner(System.in); int n = e.nextInt();
    	for(int i=0;i<n;i++) {
    	MedicamentInterne M = new MedicamentInterne() ;
    	Pharmacie.MedicamentInternes.add(M) ;
    	System.out.println("\n---AJOUT AVEC SUCCES !--- ");
    	}
    }
    
    public static void AjouterMedicamentExterne() {
    	System.out.print("\nComien de medicament voulez vous ajouter ? ");
    	Scanner e = new Scanner(System.in); int n = e.nextInt();
    	for(int i=0;i<n;i++) {
    	MedicamentExterne M = new MedicamentExterne() ;
    	MedicamentExternes.add(M) ;
    	System.out.println("\n---AJOUT AVEC SUCCES !--- ");
    	}
    	
    }
    public void AjouterFournisseur() {
    	Fournisseur F = new Fournisseur() ;
    	this.Fournisseurs.add(F) ;
    	System.out.println("\n---AJOUT AVEC SUCCES !--- ");
    }
    
    


    public static void DemanderEnregClient() {
    	System.out.println("\nVoulez vous etre enregistré dans le systeme?");
    	Scanner e = new Scanner(System.in); String rep = e.next();
    	if (rep.charAt(0) == 'o') {
    		Pharmacie.AjouterPatient();
    	}else System.out.println("\n---Merci pour votre visite !--- ");
    	
    }
    
 public void ModifierClientNom(ClientPermanent c,String nom)
 {ClientPermanent c2 ;
 {if(Pharmacie.ClientPermanents.contains(c)) 
 {	 
	 for (int i=0 ;i<Pharmacie.ClientPermanents.size();i++) 
	 {
		if(Pharmacie.ClientPermanents.get(i)==c) {				
		 c2=Pharmacie.ClientPermanents.get(i) ; 
		 c2.SetNom(nom);
		Pharmacie.ClientPermanents.set(i, c2) ;  }
	 }
	 	
 }else {System.out.println("\n---Le Client "+c.GetNom()+"n'existe pas !--- ");  }
	 
 }	 	 
}
 public void ModifierClientPrenom(ClientPermanent c,String Prenom)
 {ClientPermanent c2 ;
 {if(Pharmacie.ClientPermanents.contains(c)) 
 {	 
	 for (int i=0 ;i<Pharmacie.ClientPermanents.size();i++) 
	 {
		if(Pharmacie.ClientPermanents.get(i)==c) {				
		 c2=Pharmacie.ClientPermanents.get(i) ; 
		 c2.SetPreNom(Prenom);
		Pharmacie.ClientPermanents.set(i, c2) ;  }
	 }
	 	
 }else {System.out.println("\n---Le Client "+c.GetNom()+"n'existe pas !--- ");  }
	 
 }	 	 
} 
 
 public void ModifierClientNSS(ClientPermanent c,int NSS)
 {ClientPermanent c2 ;
 {if(Pharmacie.ClientPermanents.contains(c)) 
 {	 
	 for (int i=0 ;i<Pharmacie.ClientPermanents.size();i++) 
	 {
		if(Pharmacie.ClientPermanents.get(i)==c) {				
		 c2=Pharmacie.ClientPermanents.get(i) ; 
		 c2.SetNumeroSecuritéSociale(NSS);
		Pharmacie.ClientPermanents.set(i, c2) ;  }
	 }
	 	
 }else {System.out.println("\n---Le Client "+c.GetNom()+"n'existe pas !--- ");  }
	 
 }	 	 
}  
 public void ModifierClientAge(ClientPermanent c,int Age)
 {ClientPermanent c2 ;
 {if(Pharmacie.ClientPermanents.contains(c)) 
 {	 
	 for (int i=0 ;i<Pharmacie.ClientPermanents.size();i++) 
	 {
		if(Pharmacie.ClientPermanents.get(i)==c) {				
		 c2=Pharmacie.ClientPermanents.get(i) ; 
		 c2.SetAge(Age);
		Pharmacie.ClientPermanents.set(i, c2) ;  }
	 }
	 	
 }else {System.out.println("\n---Le Client "+c.GetNom()+"n'existe pas !--- ");  }
	 
 }	 	 
} 
 public void ModifierFournisseurNom(Fournisseur f,String nom)
 {Fournisseur f2 ;
 {if(this.Fournisseurs.contains(f)) 
 {	 
	 for (int i=0 ;i<this.Fournisseurs.size();i++) 
	 {
		if(this.Fournisseurs.get(i)==f) {				
		 f2=this.Fournisseurs.get(i) ; 
		 f2.SetNom(nom);
		this.Fournisseurs.set(i, f2) ;  }
	 }
	 	
 }else {System.out.println("\n---Le Fournisseur "+f.GetNom()+"n'existe pas !--- ");  }
	 
 }	 	 
}  
 public void ModifierFournisseurAdresse(Fournisseur f,String Adr)
 {Fournisseur f2 ;
 {if(this.Fournisseurs.contains(f)) 
 {	 
	 for (int i=0 ;i<this.Fournisseurs.size();i++) 
	 {
		if(this.Fournisseurs.get(i)==f) {				
		 f2=this.Fournisseurs.get(i) ; 
		 f2.SetAdresse(Adr);
		this.Fournisseurs.set(i, f2) ;  }
	 }
	 	
 }else {System.out.println("\n---Le Fournisseur "+f.GetNom()+"n'existe pas !--- ");  }
	 
 }	 	 
}

public static void preparerMedicament(String Nom) {
	
	System.out.println("\n---Medicament:"+Nom+" en cours de Prepartion.....---");
	System.out.println("\n---Medicament:"+Nom+" Pret---");
}  
  
public static void MedicPerime() {//affiche les noms des medic qui se periment dans 30jours ou moins
	Date date = new Date();//date aujrd
	for(int i = 0;i<Pharmacie.ProduitParapharmaceutiques.size();i++) {
		System.out.print("\nLes produits parapharmaceutiques qui expirent dans un mois sont :");
		
		if(Pharmacie.DifDate(date, 30)) {
			System.out.print(Pharmacie.ProduitParapharmaceutiques.get(i).getNom());
			
		}
	}
	for(int i = 0;i<Pharmacie.ProduitParapharmaceutiquesPetiteQtt.size();i++) {
		System.out.print("\nLes produits parapharmaceutiques a petite qt qui expirent dans un mois sont :");

		if(Pharmacie.DifDate(date, 30)) {
			System.out.print(Pharmacie.ProduitParapharmaceutiquesPetiteQtt.get(i).getNom());
			
		}
	}
	for(int i = 0;i<Pharmacie.MedicamentExternes.size();i++) {
		System.out.print("\nLes medicaments externes qui expirent dans un mois sont :");

		if(Pharmacie.DifDate(date, 30)) {
			System.out.print(Pharmacie.MedicamentExternes.get(i).getNom());
			
		}
	}
	for(int i = 0;i<Pharmacie.ProduitParapharmaceutiquesPetiteQtt.size();i++) {
		System.out.print("\nLes medicaments externes a petite qt qui expirent dans un mois sont :");

		if(Pharmacie.DifDate(date, 30)) {
			System.out.print(Pharmacie.MedicamentExternesPetiteQtt.get(i).getNom());
			
		}
	}
	
}

public static boolean DifDate(Date date, int x) {
	Date d1 = new Date();//retourne today
	int m = date.getMonth()+1;// car c'est 0-11
	int d = date.getYear()*365+date.getDay()+date.getMonth()*30-d1.getYear()*365-d1.getMonth()-d1.getDay()-x;//30
	if(m==2) {
		d=d-2;//28
		}else if (m==1||m==3||m==5||m==7||m==8||m==10||m==12) {
		d=d+1; //31
	}
	if (d>=0) {return true;}else return false;
}



public void CommanderPrdouitAttente() {
	
	for (int i=0;i<Pharmacie.ClientPermanents.size();i++){
		double PrixCommande=0.0 ; ClientPermanent c = Pharmacie.ClientPermanents.get(i) ;
	      for (int j=0;j<c.ProduitCommandé.size();j++){
	    	  String nom =c.ProduitCommandé.get(j) ;
	          int qtt =c.QuantitéCommandé.get(j) ;
		
	          MedicamentExterne p = new MedicamentExterne(nom,qtt);
   	          PrixCommande=PrixCommande+p.GetPrix()*qtt;
	
	       }
	      
	ContacterClient(c,c.ProduitCommandé,PrixCommande) ;
	c.ProduitCommandé.clear(); 
    c.QuantitéCommandé.clear();
     
	}

}
public static void mettreAjourStcokParapharmeceutique() {
	
	for (int j=0;j<Pharmacie.ProduitParaMajStock.size();j++) {
		
		String nom = Pharmacie.ProduitParaMajStock.get(j) ;
		int i = Pharmacie.VerifListeParapharmaceutique(nom); 
		Pharmacie.ProduitParapharmaceutiquesPetiteQtt.add(Pharmacie.ProduitParapharmaceutiques.get(i) );  // LE METTRE DANS LISTE PETITEQTT
		Pharmacie.ProduitParapharmaceutiques.remove(Pharmacie.ProduitParapharmaceutiques.get(i) ) ;
		ProduitParapharmaceutique P = new ProduitParapharmaceutique(nom) ;
		
	}

	
	
}
public static void mettreAjourStcokExterne() {
	for (int j=0;j<Pharmacie.ProduitExtMajStock.size();j++) {
		String nom = Pharmacie.ProduitExtMajStock.get(j) ;
	int i = Pharmacie.VerifMedicamentExterne(nom) ;
		Pharmacie.MedicamentExternesPetiteQtt.add(Pharmacie.MedicamentExternes.get(i))  ;	
		Pharmacie.MedicamentExternes.remove(Pharmacie.MedicamentExternes.get(i)) ;
		MedicamentExterne M = new MedicamentExterne(nom) ;  
	
}
}

public void ContacterClient(ClientPermanent c ,List <String> liste , double prix) {
	System.out.print("\nLa commande du client"+c.GetNom()+c.GetPreNom()
	+" est prete\nListe des produits commandés : "+liste+"\nPrix = "+prix+"DA");
	
	
}

public static void SuppremierMedicPerimé() {
	Date date = new Date();//date aujrd
	for(int i = 0;i<Pharmacie.ProduitParapharmaceutiques.size();i++) {
		System.out.print("\nLes produits parapharmaceutiques qui sont perimé et qui vont etre supprimé sont :");
		
		if(Pharmacie.DifDate(date, 0)) {
			System.out.print(Pharmacie.ProduitParapharmaceutiques.get(i).getNom());
			Pharmacie.ProduitParapharmaceutiques.remove(i) ;
		}
	}
	for(int i = 0;i<Pharmacie.ProduitParapharmaceutiquesPetiteQtt.size();i++) {
		System.out.print("\nLes produits parapharmaceutiques a petite qt perimé et qui vont etre supprimé sont :");

		if(Pharmacie.DifDate(date, 0)) {
			System.out.print(Pharmacie.ProduitParapharmaceutiquesPetiteQtt.get(i).getNom());
			Pharmacie.ProduitParapharmaceutiquesPetiteQtt.remove(i) ;
		}
	}
	for(int i = 0;i<Pharmacie.MedicamentExternes.size();i++) {
		System.out.print("\nLes medicaments externes qui sont perimé et qui vont etre supprimé sont :");

		if(Pharmacie.DifDate(date, 0)) {
			System.out.print(Pharmacie.MedicamentExternes.get(i).getNom());
			Pharmacie.MedicamentExternes.remove(i) ;
			
		}
	}
	for(int i = 0;i<Pharmacie.ProduitParapharmaceutiquesPetiteQtt.size();i++) {
		System.out.print("\nLes medicaments externes à petite qt qui sont perimés et qui vont etre supprimé sont :");

		if(Pharmacie.DifDate(date, 0)) {
			System.out.print(Pharmacie.MedicamentExternesPetiteQtt.get(i).getNom());
			Pharmacie.MedicamentExternesPetiteQtt.remove(i) ;
		}
	}
	
}

}	 
	 
	 