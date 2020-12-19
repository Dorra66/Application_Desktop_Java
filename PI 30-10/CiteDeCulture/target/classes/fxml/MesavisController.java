/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Avis;
import Entities.DemandeReserv;
import Services.AvisService;
import Services.ParticipationService;
import Services.ReservService;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MesavisController implements Initializable {

    @FXML
    private Button suppavis;
    @FXML
    private TableView<Avis> affavis;
    @FXML
    private TableColumn<Avis ,String> descavis;
    @FXML
    private Button homeback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AvisService as = new AvisService();
        ArrayList<Avis> pers = (ArrayList<Avis>) as.readByIdUser(LoginController.PERSONNECONNECTEE.getId());
        ObservableList<Avis> obs = FXCollections.observableArrayList(pers);
        affavis.setItems(obs);
        descavis.setCellValueFactory(new PropertyValueFactory<Avis, String>("DescriptionAvis"));
        
    }    

    @FXML
    private void suppAvis(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want delete it ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        AvisService as=new AvisService();
       as.deleteAvis(affavis.getSelectionModel().getSelectedItem());
       Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("mesavis.fxml"));
                suppavis.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(MesavisController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
        else{
            Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("mesavis.fxml"));
                suppavis.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(MesavisController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void HomeClient(ActionEvent event) {
         Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("homeClient.fxml"));
                homeback.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(MesavisController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
