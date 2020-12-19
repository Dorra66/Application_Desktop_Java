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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class HomeController implements Initializable {

    @FXML
    private Button addr;
    @FXML
    private Button consultr;
    @FXML
    private Button supr;
    @FXML
    private Button modr;
    @FXML
    private Button addevent;
    @FXML
    private Button delevent;
    @FXML
    private Button affevent;
    @FXML
    private Button modevent;
    @FXML
    private Button ajoutpart;
    @FXML
    private Button supppart;
    @FXML
    private Button affpart;
    @FXML
    private Button homeback;
    @FXML
    private Button consultrequest;
    @FXML
    private Button affavis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addroom(ActionEvent event) {
        
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("ajoutersalle.fxml"));
                addr.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }

    @FXML
    private void consultroom(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageSalle.fxml"));
                consultr.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void suproom(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageSalle.fxml"));
                supr.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void modrrom(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageSalle.fxml"));
                modr.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void ajoutevent(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("ajouterevent.fxml"));
                addevent.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void deleteevent(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
                delevent.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void afficheevent(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
                affevent.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void modievent(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
                modevent.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void addpart(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
                ajoutpart.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void deletepart(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageParticipation.fxml"));
                supppart.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void consultpart(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageParticipation.fxml"));
                affpart.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void consulterrequest(ActionEvent event) {
         Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichagedemande.fxml"));
                affpart.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void affavis(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageAvis.fxml"));
                affpart.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void HomeBackAdmin(ActionEvent event) {
        Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("accgeneral.fxml"));
                homeback.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
}
