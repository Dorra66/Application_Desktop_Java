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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Services.actualitésService;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class SupprimerActualiteController implements Initializable {

    @FXML
    private Button btna4;
    @FXML
    private TextField txta13;
    @FXML
    private Button r4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         btna4.setOnAction(e->{
                 try{
                 Integer a = Integer.parseInt(txta13.getText()) ;
                       
                 actualitésService ps = new actualitésService();
                 ps.deletePsta(a);
                 Parent root ;
                    try{
                 root=FXMLLoader.load(getClass().getResource("supprimerActualite.fxml"));
                 btna4.getScene().setRoot(root);}
               catch (IOException ex) {
                 Logger.getLogger(SupprimerActualiteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("actualité supprimée avec succés");
                    alert.show();
                 } catch (Exception ee) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir le champ ID !");
        alert.show();
            }    
                    
                    
    }); 
         
         
         r4.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                r4.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(SupprimerActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
    
}
}
