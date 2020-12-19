/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;


import Entities.Book;
import Entities.Membre;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Services.BookService;
import Services.MembreService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MembreupdateController implements Initializable {

    @FXML
    private TableView<Membre> MembreTable;
    @FXML
    private TableColumn<Membre, String> colName;
    @FXML
    private TableColumn<Membre, String> colLastName;
    @FXML
    private TableColumn<Membre, Integer> colCin;
    @FXML
    private TableColumn<Membre, Integer> colMobile;
    @FXML
    private TableColumn<Membre, String> colMail;
    @FXML
    private TableColumn<Membre, String> colAdress;
    @FXML
    private TableColumn<Membre, String> colSub;
    @FXML
    private TextField CinInput;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnBack;
    
    public static Membre cm ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initCol();
        showMembreData();       
        listenMembreData();
    }    
    
               //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                INIT                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            private void initCol() {
        colName.setCellValueFactory(new PropertyValueFactory<Membre, String>("nameMembre"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Membre, String>("lastnameMembre"));
        colCin.setCellValueFactory(new PropertyValueFactory<Membre, Integer>("cinMembre"));
        colMobile.setCellValueFactory(new PropertyValueFactory<Membre, Integer>("mobileMembre"));
        colMail.setCellValueFactory(new PropertyValueFactory<Membre, String>("mailMembre"));
        colAdress.setCellValueFactory(new PropertyValueFactory<Membre, String>("adressMembre"));
        colSub.setCellValueFactory(new PropertyValueFactory<Membre, String>("SubscriptionMembre"));
    }
            
            
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->MEMBRE FORM                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void toMembreUpdateForm(ActionEvent event) {
        loadWindow("/fxml/membreupdateform.fxml","Update your Membre");
    }
    
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                LOAD WINDOW                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
        void loadWindow(String loc, String title) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(fxml.HomelibController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
        
       //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                SEARCH MEMBRE                      /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void searchMembre(ActionEvent event) {
        MembreService ms = new MembreService();
        int x = Integer.parseInt(CinInput.getText());
        ArrayList<Membre> membrs = (ArrayList<Membre>) ms.findbyCin(x);
        ObservableList<Membre> obs = FXCollections.observableArrayList(membrs);
        MembreTable.setItems(obs);
    }
         
               //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                Listen TO Member DATA            /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          private void listenMembreData() {
        MembreService ms = new MembreService();
        ObservableList<Membre> membrs = ms.readALL2();
        MembreTable.setItems(membrs);
        MembreTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        MembreTable.getSelectionModel().selectedItemProperty().addListener((var, oldSelection, newSelection) -> {
            System.out.println(membrs);
            System.out.println(newSelection);
            if (newSelection != null) {
                cm = newSelection;
            }
             }); 
            }
        
                     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                SHOW BD                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
    @FXML
        private void showMembreData() {
        MembreService ms = new MembreService();
        ArrayList<Membre> membrs = (ArrayList<Membre>) ms.readALL();
        ObservableList<Membre> obs = FXCollections.observableArrayList(membrs);
        MembreTable.setItems(obs);
    }  
        
        
                   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                BACK HOME     <- ---                   /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void backHome(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/home.fxml"));
            btnBack.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(BookupdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
    
}
