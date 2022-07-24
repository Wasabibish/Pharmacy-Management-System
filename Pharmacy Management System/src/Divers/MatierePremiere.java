package Divers ;

import java.util.Scanner;

public class MatierePremiere {
	  private String nom;
	    private int dose;
 
    public MatierePremiere(String nom,int dose) {
    	this.dose = dose;
    	this.nom = nom;
    }

public MatierePremiere() {
    	System.out.print("Introduire les infos de la matiere premiere : ");
    	Scanner e = new Scanner (System.in);
    	System.out.print("\nNom : ");  this.nom = e.nextLine(); 
    	System.out.print("\nDose : "); this.dose = e.nextInt();
 }
    public String toString() {
    	return("Les info de la matiere premiere : "+"\n-nom"+this.nom+"\n-Dose : "+this.dose);
    }
    public void Afficher() {
    	System.out.print(this.toString());
    }

public void SetNom(String nom) { this.nom=nom;}
public void SetDose(int dose) { this.dose=dose ;}
public String GetNom() { return this.nom ;}
public int GetDose() { return this.dose ;}
}