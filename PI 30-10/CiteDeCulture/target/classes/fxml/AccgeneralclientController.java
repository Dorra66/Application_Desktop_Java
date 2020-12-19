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
public class AccgeneralclientController implements Initializable {

    @FXML
    private Button decg2;
    @FXML
    private Button acg2;
    @FXML
    private Button btnClientMusee;
    @FXML
    private Button evenement2;
    @FXML
    private Button ecommerce3;
    @FXML
    private Button btnLibC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         acg2.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil1.fxml"));
                acg2.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AccgeneralclientController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
         decg2.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("Login.fxml"));
                decg2.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AccgeneralclientController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
         
         
         
         
    }    

    @FXML
    private void GoToClientMusee(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("acceuilCM.fxml"));
            btnClientMusee.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccgeneralclientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showEventEspace2(ActionEvent event) {
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("homeClient.fxml"));
            evenement2.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccgeneralclientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showecommerce3(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("GestionCommande.fxml"));
            ecommerce3.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccgeneralclientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void toLibClient(ActionEvent event) {
        
                Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("libhomeuser.fxml"));
            btnLibC.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AccgeneralclientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
