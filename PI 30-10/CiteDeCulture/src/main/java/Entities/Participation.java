/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Participation {
    
    private int IdParticipation;
    private int IdEvent;
    private int IdUser;

    public Participation(int IdParticipation, int IdEvent, int IdUser) {
        this.IdParticipation = IdParticipation;
        this.IdEvent = IdEvent;
        this.IdUser = IdUser;
    }

    public Participation(int IdEvent, int IdUser) {
        this.IdEvent = IdEvent;
        this.IdUser = IdUser;
    }

    public Participation() {
        
    }
    
    public Participation(int IdEvent) {
        this.IdEvent = IdEvent;
    }

    public int getIdParticipation() {
        return IdParticipation;
    }

    public void setIdParticipation(int IdParticipation) {
        this.IdParticipation = IdParticipation;
    }

    public int getIdEvent() {
        return IdEvent;
    }

    public void setIdEvent(int IdEvent) {
        this.IdEvent = IdEvent;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
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
        final Participation other = (Participation) obj;
        if (this.IdParticipation != other.IdParticipation) {
            return false;
        }
        if (this.IdEvent != other.IdEvent) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Participation{" + "IdParticipation=" + IdParticipation + ", IdEvent=" + IdEvent + ", IdUser=" + IdUser + '}';
    }

   
    
    
   
    
}
