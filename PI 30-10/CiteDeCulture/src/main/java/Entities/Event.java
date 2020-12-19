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
 * @author ASUS
 */
public class Event {
    
    private int IdEvent;
    private String NomEvent;
    private String CategorieEvent;
    private int NbrPlaceDispo;
    private Date DateEvent;
    private String HeureEvent;
    private String affiche;

    public Event(int IdEvent, String NomEvent, String CategorieEvent, int NbrPlaceDispo, Date DateEvent, String HeureEvent, String affiche) {
        this.IdEvent = IdEvent;
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.NbrPlaceDispo = NbrPlaceDispo;
        this.DateEvent = DateEvent;
        this.HeureEvent = HeureEvent;
        this.affiche = affiche;
    }

    public Event() {
    }

    public Event(int IdEvent) {
        this.IdEvent = IdEvent;
    }
    
    

    public Event(String NomEvent, String CategorieEvent, int NbrPlaceDispo, Date DateEvent, String HeureEvent, String affiche) {
        this.NomEvent = NomEvent;
        this.CategorieEvent = CategorieEvent;
        this.NbrPlaceDispo = NbrPlaceDispo;
        this.DateEvent = DateEvent;
        this.HeureEvent = HeureEvent;
        this.affiche = affiche;
    }

    public int getIdEvent() {
        return IdEvent;
    }

    public void setIdEvent(int IdEvent) {
        this.IdEvent = IdEvent;
    }

    public String getNomEvent() {
        return NomEvent;
    }

    public void setNomEvent(String NomEvent) {
        this.NomEvent = NomEvent;
    }

    public String getCategorieEvent() {
        return CategorieEvent;
    }

    public void setCategorieEvent(String CategorieEvent) {
        this.CategorieEvent = CategorieEvent;
    }

    public int getNbrPlaceDispo() {
        return NbrPlaceDispo;
    }

    public void setNbrPlaceDispo(int NbrPlaceDispo) {
        this.NbrPlaceDispo = NbrPlaceDispo;
    }

    public Date getDateEvent() {
        return DateEvent;
    }

    public void setDateEvent(Date DateEvent) {
        this.DateEvent = DateEvent;
    }

    public String getHeureEvent() {
        return HeureEvent;
    }

    public void setHeureEvent(String HeureEvent) {
        this.HeureEvent = HeureEvent;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.IdEvent;
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
        final Event other = (Event) obj;
        if (this.IdEvent != other.IdEvent) {
            return false;
        }
        return true;
    }

    

   

    @Override
    public String toString() {
        return "Event{" + "IdEvent=" + IdEvent + ", NomEvent=" + NomEvent + ", CategorieEvent=" + CategorieEvent + ", NbrPlaceDispo=" + NbrPlaceDispo + ", DateEvent=" + DateEvent + ", HeureEvent=" + HeureEvent + ", affiche=" + affiche + '}';
    }

    
    
}
