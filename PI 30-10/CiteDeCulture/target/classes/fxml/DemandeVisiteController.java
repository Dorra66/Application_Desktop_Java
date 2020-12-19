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
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author WSI
 */
public class DemandeVisiteController implements Initializable {

    @FXML
    private TextField txtOrganizerName;
    @FXML
    private TextField txtTelNumber;
    @FXML
    private TextField txtMail;
    @FXML
    private TextField txtPostalAdd;
    @FXML
    private DatePicker selectDate;
    @FXML
    private Button btnSend;
    @FXML
    private ComboBox<String> selectTime;

    ObservableList<String> choix = FXCollections.observableArrayList(
            "Association", "Kindergarten", "Primary school", "High school", "University", "Group of tourist", "Individual visit"
    );

    ObservableList<String> options = FXCollections.observableArrayList(
            "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"
    );
    @FXML
    private ComboBox<String> selectOrganType;
    @FXML
    private TextField txtVN;
    @FXML
    private Button btnHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        selectTime.setItems(options);
        selectOrganType.setItems(choix);
        selectOrganType.setValue("Association");
        selectTime.setValue("8:00");
        btnSend.setOnAction(e -> {
            demandeVisite dv = new demandeVisite(selectOrganType.getValue(), txtOrganizerName.getText(), Integer.parseInt(txtTelNumber.getText()), txtMail.getText(), txtPostalAdd.getText(), java.sql.Date.valueOf(selectDate.getValue()), selectTime.getValue(), Integer.parseInt(txtVN.getText()));
            DemandeVisiteServices dvs = new DemandeVisiteServices();
            //Controle numero tel
            String tel = txtTelNumber.getText();
            int tel1 = Integer.parseInt(tel);
            if (String.valueOf(tel1).length() != 8) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please, enter a telephone of 8 digits !!");
                alert.showAndWait();
                return;
            }
            // Controle nombre visiteurs
            if (Integer.parseInt(txtVN.getText()) > 50) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("The number of visitors should be less than 50 !!");
                alert.showAndWait();
                return;
            }
            //Controle date de visite
            if (selectDate.getValue().isBefore(LocalDate.now())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please, enter a date after the date of today !!");
                alert.showAndWait();
                return;
            }
            //Controle saisie sur les textfield
            if ((selectOrganType.getValue().isEmpty())
                    || txtOrganizerName.getText().isEmpty()
                    || txtTelNumber.getText().isEmpty()
                    || txtMail.getText().isEmpty()
                    || txtPostalAdd.getText().isEmpty()
                    || selectTime.getValue().isEmpty()
                    || txtVN.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please, try to fill all text fields !!");
                alert.showAndWait();
                return;
            } else {
                dvs.insertDV(dv);
                Alert a = new Alert(null, "Your request has been sent successfully, thanks.", ButtonType.CLOSE);
                a.showAndWait();
                Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/AcceuilCM.fxml"));
                    btnSend.getScene().setRoot(root);
                    //dvs.insertDV(dv);
                } catch (IOException ex) {
                    Logger.getLogger(DemandeVisiteController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    @FXML
    private void GoToHome(ActionEvent event) {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/acceuilCM.fxml"));
            btnHome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DemandeVisiteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
