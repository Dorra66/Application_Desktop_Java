/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Book;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Services.BookService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class BookformController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtAuthor;
    @FXML
    private TextField txtType;
    @FXML
    private DatePicker txtDate;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    @FXML
    private ImageView BookImage;
    @FXML
    private Button btnImport;
    @FXML
    private TextField txtBookImage;
    
    
    private String file_image;
    private File Current_file;
    private FileInputStream fis;
    private Path pathfrom;
    private Path pathto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                Save BOOK                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
     @FXML
    private void saveBook(ActionEvent event) {
        BookService bs = new BookService();
        LocalDate value = txtDate.getValue();
        String addDate = value.toString();

        if (txtTitle.getText().isEmpty() || txtAuthor.getText().isEmpty() || txtType.getText().isEmpty() || txtDate.isDisable() || BookImage.isDisabled()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Vérifier Vos champs !");
            alert.showAndWait();
            return;
        }
        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
        pathto = FileSystems.getDefault().getPath("C:\\images\\" + Current_file.getName());
        Path targetDir = FileSystems.getDefault().getPath("C:\\images");
        Book b = new Book(txtTitle.getText(), txtAuthor.getText(), txtType.getText(), addDate, file_image);
        try {
            Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
            bs.addBook(b);
        } catch (IOException ex) {
            Logger.getLogger(fxml.BookformController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                IMPORT BOOK                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void importBook(ActionEvent event) {
        FileChooser fc = new FileChooser();
        Current_file = fc.showOpenDialog(null);
        if (Current_file != null) {
            Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
            BookImage.setImage(images);
            try {
                fis = new FileInputStream(Current_file);
                file_image = Current_file.getName();
                txtBookImage.setText(file_image);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(fxml.BookformController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
