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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import Util.SendMail;


/**
 * FXML Controller class
 *
 * @author WSI
 */
public class AfficherDemandeVisiteController implements Initializable {

    @FXML
    private TableView<demandeVisite> tableDV;
    private TableColumn<demandeVisite, String> colOrganizationName;
    private TableColumn<demandeVisite, String> colOrganizerName;
    private TableColumn<demandeVisite, Integer> colTel;
    private TableColumn<demandeVisite, String> colMail;
    private TableColumn<demandeVisite, String> colAdd;
    private TableColumn<demandeVisite, Date> colDate;
    private TableColumn<demandeVisite, String> colHour;
    private TableColumn<demandeVisite, Integer> colVisitorsN;
    private TableColumn<demandeVisite, String> colEtat;
    @FXML
    private Button btnDeleteRequest;
    @FXML
    private TextField txtIdReq;
    private TextField txtUpOrganizationName;
    private TextField txtUpOrganizerName;
    private TextField txtUpTelNumber;
    private TextField txtUpMail;
    private TextField txtUpPostalAdd;
    private DatePicker upSelectDate;
    private Button btnSaveReq;
    private ComboBox<String> upSelectTime;
    private TextField txtUpVisitorsNbre;

    ObservableList<String> choix = FXCollections.observableArrayList(
            "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"
    );
    @FXML
    private ComboBox<String> replyCombo;
    @FXML
    private Button btnValidReply;

    ObservableList<String> choices = FXCollections.observableArrayList(
            "Confirmed", "Rejected", "Canceled");

    demandeVisite newDemandeVisite;
    @FXML
    private Button btnHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        replyCombo.setItems(choices);
        replyCombo.setValue("Confirmed");
        DemandeVisiteServices dvs = new DemandeVisiteServices();
        ObservableList<demandeVisite> list1 = dvs.readAllDV();
        TableColumn idDV = new TableColumn("idDV");
        idDV.setPrefWidth(100);
        idDV.setCellValueFactory(new PropertyValueFactory<>("idDV"));
        
        TableColumn Source = new TableColumn("Source");
        Source.setPrefWidth(100);
        Source.setCellValueFactory(new PropertyValueFactory<>("Source"));

        TableColumn nomOrganismeD = new TableColumn("Organization Name");
        nomOrganismeD.setPrefWidth(125);
        nomOrganismeD.setCellValueFactory(new PropertyValueFactory<>("nomOrganismeD"));

        TableColumn nomResponsableD = new TableColumn("Organizer Name");
        nomResponsableD.setPrefWidth(100);
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

        tableDV.setItems(list1);
        tableDV.getColumns().addAll(Source, nomOrganismeD, nomResponsableD, numTelD, mailD, addPostaleD, dateVisiteD, heureVisiteD, nbreVisiteursD, etatDV);
        tableDV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tableDV.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            System.out.println(newSelection);
            if (newSelection != null) {
                newDemandeVisite = newSelection;
                System.out.println("id: " + newSelection.getIdDV());

            }

        });
        txtIdReq.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    filter(oldValue, newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(AfficherDemandeVisiteController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    public void filter(String oldValue, String newValue) throws SQLException {
        DemandeVisiteServices dvs = new DemandeVisiteServices();
        ObservableList<demandeVisite> data = dvs.readAllDV();
        if (newValue == null || oldValue.length() == newValue.length() || oldValue == null) {
            tableDV.setItems((ObservableList<demandeVisite>) data);
        } else {
            ObservableList<demandeVisite> filter = FXCollections.observableArrayList();
            for (demandeVisite r : data) {
                if ((r.getNomResponsableD().toLowerCase()).contains(newValue.toLowerCase())) {
                    filter.add(r);
                }
            }
            tableDV.setItems(filter);
        }
    }

    //Méthode refresh
    private void refreshTableDV(Event event){
        tableDV.setItems(null);
        tableDV.getColumns().clear();
        DemandeVisiteServices dvs = new DemandeVisiteServices();
        ObservableList<demandeVisite> list1 = dvs.readAllDV();
        TableColumn idDV = new TableColumn("idDV");
        idDV.setPrefWidth(100);
        idDV.setCellValueFactory(new PropertyValueFactory<>("idDV"));

        TableColumn nomOrganismeD = new TableColumn("Organization Name");
        nomOrganismeD.setPrefWidth(125);
        nomOrganismeD.setCellValueFactory(new PropertyValueFactory<>("nomOrganismeD"));

        TableColumn nomResponsableD = new TableColumn("Organizer Name");
        nomResponsableD.setPrefWidth(100);
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

        tableDV.setItems(list1);
        tableDV.getColumns().addAll(nomOrganismeD, nomResponsableD, numTelD, mailD, addPostaleD, dateVisiteD, heureVisiteD, nbreVisiteursD, etatDV);
        tableDV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tableDV.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            System.out.println(newSelection);
            if (newSelection != null) {
                newDemandeVisite = newSelection;
                System.out.println("id: " + newSelection.getIdDV());

            }
        });
    }
    @FXML
    private void deleteRow(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this request ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) { 
        DemandeVisiteServices dvs = new DemandeVisiteServices();
        dvs.deleteDV(tableDV.getSelectionModel().getSelectedItem().getIdDV());
        }
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherDemandeVisite.fxml"));
            btnDeleteRequest.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(AfficherDemandeVisiteController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void replyRequest(ActionEvent event) {

        DemandeVisiteServices dvs = new DemandeVisiteServices();
        dvs.replyDV((tableDV.getSelectionModel().getSelectedItem().getIdDV()), replyCombo.getValue());
        System.out.println("tesst" + tableDV.getSelectionModel().getSelectedItem().getIdDV());
        String destination = tableDV.getSelectionModel().getSelectedItem().getMailD();
        String Sujet = ("Reply to your visit request for the museum");
        String msg = ("Dear "+tableDV.getSelectionModel().getSelectedItem().getNomResponsableD()+", your visit request for the museum is :"+replyCombo.getValue());
        SendMail.sendMail(destination, Sujet, msg);
        //DemandeVisiteServices dvs = new DemandeVisiteServices();
        refreshTableDV(event);

    }

    @FXML
    private void GoToHome(ActionEvent event) {
        Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/acceuilAM.fxml"));
                    btnHome.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AfficherDemandeVisiteController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

}
