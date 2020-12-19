/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Services.ReclamationMServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RepondreReclamationCController implements Initializable {

    @FXML
    private TextField object_aff_rec;
    @FXML
    private TextField aff_rec_txtarea;
    @FXML
    private Label date_env_rec;
    @FXML
    private Label id_env_rec;
    @FXML
    private TextArea textarea_rep;
    @FXML
    private Button btn_rep_rec;
    @FXML
    private Button btn_anl_rep;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id_env_rec.setText(AfficherReclamationClientController.newreclamation.getIdsource());
        date_env_rec.setText(AfficherReclamationClientController.newreclamation.getDateReclamation());
        object_aff_rec.setText(AfficherReclamationClientController.newreclamation.getObjetReclamation());
        aff_rec_txtarea.setText(AfficherReclamationClientController.newreclamation.getDescriptionReclamation());
    }    

    @FXML
    private void onclickRepondreReclamation(ActionEvent event) throws SQLException {
        AfficherReclamationClientController.newreclamation.setReponseReclamation(textarea_rep.getText());
        ReclamationMServices rms = new ReclamationMServices();
        rms.updateRS(AfficherReclamationClientController.newreclamation);
//        ObservableList<User> uf = us.getUserbyUsername(AfficherReclamationClientController.newreclamation.getIdsource());
//        System.out.println(uf);
//        String destination =uf.get(0).getEmail();
//         System.out.println(destination);
//       String sujet="Reponse à votre réclamation";
//        String msg="La réponse de l'admin est :"+textarea_rep.getText();
//      
//        SendMail.sendMail(destination, sujet,msg);
//        System.out.println("email envoyer");
//        
       Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherReclamationClient.fxml"));
                btn_rep_rec.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(RepondreReclamationCController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void onClickAnullerReponse(ActionEvent event) {
         Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherReclamationClient.fxml"));
                btn_anl_rep.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(RepondreReclamationCController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
