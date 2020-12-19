/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import fxml.AjouterActualiteController;
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
public class ModifierSponsoringController implements Initializable {

    @FXML
    private TextField ida3;
    @FXML
    private TextArea txtm12;
    @FXML
    private DatePicker dp10;
    @FXML
    private Button btna23;
    @FXML
    private Button btna22;
    @FXML
    private Button r11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         //modif date_contrat
          btna23.setOnAction(e->{
             try {
                 java.sql.Date a = java.sql.Date.valueOf(dp10.getValue());
                    try{
                 Integer h = Integer.parseInt(ida3.getText()) ;
                 sponsoringService ps4 = new sponsoringService();
                 ps4.updatePsts_date_contrat(a, h);
                 Parent root ;
                    try{
                 root=FXMLLoader.load(getClass().getResource("modifierSponsoring.fxml"));
                 btna23.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(ModifierSponsoringController.class.getName()).log(Level.SEVERE, null, ex);
             }
              Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Date contrat modifiée avec succés");
                    alert.show();
                 }catch (Exception ee) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir le champ ID !");
        alert.show();
            }    
           } catch (Exception ee) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir le champ date !");
        alert.show();
            }   
             }); 
          //modif description
         
             btna22.setOnAction(e->{
             try {
                 Integer b = Integer.parseInt(ida3.getText()) ;
                             if(txtm12.getText().equalsIgnoreCase("")){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir le champ description !");
                        alert.show();}
                         else{
                 sponsoringService ps5 = new sponsoringService();
                 ps5.updatePsts_description(txtm12.getText(), b);
                 Parent root ;
                    try{
                 root=FXMLLoader.load(getClass().getResource("modifierSponsoring.fxml"));
                 btna22.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(ModifierSponsoringController.class.getName()).log(Level.SEVERE, null, ex);
             }
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Description modifiée avec succés");
                    alert.show();}
           } catch (Exception ee) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir le champ ID !");
                        alert.show();
            }   
             
             }); 
             
             r11.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                r11.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
    }    
    
}
