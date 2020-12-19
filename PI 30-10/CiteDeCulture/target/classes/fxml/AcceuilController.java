/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.actualités;
import Entities.personne;
import java.awt.Desktop;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Services.actualitésService;
import Services.personneService;
import javafx.application.Application;

import javafx.application.HostServices;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class AcceuilController implements Initializable{

    @FXML
    private Button acca1;
    @FXML
    private Button accm1;
    @FXML
    private Button accs1;
    @FXML
    private Button accf1;
    @FXML
    private Button acca2;
    @FXML
    private Button accm2;
    @FXML
    private Button accs2;
    @FXML
    private Button accf2;
    @FXML
    private Button acca3;
    @FXML
    private Button accm3;
    @FXML
    private Button accs3;
    @FXML
    private Button accf3;
    @FXML
    private Button dec1;
    @FXML
    private TableView<personne> tabc;
    @FXML
    private TableColumn<personne, Integer> idc1;
    @FXML
    private TableColumn<personne, String> nomc1;
    @FXML
    private TableColumn<personne, String> prenomc1;
    @FXML
    private TableColumn<personne, String> emailc1;
    @FXML
    private TableColumn<personne, Integer> cin2;
    @FXML
    private Button supprimerc1;
    @FXML
    private Button actualiserbutt;
    @FXML
    private Button btnpdf;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        //////AJOUT/////////////////
         acca1.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("ajouterActualite.fxml"));
                acca1.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
          acca2.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("ajouterPublicite.fxml"));
                acca2.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
           acca3.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("ajouterSponsoring.fxml"));
                acca3.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
           ////////////MODIFICATION//////////////////
            accm1.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("modifierActualite.fxml"));
                accm1.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
             accm2.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("modifierPublicite.fxml"));
                accm2.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
              accm3.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("modifierSponsoring.fxml"));
                accm3.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
              /////////////////SUPPRESSION//////////////////////////
               accs1.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("supprimerActualite.fxml"));
                accs1.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
                accs2.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("supprimerPublicite.fxml"));
                accs2.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
                 accs3.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("supprimerSponsoring.fxml"));
                accs3.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
            //////////Affichage//////////////////
             accf1.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("afficherActualite.fxml"));
                accf1.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
              accf2.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("affichagePub.fxml"));
                accf2.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
               accf3.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("affichageSpon.fxml"));
                accf3.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
               ////////////////deconnexion//////////////
               dec1.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("accgeneral.fxml"));
                dec1.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
               //////////supp client////////////
               personneService ps=new personneService();
               
        ArrayList<personne> act=(ArrayList<personne>) ps.readAllper();
        ObservableList<personne> obs=FXCollections.observableArrayList(act);
        idc1.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomc1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomc1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        emailc1.setCellValueFactory(new PropertyValueFactory<>("email"));
         cin2.setCellValueFactory(new PropertyValueFactory<>("cin"));
        tabc.setItems(obs);
         
          supprimerc1.setOnAction(e->{
            int index = tabc.getSelectionModel().getSelectedItem().getId();
            ps.deletePers(index);
            Parent root ;
             try{
                 root=FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
                 tabc.getScene().setRoot(root);}
               catch (IOException ex) {
                 Logger.getLogger(SupprimerActualiteController.class.getName()).log(Level.SEVERE, null, ex);
                }
           
             Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Confirmation");
                    alert.setHeaderText(null);
                    alert.setContentText("Client supprimé avec succés");
                    alert.show();
            
        });
          ////////actualiser//////////
          
           actualiserbutt.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                actualiserbutt.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
           ////////////////////pdf////////////
          actualitésService ac1 = new actualitésService();
           ArrayList<actualités> listact=(ArrayList<actualités>) ac1.readAlla();
          btnpdf.setOnAction(e->{
              String contenu = "";
              for(int j=0;j<listact.size();j++){
            int ind = j+1;
          contenu +="\n"+ind+" - "+listact.get(j).getTitre()+" - "+listact.get(j).getDescription()+" - "+listact.get(j).getDate_Début()+" - "+listact.get(j).getDate_Fin();
          ac1.generatepdfparts(contenu);
         ///////////////////
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      
                      alert.setTitle("Confirmation");
                      alert.setHeaderText(null);
                      alert.setContentText("PDF généré avec succès");
                      alert.show();
      
              }
         
        
            });
        }
           
    }    
    

