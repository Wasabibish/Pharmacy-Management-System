package Medicament ;

import java.util.Scanner;

public class MedicamentPrescrit {
    private String nom;
    private int quantité;
    private int durée;
    
   
 
    public MedicamentPrescrit() {
      	System.out.print("Introduire les infos du medicament préscrit : ");
    	Scanner e = new Scanner (System.in);
    	System.out.print("\nNom : ");  this.nom = e.nextLine(); 
    	System.out.print("\nQuantité : ");  this.quantité = e.nextInt(); 
    	System.out.print("\nDurée : "); this.durée = e.nextInt();
    
    	
    }
    public MedicamentPrescrit(String nom,int qt,int durée) {
    	this.nom = nom;
    	this.durée = durée;
    	this.quantité = qt;
    }

    public String toString() {
    	return("\n-Nom : "+this.nom+"Quantité : "+this.quantité+"\nDurée : "+this.durée+"jours");
    }
    public void Afficher() {
    	System.out.print("Les infos du medicament prescrit : ");
    	System.out.print(this.toString());
    }


    
    public void SetQuantité(int qtt) { this.quantité=qtt;}
    public void SetDurée(int durée) { this.durée=durée ;}
    public void SetNom(String nom) { this.nom=nom ;}
    


    public int GetQuantité() {return this.quantité;}
    public int GetDurée() {return this.durée ;}
    public String GetNom() {return this.nom ;}
    
    
    
}