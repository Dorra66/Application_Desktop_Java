/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import fxml.AjouterActualiteController;
import java.io.File;
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
import javafx.stage.FileChooser;
import Services.actualitésService;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class ModifierActualiteController implements Initializable {

    @FXML
    private Button btna7;
    @FXML
    private DatePicker dp6;
    @FXML
    private DatePicker dp7;
    @FXML
    private TextArea txtm1;
    @FXML
    private TextField txtm2;
    @FXML
    private TextField ida1;
    @FXML
    private Button btna8;
    @FXML
    private Button btna9;
    @FXML
    private Button btna10;
    @FXML
    private TextField txtn2;
    @FXML
    private Button btnn3;
    @FXML
    private Button btnn2;
    @FXML
    private Button r3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //modif description
         btna9.setOnAction(e->{
             try {
                  Integer s = Integer.parseInt(ida1.getText()) ;
                     if(txtm1.getText().equalsIgnoreCase("")){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir le champ description !");
                        alert.show();}
                         else{
                
                 actualitésService ps1 = new actualitésService();
                 ps1.updatePsta_description(txtm1.getText(), s);
                 Parent root ;
                  try{
                 root=FXMLLoader.load(getClass().getResource("modifierActualite.fxml"));
                 btna9.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(ModifierActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
              Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("description modifiée avec succés");
                    alert.show();}
           } catch (Exception ee) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir le champ ID !");
        alert.show();
            }    

             }); 
         //modif titre
          btna10.setOnAction(e->{
             try {
                 Integer r = Integer.parseInt(ida1.getText()) ;
                     if(txtm2.getText().equalsIgnoreCase("")){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir le champ titre !");
                        alert.show();}
                         else{
                 actualitésService ps2 = new actualitésService();
                 ps2.updatePsta_titre(txtm2.getText(), r);
                
                 Parent root ;
                 try{
                 root=FXMLLoader.load(getClass().getResource("modifierActualite.fxml"));
                 btna10.getScene().setRoot(root);}
              catch (IOException ex) {
                 Logger.getLogger(ModifierActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("titre modifiée avec succés");
                    alert.show();}
           } catch (Exception ee) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir le champ ID !");
        alert.show();
            }    
             
             }); 
          //modif date debut
           btna7.setOnAction(e->{
             try {
                 java.sql.Date a = java.sql.Date.valueOf(dp6.getValue());
                 try{
                 Integer r = Integer.parseInt(ida1.getText()) ;
                 actualitésService ps2 = new actualitésService();
                 ps2.updatePsta_date_Début(a, r);
                
                 Parent root ;
                    try{
                 root=FXMLLoader.load(getClass().getResource("modifierActualite.fxml"));
                 btna7.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(ModifierActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Date début modifiée avec succés");
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
           //modif date fin
           btna8.setOnAction(e->{
             try {
                  java.sql.Date b = java.sql.Date.valueOf(dp7.getValue());
                      try{
                 Integer r = Integer.parseInt(ida1.getText()) ;
                 actualitésService ps2 = new actualitésService();
                 ps2.updatePsta_date_Fin(b, r);
                
                 Parent root ;
                    try{
                 root=FXMLLoader.load(getClass().getResource("modifierActualite.fxml"));
                 btna8.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(ModifierActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Date fin modifiée avec succés");
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
           
           btnn2.setOnAction((event) -> {
             FileChooser f = new FileChooser();
                f.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("img", "*.*")
            );
                
                File fi = f.showOpenDialog(null);
                
                if(fi!=null){
                txtn2.setText(fi.getName());
    }
        });
            //modif image
           btnn3.setOnAction(e->{
             try {
                 Integer r = Integer.parseInt(ida1.getText()) ;
                         if(txtn2.getText().equalsIgnoreCase("")){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez saisir une image !");
                        alert.show();}
                         else{
                 actualitésService ps2 = new actualitésService();
                 ps2.updatePsta_img(txtn2.getText(), r);
                            
                 Parent root ;
                    try{
                 root=FXMLLoader.load(getClass().getResource("modifierActualite.fxml"));
                 btnn3.getScene().setRoot(root);}
                    catch (IOException ex) {
                 Logger.getLogger(ModifierActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
              Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Image modifiée avec succés");
                    alert.show();}
           } catch (Exception ee) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir le champ ID !");
                        alert.show();
            }    
             
             }); 
           
           /////////retour////
           r3.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                r3.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(ModifierActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
           
          
    }    
    
}
