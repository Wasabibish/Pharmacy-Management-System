package Personne;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import Divers.Ordonnance;
import Divers.Pharmacie;
import Medicament.MedicamentExterne;
import Produit.ProduitParapharmaceutique;

public class ClientPermanent extends Personne {

	 List<String> MaladieChronique = new ArrayList<String>();
	 public List <String> ProduitCommandé = new ArrayList<String>() ;
	 public List<Integer> QuantitéCommandé = new ArrayList<Integer>();
	 public List <String> Historique = new ArrayList<String>() ;
	 public List <String> MedicamentsFrequents = new ArrayList<String>() ;
	   private int age ;
	public ClientPermanent(String nom,String prenom,int NSS,int age,boolean aff ,List<String> liste) {
		super(nom,prenom,NSS,aff);
		this.age = age;
		this.MaladieChronique = liste;
		
	}
	  
    public ClientPermanent() {
    	super();
    	this.MaladieChronique=new ArrayList<String>();
    	Scanner e = new Scanner(System.in);
    	System.out.print("\n-Age : "); this.age= e.nextInt();
    	System.out.print("\n-Avez vous une maladie chronique? ");
    	
    	String rep = e.next();
    	if (rep.charAt(0) == 'o') {
    		
    		System.out.print("\nMaladie : "); 
    		rep = e.next();this.MaladieChronique.add(rep);
    		}
    
    	}
    
    
    public String toString() {
 
    	
    	return(super.toString()+"\n-Age : "+this.age+"\n-Maladies chroniques : "+this.MaladieChronique );
    	
    }
    public void Afficher() {
    	System.out.println(this.toString());
    }
    

          public void SetAge(int age) { this.age=age ;}
          public int GetAge() {return this.age ;}
         


         
  public void AchaterAvecOrd(Ordonnance ordonance) {

          	int seuilTest ;String nom; int qt = 0;double PrixOrd = 0.0;String reponse ="   " ;
          	
          
          Scanner e = new Scanner(System.in);
         Boolean bb= true ;int k=0;
         
       while( bb==true && k<ordonance.MedicamentPrescrits.size()) {

          nom=ordonance.MedicamentPrescrits.get(k).GetNom();
          qt=ordonance.MedicamentPrescrits.get(k).GetQuantité() ;
       
            if( Pharmacie.VerifMedicamentExterne(nom)!=-1 || Pharmacie.VerifeMedicamentInterne(nom) !=-1 )
       {//On verifie si le medic existe dans une des 2 listes de medicaments
          	  

      	if(Pharmacie.VerifMedicamentExterne(nom)!=-1 ) {  
      		int stock = Pharmacie.MedicamentExternes.get( Pharmacie.VerifMedicamentExterne(nom)).GetQuantité() ;
      	if (qt>stock) {
   		 System.out.print("\n---Certains vos medicaments ne sont pas disponnible ["+nom+"]--- \n---Voulez vous effectuer l'achat partiellement---");
      	    bb=false ;
      	    reponse = e.next();
      	   }
      	}
      	  
      	   k++ ;  }else { 
      		 System.out.print("\n---Certains vos medicaments ne sont pas disponnible ["+nom+"]--- \n---Voulez vous effectuer l'achat partiellement---");
      	       bb=false ;
      	       reponse = e.next(); 
      	            }
       
         }
       if(reponse.charAt(0)=='o'||bb==true){
    		String reponse2 ;
    		
    			
    			 System.out.print("\n---Voulez vous Commander les Produits non disponnible--");
    		     reponse2 = e.next(); 
 
    		
      	  //////////////////////////////////////////////////////////////////////////////
      	 for (int l=0;l<ordonance.MedicamentPrescrits.size();l++) {
      		 nom=ordonance.MedicamentPrescrits.get(l).GetNom() ;
      	     qt=ordonance.MedicamentPrescrits.get(l).GetQuantité() ;
              if(Pharmacie.VerifeMedicamentInterne(nom)==-1 && Pharmacie.VerifMedicamentExterne(nom)==-1 ) {
	/// c'est dont obligatoirement un medicament Externe que nous n'avons pas dans la pharmacie //
	            if(reponse2.charAt(0)=='o') {
		           this.ProduitCommandé.add(nom) ;this.QuantitéCommandé.add(qt) ;

                 }
	         }

else { //le produit est dans la liste des produits interne ou dans la liste des produits externe//
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
        		        this.Historique.add(Pharmacie.MedicamentExternesPetiteQtt.get(i2).getNom()) ;
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
             				if(qt!=0) {this.Historique.add(p.getNom()) ; }
             				Pharmacie.MedicamentExternes.set(i, p) ;
            				
            			}else { //stock insuffisant //
            				if(reponse2.charAt(0)=='o') {
            					this.ProduitCommandé.add(nom) ;this.QuantitéCommandé.add(qt) ;

                              }  
            				}
            			
                		 stock =Pharmacie.MedicamentExternes.get(i).GetQuantité();
                 		 seuilTest=Pharmacie.MedicamentExternes.get(i).getSeuilMin() ;
                 		if(stock<=seuilTest) {//Maj de stock
                 			Pharmacie.ProduitExtMajStock.add(Pharmacie.MedicamentExternes.get(i).getNom());
                 		    Pharmacie.MedicamentExternesPetiteQtt.add(Pharmacie.MedicamentExternes.get(i))  ;	
                 		    Pharmacie.MedicamentExternes.remove(Pharmacie.MedicamentExternes.get(i)) ;}	   
            		   }else System.out.print("\n---Ce medicament ["+nom+"] est expiré---");
          
            		
         	   }	
         	   i = Pharmacie.VerifeMedicamentInterne(nom) ;
         	     if(i != -1) {
         	this.Historique.add(nom) ;
         	if(!this.affiliation) {
		        	PrixOrd = PrixOrd + qt*Pharmacie.CalculMontant(nom);
		        }else { PrixOrd = PrixOrd + qt*Pharmacie.CalculMontantAffilié(nom);}		
	        
              Pharmacie.preparerMedicament(nom) ;
            	  
            		
         	      }	}
         	     
         	   } 

      	 System.out.print("\n Le prix a payé est de :"+PrixOrd+"DA");	//LE MONTANT TOTAL A PAYER
      	 if(PrixOrd !=0) {this.MajListMedicamentsFrequents() ; }
      	 }
        

////////////////////////////////////////////////////////////////////////	

	
//fin//  
}

public void MajListMedicamentsFrequents() 
{
	for(int i=0;i<this.Historique.size();i++ )
  {String nom=this.Historique.get(i) ;int cpt=0 ; 
	for(int j=0;j<this.Historique.size();j++ )
	{String nom2=this.Historique.get(j) ;   
	if(nom.equals(nom2)) {cpt=cpt+1 ;   }
	}
  if(cpt>2) {if(this.MedicamentsFrequents.contains(nom)==false) {this.MedicamentsFrequents.add(nom);  } }  

}
}

//////FIN CLASS //////


}