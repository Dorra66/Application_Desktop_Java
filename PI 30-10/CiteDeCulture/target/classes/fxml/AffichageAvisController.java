/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Avis;
import Entities.Salle;
import Services.AvisService;
import Services.SalleService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffichageAvisController implements Initializable {

    @FXML
    private TableView<Avis> affavis;
    @FXML
    private TableColumn<Avis, Integer> idavis;
    @FXML
    private TableColumn<Avis, Integer> idevent;
    @FXML
    private TableColumn<Avis, Integer> iduser;
    @FXML
    private TableColumn<Avis, String> descrip;
    @FXML
    private Button delavis;
    @FXML
    private Button Homeback3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AvisService ss=new AvisService();
         ArrayList<Avis> pers = (ArrayList<Avis>) ss.readAll();
    ObservableList<Avis> obs = FXCollections.observableArrayList(pers);
    affavis.setItems(obs);
    idavis.setCellValueFactory(new PropertyValueFactory<Avis,Integer> ("IdAvis"));
    idevent.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("IdEvent"));
    iduser.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("IdUser"));
    descrip.setCellValueFactory(new PropertyValueFactory<Avis,String>("DescriptionAvis"));
        
    }    

    @FXML
    private void deleteFeed(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want delete it ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            AvisService ss=new AvisService();
        
        ss.deleteAvis(affavis.getSelectionModel().getSelectedItem());
     
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageAvis.fxml"));
                delavis.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageAvisController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        else{
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageAvis.fxml"));
                delavis.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageAvisController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }

    @FXML
    private void HomeBACK3(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("home.fxml"));
                Homeback3.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageAvisController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
}
}
