/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.personne;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.text.Document;
import Services.personneService ;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class ModCoordController implements Initializable {

    @FXML
    private TextField modnc;
    @FXML
    private TextField modpc;
    @FXML
    private PasswordField modmdpc;
    @FXML
    private Button bmod3;
    @FXML
    private Button bmod2;
    @FXML
    private Button bmod1;
    @FXML
    private Button rett;
    @FXML
    private TextField emailemail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //modif nom
        modnc.setText(LoginController.PERSONNECONNECTEE.getNom());
        modpc.setText(LoginController.PERSONNECONNECTEE.getPrenom());
        modmdpc.setText(LoginController.PERSONNECONNECTEE.getPassword());
        emailemail.setText(LoginController.PERSONNECONNECTEE.getEmail());
         bmod1.setOnAction(e->{
         if(modnc.getText().equalsIgnoreCase("") ||emailemail.getText().equalsIgnoreCase("") ){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir tous les champs !");
                        alert.show();}
                      else{
                              personne p = new personne();
                                p.setEmail(emailemail.getText());
                                personneService ps1 = new personneService();
                             ps1.updateclient_n(modnc.getText(), emailemail.getText());
                             Parent root ;
                                try{
                               root=FXMLLoader.load(getClass().getResource("ModCoord.fxml"));
                               bmod1.getScene().setRoot(root);
                           } catch (IOException ex) {
                               Logger.getLogger(ModCoordController.class.getName()).log(Level.SEVERE, null, ex);
                           }
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("nom modifiée avec succés");
                    alert.show();}
    
                             
           

             }); 
         
         //modif prenom
         bmod2.setOnAction(e->{
         
              if(modpc.getText().equalsIgnoreCase("") ||emailemail.getText().equalsIgnoreCase("") ){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir tous les champs !");
                        alert.show();}
                      else{
                              personne p = new personne();
                                p.setEmail(emailemail.getText());
                                personneService ps1 = new personneService();
                             ps1.updateclient_n(modpc.getText(), emailemail.getText());
                             Parent root ;
                                try{
                               root=FXMLLoader.load(getClass().getResource("ModCoord.fxml"));
                               bmod2.getScene().setRoot(root);
                           } catch (IOException ex) {
                               Logger.getLogger(ModCoordController.class.getName()).log(Level.SEVERE, null, ex);
                           }
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("prenom modifiée avec succés");
                    alert.show();}
    
                             
           

             }); 
         
         //modif mdp
         bmod3.setOnAction(e->{
         if(modmdpc.getText().equalsIgnoreCase("") ||emailemail.getText().equalsIgnoreCase("") ){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir tous les champs !");
                        alert.show();}
                      else{
                              personne p = new personne();
                                p.setEmail(emailemail.getText());
                                personneService ps1 = new personneService();
                             ps1.updateclient_n(modmdpc.getText(), emailemail.getText());
                             Parent root ;
                                try{
                               root=FXMLLoader.load(getClass().getResource("ModCoord.fxml"));
                               bmod3.getScene().setRoot(root);
                           } catch (IOException ex) {
                               Logger.getLogger(ModCoordController.class.getName()).log(Level.SEVERE, null, ex);
                           }
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Mot de passe modifiée avec succés");
                    alert.show();}
    
                             
           

             }); 
         ///////retour/////////
         rett.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil1.fxml"));
                rett.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(ModifierActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
            
         
    }  
   
    
}
