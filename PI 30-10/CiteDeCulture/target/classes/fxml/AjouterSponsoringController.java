/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import fxml.AjouterActualiteController;
import Entities.sponsoring;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import Services.sponsoringService;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class AjouterSponsoringController implements Initializable {

    @FXML
    private DatePicker dp5;
    @FXML
    private TextArea txta12;
    @FXML
    private Button btna3;
    @FXML
    private Button r9;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         btna3.setOnAction(e->{
           try{
                java.sql.Date a = java.sql.Date.valueOf(dp5.getValue());
                    if(txta12.getText().equalsIgnoreCase("")){
            
                  Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir le champ description !");
                        alert.show();}
                         else{
                sponsoring s = new sponsoring(a, txta12.getText());
                sponsoringService ps = new sponsoringService();
                ps.inserts(s);
                Parent root ;
                try {
                root=FXMLLoader.load(getClass().getResource("ajouterSponsoring.fxml"));
                btna3.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterSponsoringController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Sponsoring ajouté avec succés");
                    alert.show();}
           } catch (Exception ee) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir le champ date !");
        alert.show();
            }    
              
              
              
                    
    });   
         
         
         r9.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                r9.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
    }    
    
}
