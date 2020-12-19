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
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static javax.management.remote.JMXConnectorFactory.connect;
import Services.personneService;


/**
 * FXML Controller class
 *
 * @author dorra
 */
public class InscriptionController implements Initializable {

    @FXML
    private Button inscription1;
    @FXML
    private TextField nomc;
    @FXML
    private TextField prenomc;
    @FXML
    private TextField emailc;
    @FXML
    private PasswordField mdpc;
    @FXML
    private Button reti;
    @FXML
    private TextField cin1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        inscription1.setOnAction((event) -> {
            if(emailc.getText().equalsIgnoreCase("") || mdpc.getText().equalsIgnoreCase("") || nomc.getText().equalsIgnoreCase("") || prenomc.getText().equalsIgnoreCase("") || cin1.getText().equalsIgnoreCase("")){
            
                  Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs !");
        alert.show();

            
            }
            
            else
                if(!isValid(emailc.getText())){
                 Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Email incorrect!");
        alert.show();

            }
             
              else{
                    personne p = new personne();
                  
                    p.setRole("client");
                    p.setNom(nomc.getText());
                    p.setPrenom(prenomc.getText());
                    p.setEmail(emailc.getText());
                    p.setPassword(mdpc.getText());
                     p.setCin(Integer.parseInt(cin1.getText()));
                   
                    personneService s1 = new personneService();
                     if(!s1.check(p)){
                    s1.insert(p);
                    Parent root;
                    
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Bienvenue"+" "+ s1.SearchByMail(p.getEmail()).getPrenom());
                    alert.show();
                    
                    try {
                            
                            root=FXMLLoader.load(getClass().getResource("accgeneralclient.fxml"));
                             inscription1.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      }
             
              else{
                     Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Client dejà existant!");
        alert.show();
                    }
                     }
                     });
        
        reti.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("Login.fxml"));
                reti.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
        
    }
///////////method/////////////


 public static boolean isValid(String emailc){
     
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (emailc == null) 
            return false; 
        return pat.matcher(emailc).matches(); 
     
          }
     

}
        
                
  
                
          
