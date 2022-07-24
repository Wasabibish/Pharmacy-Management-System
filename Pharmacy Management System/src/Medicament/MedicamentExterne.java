package Medicament ;

import java.util.Date;
import java.util.Scanner;


import Produit.ProduitPharmaceutique;

public class MedicamentExterne extends ProduitPharmaceutique {
private  static int taux = 10; 
private int quantité;
private int numLot;
private double prixLot;
private Date dateExp;
private String fournisseur;




    public MedicamentExterne() {
    	
    	super();
    	Scanner e = new Scanner (System.in);
    	
    	System.out.print("\n-Fournisseur : ");  this.fournisseur = e.nextLine(); 
    	System.out.print("\n-Num LOT : ");  this.numLot = e.nextInt(); 
    	System.out.print("\n-Prix D'achat : ");  this.prixLot = e.nextInt(); 
    	System.out.print("\n-Quantité : "); this.quantité = e.nextInt();
    	System.out.print("\n-Date d'expiration sous forme de AAAA MM JJ: ");
    	 Date d = new Date() ;
    	 d.setYear(e.nextInt()-1900);d.setMonth(e.nextInt()-1);d.setDate(e.nextInt());
    	 this.dateExp = d;
    	 
    }
    public MedicamentExterne(String nom, double prix,int seuil,String type,String mode,
    		boolean vendable,int pourcentage,boolean rem,int quantité,int numLot,double prixLot,String fournisseur) {
    	super(nom,prix,seuil,type,mode,vendable,pourcentage,rem);
    	Date d = new Date();
    	 d.setYear(d.getYear()+2);d.setMonth(d.getMonth()-1);// 2ans
    	this.quantité = quantité;
    	this.numLot = numLot;
    	this.prixLot = prixLot;
    	this.dateExp =d;
    	this.fournisseur = fournisseur;
    }
    
    public MedicamentExterne(String nom , double prix) {
    	super(nom,prix);
        Scanner e = new Scanner (System.in);
    	
    	System.out.print("\n-Fournisseur : ");  this.fournisseur = e.nextLine(); 
    	System.out.print("\n-Num LOT : ");  this.numLot = e.nextInt(); 
    	System.out.print("\n-Prix D'achat : ");  this.prixLot = e.nextInt(); 
    	System.out.print("\n-Quantité : "); this.quantité = e.nextInt();
    	System.out.print("\n-Date d'expiration sous forme de AAAA MM JJ: ");
    	 Date d = new Date() ;
    	 d.setYear(e.nextInt()-1900);d.setMonth(e.nextInt()-1);d.setDate(e.nextInt());
    	 this.dateExp = d;
    }
    public MedicamentExterne(String nom ) {
    	super(nom);
        Scanner e = new Scanner (System.in);
    	System.out.print("\n-Fournisseur : ");  this.fournisseur = e.nextLine(); 
    	System.out.print("\n-Num LOT : ");  this.numLot = e.nextInt(); 
    	System.out.print("\n-Prix D'achat : ");  this.prixLot = e.nextInt(); 
    	System.out.print("\n-Quantité : "); this.quantité = e.nextInt();
    	System.out.print("\n-Date d'expiration sous forme de AAAA MM JJ: ");
    	 Date d = new Date() ;
    	 d.setYear(e.nextInt()-1900);d.setMonth(e.nextInt()-1);d.setDate(e.nextInt());
    	 this.dateExp = d;
    }



    public String toString() {
    	
    	return(super.toString()+"\n-Fournisseur : "+this.fournisseur+"\n-Num LOT : "+this.numLot+"\n-Quantité : "+this.quantité+"\n-Date d'expiration : "+this.dateExp);
    }
    public void Afficher() {
    	
    	System.out.print(this.toString());
    }
    
public void SetQuantité(int qtt) { this.quantité=qtt;}
public void SetNumLot(int numL) { this.numLot=numL ;}
public void SetPrix(Double prix) { this.prixLot=prix ;}
public void SetDateExpiaration(Date d) { this.dateExp=d ;}
public void SetFournisseur(String f ) { this.fournisseur=f ;}
public void SetTaux(int t) { MedicamentExterne.taux=t;}

public int GetQuantité() {return this.quantité;}
public int GetNumLot() {return this.numLot ;}
public Double GetPrix() {return this.prixLot ;}
public Date GetDateExpiaration() {return this.dateExp ;}
public String GetFournisseur() {return this.fournisseur;}
public int GetTaux() {return MedicamentExterne.taux;}


}