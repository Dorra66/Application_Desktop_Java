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
import javafx.event.ActionEvent;
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
public class ModifiersalleController implements Initializable {

    @FXML
    private TextField modlibelle;
    @FXML
    private TextField modcapacite;
    @FXML
    private TextField modcategorie;
    @FXML
    private Button modsalle;
    @FXML
    private Button homeback4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        modlibelle.setText(AffichageSalleController.ab.getLibelle());
        modcapacite.setText(String.valueOf(AffichageSalleController.ab.getCapacite()));
        modcategorie.setText(AffichageSalleController.ab.getCategorieSalle());
    }    

    @FXML
    private void mod(ActionEvent event) {
        SalleService ss=new SalleService();
        Salle s=new Salle(modlibelle.getText(),Integer.parseInt(modcapacite.getText()),modcategorie.getText());
        ss.updateSalle(s, AffichageSalleController.ab.getIdSalle());
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("AffichageSalle.fxml"));
                modsalle.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(ModifiersalleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void HomeBack4(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("home.fxml"));
                modsalle.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(ModifiersalleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}
