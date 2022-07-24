package Personne;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Divers.Ordonnance;
import Divers.Pharmacie;
import Medicament.MedicamentExterne;
import Produit.ProduitParapharmaceutique;

public class ClientLambda  {

 
	boolean affiliation;
    
	public ClientLambda() {
		
	}
    public ClientLambda(boolean affiliation) {
    	this.affiliation = affiliation;
    	
    }
    public Boolean getAffiliation() {return this.affiliation;}
    public void SetAffiliation(Boolean Aff) {this.affiliation=Aff ;}

    public void Acheter() {//acheter un med sans ordonnance
    	Scanner e = new Scanner(System.in); 
    	String nom, rep = "oui";int seuilTest ; int qt = 0;double PrixOrd = 0.0;String reponse ="  ";
    	 List<String> Noms = new ArrayList<String>();
    	 List<Integer> Quantités = new ArrayList<Integer>();
    	
    	while (rep.charAt(0)=='o') {
    	
    	System.out.print("\nDonner le nom du medicament : "); nom = e.next();
    	System.out.print("\nDonner la quantité du medicament : "); qt = e.nextInt();
    	Noms.add(nom) ;
    	Quantités.add(qt) ;
    	System.out.print("\nVoulez vous acheter un autre medicament ?"); rep = e.next();
    	}
    	
  Boolean bb= true ;int k=0;
  
  while( bb==true && k<Noms.size())
  {
	 
  nom=Noms.get(k) ;
  qt=Quantités.get(k) ;
  
       //On verifie si le medic existe dans une des 3 listes de medicaments
  if(Pharmacie.VerifListeParapharmaceutique(nom)!=-1 || Pharmacie.VerifMedicamentExterne(nom)!=-1 || Pharmacie.VerifeMedicamentInterne(nom) !=-1 )
  {
	 if( Pharmacie.VerifListeParapharmaceutique(nom)!=-1 ) {//Produit Parapharmaceutique
		 
		 int stock = Pharmacie.ProduitParapharmaceutiques.get(Pharmacie.VerifListeParapharmaceutique(nom)).getQuantité();
	 if (qt>stock) { 
		 System.out.print("\n---Certains vos medicaments ne sont pas disponnible +["+nom+"]--- \n---Voulez vous effectuer l'achat partiellement---");
	     Pharmacie.ProduitParaMajStock.add(nom); 
	     bb=false ;
	     reponse = e.next();  
	     }
		 }
  
	if( Pharmacie.VerifMedicamentExterne(nom)!=-1 ) {  //Medicament externe
		
		int stock = Pharmacie.MedicamentExternes.get( Pharmacie.VerifMedicamentExterne(nom)).GetQuantité() ;
	if (qt>stock) {
		System.out.print("\n---Certains vos medicaments ne sont pas disponnible +["+nom+"]--- \n---Acceptez voulez vous effectuer l'achat partiellement---");
	    Pharmacie.ProduitExtMajStock.add(nom);   
 	    bb=false ;
	    reponse = e.next();
	   }
	}
	  
	   k++ ;  }else{//Ce medicament n'existe pas dans la pharmacie */
		    
			System.out.print("\n---Certains vos medicaments ne sont pas disponnible +["+nom+"]--- \n---Acceptez voulez vous effectuer l'achat partiellement---");
	   bb=false ;
	   reponse = e.next();  }
  }
  
    
  
  if(reponse.charAt(0)=='o'||bb==true){
	  //////////////////////////////////////////////////////////////////////////////
	 for (int l=0;l<Noms.size();l++) {//On calcul le montant de tous les medicaments
		nom=Noms.get(l) ;
		qt=Quantités.get(l) ;
    	int i = Pharmacie.VerifListeParapharmaceutique(nom);
    	
    	if(i != -1) {//Produit Parapharmaceutique
   		        int i2 = Pharmacie.VerifListeParapharmaceutiquePetiteQtt(nom) ;//On verifie si ce medic a atteint son seuil
			    if (i2 != -1) {//Il a atteint son seuil
				      int stock2 = Pharmacie.ProduitParapharmaceutiquesPetiteQtt.get(i2).getQuantité() ;  
				      
     		          if(stock2 >= qt ) {//on vend celui qui a atteint son seuil et TOUTE LA QTT demandée par le client
     		        	  ProduitParapharmaceutique p ;
      		              p=Pharmacie.ProduitParapharmaceutiquesPetiteQtt.get(i2);
      		              p.setQtt(stock2-qt);
     			          PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
     				      Pharmacie.ProduitParapharmaceutiquesPetiteQtt.set(i2, p) ;
     				      qt=0 ;
     			     }else {//on vend celui qui a atteint son seuil mais pas TOUTE LA QTT demandée par le client
     			    	 ProduitParapharmaceutique p ;
      		             p=Pharmacie.ProduitParapharmaceutiquesPetiteQtt.get(i2);
      		             Pharmacie.ProduitParapharmaceutiquesPetiteQtt.remove(p) ;  qt=qt-stock2 ;  
      		               }
			         }
    		int stock = Pharmacie.ProduitParapharmaceutiques.get(i).getQuantité();
    		if(stock>=qt) {
    			ProduitParapharmaceutique p ;
    		    p=Pharmacie.ProduitParapharmaceutiques.get(i);
    		    p.setQtt(stock-qt);
    			Pharmacie.ProduitParapharmaceutiques.set(i, p) ;
    			PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
    		
    		}
    		stock = Pharmacie.ProduitParapharmaceutiques.get(i).getQuantité();
    		seuilTest=Pharmacie.ProduitParapharmaceutiques.get(i).getSeuilMin() ;
    		if(stock<=seuilTest) { 
    			Pharmacie.ProduitParaMajStock.add(Pharmacie.ProduitParapharmaceutiques.get(i).getNom()) ;
    		 }
    	    }
    	
    	   i = Pharmacie.VerifMedicamentExterne(nom);
    	   if(i != -1) {//Medicament Externe

    	     int stock = Pharmacie.MedicamentExternes.get(i).GetQuantité() ;
       	     if(Pharmacie.MedicamentExternes.get(i).GetVendableSansOrd()== true) { 
       		   if(Pharmacie.DifDate(Pharmacie.MedicamentExternes.get(i).GetDateExpiaration(),90)) { 
       			   //On test seulement sur 3 mois car on a pas la durée du traitement
         		   
       			   int i2 =Pharmacie.VerifMedicamentExternePetiteQtt(nom) ;
				   if (i2 != -1) {//Si il a atteint son seuil
					  int stock2 = Pharmacie.MedicamentExternesPetiteQtt.get(i2).GetQuantité() ;    
	       			  if(stock2 >= qt ) {//On peut vendre toute la qtt demandée du client
	       				  MedicamentExterne p ;
	        		      p=Pharmacie.MedicamentExternesPetiteQtt.get(i2);
	        		      p.SetQuantité(stock2-qt);
	       			      PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
	       			      Pharmacie.MedicamentExternesPetiteQtt.set(i2, p) ;
	       			      qt=0 ;
	       			}else {//On peut vendre qu'une partie de la qtt demandée
	       			MedicamentExterne p ;
	        		p=Pharmacie.MedicamentExternesPetiteQtt.get(i2);
	        		Pharmacie.MedicamentExternesPetiteQtt.remove(p) ;  qt=qt-stock2 ;  }
				   
				   } 
       		    stock =Pharmacie.MedicamentExternes.get(i).GetQuantité();
       			if(stock >= qt ) {
       				 MedicamentExterne p ;
        		     p=Pharmacie.MedicamentExternes.get(i);
        		     p.SetQuantité(stock-qt);
       				 PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
       				 Pharmacie.MedicamentExternes.set(i, p) ;
       			}
       		 stock =Pharmacie.MedicamentExternes.get(i).GetQuantité();
       		 seuilTest=Pharmacie.MedicamentExternes.get(i).getSeuilMin() ;
       		if(stock<=seuilTest) {//Maj stock
       			    Pharmacie.ProduitExtMajStock.add(Pharmacie.MedicamentExternes.get(i).getNom()); 
       		}
       		   }else System.out.print("\n---Ce medicament ["+nom+"] est expiré---");
       		   
       	   }else System.out.print("\nCe medicament ["+nom+"] est vendable par  ordonnance seulement");
       		
       		
    	   }	
    	   
    	   i = Pharmacie.VerifeMedicamentInterne(nom) ;
    	   if(i != -1) {//Medicament Interne
    		   
       	     if(Pharmacie.MedicamentInternes.get(i).GetVendableSansOrd()== true) {
       			
       				PrixOrd = PrixOrd + Pharmacie.CalculMontant(nom);	
       
         	   }else System.out.print("\nCe medicament ["+nom+"] est vendable par  ordonnance seulement");
    	   } 
       		
    	   } 

	 System.out.println("\n\nLe prix a payé est de :"+PrixOrd+"DA");  Pharmacie.DemanderEnregClient();

	 }else {System.out.print("\n---Merci de votre visite---");    }
  

      
    }
    
 
    public void AchaterAvecOrd(Ordonnance ordonance) {
    	int seuilTest ;String nom; int qt = 0;double PrixOrd = 0.0;String reponse ="   " ;
    	
    
    Scanner e = new Scanner(System.in);
   Boolean bb= true ;int k=0;
   
 while( bb==true && k<ordonance.MedicamentPrescrits.size()) {

    nom=ordonance.MedicamentPrescrits.get(k).GetNom();
    qt=ordonance.MedicamentPrescrits.get(k).GetQuantité() ;
 
      if( Pharmacie.VerifMedicamentExterne(nom)!=-1 || Pharmacie.VerifeMedicamentInterne(nom) !=-1 )
 { //On verifie si le medic existe dans une des 2 listes de medicaments
    	  

	if(Pharmacie.VerifMedicamentExterne(nom)!=-1 ) {  
		int stock = Pharmacie.MedicamentExternes.get( Pharmacie.VerifMedicamentExterne(nom)).GetQuantité() ;
	if (qt>stock) {
		System.out.print("\n---Certains vos medicaments ne sont pas disponnible--- \n---Voulez vous effectuer l'achat partiellement---");
	    bb=false ;
	    reponse = e.next();
	   }
	}
	  
	   k++ ;  }else { //Pharmacie.VerifMedicamentExterne(nom)==-1 && Pharmacie.VerifeMedicamentInterne(nom) ==-1 (le produit n'est ni externe ni interne)//
		   System.out.print("\n---Certains vos medicaments ne sont pas disponnible--- \n--- voulez vous effectuer l'achat partiellement---");
	       bb=false ;
	       reponse = e.next(); 
	            }
 
   }
 if(reponse.charAt(0)=='o'||bb==true){
	  //////////////////////////////////////////////////////////////////////////////
	 for (int l=0;l<ordonance.MedicamentPrescrits.size();l++) {
		 nom=ordonance.MedicamentPrescrits.get(l).GetNom() ;
	     qt=ordonance.MedicamentPrescrits.get(l).GetQuantité() ;

   	   int i = Pharmacie.VerifMedicamentExterne(nom);
   	   if(i != -1) {//Medic Externe
   		   int stock = Pharmacie.MedicamentExternes.get(i).GetQuantité() ;
      	 
     if(Pharmacie.DifDate(Pharmacie.MedicamentExternes.get(i).GetDateExpiaration(),ordonance.MedicamentPrescrits.get(l).GetDurée()))
      			   {//on test si le medic ne sera pas expiré jusqu'a apres la durée du traitement
		   int i2 =Pharmacie.VerifMedicamentExternePetiteQtt(nom) ;
		   if (i2 != -1) {//Il a atteint don seuil
			   int stock2 = Pharmacie.MedicamentExternesPetiteQtt.get(i2).GetQuantité() ;    
 			if(stock2 >= qt ) {//On peut vendre la totalité de la qtt demandée
 				MedicamentExterne p ;
  		        p=Pharmacie.MedicamentExternesPetiteQtt.get(i2);
  		        p.SetQuantité(stock2-qt);
  		      if(!this.affiliation) {
		        	PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
		        }else { PrixOrd = PrixOrd + qt*Pharmacie.CalculMontantAffilié(nom);}
 				Pharmacie.MedicamentExternesPetiteQtt.set(i2, p) ;
 				qt=0 ;
 			}else {//On peut vendre qu'une partie de la qtt demandée
 				MedicamentExterne p ;
  		        p=Pharmacie.MedicamentExternesPetiteQtt.get(i2);
  		        Pharmacie.MedicamentExternesPetiteQtt.remove(p) ;  qt=qt-stock2 ;  }
		   
		   }
      		     
    	 stock =Pharmacie.MedicamentExternes.get(i).GetQuantité();
      			if(stock >= qt ) {
      				MedicamentExterne p ;
        		    p=Pharmacie.MedicamentExternes.get(i);
        		    p.SetQuantité(stock-qt);
        		    if(!this.affiliation) {
      		        	PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
      		        }else { PrixOrd = PrixOrd + qt*Pharmacie.CalculMontantAffilié(nom);}
       				Pharmacie.MedicamentExternes.set(i, p) ;
      				
      			}
      			   
          		 stock =Pharmacie.MedicamentExternes.get(i).GetQuantité();
           		 seuilTest=Pharmacie.MedicamentExternes.get(i).getSeuilMin() ;
           		if(stock<=seuilTest) {//Maj de stock
           			Pharmacie.ProduitExtMajStock.add(Pharmacie.MedicamentExternes.get(i).getNom());
           		    Pharmacie.MedicamentExternesPetiteQtt.add(Pharmacie.MedicamentExternes.get(i))  ;	
           		    Pharmacie.MedicamentExternes.remove(Pharmacie.MedicamentExternes.get(i)) ;}	   
      		   }else System.out.print("\n---Ce medicament est expiré---");
    
      		
   	   }	
   	   i = Pharmacie.VerifeMedicamentInterne(nom) ;
   	     if(i != -1) {
   	
   	    	if(!this.affiliation) {
		        	PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
		        }else { PrixOrd = PrixOrd + qt*Pharmacie.CalculMontantAffilié(nom);}    
   	    	Pharmacie.preparerMedicament(nom) ;
      	  
   	      }	
   	   } 

	 System.out.print("\n Le Prix a Payé est de :"+PrixOrd);//LE MONTANT TOTAL A PAYER
	 }
 
   	
     
   }
  

}