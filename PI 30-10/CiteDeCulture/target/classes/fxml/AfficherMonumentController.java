/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Monument;
import Services.MonumentServices;
import java.io.File;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author WSI
 */
public class AfficherMonumentController implements Initializable {

    private TableColumn<Monument, Integer> colID;
    private TableColumn<Monument, String> colDesc;
    @FXML
    private TableView<Monument> tableM;
    @FXML
    private Button btnDeleteM;
    @FXML
    private Button btnEditM;
    @FXML
    private ImageView imageView;
    public static Monument an;
    @FXML
    private TextField txtSearchMonument;
    @FXML
    private Button btnHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MonumentServices ms = new MonumentServices();

        ObservableList<Monument> list = ms.readAllM();
        //ObservableList<Monument> obs = FXCollections.observableArrayList(list);
        tableM.setItems(list);
//        colIDM.setCellValueFactory(new PropertyValueFactory<Monument, Integer>("idM"));
//        colNM.setCellValueFactory(new PropertyValueFactory<Monument, String>("nomM"));
//        colDescM.setCellValueFactory(new PropertyValueFactory<Monument, String>("descriptionM"));

        TableColumn idM = new TableColumn("id");
        idM.setPrefWidth(100);
        idM.setCellValueFactory(new PropertyValueFactory<>("idM"));

        TableColumn nomM = new TableColumn("Name");
        nomM.setPrefWidth(150);
        nomM.setCellValueFactory(new PropertyValueFactory<>("nomM"));

        TableColumn descriptionM = new TableColumn("Description");
        descriptionM.setPrefWidth(460);
        descriptionM.setCellValueFactory(new PropertyValueFactory<>("descriptionM"));

        tableM.setItems(list);
        tableM.getColumns().addAll(nomM, descriptionM);
        tableM.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableM.getSelectionModel().selectedItemProperty().addListener(((obs, oldSelection, newSelection) -> {

            String x = tableM.getSelectionModel().getSelectedItem().getImageM();
            File file = new File("C:\\images\\" + x);
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);

            if (newSelection != null) {
                an = newSelection;
                System.out.println(an);
            }

            btnEditM.setOnAction(e -> {

                Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/modifierMonument.fxml"));
                    btnDeleteM.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AfficherMonumentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

                
//            if (newSelection != null) {
//                an = newSelection;
//                String nom = an.getNomM();
//                String desc = an.getDescriptionM();
//                String img = an.getImageM();
            // }
        }));

        txtSearchMonument.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    filter(oldValue, newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(AfficherMonumentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    public void filter(String oldValue, String newValue) throws SQLException {
        MonumentServices ms = new MonumentServices();
        ObservableList<Monument> data = ms.readAllM();
        if (newValue == null || oldValue.length() == newValue.length() || oldValue == null) {
            tableM.setItems((ObservableList<Monument>) data);
        } else {
            ObservableList<Monument> filter = FXCollections.observableArrayList();
            for (Monument r : data) {
                if ((r.getNomM().toLowerCase()).contains(newValue.toLowerCase())) {
                    filter.add(r);
                }
            }
            tableM.setItems(filter);
        }
    }

    @FXML
    private void deleteRow(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this monument ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            MonumentServices ms = new MonumentServices();
            ms.deleteM(tableM.getSelectionModel().getSelectedItem().getIdM());
        }

        Parent root;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherMonument.fxml"));
            btnDeleteM.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherMonumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void GoToEditM(ActionEvent event) {

        Parent root;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/modifierMonument.fxml"));
            btnEditM.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherMonumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoToHome(ActionEvent event) {
        Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/acceuilAM.fxml"));
                    btnDeleteM.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AfficherMonumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

}
