/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Membre {
    
    int idMembre,cinMembre,mobileMembre; 
    String nameMembre,lastnameMembre,mailMembre,adressMembre,SubscriptionMembre;

    public Membre() {
    }

    public Membre(int idMembre,String nameMembre, String lastnameMembre, int cinMembre, int mobileMembre,  String mailMembre, String adressMembre, String SubscriptionMembre) {
        this.idMembre = idMembre;
        this.cinMembre = cinMembre;
        this.mobileMembre = mobileMembre;
        this.nameMembre = nameMembre;
        this.lastnameMembre = lastnameMembre;
        this.mailMembre = mailMembre;
        this.adressMembre = adressMembre;
        this.SubscriptionMembre = SubscriptionMembre;
    }

    public Membre(String nameMembre, String lastnameMembre,int cinMembre, int mobileMembre,  String mailMembre, String adressMembre, String SubscriptionMembre) {
        this.cinMembre = cinMembre;
        this.mobileMembre = mobileMembre;
        this.nameMembre = nameMembre;
        this.lastnameMembre = lastnameMembre;
        this.mailMembre = mailMembre;
        this.adressMembre = adressMembre;
        this.SubscriptionMembre = SubscriptionMembre;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getCinMembre() {
        return cinMembre;
    }

    public void setCinMembre(int cinMembre) {
        this.cinMembre = cinMembre;
    }

    public int getMobileMembre() {
        return mobileMembre;
    }

    public void setMobileMembre(int mobileMembre) {
        this.mobileMembre = mobileMembre;
    }

    public String getNameMembre() {
        return nameMembre;
    }

    public void setNameMembre(String nameMembre) {
        this.nameMembre = nameMembre;
    }

    public String getLastnameMembre() {
        return lastnameMembre;
    }

    public void setLastnameMembre(String lastnameMembre) {
        this.lastnameMembre = lastnameMembre;
    }

    public String getMailMembre() {
        return mailMembre;
    }

    public void setMailMembre(String mailMembre) {
        this.mailMembre = mailMembre;
    }

    public String getAdressMembre() {
        return adressMembre;
    }

    public void setAdressMembre(String adressMembre) {
        this.adressMembre = adressMembre;
    }

    public String getSubscriptionMembre() {
        return SubscriptionMembre;
    }

    public void setSubscriptionMembre(String SubscriptionMembre) {
        this.SubscriptionMembre = SubscriptionMembre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idMembre;
        hash = 47 * hash + this.cinMembre;
        hash = 47 * hash + this.mobileMembre;
        hash = 47 * hash + Objects.hashCode(this.nameMembre);
        hash = 47 * hash + Objects.hashCode(this.lastnameMembre);
        hash = 47 * hash + Objects.hashCode(this.mailMembre);
        hash = 47 * hash + Objects.hashCode(this.adressMembre);
        hash = 47 * hash + Objects.hashCode(this.SubscriptionMembre);
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
        final Membre other = (Membre) obj;
        if (this.idMembre != other.idMembre) {
            return false;
        }
        if (this.cinMembre != other.cinMembre) {
            return false;
        }
        if (this.mobileMembre != other.mobileMembre) {
            return false;
        }
        if (!Objects.equals(this.nameMembre, other.nameMembre)) {
            return false;
        }
        if (!Objects.equals(this.lastnameMembre, other.lastnameMembre)) {
            return false;
        }
        if (!Objects.equals(this.mailMembre, other.mailMembre)) {
            return false;
        }
        if (!Objects.equals(this.adressMembre, other.adressMembre)) {
            return false;
        }
        if (!Objects.equals(this.SubscriptionMembre, other.SubscriptionMembre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Membre{" + "idMembre=" + idMembre + ", cinMembre=" + cinMembre + ", mobileMembre=" + mobileMembre + ", nameMembre=" + nameMembre + ", lastnameMembre=" + lastnameMembre + ", mailMembre=" + mailMembre + ", adressMembre=" + adressMembre + ", SubscriptionMembre=" + SubscriptionMembre + '}';
    }
}
