/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Membre;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Services.MembreService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MembreupdateformController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtMail;
    @FXML
    private TextField txtAdress;
    @FXML
    private DatePicker txtSub;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnSave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         txtName.setText(MembreupdateController.cm.getNameMembre());
         txtLastName.setText(MembreupdateController.cm.getLastnameMembre());
         txtCin.setText(Integer.toString(MembreupdateController.cm.getCinMembre()));
         txtMobile.setText(Integer.toString(MembreupdateController.cm.getMobileMembre()));
         txtMail.setText(MembreupdateController.cm.getMailMembre());
         txtAdress.setText(MembreupdateController.cm.getAdressMembre()); 
    }    
    
    
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                Save BOOK                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @FXML
    private void saveMembre(ActionEvent event){
        MembreService ms = new MembreService();
        LocalDate value = txtSub.getValue();
        String subDate = value.toString();    
               if (txtName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtCin.getText().isEmpty() || txtMobile.getText().isEmpty()|| txtMail.getText().isEmpty() || txtAdress.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Vérifier Vos champs !");
            alert.showAndWait();
            return;
        }
      Membre m = new Membre(txtName.getText(), txtLastName.getText(),Integer.parseInt(txtCin.getText()),Integer.parseInt(txtMobile.getText()),txtMail.getText(),txtAdress.getText(),subDate);
        ms.updateMembre(m);
        }
    
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                CLOSE FORM                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void closeForm(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
}
