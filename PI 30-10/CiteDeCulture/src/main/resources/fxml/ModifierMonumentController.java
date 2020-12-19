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
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierMonumentController implements Initializable {

    @FXML
    private TextField txtNm;
    @FXML
    private TextArea txtDsc;
    @FXML
    private ImageView imgVM;
    @FXML
    private Button impImg;
    @FXML
    private Button editM;
//    public static Monument an;
    final FileChooser fileChooser = new FileChooser();
    private String file_image;
    private Desktop desktop = Desktop.getDesktop();
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    private FileInputStream fis;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtNm.setText(AfficherMonumentController.an.getNomM());
        txtDsc.setText(AfficherMonumentController.an.getDescriptionM());
        File file = new File("C:\\images\\" + AfficherMonumentController.an.getImageM());
        Image image = new Image(file.toURI().toString());
        imgVM.setImage(image);
    }

    @FXML
    private void editMonument(ActionEvent event) {
        
        Monument m = new Monument(txtNm.getText(), txtDsc.getText(), file_image);
        MonumentServices ms = new MonumentServices();
        ms.updateM(AfficherMonumentController.an.getIdM(), m);
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherMonument.fxml"));
            editM.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ModifierMonumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // insertion img fi bd
        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
        pathto = FileSystems.getDefault().getPath("C:\\images" + Current_file.getName());
        Path targetDir = FileSystems.getDefault().getPath("C:\\images");
        try {
            Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(ModifierMonumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        

//Controle saisie sur les textfield
//        if ((txtNm.getText().isEmpty())
//                || txtDsc.getText().isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setContentText("Please, try to fill all text fields !!");
//            alert.showAndWait();
//            return;
//        }
        

    }

    @FXML
    private void importImage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
            imgVM.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModifierMonumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        final GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(impImg, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
    }

    @FXML
    private void GoToAffMon(ActionEvent event) {
        Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/afficherMonument.fxml"));
                    btnCancel.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(ModifierMonumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

}
