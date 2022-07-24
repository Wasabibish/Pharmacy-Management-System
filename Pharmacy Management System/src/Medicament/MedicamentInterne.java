package Medicament ;

import Produit.ProduitPharmaceutique;

public class MedicamentInterne extends ProduitPharmaceutique {
    private  static int taux = 20; 
 
    public MedicamentInterne() {
   	 super();
    	
    }
    public MedicamentInterne(String nom, double prix,int seuil,String type,String mode,boolean vendable,int pourcentage,boolean rem ) {
    	super(nom,prix,seuil,type,mode,vendable,pourcentage,rem);
    }
    
    public String toString() {
    	
    	return(super.toString()+"\n-Taux : "+this.GetTaux());
    }
    public void Afficher () {
    	super.Afficher();
    	System.out.print(this.toString());
    }
    

    public void SetTaux(int t) { MedicamentInterne.taux=t;}
    public int GetTaux() {return MedicamentInterne.taux;}
}