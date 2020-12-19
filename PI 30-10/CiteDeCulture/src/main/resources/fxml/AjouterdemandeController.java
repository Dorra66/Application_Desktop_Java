/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.DemandeReserv;
import Entities.Salle;
import Services.ReservService;
import Services.SalleService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import java.util.regex.*;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterdemandeController implements Initializable {

    @FXML
    private DatePicker datereserv;
    @FXML
    private TextField nomorg;
    @FXML
    private TextField prenomorg;
    @FXML
    private TextField telorg;
    @FXML
    private TextField mailorg;
    @FXML
    private TextField categreserv;
    @FXML
    private TextField place;

    @FXML
    private Button addreserv;
    @FXML
    private TextField nomreserv;
    @FXML
    private Button importerreserv;
    @FXML
    private TextField imagereserv;
    @FXML
    private ComboBox<String> heurereserv;

    ObservableList<String> list = FXCollections.observableArrayList(
            "8:00", "9:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"
    );
    //  ObservableList<String> list1=FXCollections.observableArrayList(
    //      "In progress","canceled","accepted"
    //       );
    @FXML
    private Button homeback5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        heurereserv.setItems(list);
        ReservService rs = new ReservService();
        importerreserv.setOnAction((event) -> {
            FileChooser f = new FileChooser();
            f.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Image", "*.*")
            );

            File fi = f.showOpenDialog(null);

            if (fi != null) {
                imagereserv.setText(fi.getName());
            }
        });

        addreserv.setOnAction(p -> {
            String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+" + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
            Pattern pattern = Pattern.compile(masque);
            Matcher controler = pattern.matcher(mailorg.getText());
            ReservService ps = new ReservService();
            if(datereserv.getValue().equals("") || nomorg.getText().equalsIgnoreCase("") || prenomorg.getText().equalsIgnoreCase("") || telorg.getText().equalsIgnoreCase("") || categreserv.getText().equalsIgnoreCase("")|| place.getText().equalsIgnoreCase("") || nomreserv.getText().equalsIgnoreCase("") || imagereserv.getText().equalsIgnoreCase("") || heurereserv.getValue().equals("")){
                
                     Alert alert1 = new Alert(Alert.AlertType.ERROR);
                                  alert1.setTitle("Message");
                        alert1.setHeaderText(null);
                        alert1.setContentText("Veuillez remplir les champs correctement!");
                        alert1.show();
            }else{  
            if (controler.matches()) {
                //Ok : la saisie est bonne

                String text = telorg.getText();
                int xaxis1 = Integer.parseInt(text);

                if (String.valueOf(xaxis1).length() == 8) {
                     if (datereserv.getValue().isAfter(LocalDate.now())) {
                         DemandeReserv s = new DemandeReserv(nomorg.getText(), prenomorg.getText(), Integer.parseInt(telorg.getText()), mailorg.getText(), categreserv.getText(), nomreserv.getText(), Integer.parseInt(place.getText()), java.sql.Date.valueOf(datereserv.getValue()), heurereserv.getValue(), imagereserv.getText());

                            ps.insert(s);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Demande ajoutée avec succés :)");
                        alert.show();
                        
                            if (LoginController.PERSONNECONNECTEE.getRole().equals("client")) {
                           
                               
                             try {
                                  Parent root;
                                 root = FXMLLoader.load(getClass().getResource("homeClient.fxml"));
                                 addreserv.getScene().setRoot(root);
                             } catch (IOException ex) {
                                 Logger.getLogger(AjouterdemandeController.class.getName()).log(Level.SEVERE, null, ex);
                             }
                                
                           
                         
                           
                            
                        }

                         
                     }else{
                         Alert alert = new Alert(Alert.AlertType.ERROR);

                    alert.setTitle("Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Date is not valid !");
                    alert.show();
                        }
                    
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);

                    alert.setTitle("Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Phone number is not valid !");
                    alert.show();
                        }
                
                }else{
                
                    Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Email format is not valid !");
                alert.show();

                    
            }                 
            } 
                              //  Logger.getLogger(AjouterdemandeController.class.getName()).log(Level.SEVERE, null, ex);
                                 
                                         

        });

    }

    @FXML
    private void HomeBack5(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("homeClient.fxml"));
                homeback5.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterdemandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
