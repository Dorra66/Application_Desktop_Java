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
import javafx.scene.layout.AnchorPane;
import Services.actualitésService;


/**
 * FXML Controller class
 *
 * @author dorra
 */
public class AfficherActualiteController implements Initializable {
    @FXML
    private TableView<actualités> tablea1;
    private ListDataa listdata = new ListDataa();
    @FXML
    private TableColumn<actualités,Date> coldate_Début;
    @FXML
    private TableColumn<actualités, Date> coldate_Fin;
    @FXML
    private TableColumn<actualités, Integer> colid;
    @FXML
    private TableColumn<actualités, String> coldescription;
    @FXML
    private TableColumn<actualités, String> coltitre;
    @FXML
    private TableColumn<actualités, String> colImage1;
    @FXML
    private Button r2;
    @FXML
    private ImageView img2;
    @FXML
    private TextField search1;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
          
          
          
        actualitésService ps=new actualitésService();
        ArrayList<actualités> act=(ArrayList<actualités>) ps.readAlla();
        ObservableList<actualités> obs=FXCollections.observableArrayList(act);
        tablea1.setItems(obs);
        
        tablea1.setOnMouseClicked((javafx.scene.input.MouseEvent event)->{ 
        String x=tablea1.getSelectionModel().getSelectedItem().getImg();
        File file = new File("C:\\images\\"+x);
        Image image = new Image(file.toURI().toString());
        img2.setImage(image);});
        
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        coldate_Début.setCellValueFactory(new PropertyValueFactory<>("date_Début"));
        coldate_Fin.setCellValueFactory(new PropertyValueFactory<>("date_Fin"));
        coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        colImage1.setCellValueFactory(new PropertyValueFactory<>("img"));
        
        
       
        //////////recherche//////////////////
        search1.setOnKeyReleased((event) -> {
             listdata.setTitre(search1.getText());
             tablea1.setItems(listdata.getAct());
             colid.setCellValueFactory(new PropertyValueFactory<>("id"));
             coldate_Début.setCellValueFactory(new PropertyValueFactory<>("date_Début"));
             coldate_Fin.setCellValueFactory(new PropertyValueFactory<>("date_Fin"));
             coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
             coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
             colImage1.setCellValueFactory(new PropertyValueFactory<>("img"));
             
             
        });
        
          //////////retour/////////////
          r2.setOnAction(e->{
             try{
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                r2.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
               
            });
         
         
       
    }    
    
}
