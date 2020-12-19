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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import Services.actualitésService;
import Services.publicitésService;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class ModifierPubliciteController implements Initializable {

    @FXML
    private Button btna16;
    @FXML
    private Button btna17;
    @FXML
    private TextField ida2;
    @FXML
    private TextField txtm6;
    @FXML
    private TextArea txtm7;
    @FXML
    private TextField dorra;
    @FXML
    private Button sehli;
    @FXML
    private Button life;
    @FXML
    private Button r7;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         //modif titre
          btna16.setOnAction(e->{
             try {
                 Integer b = Integer.parseInt(ida2.getText()) ;
                         if(txtm6.getText().equalsIgnoreCase("")){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir le champ titre !");
                        alert.show();}
                         else{
                 publicitésService ps3 = new publicitésService();
                 ps3.updatePstp_titre(txtm6.getText(), b);
                 Parent root ;
                    try{
                 root=FXMLLoader.load(getClass().getResource("modifierPublicite.fxml"));
                 btna16.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(ModifierPubliciteController.class.getName()).log(Level.SEVERE, null, ex);
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
         //modif description
         btna17.setOnAction(e->{
             try {
                 Integer b = Integer.parseInt(ida2.getText()) ;
                           if(txtm7.getText().equalsIgnoreCase("")){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir le champ description !");
                        alert.show();}
                         else{    
                 publicitésService ps4 = new publicitésService();
                  ps4.updatePstp_description(txtm7.getText(), b);
                 Parent root ;
                    try{
                 root=FXMLLoader.load(getClass().getResource("modifierPublicite.fxml"));
                 btna17.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(ModifierPubliciteController.class.getName()).log(Level.SEVERE, null, ex);
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
         
         
         sehli.setOnAction((event) -> {
             FileChooser f = new FileChooser();
                f.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("img", "*.*")
            );
                
                File fi = f.showOpenDialog(null);
                
                if(fi!=null){
                dorra.setText(fi.getName());
    }
        });
            //modif image
           life.setOnAction(e->{
             try {
                 Integer r = Integer.parseInt(ida2.getText()) ;
                         if(dorra.getText().equalsIgnoreCase("")){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez saisir une image !");
                        alert.show();}
                         else{  
                publicitésService ps5 = new publicitésService();
                 ps5.updatePstp_imag(dorra.getText(), r);
                
                 Parent root ;
                    try{
                 root=FXMLLoader.load(getClass().getResource("modifierPublicite.fxml"));
                 life.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(ModifierPubliciteController.class.getName()).log(Level.SEVERE, null, ex);
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
           
           r7.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                r7.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            });
           
    }    
    
}
