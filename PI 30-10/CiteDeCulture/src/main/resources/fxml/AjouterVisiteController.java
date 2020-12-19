/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.demandeVisite;
import Services.DemandeVisiteServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.Parent;
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

/**
 * FXML Controller class
 *
 * @author WSI
 */
public class AjouterVisiteController implements Initializable {

    @FXML
    private TableView<demandeVisite> tableV;
    @FXML
    private Button btnDeleteV;
    @FXML
    private TextField txtIdCV;

    ObservableList<String> choix = FXCollections.observableArrayList(
                "8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"
             );
    private TextField txtUpOrganizationNameV;
    private TextField txtUpOrganizerNameV;
    private TextField txtUpTelNumberV;
    private TextField txtUpMailV;
    private TextField txtUpPostalAddV;
    private DatePicker upSelectDateV;
    private ComboBox<String> upSelectTimeV;
    private TextField txtUpVisitorsNbreV;
    private Button btnEditV;
    demandeVisite newDemandeVisite ;
    @FXML
    private Button btnHome;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DemandeVisiteServices dvs = new DemandeVisiteServices();
        /*ObservableList<demandeVisite> list= dvs.readAllCDV();
        ObservableList<demandeVisite> obs = FXCollections.observableArrayList(list);
        tableV.setItems(obs);
        //colIdV.setCellValueFactory(new PropertyValueFactory<demandeVisite, Integer>("idDV"));
        colNomOrganismeV.setCellValueFactory(new PropertyValueFactory<demandeVisite, String>("nomOrganismeD"));
        colNomResponsableV.setCellValueFactory(new PropertyValueFactory<demandeVisite, String>("nomResponsableD"));
        colTelV.setCellValueFactory(new PropertyValueFactory<demandeVisite, Integer>("numTelD"));
        colMailV.setCellValueFactory(new PropertyValueFactory<demandeVisite, String>("mailD"));
        colAddV.setCellValueFactory(new PropertyValueFactory<demandeVisite, String>("addPostaleD"));
        colDateV.setCellValueFactory(new PropertyValueFactory<demandeVisite, Date>("dateVisiteD"));
        colHeureV.setCellValueFactory(new PropertyValueFactory<demandeVisite, String>("heureVisiteD"));
        colNbreVisiteurs.setCellValueFactory(new PropertyValueFactory<demandeVisite, Integer>("nbreVisiteursD"));
        colEtatV.setCellValueFactory(new PropertyValueFactory<demandeVisite, String>("etatDV"));*/
        ObservableList<demandeVisite> list1 = dvs.readAllCDV();
            TableColumn idDV = new TableColumn("idDV");
            idDV.setPrefWidth(100);
            idDV.setCellValueFactory(new PropertyValueFactory<>("idDV"));
            
            TableColumn Source = new TableColumn("Source");
            Source.setPrefWidth(100);
            Source.setCellValueFactory(new PropertyValueFactory<>("Source"));
           
            TableColumn nomOrganismeD = new TableColumn("Organization Name");
            nomOrganismeD.setPrefWidth(150);
            nomOrganismeD.setCellValueFactory(new PropertyValueFactory<>("nomOrganismeD"));
        
            TableColumn nomResponsableD = new TableColumn("Organizer Name");
            nomResponsableD.setPrefWidth(150);
            nomResponsableD.setCellValueFactory(new PropertyValueFactory<>("nomResponsableD"));
        
            TableColumn numTelD = new TableColumn("N° Tel");
            numTelD.setPrefWidth(100);
            numTelD.setCellValueFactory(new PropertyValueFactory<>("numTelD"));
            
            TableColumn mailD = new TableColumn("Mail");
            mailD.setPrefWidth(125);
            mailD.setCellValueFactory(new PropertyValueFactory<>("mailD"));
            
            TableColumn addPostaleD = new TableColumn("Postal Address");
            addPostaleD.setPrefWidth(100);
            addPostaleD.setCellValueFactory(new PropertyValueFactory<>("addPostaleD"));
            
            TableColumn dateVisiteD = new TableColumn("Date");
            dateVisiteD.setPrefWidth(100);
            dateVisiteD.setCellValueFactory(new PropertyValueFactory<>("dateVisiteD"));
            
            TableColumn heureVisiteD = new TableColumn("Hour");
            heureVisiteD.setPrefWidth(100);
            heureVisiteD.setCellValueFactory(new PropertyValueFactory<>("heureVisiteD"));
            
            TableColumn nbreVisiteursD = new TableColumn("Visitors Nbre");
            nbreVisiteursD.setPrefWidth(100);
            nbreVisiteursD.setCellValueFactory(new PropertyValueFactory<>("nbreVisiteursD"));
            
            TableColumn etatDV = new TableColumn("Status");
            etatDV.setPrefWidth(91);
            etatDV.setCellValueFactory(new PropertyValueFactory<>("etatDV"));
            
            tableV.setItems(list1);
            tableV.getColumns().addAll(Source,nomOrganismeD, nomResponsableD, numTelD, mailD, addPostaleD, dateVisiteD, heureVisiteD, nbreVisiteursD, etatDV);
            tableV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            tableV.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                System.out.println(newSelection);
                if (newSelection != null) {
                    newDemandeVisite = newSelection;
                    System.out.println("id: " + newSelection.getIdDV());
                    
                }

            });
         txtIdCV.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    try {
                        filter(oldValue, newValue);
                    } catch (SQLException ex) {
                        Logger.getLogger(AjouterVisiteController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
   }    
    
public void filter(String oldValue, String newValue) throws SQLException {
DemandeVisiteServices dvs = new DemandeVisiteServices();
        ObservableList<demandeVisite> data = dvs.readAllCDV();
        if (newValue == null || oldValue.length() == newValue.length() || oldValue == null) {
            tableV.setItems((ObservableList<demandeVisite>) data);
        } else {
            ObservableList<demandeVisite> filter = FXCollections.observableArrayList();
            for (demandeVisite r : data) {
                if ((r.getNomResponsableD().toLowerCase()).contains(newValue.toLowerCase())) {
                    filter.add(r);
                    }
            }
            tableV.setItems(filter);
        }
    }

   /* public void filterO(String oldValue, String newValue) throws SQLException {
        DemandeVisiteServices dvs = new DemandeVisiteServices();
        ObservableList<demandeVisite> data = dvs.;
        if (newValue == null || oldValue.length() == newValue.length() || oldValue == null) {
            tableV.setItems(data);
        } else {
            ObservableList<demandeVisite> filter = FXCollections.observableArrayList();
            for (demandeVisite r : data) {
                if (r.getUsername().contains(newValue)) {
                    filter.add(r);
                }
            }
            tableV.setItems(filter);
        }
    }*/
    @FXML
    private void deleteRow(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this confirmed visit ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            DemandeVisiteServices dvs = new DemandeVisiteServices();
            dvs.deleteDV(tableV.getSelectionModel().getSelectedItem().getIdDV());
        }
        
        Parent root ;       
        try {
            root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ajouterVisite.fxml"));
            btnDeleteV.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterVisiteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoToHome(ActionEvent event) {
        Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/acceuilAM.fxml"));
                    btnHome.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AjouterVisiteController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
     
}
