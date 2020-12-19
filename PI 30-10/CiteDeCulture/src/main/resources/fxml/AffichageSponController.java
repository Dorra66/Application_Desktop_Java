/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.sponsoring;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import Services.sponsoringService;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class AffichageSponController implements Initializable {

    @FXML
    private TableView<sponsoring> tabb;
    @FXML
    private TableColumn<sponsoring, Integer> colid;
    @FXML
    private TableColumn<sponsoring, Date> coldate;
    @FXML
    private TableColumn<sponsoring, String> coldes;
    @FXML
    private Button r10;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        sponsoringService ps=new sponsoringService();
        ArrayList<sponsoring> act=(ArrayList<sponsoring>) ps.readAlls();
        ObservableList<sponsoring> obs=FXCollections.observableArrayList(act);
        tabb.setItems(obs);
         colid.setCellValueFactory(new PropertyValueFactory<>("id"));
         coldate.setCellValueFactory(new PropertyValueFactory<>("date_contrat"));
        coldes.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        r10.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                r10.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
        
    }    
    
}
