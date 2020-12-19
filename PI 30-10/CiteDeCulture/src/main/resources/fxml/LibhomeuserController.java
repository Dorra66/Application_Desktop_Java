/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class LibhomeuserController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private Button btnMybooks;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnAvailableBooks;
    @FXML
    private Button btnSendRequest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->  REQUEST FORM                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
        @FXML
    private void toRequestForm(ActionEvent event) {
        loadWindow("/fxml/userrequestform.fxml","Add new Request");
    }
    
    
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->  BOOK DATA                     /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void allBooks(ActionEvent event) {
        loadWindow("/fxml/bookdataavail.fxml","ALL BOOKS");
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
    ///////////////////////////              EXIT                      /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /* @FXML
    private void exitLib(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }*/
        @FXML
    private void exitLib(ActionEvent event) {
              try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accgeneralclient.fxml"));
            btnExit.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(HomelibController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
