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
public class AcceuilCMController implements Initializable {

    @FXML
    private Button btnShMon;
    @FXML
    private Button btnARequest;
    @FXML
    private Button btnSC;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnMyReq;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showMonument(ActionEvent event) {
        Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherMonumentClient.fxml"));
                    btnShMon.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilCMController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void GoToARequest(ActionEvent event) {
        Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/demandeVisite.fxml"));
                    btnARequest.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilCMController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void GoToSC(ActionEvent event) {
        Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ajouterReclamationClient.fxml"));
                    btnSC.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilCMController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void goToCHome(ActionEvent event) {
        Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accgeneralclient.fxml"));
                    btnSC.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilCMController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void GoToMyReq(ActionEvent event) {
        Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherMesDemandes.fxml"));
                    btnARequest.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilCMController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
}
