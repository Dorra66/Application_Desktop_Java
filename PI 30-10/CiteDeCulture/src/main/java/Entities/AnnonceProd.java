/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.util.Objects;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

/**
 *
 * @author emna
 */
public class AnnonceProd {
  private int id_prod;
    private String  nom_prod;
    private String description;  
    private int stock;
    private int  prix;
    private String image;

    private StringProperty npProp = new SimpleStringProperty("Hello");
//     private StringProperty pirxProp = new SimpleStringProperty("esprit");
    //private Object PrixProp;
    //private Object pirxProp;

  //  public AnnonceProd(String text, String text0, int parseInt, String text1) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    

    public StringProperty getNpProp() {
        return npProp;
    }

    public void setNpProp(String npProp) {
        this.npProp.set(npProp) ;
    }

   // public StringProperty getPrixProp() {
     //   return pirxProp;
    //}
    
   /* public void setPrixProp(int  PrixProp) {
        this.PrixProp.set(PrixProp) ;
    }*/

   

  //  public void setPirxProp(String  pirxProp) {
    //    this.pirxProp.set(pirxProp);
    //}

    
   
 
    public AnnonceProd() {
    }   
   
    public AnnonceProd(String nom_prod, String description, int stock, int  prix, String image) {
        this.nom_prod = nom_prod;
        this.description = description;
        this.stock = stock;
        this.prix = prix;
        this.image = image;
    }

    public AnnonceProd(int id_prod, String nom, String description, int stock, int  prix, String image) {
        this.id_prod = id_prod;
        this.nom_prod = nom;
        this.description = description;
        this.stock = stock;
        this.prix = prix;
        this.image = image;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public int getPrix() {
        return prix;
    }

    
    public String getImage() {
        return image;
    }

    public void setNom(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "AnnonceProd{" + "id_prod=" + id_prod + ", nom_prod=" + nom_prod + ", description=" + description + ", stock=" + stock + ", prix=" + prix + ", image=" + image + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AnnonceProd other = (AnnonceProd) obj;
        if (this.id_prod != other.id_prod) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (!Objects.equals(this.nom_prod, other.nom_prod)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }
 
  public void diminuer_stock (int nombre) {
        AnnonceProd a=new AnnonceProd();
	int s=a.getStock();
       s-= nombre;
      }

    
    
}