/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Event;
import Services.EventService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifiereventController implements Initializable {

    @FXML
    private TextField modname1;
    @FXML
    private TextField modcateg1;
    @FXML
    private TextField modplace1;
    @FXML
    private DatePicker moddate1;
    @FXML
    private ComboBox<String> modheure1;
    @FXML
    private TextField modaffiche1;
    @FXML
    private Button importaff1;
    @FXML
    private Button updateevent1;
     
    ObservableList<String> list1=FXCollections.observableArrayList(
          "8:00","9:00","10:00","11:00","12:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00"  
            );

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        modheure1.setItems(list1);
        modname1.setText(AffichageeventController.ac.getNomEvent());
        modcateg1.setText(AffichageeventController.ac.getCategorieEvent());
        modplace1.setText(String.valueOf(AffichageeventController.ac.getNbrPlaceDispo()));
        moddate1.setValue(AffichageeventController.ac.getDateEvent().toLocalDate());
        modheure1.setValue(AffichageeventController.ac.getHeureEvent());
        modaffiche1.setText(AffichageeventController.ac.getAffiche());
                
    }    

    @FXML
    private void importaff(ActionEvent event) {
        importaff1.setOnAction((image) -> {
             FileChooser f = new FileChooser();
                f.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image", "*.*")
            );
                
                File fi = f.showOpenDialog(null);
                
                if(fi!=null){
               modaffiche1.setText(fi.getName());
    }
        });
    }

    @FXML
    private void updateevent(ActionEvent event) {
        
         Event e=new Event(modname1.getText(),modcateg1.getText(),Integer.parseInt(modplace1.getText()),java.sql.Date.valueOf(moddate1.getValue()), (String) modheure1.getValue(),modaffiche1.getText());
            EventService es=new EventService();
            es.updateEvent(e,AffichageeventController.ac.getIdEvent());
            Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
                updateevent1.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(ModifiereventController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
