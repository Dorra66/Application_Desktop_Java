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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Services.publicitésService;


/**
 * FXML Controller class
 *
 * @author dorra
 */
public class AffichagePubController implements Initializable {

    @FXML
    private TableView<publicités> tablea2;
    @FXML
    private TableColumn<publicités, Integer >c1;
    @FXML
    private TableColumn<publicités, String> c2;
    @FXML
    private TableColumn<publicités, String> c3;
    @FXML
    private TableColumn<publicités, String> c;
    @FXML
    private Button r6;
    @FXML
    private ImageView img1;
    @FXML
    private Button btnstat;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        publicitésService ps=new publicitésService();
        ArrayList<publicités> pub = (ArrayList<publicités>) ps.readAllp() ;
        ObservableList<publicités> obb = FXCollections.observableArrayList(pub) ;
        tablea2.setItems(obb);
        
        tablea2.setOnMouseClicked((javafx.scene.input.MouseEvent event)->{ 
        String x=tablea2.getSelectionModel().getSelectedItem().getImag();
         File file = new File("C:\\images\\"+x);
         Image image = new Image(file.toURI().toString());
          img1.setImage(image);});
        
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
         c2.setCellValueFactory(new PropertyValueFactory<>("titre"));
          c3.setCellValueFactory(new PropertyValueFactory<>("description"));
          c.setCellValueFactory(new PropertyValueFactory<>("imag"));
        
       
        ///////////statistiques////////////////
         btnstat.setOnAction(e->{
         
            try {
                
                Parent root ;
                root=FXMLLoader.load(getClass().getResource("PieChart.fxml"));
                btnstat.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AffichagePubController.class.getName()).log(Level.SEVERE, null, ex);
            }
                      
                     
      });
         //////////retour/////////////
          r6.setOnAction(e->{
              
             try {
                
                 
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                r6.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
               
            });
        
        
    }    
    
}
