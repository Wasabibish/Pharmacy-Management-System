package Produit;
import Enum.TypePP ;

import java.util.Scanner;

import Enum.ModeM;
public class ProduitParapharmaceutique extends Produit {
	private int Quantit� ;
    private TypePP type;
    private ModeM modedeprise;
    

    public ProduitParapharmaceutique(String nom, double prix,int seuil,int qt,String type,String mode) {
    	super(nom,prix,seuil);
    	this.Quantit� = qt;
    	this.modedeprise = ModeM.valueOf(mode);
    	this.type = TypePP.valueOf(type);
    }
    
    public ProduitParapharmaceutique(String nom) {
    	super(nom);
    	Scanner e = new Scanner (System.in);
    	System.out.print("\n-Type : ");  this.type = TypePP.valueOf(e.nextLine()); 
    	System.out.print("\n-Mode : ");  this.modedeprise = ModeM.valueOf(e.nextLine()); 
    	System.out.print("\n-Quantit� : ");  this.Quantit� = e.nextInt() ;
    	
    }
    
    public ProduitParapharmaceutique() {
    	super();
    	Scanner e = new Scanner (System.in);
    	System.out.print("\n-Type : ");  this.type = TypePP.valueOf(e.nextLine()); 
    	System.out.print("\n-Mode : ");  this.modedeprise = ModeM.valueOf(e.nextLine()); 
    	System.out.print("\n-Quantit� : ");  this.Quantit� = e.nextInt() ;
    	
    }
    public String toString() {
    	
    	return(super.toString()+"\n-Type : "+this.type+"\n-Mode de prise : "+this.modedeprise);
    }
    public void Afficher() {
    	super.Afficher();
    	System.out.print(this.toString());
    }

    public void SetType(TypePP type) { this.type=type ;}
    public void SetModeDePrise(ModeM mode) { this.modedeprise=mode ;}
    public void setQtt(int quantit�) {this.Quantit�=quantit� ;  }
  
    
    
    public TypePP getType() {return this.type;}
    public ModeM getModeDePrise() {return this.modedeprise;}
    public int getQuantit�() {return this.Quantit�;}

}