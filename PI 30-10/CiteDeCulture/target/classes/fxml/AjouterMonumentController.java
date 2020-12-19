/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Monument;
import Services.MonumentServices;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author WSI
 */
public class AjouterMonumentController implements Initializable {
    
    final FileChooser fileChooser = new FileChooser();
    private String file_image;
    private Desktop desktop = Desktop.getDesktop();
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    private FileInputStream fis;
    @FXML
    private TextArea txtDesc;
    @FXML
    private Button btnAddM;
    @FXML
    private TextField txtNomM;
    @FXML
    private Button btnBrowse;
    @FXML
    private ImageView imgView;
    @FXML
    private Button btnHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    btnAddM.setOnAction(e->{
        
            Monument m = new Monument(txtNomM.getText(), txtDesc.getText(),file_image);
            MonumentServices ms = new MonumentServices();
            ms.insertM(m);
            // insertion img fi bd
            pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
            pathto = FileSystems.getDefault().getPath("C:\\images" + Current_file.getName());
            Path targetDir = FileSystems.getDefault().getPath("C:\\images");
        try{
            Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
                Logger.getLogger(AjouterMonumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        //Controle saisie sur les textfield
            if ((txtNomM.getText().isEmpty())
                    || txtDesc.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please, try to fill all text fields !!");
                alert.showAndWait();
                return;
            }
            
            
        
            Parent root;
            
            try {
                root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherMonument.fxml"));
                btnAddM.getScene().setRoot(root);
                
            } catch (IOException ex) {
                Logger.getLogger(AjouterMonumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        });
    }    

    @FXML
    private void uploadImage(ActionEvent event) {
         FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
            imgView.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AjouterMonumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        final GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(btnBrowse, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
    
}

    @FXML
    private void GoToHome(ActionEvent event) {
        Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/acceuilAM.fxml"));
                    btnHome.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AjouterMonumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
