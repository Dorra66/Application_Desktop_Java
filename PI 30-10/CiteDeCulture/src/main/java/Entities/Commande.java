/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Commande {
    
  private int id;
    private String date; 
    private int total;
    private int id_cl;

    public Commande() {
    }

    public Commande(String date) {
        this.date = date;
    }
    

    public Commande(int total, int id_cl) {
        this.total = total;
        this.id_cl = id_cl;
    }

    
    
    
    

    public Commande(int id ,String date, int total ,int id_cl) {
        this.id=id;
        this.date = date;
        this.total = total;
        this.id_cl = id_cl;
        
    }

    public Commande(String  date, int total,int id_cl) {
        this.date = date;
        this.total = total;
        this.id_cl = id_cl;
    }
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    

    public void setDate(String date) {
        this.date = date;
    }

    

    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId_cl() {
        return id_cl;
    }

    public void setId_cl(int id_cl) {
        this.id_cl = id_cl;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", date=" + date + ", total=" + total + ", id_cl=" + id_cl + '}';
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
        final Commande other = (Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.total != other.total) {
            return false;
        }
        if (this.id_cl != other.id_cl) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

}