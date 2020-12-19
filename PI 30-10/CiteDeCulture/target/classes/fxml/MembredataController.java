/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Book;
import Entities.Membre;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Services.BookService;
import Services.MembreService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MembredataController implements Initializable {
    @FXML
    private TableView<Membre> MembreTable;
    @FXML
    private TableColumn<Membre, String> colName;
    @FXML
    private TableColumn<Membre, String> colLastName;
    @FXML
    private TableColumn<Membre, String> colCin;
    @FXML
    private TableColumn<Membre, String> colMobile;
    @FXML
    private TableColumn<Membre, String> colMail;
    @FXML
    private TableColumn<Membre, String> colAdress;
    @FXML
    private TableColumn<Membre, String> colSubscriptionDate;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initCol();
        showMembreData();
    }    
    
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                INIT                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            private void initCol() {
        colName.setCellValueFactory(new PropertyValueFactory<Membre, String>("nameMembre"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Membre, String>("lastnameMembre"));
        colCin.setCellValueFactory(new PropertyValueFactory<Membre, String>("cinMembre"));
        colMobile.setCellValueFactory(new PropertyValueFactory<Membre, String>("mobileMembre"));
        colMail.setCellValueFactory(new PropertyValueFactory<Membre, String>("mailMembre"));
        colAdress.setCellValueFactory(new PropertyValueFactory<Membre, String>("adressMembre"));
        colSubscriptionDate.setCellValueFactory(new PropertyValueFactory<Membre, String>("SubscriptionMembre"));
    }
            
            
                        
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                SHOW BD                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            
        private void showMembreData() {
        MembreService ms = new MembreService();
        ArrayList<Membre> membrs = (ArrayList<Membre>) ms.readALL();
        ObservableList<Membre> obs = FXCollections.observableArrayList(membrs);
        MembreTable.setItems(obs);
    }  
    
}
