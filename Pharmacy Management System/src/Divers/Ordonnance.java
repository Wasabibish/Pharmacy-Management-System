package Divers;
import java.util.* ;

import Medicament.MedicamentPrescrit;
import Personne.Medecin;




  public class Ordonnance {
	  private String nomC;
	  private String prenomC;
	  private int ageC ;
	  private String nomM;
	  private String prenomM;
	  private String specialitéM;
	  private String adresseM;
	  private Date dateConsult;
	  public List<MedicamentPrescrit> MedicamentPrescrits = new ArrayList<MedicamentPrescrit>(); 


	  
      public Ordonnance(String nomP,String pnomP,int age,Medecin m,List<MedicamentPrescrit> liste) {
    	  Date date = new Date();
    	  this.dateConsult = date;
    	  this.nomC = nomP;
    	  this.nomM = m.GetNom();
    	  this.prenomC = pnomP;
    	  this.prenomM = m.GetPreNom();
    	  this.ageC = age;
    	  this.MedicamentPrescrits = liste;
    	  
      }
    	

     public Ordonnance( ) { 
    	 
   	  	System.out.print("Veuillez saisir les infos de l'ordonnance : ");
   	  	Scanner e = new Scanner (System.in);
   	    Date date = new Date();
   	  	this.dateConsult = date;
     	System.out.print("\n-Nom du Patient : ");  this.nomC=e.nextLine();  
     	System.out.print("\n-Prenom du Patient : ");  this.prenomC=e.nextLine();
     	System.out.print("\n-Age Du Patient : "); this.ageC = e.nextInt();
     	System.out.print("\n-Nom du Medecin : ");  this.nomM = e.next(); 
   		System.out.print("\n-Preom du Medecin : ");  this.prenomM = e.next(); 
   		System.out.print("\n-Specialité du Medecin : ");  this.specialitéM = e.next(); 
   		System.out.print("\n-Adresse Medecin : ");  this.adresseM = e.next(); 
    	  this.Prescrire();
    	  
    	  
     }
     
     public void Prescrire() {
    	 System.out.print("\nCombien de medicaments a préscrire ? ");
    	 Scanner e = new Scanner(System.in);
    	 int n = e.nextInt();
    	 for(int i = 0;i<n;i++) {
    		 MedicamentPrescrit m = new MedicamentPrescrit();
    		 this.MedicamentPrescrits.add(m);
    	 }
     }
 
      
      public String toString() {
    	  String  chaine="" ;
    	  for(int i=0;i<MedicamentPrescrits.size();i++)
    	  {chaine=chaine+MedicamentPrescrits.get(i).toString() ;  }
      	
      	return("\nDate de consultation : "+this.dateConsult+"\n-Nom du Patient : "+this.nomC+"\n-Prenom du Patient : "+this.prenomC+"\n-Age du Patient : "+
      	this.ageC+"\n-Nom du Medecin : "+this.nomM+"\n-Prenomom du Medecin : "+this.prenomM+"\n-Specialité du Medecin : "+
      			this.specialitéM+"\n-Adresse Du Medecin : "+this.adresseM
      			+"\n-Liste Medicaments Prescrits : "+this.MedicamentPrescrits);
      	
      }
      public void Afficher() {
      	System.out.println(this.toString());
      }

  

    public void SetDateConsult(Date d) { this.dateConsult=d ;}
    public Date GetDateConsultation() { return this.dateConsult ;}

}