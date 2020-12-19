/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Salle;
import Services.SalleService;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffichageSalleController implements Initializable {

    @FXML
    private TableColumn<Salle, Integer> IdSalle;
    @FXML
    private TableColumn<Salle, String> libelle;
    @FXML
    private TableColumn<Salle, Integer> capacite;
    @FXML
    private TableColumn<Salle, String> categorie;
    @FXML
    private TableView<Salle> afficheSalle;
    @FXML
    private Button suppsalle;
    
    @FXML
    private Button showsalle;
    public static Salle ab;
    
    
    @FXML
    private Button retourajout;
    @FXML
    private Button homeback1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SalleService ss=new SalleService();
         ArrayList<Salle> pers = (ArrayList<Salle>) ss.readAll();
    ObservableList<Salle> obs = FXCollections.observableArrayList(pers);
    afficheSalle.setItems(obs);
    IdSalle.setCellValueFactory(new PropertyValueFactory<Salle,Integer> ("IdSalle"));
    libelle.setCellValueFactory(new PropertyValueFactory<Salle,String>("Libelle"));
    capacite.setCellValueFactory(new PropertyValueFactory<Salle,Integer>("Capacite"));
    categorie.setCellValueFactory(new PropertyValueFactory<Salle,String>("CategorieSalle"));
    
    afficheSalle.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    afficheSalle.getSelectionModel().selectedItemProperty().addListener(((obs1, oldSelection, newSelection)->{
        if(newSelection != null){
            ab = newSelection;
            System.out.println(ab);
        }
    }));
   
    
    }   
    
    
   
    @FXML
    public void deleteRow(ActionEvent event){
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want delete it ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        SalleService ss=new SalleService();
        ss.deleteSalle(afficheSalle.getSelectionModel().getSelectedItem().getIdSalle());
     
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageSalle.fxml"));
                suppsalle.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageSalleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            Parent root;
            
            try {
                root = FXMLLoader.load(getClass().getResource("affichageSalle.fxml"));
                suppsalle.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageSalleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
}
    
    @FXML
   public void show(ActionEvent event){
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("modifiersalle.fxml"));
                showsalle.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageSalleController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
   }
   
   /* public void mod(ActionEvent event){
       
      Salle s=new Salle(modlibelle.getText(),Integer.parseInt(modcapacite.getText()),modcategorie.getText());
            SalleService ps=new SalleService();
            ps.updateSalle(s, afficheSalle.getSelectionModel().getSelectedItem().getIdSalle());
          
          Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageSalle.fxml"));
                modsalle.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageSalleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }*/

    @FXML
    private void showajout(ActionEvent event) {
        
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("ajoutersalle.fxml"));
                retourajout.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageSalleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }

    @FXML
    private void HomeBack1(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("home.fxml"));
                homeback1.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichageSalleController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
               
               
               
            
    
}
   
    
