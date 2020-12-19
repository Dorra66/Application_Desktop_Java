/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.DemandeReserv;
import Entities.Event;
import Entities.Salle;
import Services.EventService;
import Services.ReservService;
import Services.SalleService;
import Util.ApiSMS;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffichagedemandeController implements Initializable {

    @FXML
    private TableView<DemandeReserv> affichedemande;
    @FXML
    private TableColumn<DemandeReserv, Integer> idreserv;
    @FXML
    private TableColumn<DemandeReserv, String> orgname;
    @FXML
    private TableColumn<DemandeReserv, String> orglastname;
    @FXML
    private TableColumn<DemandeReserv, Integer> orgtel;
    @FXML
    private TableColumn<DemandeReserv, String> orgmail;
    @FXML
    private TableColumn<DemandeReserv, String> categorie;
    @FXML
    private TableColumn<DemandeReserv, Integer> nbrplace;

    @FXML
    private Button suppdemande;
    @FXML
    private TableColumn<DemandeReserv, String> namereserv;
    @FXML
    private TableColumn<DemandeReserv, Date> datereserv;

    @FXML
    private ComboBox<String> combostate;
    @FXML
    private Button showetat;
    @FXML
    private Button showReserv;
    @FXML
    private Button retourajout;
    @FXML
    private TableColumn<DemandeReserv, String> heure;
    @FXML
    private TableColumn<DemandeReserv, String> etat;
    @FXML
    private TableColumn<DemandeReserv, String> affiche;

    private DemandeReserv d;

    ObservableList<String> list1 = FXCollections.observableArrayList(
            "cancel", "accept"
    );
    @FXML
    private TextField searchetat;
    // public static final String ACCOUNT_SID ="ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    //  public static final String AUTH_TOKEN ="your_auth_token";
    @FXML
    private Button homeback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        combostate.setItems(list1);
        ReservService ss = new ReservService();
        ArrayList<DemandeReserv> pers = (ArrayList<DemandeReserv>) ss.readAll();
        ObservableList<DemandeReserv> obs = FXCollections.observableArrayList(pers);
        affichedemande.setItems(obs);
        idreserv.setCellValueFactory(new PropertyValueFactory<DemandeReserv, Integer>("IdReserv"));
        orgname.setCellValueFactory(new PropertyValueFactory<DemandeReserv, String>("NomOrg"));
        orglastname.setCellValueFactory(new PropertyValueFactory<DemandeReserv, String>("PrenomOrg"));
        orgtel.setCellValueFactory(new PropertyValueFactory<DemandeReserv, Integer>("TelOrg"));
        orgmail.setCellValueFactory(new PropertyValueFactory<DemandeReserv, String>("MailOrg"));
        categorie.setCellValueFactory(new PropertyValueFactory<DemandeReserv, String>("CategorieReserv"));
        namereserv.setCellValueFactory(new PropertyValueFactory<DemandeReserv, String>("NomReserv"));
        nbrplace.setCellValueFactory(new PropertyValueFactory<DemandeReserv, Integer>("NbrPlace"));
        datereserv.setCellValueFactory(new PropertyValueFactory<DemandeReserv, Date>("DateReserv"));
        heure.setCellValueFactory(new PropertyValueFactory<DemandeReserv, String>("Heure"));
        affiche.setCellValueFactory(new PropertyValueFactory<DemandeReserv, String>("Affiche"));
        etat.setCellValueFactory(new PropertyValueFactory<DemandeReserv, String>("Etat"));

        affichedemande.getSelectionModel().selectedItemProperty().addListener((obs1, oldSelection, newSelection) -> {
            System.out.println(newSelection);
            if (newSelection != null) {
                d = newSelection;
                System.out.println("id: " + newSelection.getIdReserv());

            }

        });
        searchetat.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    filter(oldValue, newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(AffichagedemandeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
        

    }

    public void filter(String oldValue, String newValue) throws SQLException {
        ReservService dvs = new ReservService();
        List<DemandeReserv> data = dvs.readAll();
        if (newValue == null || oldValue.length() == newValue.length() || oldValue == null) {
            affichedemande.setItems((ObservableList<DemandeReserv>) data);
        } else {
            ObservableList<DemandeReserv> filter = FXCollections.observableArrayList();
            for (DemandeReserv r : data) {
                if ((r.getEtat()).contains(newValue)) {
                    filter.add(r);
                }
            }
            affichedemande.setItems(filter);
        }
    }

    @FXML
    private void deleteDemande(ActionEvent event) {

        ReservService ss = new ReservService();
        ss.deleteReserv(affichedemande.getSelectionModel().getSelectedItem());

        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("affichagedemande.fxml"));
            suppdemande.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichagedemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void updateetat(ActionEvent event) {

        //  DemandeReserv s=new DemandeReserv(combostate.getValue());
        ReservService ps = new ReservService();
        if (combostate.getValue() == "accept") {

            ps.updateEtatReserv(affichedemande.getSelectionModel().getSelectedItem(), combostate.getValue());
            Event ev = new Event(affichedemande.getSelectionModel().getSelectedItem().getNomReserv(), affichedemande.getSelectionModel().getSelectedItem().getCategorieReserv(), affichedemande.getSelectionModel().getSelectedItem().getNbrPlace(), affichedemande.getSelectionModel().getSelectedItem().getDateReserv(), affichedemande.getSelectionModel().getSelectedItem().getHeure(), affichedemande.getSelectionModel().getSelectedItem().getAffiche());
            EventService es = new EventService();
            es.insertEvent(ev);
            
            
            ApiSMS.sendSMS(affichedemande.getSelectionModel().getSelectedItem().getTelOrg(), "Your request that have the date" + " "+ affichedemande.getSelectionModel().getSelectedItem().getDateReserv()+" ; at time "+" "+ affichedemande.getSelectionModel().getSelectedItem().getHeure()+" was accepted !");

        } else {
            ps.updateEtatReserv(affichedemande.getSelectionModel().getSelectedItem(), combostate.getValue());
            ApiSMS.sendSMS(affichedemande.getSelectionModel().getSelectedItem().getTelOrg(),  "Your request that have the date" + " "+ affichedemande.getSelectionModel().getSelectedItem().getDateReserv()+" ; at time "+" "+ affichedemande.getSelectionModel().getSelectedItem().getHeure()+" was rejected!");
        }
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("affichagedemande.fxml"));
            showetat.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichagedemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void showetat(ActionEvent event) {

        ReservService ss = new ReservService();
        ArrayList<DemandeReserv> pers = (ArrayList<DemandeReserv>) ss.readById(affichedemande.getSelectionModel().getSelectedItem());
        ObservableList<DemandeReserv> obs = FXCollections.observableArrayList(pers);
        for (int i = 0; i < obs.size(); i++) {
            combostate.setValue(obs.get(i).getEtat().toString());

        }

    }

    @FXML
    private void homeResquest(ActionEvent event) {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("ajouterdemande.fxml"));
            retourajout.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichagedemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Home(ActionEvent event) {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            homeback.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichagedemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
