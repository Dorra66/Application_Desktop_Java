/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Issue {

        int issueId,bookId,idMembre,renewCount; 
        Timestamp issueTime;

    public Issue() {
    }

    public Issue(int issueId, int bookId, int idMembre, int renewCount, Timestamp issueTime) {
        this.issueId = issueId;
        this.bookId = bookId;
        this.idMembre = idMembre;
        this.renewCount = renewCount;
        this.issueTime = issueTime;
    }

    public Issue(int bookId, int idMembre, int renewCount, Timestamp issueTime) {
        this.bookId = bookId;
        this.idMembre = idMembre;
        this.renewCount = renewCount;
        this.issueTime = issueTime;
    }

    public Issue(int bookId, int idMembre) {
        this.bookId = bookId;
        this.idMembre = idMembre;
    }
    

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getRenewCount() {
        return renewCount;
    }

    public void setRenewCount(int renewCount) {
        this.renewCount = renewCount;
    }

    public Timestamp getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Timestamp issueTime) {
        this.issueTime = issueTime;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.issueId;
        hash = 97 * hash + this.bookId;
        hash = 97 * hash + this.idMembre;
        hash = 97 * hash + this.renewCount;
        hash = 97 * hash + Objects.hashCode(this.issueTime);
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
        final Issue other = (Issue) obj;
        if (this.issueId != other.issueId) {
            return false;
        }
        if (this.bookId != other.bookId) {
            return false;
        }
        if (this.idMembre != other.idMembre) {
            return false;
        }
        if (this.renewCount != other.renewCount) {
            return false;
        }
        if (!Objects.equals(this.issueTime, other.issueTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Issue{" + "issueId=" + issueId + ", bookId=" + bookId + ", idMembre=" + idMembre + ", renewCount=" + renewCount + ", issueTime=" + issueTime + '}';
    }

}

