/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Avis;
import Entities.Event;
import Entities.Participation;
import Entities.Salle;
import Services.AvisService;
import Services.EventService;
import Services.ParticipationService;
import Services.ReservService;
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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffichageParticipationController implements Initializable {

    @FXML
    private TableColumn<Participation, Integer> idpart;
    @FXML
    private TableColumn<Participation, Integer> idevent;
    @FXML
    private TableColumn<Participation, Integer> iduser;
    @FXML
    private TextField totalpart;
    @FXML
    private TableView<Participation> affichpart;
    @FXML
    private TextField nameevent;
    @FXML
    private Button deletepart;
    @FXML
    private Button Home2;
   
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        affichpart.setOnMouseClicked((javafx.scene.input.MouseEvent event)->{
            ParticipationService ps = new ParticipationService();
            String str = ps.nameParticipEvent(affichpart.getSelectionModel().getSelectedItem());
            nameevent.setText(str);
            int y = ps.NbrParticipations(affichpart.getSelectionModel().getSelectedItem());
            totalpart.setText(String.valueOf(y));
        }
        );
         ParticipationService ps=new ParticipationService();
         
         ArrayList<Participation> pers = (ArrayList<Participation>) ps.ListParticip();
    ObservableList<Participation> obs = FXCollections.observableArrayList(pers);
    affichpart.setItems(obs);
    idpart.setCellValueFactory(new PropertyValueFactory<Participation,Integer> ("IdParticipation"));
    idevent.setCellValueFactory(new PropertyValueFactory<Participation,Integer>("IdEvent"));
    iduser.setCellValueFactory(new PropertyValueFactory<Participation,Integer>("IdUser"));
    
   
      
       
    // String nom = ps.nameParticipEvent(affichpart.getSelectionModel().getSelectedItem());
   //  nameevent.setText(nom);
    
 
              }

    @FXML
    private void deleteParticip(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want delete it ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        ParticipationService ss=new ParticipationService();
        ss.deleteParticipationById(affichpart.getSelectionModel().getSelectedItem());
     
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageParticipation.fxml"));
                deletepart.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageParticipationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        else{
            Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageParticipation.fxml"));
                deletepart.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageParticipationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void HomeBack2(ActionEvent event) {
         Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("home.fxml"));
                Home2.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageParticipationController.class.getName()).log(Level.SEVERE, null, ex);
            }
}
}

    
     
    

    
    
    

