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
public class Panier {
    private int id;
    private int id_prod;
    private int id_client;
  

    public Panier() {
    }

    public Panier(int id, int id_prod, int id_client) {
        this.id = id;
        this.id_prod = id_prod;
        this.id_client = id_client;
    }

    public Panier(int id_prod, int id_client) {
        this.id_prod = id_prod;
        this.id_client = id_client;
    }

    public int getId() {
        return id;
    }

    public int getId_prod() {
        return id_prod;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", id_prod=" + id_prod + ", id_client=" + id_client + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Panier other = (Panier) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_prod != other.id_prod) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        return true;
    }

    
    
    
}  