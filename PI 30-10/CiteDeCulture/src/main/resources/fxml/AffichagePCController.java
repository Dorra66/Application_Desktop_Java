/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.publicités;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Services.publicitésService;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class AffichagePCController implements Initializable {

    @FXML
    private TableView<publicités> tablea2c;
    @FXML
    private TableColumn<publicités, Integer> c1c;
    @FXML
    private TableColumn<publicités, String> c2c;
    @FXML
    private TableColumn<publicités, String> c3c;
    @FXML
    private TableColumn<publicités, String> cc;
    @FXML
    private ImageView img1c;
    @FXML
    private Button act2c;
    @FXML
    private Button btnstatc;
    @FXML
    private Button retouuur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          publicitésService ps=new publicitésService();
        ArrayList<publicités> pub = (ArrayList<publicités>) ps.readAllp() ;
        ObservableList<publicités> obb = FXCollections.observableArrayList(pub) ;
        tablea2c.setItems(obb);
        
        tablea2c.setOnMouseClicked((javafx.scene.input.MouseEvent event)->{ 
        String x=tablea2c.getSelectionModel().getSelectedItem().getImag();
         File file = new File("C:\\images\\"+x);
         Image image = new Image(file.toURI().toString());
          img1c.setImage(image);});
        
        c1c.setCellValueFactory(new PropertyValueFactory<>("id"));
         c2c.setCellValueFactory(new PropertyValueFactory<>("titre"));
          c3c.setCellValueFactory(new PropertyValueFactory<>("description"));
          cc.setCellValueFactory(new PropertyValueFactory<>("imag"));
        
       
        ///////////statistiques////////////////
         btnstatc.setOnAction(e->{
         
            try {
                
                Parent root ;
                root=FXMLLoader.load(getClass().getResource("PieChartC.fxml"));
                btnstatc.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichagePubController.class.getName()).log(Level.SEVERE, null, ex);
            }
                      
                     
      });
         //////////retour/////////////
          retouuur.setOnAction(e->{
              
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil1.fxml"));
                retouuur.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
            });
        
    }    
    
}
