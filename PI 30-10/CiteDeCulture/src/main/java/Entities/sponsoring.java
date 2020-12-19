/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author dorra
 */
public class sponsoring {
    
  
   private int id ;
   
   private Date date_contrat ;
   private String description;

    public sponsoring() {
    }

    public sponsoring(int id ,Date date_contrat, String description) {
       
        this.id = id;
       
        this.date_contrat = date_contrat;
        this.description = description;
    }

    public sponsoring(Date date_contrat, String description) {
       
        this.date_contrat = date_contrat;
        this.description = description;
    }

   

    public int getId() {
        return id;
    }

   
    public Date getDate_contrat() {
        return date_contrat;
    }

    public String getDescription() {
        return description;
    }

   

    public void setId(int id) {
        this.id = id;
    }

   
    public void setDate_contrat(Date date_contrat) {
        this.date_contrat = date_contrat;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "sponsoring{"+ " id=" + id + ", date_contrat=" + date_contrat + ", description=" + description + '}';
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
        final sponsoring other = (sponsoring) obj;
       
        if (!Objects.equals(this.date_contrat, other.date_contrat)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
   
   
   
    
}
