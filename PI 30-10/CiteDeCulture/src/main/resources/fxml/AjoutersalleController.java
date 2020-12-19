/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Salle;
import Services.SalleService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutersalleController implements Initializable {

    @FXML
    private Button ajoutersalle;
    @FXML
    private TextField libelle;
    @FXML
    private TextField capacite;
    @FXML
    private TextField categorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ajoutersalle.setOnAction(e->{
             Salle s=new Salle(libelle.getText(),Integer.parseInt(capacite.getText()),categorie.getText());
            SalleService ps=new SalleService();
            ps.insert(s);
            
            Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichagesalle.fxml"));
                ajoutersalle.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjoutersalleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }    
    
}
