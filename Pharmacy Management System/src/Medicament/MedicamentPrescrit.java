package Medicament ;

import java.util.Scanner;

public class MedicamentPrescrit {
    private String nom;
    private int quantit�;
    private int dur�e;
    
   
 
    public MedicamentPrescrit() {
      	System.out.print("Introduire les infos du medicament pr�scrit : ");
    	Scanner e = new Scanner (System.in);
    	System.out.print("\nNom : ");  this.nom = e.nextLine(); 
    	System.out.print("\nQuantit� : ");  this.quantit� = e.nextInt(); 
    	System.out.print("\nDur�e : "); this.dur�e = e.nextInt();
    
    	
    }
    public MedicamentPrescrit(String nom,int qt,int dur�e) {
    	this.nom = nom;
    	this.dur�e = dur�e;
    	this.quantit� = qt;
    }

    public String toString() {
    	return("\n-Nom : "+this.nom+"Quantit� : "+this.quantit�+"\nDur�e : "+this.dur�e+"jours");
    }
    public void Afficher() {
    	System.out.print("Les infos du medicament prescrit : ");
    	System.out.print(this.toString());
    }


    
    public void SetQuantit�(int qtt) { this.quantit�=qtt;}
    public void SetDur�e(int dur�e) { this.dur�e=dur�e ;}
    public void SetNom(String nom) { this.nom=nom ;}
    


    public int GetQuantit�() {return this.quantit�;}
    public int GetDur�e() {return this.dur�e ;}
    public String GetNom() {return this.nom ;}
    
    
    
}