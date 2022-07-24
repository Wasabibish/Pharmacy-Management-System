package Personne;

import java.util.Scanner;

public class Personne extends ClientLambda {


	   private String nom;
	   private String prenom;
	   private int NSS;
	   
	public Personne(String nom,String prenom,int NSS,boolean aff) {
		super(aff);
		this.nom = nom;
		this.prenom = prenom;
		this.NSS = NSS;
		
	}
	   

    
    
    public Personne() {
    	System.out.print("Introduire les infos du client : ");
    	Scanner e = new Scanner(System.in);
    	System.out.print("\n-Nom : ");  this.nom = e.nextLine(); 
    	System.out.print("\n-Preom : ");  this.prenom = e.nextLine(); 
    	System.out.print("\n-NNSS : "); this.NSS = e.nextInt();
    	
    }
    public String toString() {
    	return ("\nLes infos du client : "+"\n-Nom : "+this.nom+"\n-Prenom : "+this.prenom+"\n-NSS : "+this.NSS);
    }
    public void Afficher() {
    	System.out.print(this.toString());
    }
    
    public void SetNom(String nom) { this.nom=nom ;}
    public void SetPreNom(String prenom) { this.prenom=prenom ;}
    public void SetNumeroSecuritéSociale(int nss) { this.NSS=nss ;}
    
    
    public String GetNom() {return this.nom ;}
    public String GetPreNom() {return this.prenom ;}
    public int GetNumeroSecuritéSociale() {return this.NSS ;}    
}