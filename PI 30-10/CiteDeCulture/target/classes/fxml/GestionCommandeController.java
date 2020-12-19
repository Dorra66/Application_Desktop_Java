/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.sql.ResultSet;
import java.sql.Connection;
import Util.DataSource;
import java.util.List;
import java.sql.Statement;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import services.AnnonceProdService;
import Entities.AnnonceProd;
import Entities.personne;
import Entities.Panier;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.image.Image;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import Services.PanierService;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Optional;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import Util.DataSource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



/**
 * FXML Controller class
 *
 * @author emna
 */
public class GestionCommandeController implements Initializable {

    @FXML
    private TableView<AnnonceProd> catalogue;
    @FXML
    private TableColumn<?, ?> nprod;
    @FXML
    private TableColumn<?, ?> dprod;
    @FXML
    private TableColumn<?, ?> iprod;
   
    @FXML
    private Button addpanier;
    
    @FXML
    private ImageView img;
    @FXML
    private Button mybasket;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        AnnonceProdService ps=new AnnonceProdService();
        ArrayList<AnnonceProd> per=(ArrayList<AnnonceProd>) ps.readAll();
        ObservableList<AnnonceProd> ob=FXCollections.observableArrayList(per);
        catalogue.setItems(ob);
        nprod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
        dprod.setCellValueFactory(new PropertyValueFactory<>("description"));
        iprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
       
        
        
        catalogue.setOnMouseClicked((javafx.scene.input.MouseEvent event)->{
        String x=catalogue.getSelectionModel().getSelectedItem().getImage();
        File nomfichier = new File("C:\\wamp64\\www\\images\\"+x);
        Image image=new Image(nomfichier.toURI().toString());
        img.setImage(image);
    });
        
        
        Panier p=new Panier();
         PanierService pss =new PanierService();
       
      
       
        addpanier.setOnAction(e->
                {
        
          AnnonceProd x= catalogue.getSelectionModel().getSelectedItem();
            
     if(x.getStock()==0){ 
                  addpanier.setDisable(true);
          
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setHeaderText(null);
                  alert.setContentText("insufficient stock");

                  ButtonType ok = new ButtonType("ok");
                  ButtonType buttonTypeCancel = new ButtonType("Cancel");

                   alert.getButtonTypes().setAll(ok, buttonTypeCancel);

                   Optional<ButtonType> result = alert.showAndWait();
                         if (result.get() == ok){
                               addpanier.setDisable(false);
                                                 }
                             else {
                              addpanier.setDisable(false);
                                   }
 
          }
      else  {   
        
                   p.setId_prod(x.getId_prod());
                    p.setId_client(LoginController.PERSONNECONNECTEE.getId());
                      pss.insertP(p); 
          
                 Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                   alert1.setTitle("Information ");
                   alert1.setHeaderText(null);
                    alert1.setContentText("Product added into bascket  successfully!");
                     alert1.show();}
          
                });
     
          
          
          
          
     
    }
        
    


   /* private void AfficherMonPanier(ActionEvent event) {
        try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("Monpanier.fxml"));
                voirpanier.getScene().setRoot(root);
             } 
             
             catch (IOException ex) {
                 Logger.getLogger(GestionCommandeController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
    }*/

    @FXML
    private void ShowBasket(ActionEvent event) {
         try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("Monpanier.fxml"));
                mybasket.getScene().setRoot(root);
             } 
             
             catch (IOException ex) {
                 Logger.getLogger(GestionCommandeController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
}

    

   
   


  


                        

        
    
    
    

   
   

    

    
   
