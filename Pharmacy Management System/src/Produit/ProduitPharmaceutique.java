package Produit;
import java.util.Scanner;

import Enum.* ;
public class ProduitPharmaceutique extends Produit {
    private TypeM type;
    private ModeM modeDePrise;
    private boolean VendableSansOrd;
    private int pourcentageRembour;
    private Boolean Remboursable ;
    
    public ProduitPharmaceutique(String nom, double prix,int seuil,String type,String mode,boolean vendable,int pourcentage,boolean rem ) {
    	super(nom,prix,seuil);
    	this.type = TypeM.valueOf(type);
    	this.modeDePrise = ModeM.valueOf(mode);
    	this.VendableSansOrd = vendable;
    	if (rem = true) {this.pourcentageRembour=pourcentage;}else this.pourcentageRembour = 0;
    }
    
    public ProduitPharmaceutique(String nom, double prix) {
    	super(nom,prix); 
    	Scanner e = new Scanner (System.in);
    	System.out.print("\n-Type : ");  this.type = TypeM.valueOf(e.nextLine()); 
    	System.out.print("\n-Mode de prise : ");  this.modeDePrise = ModeM.valueOf(e.next());
    	System.out.print("\n-Est-il remboursable ?t/f "); this.VendableSansOrd = e.nextBoolean();
    	if (this.VendableSansOrd =true) {
    	System.out.print("\n-Pourcentage de rembourcement : "); this.pourcentageRembour = e.nextInt();}else this.pourcentageRembour = 0 ;
    	System.out.print("\n-Est-il vendable sans ordonnance ?t/f "); this.VendableSansOrd = e.nextBoolean();
    	

    }
    
    public ProduitPharmaceutique(String nom) {
    	super(nom);
    	Scanner e = new Scanner (System.in);
    	System.out.print("\n-Type : ");  this.type = TypeM.valueOf(e.nextLine()); 
    	System.out.print("\n-Mode de prise : ");  this.modeDePrise = ModeM.valueOf(e.next()); 
    	System.out.print("\n-Est-il remboursable ?t/f "); this.VendableSansOrd = e.nextBoolean();
    	if (this.VendableSansOrd =true) {
    	System.out.print("\n-Pourcentage de rembourcement : "); this.pourcentageRembour = e.nextInt();}else this.pourcentageRembour = 0 ;
    	System.out.print("\n-Est-il vendable sans ordonnance ? "); this.VendableSansOrd = e.nextBoolean();
  
    }

    
    public ProduitPharmaceutique() {
    	super();
    	Scanner e = new Scanner (System.in);
    	System.out.print("\n-Type : ");  this.type = TypeM.valueOf(e.nextLine()); 
    	System.out.print("\n-Mode de prise : ");  this.modeDePrise = ModeM.valueOf(e.next()); 
    	System.out.print("\n-Est-il remboursable ?t/f "); this.VendableSansOrd = e.nextBoolean();
    	if (this.VendableSansOrd =true) {
    	System.out.print("\n-Pourcentage de rembourcement : "); this.pourcentageRembour = e.nextInt();}else this.pourcentageRembour = 0 ;    	System.out.print("\n-Est-il vendable sans ordonnance ? "); this.VendableSansOrd = e.nextBoolean();
    	
    }
    
    public String toString() {
    	
    	return(super.toString()+"\n-Type : "+this.type+"\n-Mode de prise : "+this.modeDePrise+"\n-Pourcentage de remboursement : "+this.pourcentageRembour+
    			"\n-Vendable sans ordonnance : "+this.VendableSansOrd);
    }
    
    public void Afficher() {
    	System.out.print(this.toString());
    }



    public void SetType(TypeM type) { this.type=type ;}
    public void SetModeDePrise(ModeM mode) { this.modeDePrise=mode ;}
    public void SetVendableSansOrd(Boolean b) { this.VendableSansOrd=b ;}
    public void SetPourcentageRembour(int pourcentage) { this.pourcentageRembour=pourcentage ;}
    public void SetRemboursable(Boolean b) { this.Remboursable=b ;}
    
    public TypeM getType() {return this.type;}
    public ModeM getModeDePrise() {return this.modeDePrise;}
    public Boolean GetVendableSansOrd( ) {return this.VendableSansOrd ;}
    public int GetPourcentageRembour() {return this.pourcentageRembour ;}
    public Boolean GetRemboursable( ) {return this.Remboursable ;}
    

}