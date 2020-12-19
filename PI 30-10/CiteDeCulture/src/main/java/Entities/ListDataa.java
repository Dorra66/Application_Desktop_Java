/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Services.actualitésService;

/**
 *
 * @author dorra
 */
public class ListDataa {
    
     private ObservableList <actualités> per=FXCollections.observableArrayList();
    private String titre="";

    public String getTitre() {
        return titre;
    }

    public void setTitre(String Titre) {
        this.titre = Titre;
    }
    
    public ListDataa() {
        
            }
    
    public ObservableList<actualités> getAct(){
        actualitésService pdao= actualitésService.getInstance() ;
        per = pdao.displaybyTitre(titre);
        return per;
    }
    
    
}
