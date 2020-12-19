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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherMesDemandesController implements Initializable {

    @FXML
    private TableView<demandeVisite> tableMyReq;
    @FXML
    private Button btnHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DemandeVisiteServices dvs = new DemandeVisiteServices();
        ObservableList<demandeVisite> list1 = dvs.readAllDVC(LoginController.PERSONNECONNECTEE.getPrenom());
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

        tableMyReq.setItems(list1);
        tableMyReq.getColumns().addAll(Source,nomOrganismeD, nomResponsableD, numTelD, mailD, addPostaleD, dateVisiteD, heureVisiteD, nbreVisiteursD, etatDV);
    }    

    @FXML
    private void GoToHome(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/acceuilCM.fxml"));
            btnHome.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(AfficherMesDemandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
