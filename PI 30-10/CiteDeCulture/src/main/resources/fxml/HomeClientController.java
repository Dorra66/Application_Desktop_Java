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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class HomeClientController implements Initializable {

    @FXML
    private Button consultermyevents;
    @FXML
    private Button ajoutermyreservation;
    @FXML
    private Button consultermesparticipations;
    @FXML
    private Button consultermesavi;
    @FXML
    private Button HomeBackClient1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             }    

    @FXML
    private void consultevents(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
                consultermyevents.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeClientController.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    @FXML
    private void ajoutermyreservation(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("ajouterdemande.fxml"));
                ajoutermyreservation.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void consultermesparticip(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("mesparticipations.fxml"));
                consultermesparticipations.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void consultermesavis(Event event) {
          Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("mesavis.fxml"));
                consultermesavi.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void HomeBackClient1(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("accgeneralclient.fxml"));
                HomeBackClient1.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
