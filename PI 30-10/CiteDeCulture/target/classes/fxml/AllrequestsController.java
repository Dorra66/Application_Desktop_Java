/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Request;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Services.RequestService;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AllrequestsController implements Initializable {

    @FXML
    private TableView<Request> RequestTable;
    @FXML
    private TableColumn<Request, String> colBookTitle;
    @FXML
    private TableColumn<Request, String> colMembreName;
    @FXML
    private TableColumn<Request, String> colLastName;
    @FXML
    private TableColumn<Request, String> colMail;
    
        public static Request res ;
    @FXML
    private Button btnConfirml;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                initCol();
        showRequestData();
        listenRequestData();
    }    
    
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                INIT                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            private void initCol() {
        colBookTitle.setCellValueFactory(new PropertyValueFactory<Request, String>("bookTitle"));
        colMembreName.setCellValueFactory(new PropertyValueFactory<Request, String>("membreName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Request, String>("membreLastname"));
        colMail.setCellValueFactory(new PropertyValueFactory<Request, String>("membreMail"));
    }
            
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                SHOW BD                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            
        private void showRequestData() {
        RequestService rs = new RequestService();
        ArrayList<Request> var = (ArrayList<Request>) rs.readALL();
        ObservableList<Request> obs = FXCollections.observableArrayList(var);
        RequestTable.setItems(obs);
    }  
        
                       //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                Listen TO BOOK DATA            /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          private void listenRequestData() {
        RequestService rs = new RequestService();
        ObservableList<Request> requests = rs.readALL2();
        RequestTable.setItems(requests);
        RequestTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        RequestTable.getSelectionModel().selectedItemProperty().addListener((var, oldSelection, newSelection) -> {
            System.out.println(requests);
            System.out.println(newSelection);
            if (newSelection != null) {
                res = newSelection;
            }
             }); 
            }

          
                                 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                DELETE REQUEST          /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void ConfirmRequest(ActionEvent event) {
                RequestService rs = new RequestService();
                rs.deleteRequest();
    }
}
