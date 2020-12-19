/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.AnnonceProd;
import Entities.personne;
import Entities.Commande;
import Entities.Panier;
import Entities.PanierRempli;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.AnnonceProdService;
import Services.CommandeService;
import Services.PanierRempliService;
import Services.PanierService;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;



/**
 * FXML Controller class
 *
 * @author emna
 */
public class MonpanierController implements Initializable {

    @FXML
    private TableView<PanierRempli> pan;
    @FXML
    private TableColumn nameproduct;
   
    @FXML
    private TextField firstcl;
   
   
      @FXML
    private Button confcmd;  
    @FXML
    private Button cancel;
    @FXML
    private Button uppanier;
    @FXML
    private TextField prcl;
 
    /**
     * Initializes the controller class.
     */
    //@Override
    
    public void initialize(URL url, ResourceBundle rb) {
        Panier p=new Panier();
     
    
        PanierRempliService ps=new PanierRempliService();
        List<PanierRempli> pers=ps.readpn(LoginController.PERSONNECONNECTEE.getId());
        ObservableList<PanierRempli> obs = FXCollections.observableArrayList(pers);
             pan.setItems(obs);
       

        for (int i = 0; i < obs.size() ;i++) {
            System.out.println(obs.get(i));
        }
        
        nameproduct.setCellValueFactory(new Callback<CellDataFeatures<PanierRempli, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<PanierRempli, String> param) {
                return param.getValue().getProd().getNpProp();
            }
        });
        
              System.out.println(pers.get(0).getClt());
        
        
                 firstcl.setText(pers.get(0).getClt().getNom());
      
      
                  prcl.setText(pers.get(0).getClt().getPrenom());
                // adrcl.setText(pers.get(0).getClt().getAdresse_cl()); 
       
      
        
         uppanier.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("GestionCommande.fxml"));
                uppanier.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(MonpanierController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            });           
    
         
       // PanierService pss=new PanierService();
         
         cancel.setOnAction(e->{
             
             PanierService pss=new PanierService();
             try {
                 
                 
                  pss.deletePst(LoginController.PERSONNECONNECTEE.getId());               
                  
                  
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("GestionCommande.fxml"));
                cancel.getScene().setRoot(root);
                                                            
             } catch (IOException ex) {
                 Logger.getLogger(MonpanierController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            });            
         
        
       
          
         confcmd.setOnAction(e->{
           CommandeService cs=new CommandeService();
                     cs.parcourir_cmd_insert_diminuer(LoginController.PERSONNECONNECTEE.getId());
             
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Information ");
                 alert.setHeaderText(null);
                 alert.setContentText("order passed successfully");
                   alert.show();

       
         });  
    
   
}
  
}
    
   
 

                 
            
         
            
     
   
     
        
        
     
        
        
        
        
        

