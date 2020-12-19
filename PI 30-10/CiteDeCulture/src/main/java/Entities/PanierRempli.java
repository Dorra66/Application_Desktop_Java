/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author emna
 */
public class PanierRempli {
    private int id_pn;
    private AnnonceProd prod;
    private personne clt;

    public PanierRempli() {
    }
    

    
    
    
    
    public PanierRempli(int id_pn, AnnonceProd prod, personne clt) {
        this.id_pn = id_pn;
        this.prod = prod;
        this.clt = clt;
    }

    public PanierRempli(AnnonceProd prod) {
        this.prod = prod;
    }

    

    public int getId_pn() {
        return id_pn;
    }

    public AnnonceProd getProd() {
        return prod;
    }

    public personne getClt() {
        return clt;
    }

    public void setId_pn(int id_pn) {
        this.id_pn = id_pn;
    }

    public void setProd(AnnonceProd prod) {
        this.prod = prod;
    }

    public void setClt(personne clt) {
        this.clt = clt;
    }

    @Override
    public String toString() {
        return "PanierRempli{" + "id_pn=" + id_pn + ", prod=" + prod + ", clt=" + clt + '}';
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
        final PanierRempli other = (PanierRempli) obj;
        if (this.id_pn != other.id_pn) {
            return false;
        }
        if (!Objects.equals(this.prod, other.prod)) {
            return false;
        }
        if (!Objects.equals(this.clt, other.clt)) {
            return false;
        }
        return true;
    }
 
    
    
    
    
    
    
    
    
    
    
    
    
}



    
    
    

