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
 * @author dorra
 */
public class AccgeneralController implements Initializable {

    @FXML
    private Button acg1;
    @FXML
    private Button decg1;
    @FXML
    private Button btnAdminMusee;
    @FXML
    private Button evenement1;
    @FXML
    private Button ecommerce;
    @FXML
    private Button bttnLibA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        acg1.setOnAction(e -> {
            try {

                Parent root;
                root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                acg1.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AccgeneralController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        decg1.setOnAction(e -> {
            try {

                Parent root;
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                decg1.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AccgeneralController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

    }

    @FXML
    private void GoToAdminMusee(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("acceuilAM.fxml"));
            btnAdminMusee.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccgeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void EventEspaceShow(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            evenement1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccgeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ecommerceshow(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("GestionProduit.fxml"));
            ecommerce.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccgeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void toLibAdmin(ActionEvent event) {
        
                Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("homelib.fxml"));
            bttnLibA.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccgeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
