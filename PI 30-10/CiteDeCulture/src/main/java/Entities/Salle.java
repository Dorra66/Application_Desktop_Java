/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ASUS
 */
public class Salle {
    private int IdSalle;
    private String Libelle;
    private int Capacite;
    private String CategorieSalle;

    public Salle(int IdSalle, String Libelle, int Capacite, String CategorieSalle) {
        this.IdSalle = IdSalle;
        this.Libelle = Libelle;
        this.Capacite = Capacite;
        this.CategorieSalle = CategorieSalle;
    }

    public Salle(String Libelle, int Capacite, String CategorieSalle) {
        this.Libelle = Libelle;
        this.Capacite = Capacite;
        this.CategorieSalle = CategorieSalle;
    }
    
    
    public Salle() {
    }

    public int getIdSalle() {
        return IdSalle;
    }

    public void setIdSalle(int IdSalle) {
        this.IdSalle = IdSalle;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle =Libelle;
    }

    public int getCapacite() {
        return Capacite;
    }

    public void setCapacite(int Capacite) {
        this.Capacite = Capacite;
    }

    public String getCategorieSalle() {
        return CategorieSalle;
    }

    public void setCategorieSalle(String CategorieSalle) {
        this.CategorieSalle = CategorieSalle;
    }

    @Override
    public String toString() {
        return "Salle{" + "IdSalle=" + IdSalle + ", Libelle=" + Libelle + ", Capacite=" + Capacite + ", CategorieSalle=" + CategorieSalle + '}';
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.IdSalle != other.IdSalle) {
            return false;
        }
        if (!Objects.equals(this.Libelle, other.Libelle)) {
            return false;
        }
        return true;
    }
    
    
}
