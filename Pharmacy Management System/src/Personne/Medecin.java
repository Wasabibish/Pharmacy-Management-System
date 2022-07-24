package Personne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Divers.Pharmacie;
import Medicament.MedicamentExterne;
import Produit.ProduitParapharmaceutique;

public class Medecin extends Personne {

  

    private String specialité;
    private String adresse;
    private boolean Conventionné;
    
    public List <String> ProduitCommandé = new ArrayList<String>() ;
	public List<Integer> QuantitéCommandé = new ArrayList<Integer>();


    public Medecin(String nom,String prenom,int NSS,boolean aff,String sp,String adr,boolean conventionné) {
    	super(nom,prenom,NSS,aff);
    	this.adresse = adr;
    	this.specialité = sp;
    	this.Conventionné = conventionné;
    	
    }
    
    public Medecin() {
    	super();
    	Scanner e = new Scanner (System.in);
    	System.out.print("\n-Adress : ");  this.adresse = e.nextLine(); 
    	System.out.print("\n-Specialité : ");  this.specialité = e.nextLine(); 
    	System.out.print("\n-Conventionné : "); this.Conventionné = e.hasNextBoolean();
    	
    }
    
    public String toString() {
    	super.Afficher();
    	return("\n-Adress : "+this.adresse+"\n-Specialité : "+this.specialité);
    }
    public void Afficher() {
    	System.out.print(this.toString());
    }
   
    public void SetAdresse(String adresse) { this.adresse=adresse ;}
    public void SetSpecialité(String specialite) { this.specialité=specialite ;}
    public void SetConventionné(Boolean b) { this.Conventionné=b ;}    


    public String GetAdresse() {return this.adresse ;}
    public String GetSpecialité() {return this.specialité ;}   
    public Boolean GetConventionné() {return this.Conventionné ;}
    
    
    
    public void passerCommande() {
    	Scanner e = new Scanner(System.in); 
    	String nom, rep = "oui";int seuilTest ; int qt = 0;double PrixOrd = 0.0;
    	 List<String> Noms = new ArrayList<String>();
    	 List<Integer> Quantités = new ArrayList<Integer>();
    	while (rep.charAt(0)=='o') {
        	
        	System.out.print("\nDonner le nom du medicament : "); nom = e.next();
        	System.out.print("\nDonner la quantité du medicament : "); qt = e.nextInt();
        	Noms.add(nom) ;
        	Quantités.add(qt) ;
        	System.out.print("\nVoulez vous acheter ou commander un autre medicament ?"); rep = e.next();
        	}
    	
  
    	  for (int l=0;l<Noms.size();l++) {//On calcul le montant de tous les medicaments
    			nom=Noms.get(l) ;
    			qt=Quantités.get(l) ;
    	    	int i = Pharmacie.VerifListeParapharmaceutique(nom);
    	    	
    	    	if(i != -1) {//Produit Parapharmaceutique
    	   		        int i2 = Pharmacie.VerifListeParapharmaceutiquePetiteQtt(nom) ;//On verifie si ce medic a atteint son seuil
    				    if (i2 != -1) {//Il a atteint son seuil
    					      int stock2 = Pharmacie.ProduitParapharmaceutiquesPetiteQtt.get(i2).getQuantité() ;  
    					      
    	     		          if(stock2 >= qt ) {//on vend celui qui a atteint son seuil et TOUTE LA QTT demandée par le med
    	     		        	  ProduitParapharmaceutique p ;
    	      		              p=Pharmacie.ProduitParapharmaceutiquesPetiteQtt.get(i2);
    	      		              p.setQtt(stock2-qt);
    	     			          PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
    	     				      Pharmacie.ProduitParapharmaceutiquesPetiteQtt.set(i2, p) ;
    	     				      qt=0 ;
    	     				      Noms.remove(l); Quantités.remove(l);
    	     				      
    	     			     }
    				         }
    	    		int stock = Pharmacie.ProduitParapharmaceutiques.get(i).getQuantité();
    	    		if(stock>=qt) {
    	    			ProduitParapharmaceutique p ;
    	    		    p=Pharmacie.ProduitParapharmaceutiques.get(i);
    	    		    p.setQtt(stock-qt);
    	    			Pharmacie.ProduitParapharmaceutiques.set(i, p) ;
    	    			PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
   				      Noms.remove(l); Quantités.remove(l);

    	    		
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
    	       		   if(Pharmacie.DifDate(Pharmacie.MedicamentExternes.get(i).GetDateExpiaration(),180)) { ////////////////////////////////////
    	       			   //On test seulement sur 6 mois 
    	         		   
    	       			   int i2 =Pharmacie.VerifMedicamentExternePetiteQtt(nom) ;
    					   if (i2 != -1) {//Si il a atteint son seuil
    						  int stock2 = Pharmacie.MedicamentExternesPetiteQtt.get(i2).GetQuantité() ;    
    		       			  if(stock2 >= qt ) {//On peut vendre toute la qtt demandée du med
    		       				  MedicamentExterne p ;
    		        		      p=Pharmacie.MedicamentExternesPetiteQtt.get(i2);
    		        		      p.SetQuantité(stock2-qt);
    		       			      PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
    		       			      Pharmacie.MedicamentExternesPetiteQtt.set(i2, p) ;
    		       			      qt=0 ;
    	     				      Noms.remove(l); Quantités.remove(l);

    		       			}
    					   
    					   } 
    	       		    stock =Pharmacie.MedicamentExternes.get(i).GetQuantité();
    	       			if(stock >= qt ) {
    	       				 MedicamentExterne p ;
    	        		     p=Pharmacie.MedicamentExternes.get(i);
    	        		     p.SetQuantité(stock-qt);
    	       				 PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
    	       				 Pharmacie.MedicamentExternes.set(i, p) ;
	     				      Noms.remove(l); Quantités.remove(l);

    	       			}
    	       		 stock =Pharmacie.MedicamentExternes.get(i).GetQuantité();
    	       		 seuilTest=Pharmacie.MedicamentExternes.get(i).getSeuilMin() ;
    	       		if(stock<=seuilTest) {//Maj stock
    	       			    Pharmacie.ProduitExtMajStock.add(Pharmacie.MedicamentExternes.get(i).getNom()); 
    	       		}
    	       		   }else System.out.print("\n---Ce medicament ["+nom+"] est expiré---");
    	       		   
    	    	   }	
    	    	   
    	    	   i = Pharmacie.VerifeMedicamentInterne(nom) ;
    	    	   if(i != -1) {//Medicament Interne
    	    		   
    	       		  PrixOrd = PrixOrd + Pharmacie.CalculMontant(nom);	
   				      Noms.remove(l); Quantités.remove(l);

    	    	   } 
    	       		
    	    	   } 

    		 System.out.println("\n\nLe prix a payé est de :"+PrixOrd+"DA");  
    		 if(!Noms.isEmpty()) {
    		          if(!this.Conventionné ) {
    			 System.out.print("\nSeuls les medecins conventionnés peuvent passer une commande");
    		 }else {
    		 System.out.println("\n\nVotre commande est en cours merci ");  

    		 this.ProduitCommandé = Noms;
    		 this.QuantitéCommandé = Quantités;
    		 
    		//commande 
    		 double PrixCommande=0.0 ;
   	      for (int j=0;j<this.ProduitCommandé.size();j++){
   	    	  String produit = this.ProduitCommandé.get(j) ;
   	          int qtt =this.QuantitéCommandé.get(j) ;
   		
   	          MedicamentExterne p = new MedicamentExterne(produit,qtt);
   	          PrixCommande=PrixCommande+p.GetPrix()*qtt;
   	         
   	
   	       } System.out.print("\nLe prix des prodduits commandés est : "+PrixCommande+"DA");

    		 }
    		 }
    }

    	      
 }
    	  
    

	
