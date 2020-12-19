/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.personne;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.management.Notification;
import Services.personneService;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField mdp;
    @FXML
    private Button connect;
    @FXML
    private Button inscription;
    public static personne PERSONNECONNECTEE ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        connect.setOnAction((event) -> {

            if (email.getText().equalsIgnoreCase("") || mdp.getText().equalsIgnoreCase("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs");
                alert.show();

            } else {
                personne p = new personne();
                p.setEmail(email.getText());
                p.setPassword(mdp.getText());
                personneService s1 = new personneService();
                try {
                    p = s1.Authentification(email.getText(), mdp.getText());

                    if (p == null) {
                        System.out.println(" sys null");
                    } else {
                        if ((email.getText().equals(s1.Authentification(email.getText(),mdp.getText()).getEmail())) && (p.getRole().equals("admin"))) {
                            System.out.println("Welcome Admin : " + p.getEmail());
                             Alert alert = new Alert(Alert.AlertType.INFORMATION);

                                alert.setTitle("Confirmation");
                            alert.setHeaderText(null);
                            alert.setContentText("Bienvenue admin");
                            alert.show();
                            Parent root;
                            try {
                                root = FXMLLoader.load(getClass().getResource("accgeneral.fxml"));
                            
                            Scene newScene = new Scene(root);
                            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            window.setScene(newScene);
                            window.show();
                            } catch (IOException ex) {
                                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else if ((email.getText().equals(s1.Authentification(email.getText(),mdp.getText()).getEmail())) && (p.getRole().equals("client"))) {
                            System.out.println("Welcome client : " + p);
                             Alert alert = new Alert(Alert.AlertType.INFORMATION);

                                    alert.setTitle("Confirmation");
                                alert.setHeaderText(null);
                                alert.setContentText("Bienvenue"+" "+ s1.SearchByMail(p.getEmail()).getPrenom());
                                alert.show();
                            Parent root;
                            try {
                                root = FXMLLoader.load(getClass().getResource("accgeneralclient.fxml"));
                            
                            Scene newScene = new Scene(root);
                            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            window.setScene(newScene);
                            window.show();
                            } catch (IOException ex) {
                                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        

                    }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                    if (!"dorra.sehli@esprit.tn".equalsIgnoreCase(email.getText())) {
//
//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//
//                        alert.setTitle("Confirmation");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Bienvenue" + " " + s1.SearchByMail(p.getEmail()).getPrenom());
//                        alert.show();
//
//                        try {
//                            Parent root;
//                            root = FXMLLoader.load(getClass().getResource("acceuil1.fxml"));
//                            connect.getScene().setRoot(root);
//                        } catch (IOException ex) {
//                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    } else if ("dorra.sehli@esprit.tn".equalsIgnoreCase(email.getText())) {
//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//
//                        alert.setTitle("Confirmation");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Bienvenue admin");
//                        alert.show();
//                        try {
//
//                            root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
//                            connect.getScene().setRoot(root);
//                        } catch (IOException ex) {
//                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                    }
//                }else if (s1.check(p) == false) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//
//                    alert.setTitle("Erreur");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Informations incorrectes !");
//                    alert.show();
//
//                }
            PERSONNECONNECTEE = p ;
                System.out.println("personne co "+PERSONNECONNECTEE);
            }
             

        });

        inscription.setOnAction(e -> {
            try {

                Parent root;
                root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
                inscription.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

    }

}
