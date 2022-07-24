package Personne;

import java.util.Scanner;

public class Fournisseur  {
    private String Nom;
    private String adresse;
    
    
    public Fournisseur() {
    	System.out.print("Introduire les infos du Fournisseur : ");
    	Scanner e = new Scanner(System.in);
    	System.out.print("\nNom : ");  this.Nom = e.nextLine(); 
    	System.out.print("\nAdresse : ");  this.adresse = e.nextLine(); 

    }
    public Fournisseur(String nom,String adr) {
    	this.adresse = adr;
    	this.Nom = nom;
    }


    public void SetNom(String nom) { this.Nom=nom ;}
    public String GetNom() {return this.Nom ;}
    public void SetAdresse(String adr) { this.adresse=adr ;}
    public String GetAdresse() {return this.adresse ;}
}