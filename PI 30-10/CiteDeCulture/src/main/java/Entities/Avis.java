/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author ASUS
 */
public class Avis {
    
    private int IdAvis;
    private int IdEvent;
    private int IdUser;
    private String DescriptionAvis;

    public Avis() {
    }

    public Avis(int IdAvis, int id_event, int id_user, String DescriptionAvis) {
        this.IdAvis = IdAvis;
        this.IdEvent = id_event;
        this.IdUser = id_user;
        this.DescriptionAvis = DescriptionAvis;
    }

    public Avis(int id_event, int id_user, String DescriptionAvis) {
        this.IdEvent = id_event;
        this.IdUser = id_user;
        this.DescriptionAvis = DescriptionAvis;
    }

    public Avis(int IdAvis, String DescriptionAvis) {
        this.IdAvis = IdAvis;
        this.DescriptionAvis = DescriptionAvis;
    }
    
    


   
    public Avis(String DescriptionAvis) {
        this.DescriptionAvis = DescriptionAvis;
    }
    

    

    public int getIdAvis() {
        return IdAvis;
    }

    public void setIdAvis(int IdAvis) {
        this.IdAvis = IdAvis;
    }

    public String getDescriptionAvis() {
        return DescriptionAvis;
    }

    public void setDescriptionAvis(String DescriptionAvis) {
        this.DescriptionAvis = DescriptionAvis;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int id_user) {
        this.IdUser = id_user;
    }

    public int getIdEvent() {
        return IdEvent;
    }

    public void setIdEvent(int id_event) {
        this.IdEvent = id_event;
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
        final Avis other = (Avis) obj;
        if (this.IdAvis != other.IdAvis) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avis{" + "IdAvis=" + IdAvis + ", DescriptionAvis=" + DescriptionAvis + ", id_user=" + IdUser + ", id_event=" + IdEvent + '}';
    }

   
    
    
    
}
