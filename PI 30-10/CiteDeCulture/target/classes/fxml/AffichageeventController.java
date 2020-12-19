/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Event;
import Entities.Participation;
import Entities.Salle;

import Services.AvisService;
import Services.EventService;
import Services.ParticipationService;

import Services.ReservService;
import Services.SalleService;

import static fxml.AffichageSalleController.ab;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffichageeventController implements Initializable {
    
    @FXML
    public TableView<Event> affevent;
    @FXML
    public TableColumn<Event, Integer> evid;
    @FXML
    private TableColumn<Event, String> evname;
    @FXML
    private TableColumn<Event, String> evcateg;
    @FXML
    private TableColumn<Event, Integer> evplace;
    @FXML
    private TableColumn<Event, Date> evdate;
    @FXML
    private TableColumn<Event, String> evdeheu;
    
    @FXML
    private Button deleteevent;
    @FXML
    private Button participevent;
    @FXML
    private TableColumn<Event, String> afficheev;
    
    @FXML
    private Button showevent;
    
    Event e;
    public static Event ac;
    
    ObservableList<String> list = FXCollections.observableArrayList(
            "8:00", "9:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"
    );
    @FXML
    private TextField searchevent;
    @FXML
    private ImageView imageevent;
    @FXML
    private Button mesparticipations;
    @FXML
    private Button homeretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        modheure.setItems(list);
        if (LoginController.PERSONNECONNECTEE.getRole().equals("client")) {
            showevent.setVisible(false);
            deleteevent.setVisible(false);
            evid.setVisible(false);
        }
        
        affevent.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            String x = affevent.getSelectionModel().getSelectedItem().getAffiche();
            File file = new File("C:\\images\\" + x);
            Image image = new Image(file.toURI().toString());
            imageevent.setImage(image);
        });
        
        EventService es = new EventService();
        ArrayList<Event> eve = (ArrayList<Event>) es.readAll();
        ObservableList<Event> obs = FXCollections.observableArrayList(eve);
        affevent.setItems(obs);
        evid.setCellValueFactory(new PropertyValueFactory<Event, Integer>("IdEvent"));
        evname.setCellValueFactory(new PropertyValueFactory<Event, String>("NomEvent"));
        evcateg.setCellValueFactory(new PropertyValueFactory<Event, String>("CategorieEvent"));
        evplace.setCellValueFactory(new PropertyValueFactory<Event, Integer>("NbrPlaceDispo"));
        evdate.setCellValueFactory(new PropertyValueFactory<Event, Date>("DateEvent"));
        evdeheu.setCellValueFactory(new PropertyValueFactory<Event, String>("HeureEvent"));
        afficheev.setCellValueFactory(new PropertyValueFactory<Event, String>("Affiche"));
        
        affevent.getSelectionModel().selectedItemProperty().addListener((obs1, oldSelection, newSelection) -> {
            System.out.println(newSelection);
            if (newSelection != null) {
                e = newSelection;
                System.out.println("id: " + newSelection.getIdEvent());
                
            }
            
        });
        searchevent.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    filter(oldValue, newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(AffichageeventController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        affevent.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        affevent.getSelectionModel().selectedItemProperty().addListener(((obs1, oldSelection, newSelection) -> {
            if (newSelection != null) {
                ac = newSelection;
                System.out.println(ac);
            }
        }));
        
    }
    
    public void filter(String oldValue, String newValue) throws SQLException {
        EventService dvs = new EventService();
        List<Event> data = dvs.readAll();
        if (newValue == null || oldValue.length() == newValue.length() || oldValue == null) {
            affevent.setItems((ObservableList<Event>) data);
        } else {
            ObservableList<Event> filter = FXCollections.observableArrayList();
            for (Event r : data) {
                if ((r.getCategorieEvent()).contains(newValue)) {
                    filter.add(r);
                }
            }
            affevent.setItems(filter);
        }
    }
    
    @FXML
    private void suppevent(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want delete it ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            ParticipationService ps = new ParticipationService();
            ps.deleteParticipation(affevent.getSelectionModel().getSelectedItem().getIdEvent());
            AvisService as = new AvisService();
            as.deleteAvisById(affevent.getSelectionModel().getSelectedItem().getIdEvent());
            
            EventService ss = new EventService();
            ss.deleteEventById(affevent.getSelectionModel().getSelectedItem().getIdEvent());
            
            Parent root;
            
            try {
                root = FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
                deleteevent.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageeventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Parent root;
            
            try {
                root = FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
                deleteevent.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageeventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void participer(ActionEvent event) {
        
        ParticipationService ps = new ParticipationService();
        List<Participation> participation = new ArrayList<>();
        Participation p = new Participation(affevent.getSelectionModel().getSelectedItem().getIdEvent(), LoginController.PERSONNECONNECTEE.getId());
        participation = ps.maListeParticipationEvent(p);
        
        if (participation.isEmpty()) {
            ps.insertParticip(p);
            
        } else {
            //System.out.println("deja");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("you are already participating!");
            alert.show();
        }
        
        Parent root;
        
        try {
            root = FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
            participevent.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /* private void importaff(ActionEvent event) {
        
    }*/
    @FXML
    private void showevent(ActionEvent event) {
        Parent root;
        
        try {
            root = FXMLLoader.load(getClass().getResource("modifierevent.fxml"));
            showevent.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* private void updateevent(ActionEvent event) {
        
      
          
          Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
                updateevent.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageeventController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }*/

 /* private void searchcateg(ActionEvent event) {
        EventService es=new EventService();
        ArrayList<Event> pers = (ArrayList<Event>) es.searchEvent(searchevent.getPromptText());
        //ArrayList<Event> pers = (ArrayList<Event>) es.readAll();
    ObservableList<Event> obs = FXCollections.observableArrayList(pers); 
     affevent.setItems(obs);
   evid.setCellValueFactory(new PropertyValueFactory<Event,Integer> ("IdEvent"));
   evname.setCellValueFactory(new PropertyValueFactory<Event,String>("NomEvent"));
   evcateg.setCellValueFactory(new PropertyValueFactory<Event,String>("CategorieEvent"));
   evplace.setCellValueFactory(new PropertyValueFactory<Event,Integer>("NbrPlaceDispo"));
   evdate.setCellValueFactory(new PropertyValueFactory<Event,Date>("DateEvent"));
   evdeheu.setCellValueFactory(new PropertyValueFactory<Event,String>("HeureEvent"));
   afficheev.setCellValueFactory(new PropertyValueFactory<Event,String>("Affiche"));
        
    
    }*/
    @FXML
    private void myparticipationsshow(ActionEvent event) {
        Parent root;
        
        try {
            root = FXMLLoader.load(getClass().getResource("mesparticipations.fxml"));
            deleteevent.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void HomeRetour(ActionEvent event) {
        if(LoginController.PERSONNECONNECTEE.getRole().equals("client")){
        Parent root;
        
        try {
            root = FXMLLoader.load(getClass().getResource("homeClient.fxml"));
            deleteevent.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        else{
           Parent root;
        
        try {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            homeretour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
}
