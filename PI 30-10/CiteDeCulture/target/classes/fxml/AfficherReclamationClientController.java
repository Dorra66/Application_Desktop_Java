/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.ReclamationM;
import Services.ReclamationMServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherReclamationClientController implements Initializable {

    @FXML
    private Button btn_supp_rclm;
    private List<ReclamationM> lst;
    public static ReclamationM newreclamation;
    ReclamationMServices rs = new ReclamationMServices();
    @FXML
    private TableView<ReclamationM> affRecTab;
    @FXML
    private Button btn_aff_rec;
    public static ReclamationM newRec;
    @FXML
    private Button btnHome;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        tableAffRec.setItems(lst);
//        tableAffRec.getColumns().clear();
        ObservableList<ReclamationM> list = rs.readAllRC();
  //      affRecTab.setItems(list);
//        tableAffRec.setItems(lst);
//        ids.setCellValueFactory(new PropertyValueFactory<ReclamationM,String>("idSource"));
        TableColumn idRM = new TableColumn("ID Reclamation");
        idRM.setPrefWidth(100);
        idRM.setCellValueFactory(new PropertyValueFactory<>("idRM"));
        
        TableColumn idSource = new TableColumn("ID Source");
        idSource.setPrefWidth(100);
        idSource.setCellValueFactory(new PropertyValueFactory<>("Idsource"));
        
        TableColumn objetRM = new TableColumn("Objet");
        objetRM.setPrefWidth(200);
        objetRM.setCellValueFactory(new PropertyValueFactory<>("objetReclamation"));
               
        TableColumn descriptionRM = new TableColumn("Claim Subject");
        descriptionRM.setPrefWidth(350);
        descriptionRM.setCellValueFactory(new PropertyValueFactory<>("descriptionReclamation"));
        
        TableColumn destinationRM = new TableColumn("Destination");
        destinationRM.setPrefWidth(100);
        destinationRM.setCellValueFactory(new PropertyValueFactory<>("destinationReclamation"));       
        
        
        TableColumn statusRM = new TableColumn("Status");
        statusRM.setPrefWidth(50);
        statusRM.setCellValueFactory(new PropertyValueFactory<>("statusReclamation"));
        
        TableColumn dateRM = new TableColumn("Date Of Sending");
        dateRM.setPrefWidth(150);
        dateRM.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
        
        TableColumn reponseRM = new TableColumn("Reply");
        reponseRM.setPrefWidth(180);
        reponseRM.setCellValueFactory(new PropertyValueFactory<>("reponseReclamation"));
        
        System.out.println("list :"+list);
        
        affRecTab.setItems(list);
        affRecTab.getColumns().addAll(idSource, objetRM, descriptionRM, statusRM, dateRM, reponseRM);
        affRecTab.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        affRecTab.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            System.out.println(newSelection);
            if (newSelection != null) {
                newreclamation = newSelection;
            }
            
        });
    }

    @FXML
    private void buttonAfficherReclamationClient(ActionEvent event) throws SQLException {
         //System.out.println(reclamationjdida.getIdReclamation());
         ReclamationMServices rms = new ReclamationMServices();
        //newreclamation.setStatusReclamation("vu");
        ReclamationM rm = rms.updateRS(newreclamation);
        System.out.println(rm.getStatusReclamation());
       Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/repondreReclamationC.fxml"));
                btn_aff_rec.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AfficherReclamationClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
//        Scene newScene = new Scene(root);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(newScene);
//        window.show();
    }

    @FXML
    private void ButtonSupprimerReclamationClient(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this claim ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) { 
        ReclamationMServices dvs = new ReclamationMServices();
        dvs.deleteRM(affRecTab.getSelectionModel().getSelectedItem().getIdRM());
        }
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherReclamationClient.fxml"));
            btn_supp_rclm.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(AfficherReclamationClientController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoToHome(ActionEvent event) {
        Parent root;          
            try {
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/acceuilAM.fxml"));
                btnHome.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AfficherReclamationClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}

//    @FXML
//    private void buttonAfficherReclamationClient(ActionEvent event) {
//    }
//
//    @FXML
//    private void ButtonSupprimerReclamationClient(ActionEvent event) {
//    }
    
//}
