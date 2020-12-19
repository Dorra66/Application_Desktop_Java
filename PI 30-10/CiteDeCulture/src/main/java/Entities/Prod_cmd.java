/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author emna
 */
public class Prod_cmd {
    int id;
    int id_prod;
    int id_cmd;

    public Prod_cmd() {
    }
    
    
    

    public Prod_cmd(int id, int id_prod, int id_cmd) {
        this.id = id;
        this.id_prod = id_prod;
        this.id_cmd = id_cmd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public void setId_cmd(int id_cmd) {
        this.id_cmd = id_cmd;
    }

    public int getId() {
        return id;
    }

    public int getId_prod() {
        return id_prod;
    }

    public int getId_cmd() {
        return id_cmd;
    }

    @Override
    public String toString() {
        return "Prod_cmd{" + "id=" + id + ", id_prod=" + id_prod + ", id_cmd=" + id_cmd + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Prod_cmd other = (Prod_cmd) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_prod != other.id_prod) {
            return false;
        }
        if (this.id_cmd != other.id_cmd) {
            return false;
        }
        return true;
    }
  
    
    
    
    
    
}
