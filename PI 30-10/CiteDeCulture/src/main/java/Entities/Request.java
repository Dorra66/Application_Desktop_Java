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
public class Request {
    
    int idRequest;
    String bookTitle,membreName,membreLastName,membreMail;

    
    public Request() {
    }

    public Request(int idRequest, String bookTitle, String membreName, String membreLastName, String membreMail) {
        this.idRequest = idRequest;
        this.bookTitle = bookTitle;
        this.membreName = membreName;
        this.membreLastName = membreLastName;
        this.membreMail = membreMail;
    }

    public Request(String bookTitle, String membreName, String membreLastName, String membreMail) {
        this.bookTitle = bookTitle;
        this.membreName = membreName;
        this.membreLastName = membreLastName;
        this.membreMail = membreMail;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getMembreName() {
        return membreName;
    }

    public void setMembreName(String membreName) {
        this.membreName = membreName;
    }

    public String getMembreLastName() {
        return membreLastName;
    }

    public void setMembreLastName(String membreLastName) {
        this.membreLastName = membreLastName;
    }

    public String getMembreMail() {
        return membreMail;
    }

    public void setMembreMail(String membreMail) {
        this.membreMail = membreMail;
    }

    @Override
    public String toString() {
        return "Request{" + "idRequest=" + idRequest + ", bookTitle=" + bookTitle + ", membreName=" + membreName + ", membreLastName=" + membreLastName + ", membreMail=" + membreMail + '}';
    }
}