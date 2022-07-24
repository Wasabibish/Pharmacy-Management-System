package Produit;

import java.util.Scanner;

public class Produit {

    private String nom;
    protected double prix;
    private int seuilMin;
  

    public Produit(String nom, double prix,int seuil) {
    	this.nom = nom;
    	this.prix = prix;
    	this.seuilMin = seuil;
    	
    }
    public Produit(String nom, double prix) {
    	this.nom = nom;
    	this.prix = prix;
    	System.out.print("Introduire les infos du produit ["+nom+"] : ");
    	Scanner e = new Scanner (System.in);
    	System.out.print("\nSeuil : "); this.seuilMin = e.nextInt();
    }
    public Produit(String nom) {
    	this.nom = nom;
    	System.out.print("Introduire les infos du produit : ");
    	Scanner e = new Scanner (System.in);
    	System.out.print("\nPrix De Vente : ");  this.prix= e.nextDouble(); 
    	System.out.print("\nSeuil : "); this.seuilMin = e.nextInt();
    }
    
    public Produit() {
    	System.out.print("Introduire les infos du produit : ");
    	Scanner e = new Scanner (System.in);
    	System.out.print("\nNom : ");  this.nom = e.nextLine(); 
    	System.out.print("\nPrix De Vente : ");  this.prix= e.nextDouble(); 
    	System.out.print("\nSeuil : "); this.seuilMin = e.nextInt();
    	
    }
	
    public String toString() {
    	return("\nLes infos du produit : "+"\n-Nom : "+this.nom+"\n-Prix : "+this.prix+"DA\n-Seuil min : "+this.seuilMin);
    }
    public void Afficher() {
    	System.out.print(this.toString());
    }
    public void SetNom(String nom) { this.nom=nom ;}
    public void SetPrix(Double prix) { this.prix=prix ;}
    public void SetSeuilMin(int seuil) { this.seuilMin=seuil ;}
    
    
    public String getNom() {return this.nom;}
    public Double getPrix() {return this.prix;}
    public int getSeuilMin() {return this.seuilMin;}


}