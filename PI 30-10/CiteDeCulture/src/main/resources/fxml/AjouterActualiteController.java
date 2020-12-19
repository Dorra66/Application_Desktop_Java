/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.actualités;
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
public class AjouterActualiteController implements Initializable {

    @FXML
    private DatePicker dp1;
    @FXML
    private DatePicker dpa2;
    @FXML
    private TextArea txta1;
    @FXML
    private TextField txta2;
    @FXML
    private Button btna1;
    @FXML
    private TextField txtn1;
    @FXML
    private Button btnn1;
    @FXML
    private Button r1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         btnn1.setOnAction((event) -> {
             FileChooser f = new FileChooser();
                f.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("img", "*.*")
            );
                
                File fi = f.showOpenDialog(null);
                
                if(fi!=null){
                txtn1.setText(fi.getName());
    }
        });
        
         btna1.setOnAction(e->{
             try {
                 java.sql.Date a = java.sql.Date.valueOf(dp1.getValue());
                 java.sql.Date b = java.sql.Date.valueOf(dpa2.getValue());
                         if(txta1.getText().equalsIgnoreCase("") || txta2.getText().equalsIgnoreCase("") || txtn1.getText().equalsIgnoreCase("")){
            
                  Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("Veuillez remplir tous les champs");
                        alert.show();}
                         else{
                 actualités p = new actualités(a, b,txta1.getText(), txta2.getText(), txtn1.getText());
                 actualitésService ps = new actualitésService();
                 ps.inserta(p);
                 Parent root ;
                 try {
                 root=FXMLLoader.load(getClass().getResource("ajouterActualite.fxml"));
                 btna1.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("actualité ajoutée");
                    alert.show();}
           } catch (Exception ee) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);

                        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir le champ date !");
        alert.show();
            }    
                 
    });  
         
          r1.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                r1.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
         
         
    }    
    
}
