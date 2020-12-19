/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.ListDataa;
import Entities.actualités;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Services.actualitésService;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class AfficherACController implements Initializable {

    @FXML
    private TableView<actualités> tablea1c;
    private ListDataa listdata = new ListDataa();
    @FXML
    private TableColumn<actualités, Date> coldate_Débutc;
    @FXML
    private TableColumn<actualités, Date> coldate_Finc;
    @FXML
    private TableColumn<actualités, Integer> colidc;
    @FXML
    private TableColumn<actualités, String> coldescriptionc;
    @FXML
    private TableColumn<actualités, String> coltitrec;
    @FXML
    private TableColumn<actualités, String> colImage1c;
    @FXML
    private Button r2c;
    @FXML
    private Button actualiserc;
    @FXML
    private TextField search1c;
    @FXML
    private ImageView img2c;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         actualitésService ps=new actualitésService();
        ArrayList<actualités> act=(ArrayList<actualités>) ps.readAlla();
        ObservableList<actualités> obs=FXCollections.observableArrayList(act);
        tablea1c.setItems(obs);
        
         tablea1c.setOnMouseClicked((javafx.scene.input.MouseEvent event)->{ 
        String x=tablea1c.getSelectionModel().getSelectedItem().getImg();
         File file = new File("C:\\images\\"+x);
         Image image = new Image(file.toURI().toString());
          img2c.setImage(image);});
        
        colidc.setCellValueFactory(new PropertyValueFactory<>("id"));
        coldate_Débutc.setCellValueFactory(new PropertyValueFactory<>("date_Début"));
        coldate_Finc.setCellValueFactory(new PropertyValueFactory<>("date_Fin"));
        coldescriptionc.setCellValueFactory(new PropertyValueFactory<>("description"));
        coltitrec.setCellValueFactory(new PropertyValueFactory<>("titre"));
        colImage1c.setCellValueFactory(new PropertyValueFactory<>("img"));
        
        //////////recherche//////////////////
        search1c.setOnKeyReleased((event) -> {
             listdata.setTitre(search1c.getText());
             tablea1c.setItems(listdata.getAct());
             colidc.setCellValueFactory(new PropertyValueFactory<>("id"));
             coldate_Débutc.setCellValueFactory(new PropertyValueFactory<>("date_Début"));
             coldate_Finc.setCellValueFactory(new PropertyValueFactory<>("date_Fin"));
             coldescriptionc.setCellValueFactory(new PropertyValueFactory<>("description"));
             coltitrec.setCellValueFactory(new PropertyValueFactory<>("titre"));
             colImage1c.setCellValueFactory(new PropertyValueFactory<>("img"));
             
             
        });
        ///////////actualiser///////////
            actualiserc.setOnAction(e->{
             try{
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("afficherAC.fxml"));
                actualiserc.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
               
            });
        
          //////////retour/////////////
          r2c.setOnAction(e->{
             try{
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil1.fxml"));
                r2c.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
               
            });
        
        
        
    }    
    
}
