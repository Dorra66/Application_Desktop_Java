/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import fxml.AjouterActualiteController;
import Entities.publicités;
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
import Services.publicitésService;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class AjouterPubliciteController implements Initializable {

    @FXML
    private TextField txta6;
    @FXML
    private TextArea txta7;
    @FXML
    private Button btna2;
    @FXML
    private TextField txtn3;
    @FXML
    private Button btnn3;
    @FXML
    private Button r5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btnn3.setOnAction((event) -> {
            
             FileChooser f = new FileChooser();
                f.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("imag", "*.*")
            );
                
                File fi = f.showOpenDialog(null);
                
                if(fi!=null){
                txtn3.setText(fi.getName());
    }
                
        });
        
         btna2.setOnAction(e->{
             
             if(txta6.getText().equalsIgnoreCase("") || txta7.getText().equalsIgnoreCase("") || txtn3 .getText().equalsIgnoreCase("")){
            
                  Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir tous les champs !");
                        alert.show();}
                         else{
              publicités p = new publicités(txta6.getText(), txta7.getText(), txtn3.getText());
                 publicitésService ps = new publicitésService();
                 ps.insertp(p);
                 Parent root ;
                 
                 
            try {
                root=FXMLLoader.load(getClass().getResource("ajouterPublicite.fxml"));
                btna2.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterPubliciteController.class.getName()).log(Level.SEVERE, null, ex);
            }
             Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("pub ajoutée");
                    alert.show();
                 
         
             }           
                        
    });   
        
       
         
           
         
         r5.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                r5.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            });
    }
}
                 
                 
                 

    


