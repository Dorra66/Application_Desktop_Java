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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
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
public class AjouterReclamationClientController implements Initializable {

    @FXML
    private Button btnCancelClaim;
    @FXML
    private Button btnSendClaim;
    @FXML
    private TextArea txtDescR;
    @FXML
    private TextField txtObjetR;
    ObservableList<ReclamationM> list;
    @FXML
    private Tab showClaimHistory;
    @FXML
    private TableView<ReclamationM> tableH;

    private ObservableList<ReclamationM> lst;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    @FXML
    private void SendClaim(ActionEvent event) {
        ReclamationMServices rms = new ReclamationMServices();
        ReclamationM rm = new ReclamationM();
        String objet = txtDescR.getText();
        String desc = txtObjetR.getText();

//        if ((objet.equals("")) || (desc.equals(""))) {
//            //  lap_reponse.setText("Romplir tout les cases SVP");
//        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date d1 = new Date();
            String date = dateFormat.format(d1);

            rm.getIdRM();
            rm.setIdsource(LoginController.PERSONNECONNECTEE.getPrenom());//Compte utilisateur nécessaire:::LoginController.USERCONNECTER.getUsername()
            rm.setDestinationReclamation("ADMIN");
            rm.setObjetReclamation(objet);
            rm.setDescriptionReclamation(desc);
            rm.setDateReclamation(date);
            rm.setStatusReclamation("non vu");
            rm.setRoleSource(LoginController.PERSONNECONNECTEE.getRole());//Compte utilisateur nécessaire:::LoginController.USERCONNECTER.getRole()
            rm.setReponseReclamation("Aucune réponse");
            rms.insertRM(rm);
//            if (rms.insertRM(rm) == true) {
//                lap_reponse.setText("Réclamation envoyer");
//            } else {
//                lap_reponse.setText("Probléme d'envoi essaiyer encore");
//            }
//        }
    }

    @FXML
    private void onClickSH(Event event) throws SQLException {
        ReclamationMServices rms = new ReclamationMServices();      
        lst = rms.readAllRH(LoginController.PERSONNECONNECTEE.getPrenom());
        System.out.println("ok bb "+LoginController.PERSONNECONNECTEE.getId());
         
        TableColumn idRM = new TableColumn("ID Reclamation");
        idRM.setPrefWidth(100);
        idRM.setCellValueFactory(new PropertyValueFactory<>("idRM"));

        TableColumn idSource = new TableColumn("ID Source");
        idSource.setPrefWidth(100);
        idSource.setCellValueFactory(new PropertyValueFactory<>("Idsource"));

        TableColumn destinationRM = new TableColumn("Destination");
        destinationRM.setPrefWidth(100);
        destinationRM.setCellValueFactory(new PropertyValueFactory<>("destinationReclamation"));

        TableColumn objetRM = new TableColumn("Objet");
        objetRM.setPrefWidth(200);
        objetRM.setCellValueFactory(new PropertyValueFactory<>("objetReclamation"));

        TableColumn descriptionRM = new TableColumn("Claim Subject");
        descriptionRM.setPrefWidth(350);
        descriptionRM.setCellValueFactory(new PropertyValueFactory<>("descriptionReclamation"));

        TableColumn statusRM = new TableColumn("Status");
        statusRM.setPrefWidth(50);
        statusRM.setCellValueFactory(new PropertyValueFactory<>("statusReclamation"));

        TableColumn dateRM = new TableColumn("Date Of Sending");
        dateRM.setPrefWidth(150);
        dateRM.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));

        TableColumn reponseRM = new TableColumn("Reply");
        reponseRM.setPrefWidth(180);
        reponseRM.setCellValueFactory(new PropertyValueFactory<>("reponseReclamation"));

        //tableH.getItems();
       // tableH.getColumns();
        tableH.setItems(lst);
        System.out.println("listaa "+lst);
        tableH.getColumns().addAll(destinationRM, objetRM, descriptionRM, statusRM, dateRM, reponseRM);

    }

    @FXML
    private void GoToHome(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/acceuilCM.fxml"));
            btnCancelClaim.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(AfficherReclamationClientController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
