/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Avis;
import Entities.Event;
import Entities.Participation;
import Services.AvisService;
import Services.EventService;
import Services.ParticipationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MesparticipationsController implements Initializable {

    public static MesparticipationsController cont;

    @FXML
    private TableView<Event> tableEvent;
    @FXML
    private TableColumn<Event, String> nameEvent;
    @FXML
    private TableColumn<Event, Date> dateEvent;

    ParticipationService participationService = new ParticipationService();
    EventService eventService = new EventService();

    ObservableList<Event> listViewEvent;
    @FXML
    private Button suppparticip;
    @FXML
    private TextArea descripavis;
    @FXML
    private Button ajoutavis;
    @FXML
    private Button homeClient;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

           
            cont = this;
            AfficherDataLV();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void setCellValueParticipation() {

        nameEvent.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNomEvent()));
        // nameEvent.setCellValueFactory(new PropertyValueFactory<>("IdEvent"));
         dateEvent.setCellValueFactory(cd -> new SimpleObjectProperty(cd.getValue().getDateEvent()));

    }

    public void AfficherDataLV() throws IOException {
        List<Event> listeEvents = new ArrayList<>();
        listeEvents = eventService.getParticipatedEvent(LoginController.PERSONNECONNECTEE.getId());

        listViewEvent = FXCollections.observableArrayList(listeEvents);
        tableEvent.setItems(listViewEvent);
        setCellValueParticipation();
    }

    @FXML
    private void supprimerMaParticipation(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want delete it ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        ParticipationService ss=new ParticipationService();
       ss. deleteParticipationByEvent(tableEvent.getSelectionModel().getSelectedItem());
       Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("mesparticipations.fxml"));
                suppparticip.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(MesparticipationsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            else{
                    Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("mesparticipations.fxml"));
                suppparticip.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(MesparticipationsController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
}

    @FXML
    private void ajouterAvis(ActionEvent event) {
        ajoutavis.setOnAction(e->{
            AvisService as=new AvisService();
            Event ev = new Event(tableEvent.getSelectionModel().getSelectedItem().getIdEvent());
            Avis a = new Avis(tableEvent.getSelectionModel().getSelectedItem().getIdEvent(),ev.getIdEvent(),descripavis.getText());
            as.insertAvis(a,LoginController.PERSONNECONNECTEE.getId()); 
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("mesparticipations.fxml"));
                ajoutavis.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(MesparticipationsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
      
    });

    }

    @FXML
    private void HomeClient(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("homeClient.fxml"));
                homeClient.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(MesparticipationsController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }


