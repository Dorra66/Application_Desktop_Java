/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class DemandeReserv {
    private int IdReserv;
    private String NomOrg;
    private String PrenomOrg;
    private int TelOrg;
    private String MailOrg;
    private String CategorieReserv;
    private String NomReserv;
    private int NbrPlace;
    private Date DateReserv;
    private String Heure;
    private String Affiche;
    private String Etat;

    public DemandeReserv(String NomOrg, String PrenomOrg, int TelOrg, String MailOrg, String CategorieReserv, String NomReserv, int NbrPlace, Date DateReserv, String Heure, String Affiche, String Etat) {
        this.NomOrg = NomOrg;
        this.PrenomOrg = PrenomOrg;
        this.TelOrg = TelOrg;
        this.MailOrg = MailOrg;
        this.CategorieReserv = CategorieReserv;
        this.NomReserv = NomReserv;
        this.NbrPlace = NbrPlace;
        this.DateReserv = DateReserv;
        this.Heure = Heure;
        this.Affiche = Affiche;
        this.Etat = Etat;
    }

    public DemandeReserv() {
    }

    public DemandeReserv(int IdReserv, String NomOrg, String PrenomOrg, int TelOrg, String MailOrg, String CategorieReserv, String NomReserv, int NbrPlace, Date DateReserv, String Heure, String Affiche, String Etat) {
        this.IdReserv = IdReserv;
        this.NomOrg = NomOrg;
        this.PrenomOrg = PrenomOrg;
        this.TelOrg = TelOrg;
        this.MailOrg = MailOrg;
        this.CategorieReserv = CategorieReserv;
        this.NomReserv = NomReserv;
        this.NbrPlace = NbrPlace;
        this.DateReserv = DateReserv;
        this.Heure = Heure;
        this.Affiche = Affiche;
        this.Etat = Etat;
    }

    public DemandeReserv(String NomOrg, String PrenomOrg, int TelOrg, String MailOrg, String CategorieReserv, String NomReserv, int NbrPlace, Date DateReserv, String Heure, String Affiche) {
        this.NomOrg = NomOrg;
        this.PrenomOrg = PrenomOrg;
        this.TelOrg = TelOrg;
        this.MailOrg = MailOrg;
        this.CategorieReserv = CategorieReserv;
        this.NomReserv = NomReserv;
        this.NbrPlace = NbrPlace;
        this.DateReserv = DateReserv;
        this.Heure = Heure;
        this.Affiche = Affiche;
    }
    

    public int getIdReserv() {
        return IdReserv;
    }

    public void setIdReserv(int IdReserv) {
        this.IdReserv = IdReserv;
    }

    public String getNomOrg() {
        return NomOrg;
    }

    public void setNomOrg(String NomOrg) {
        this.NomOrg = NomOrg;
    }

    public String getPrenomOrg() {
        return PrenomOrg;
    }

    public void setPrenomOrg(String PrenomOrg) {
        this.PrenomOrg = PrenomOrg;
    }

    public int getTelOrg() {
        return TelOrg;
    }

    public void setTelOrg(int TelOrg) {
        this.TelOrg = TelOrg;
    }

    public String getMailOrg() {
        return MailOrg;
    }

    public void setMailOrg(String MailOrg) {
        this.MailOrg = MailOrg;
    }

    public String getCategorieReserv() {
        return CategorieReserv;
    }

    public void setCategorieReserv(String CategorieReserv) {
        this.CategorieReserv = CategorieReserv;
    }

    public String getNomReserv() {
        return NomReserv;
    }

    public void setNomReserv(String NomReserv) {
        this.NomReserv = NomReserv;
    }

    public int getNbrPlace() {
        return NbrPlace;
    }

    public void setNbrPlace(int NbrPlace) {
        this.NbrPlace = NbrPlace;
    }

    public Date getDateReserv() {
        return DateReserv;
    }

    public void setDateReserv(Date DateReserv) {
        this.DateReserv = DateReserv;
    }

    public String getHeure() {
        return Heure;
    }

    public void setHeure(String Heure) {
        this.Heure = Heure;
    }

    public String getAffiche() {
        return Affiche;
    }

    public void setAffiche(String Affiche) {
        this.Affiche = Affiche;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    @Override
    public String toString() {
        return "DemandeReserv{" + "IdReserv=" + IdReserv + ", NomOrg=" + NomOrg + ", PrenomOrg=" + PrenomOrg + ", TelOrg=" + TelOrg + ", MailOrg=" + MailOrg + ", CategorieReserv=" + CategorieReserv + ", NomReserv=" + NomReserv + ", NbrPlace=" + NbrPlace + ", DateReserv=" + DateReserv + ", Heure=" + Heure + ", Affiche=" + Affiche + ", Etat=" + Etat + '}';
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
        final DemandeReserv other = (DemandeReserv) obj;
        if (this.IdReserv != other.IdReserv) {
            return false;
        }
        if (!Objects.equals(this.NomOrg, other.NomOrg)) {
            return false;
        }
        if (!Objects.equals(this.PrenomOrg, other.PrenomOrg)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
