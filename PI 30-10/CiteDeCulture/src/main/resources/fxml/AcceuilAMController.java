/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

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

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AcceuilAMController implements Initializable {

    @FXML
    private Button btnAM;
    @FXML
    private Button btnML;
    @FXML
    private Button btnVR;
    @FXML
    private Button btnCVR;
    @FXML
    private Button btnTT;
    @FXML
    private Button btnHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GoToAM(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ajouterMonument.fxml"));
                btnAM.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AcceuilAMController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void GoToML(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherMonument.fxml"));
                btnML.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AcceuilAMController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void GoToVR(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherDemandeVisite.fxml"));
                btnVR.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AcceuilAMController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void GoToCVR(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ajouterVisite.fxml"));
                btnCVR.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AcceuilAMController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void GoToTT(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherReclamationClient.fxml"));
                btnTT.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AcceuilAMController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void GoToAHome(ActionEvent event) {
         try {
             Parent root;
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accgeneral.fxml"));
                btnHome.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AcceuilAMController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
