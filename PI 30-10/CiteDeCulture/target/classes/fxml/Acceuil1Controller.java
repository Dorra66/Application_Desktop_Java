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
public class Acceuil1Controller implements Initializable {

    @FXML
    private Button client1; 
    @FXML
    private Button client2;
    @FXML
    private Button dec2;
    @FXML
    private Button modcoord;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         client1.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("affichagePC.fxml"));
                client1.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
         client2.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("afficherAC.fxml"));
                client2.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
          ////////////////deconnexion//////////////
               dec2.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("accgeneralclient.fxml"));
                dec2.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
               ////////////////////
               modcoord.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("ModCoord.fxml"));
                modcoord.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
        
    }    
    
}
