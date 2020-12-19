/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author dorra
 */
public class publicités {
   
    private int id ; 
   
    private String titre ;
    private String description ;
    private String imag;

    public publicités( int id, String titre, String description,String imag) {
        
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.imag = imag;
    }

    public publicités(String titre, String description,String imag) {
       
        this.titre = titre;
        this.description = description;
        this.imag = imag;
    }
    
    
    public publicités(){
    }

    

    public int getId() {
        return id;
    }

   

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    

    public void setId(int id) {
        this.id = id;
    }

   

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public String toString() {
        return "publicité "+'{' + "id=" + id + ", titre=" + titre + ", description=" + description + ", imag=" + imag + '}';
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
        final publicités other = (publicités) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.imag, other.imag)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
}
