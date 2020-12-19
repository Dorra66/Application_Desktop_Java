/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.DemandeReserv;
import Entities.Event;
import Services.EventService;
import Services.ReservService;
import java.awt.Desktop;
//import java.awt.Insets;
import javafx.geometry.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutereventController implements Initializable {
    
    final FileChooser fileChooser = new FileChooser();
    private String file_image;
    private Desktop desktop = Desktop.getDesktop();
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    private FileInputStream fis;
    @FXML
    private TextField nameevent;
    @FXML
    private TextField category;
    @FXML
    private TextField nbrplace;
    @FXML
    private DatePicker date;
    @FXML
    private Button addevent;
    @FXML
    private ComboBox<String> heuredebevent;
    
    @FXML
    private Button importE;
    @FXML
    private ImageView imgview;
    
    ObservableList<String> list = FXCollections.observableArrayList(
            "8:00", "9:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"
    );

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        heuredebevent.setItems(list);
        
        importE.setOnAction((event) -> {
            FileChooser fc = new FileChooser();
            Current_file = fc.showOpenDialog(null);
            if (Current_file != null) {
                Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
                imgview.setImage(images);
                
                try {
                    fis = new FileInputStream(Current_file);
                    file_image = Current_file.getName();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AjoutereventController.class.getName()).log(Level.SEVERE, null, ex);
                }
                final GridPane inputGridPane = new GridPane();
                GridPane.setConstraints(importE, 0, 0);
                inputGridPane.setHgap(6);
                inputGridPane.setVgap(6);
                final Pane rootGroup = new VBox(12);
                rootGroup.getChildren().addAll(inputGridPane);
                rootGroup.setPadding(new Insets(12, 12, 12, 12));
            }
        });
        
        addevent.setOnAction(e -> {
            if (date.getValue().isAfter(LocalDate.now())) {
                
                Event ev = new Event(nameevent.getText(), category.getText(), Integer.parseInt(nbrplace.getText()), java.sql.Date.valueOf(date.getValue()), heuredebevent.getValue(), file_image);
                          
// insertion image fi bd
                pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
                pathto = FileSystems.getDefault().getPath("C:\\images\\" + Current_file.getName());
                Path targetDir = FileSystems.getDefault().getPath("C:\\images");
                
                try {
                    Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(AjoutereventController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                EventService ps = new EventService();
                ps.insertEvent(ev);
                
                Parent root;
                
                try {
                    root = FXMLLoader.load(getClass().getResource("affichageevent.fxml"));
                    addevent.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AjoutereventController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("The date of event is invalid!");
                alert.show();
                
            }
            
        });
    }
    
}
