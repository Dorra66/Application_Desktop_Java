/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Request;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Services.RequestService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class UserrequestformController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtMail;
    @FXML
    private Button btnSaveRequest;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtBookTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeForm(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                SAVE REQUEST                       /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void saveRequest(ActionEvent event) {
        RequestService rs = new RequestService();

        if (txtBookTitle.getText().isEmpty() ||txtName.getText().isEmpty() || txtLastName.getText().isEmpty()  || txtMail.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Vérifier Vos champs !");
            alert.showAndWait();
            return;
        }
        Request r = new Request(txtBookTitle.getText(),txtName.getText(), txtLastName.getText(), txtMail.getText());
        rs.addRequest(r);
    }

}
