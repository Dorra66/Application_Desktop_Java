/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Book;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Services.BookService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class BookupdateController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnUpdate;
    @FXML
    public  TableView<Book> BookTable;
    @FXML
    private TableColumn<Book, String> colTitle;
    @FXML
    private TableColumn<Book, String> colAuthor;
    @FXML
    private TableColumn<Book, String> colType;
    @FXML
    private TableColumn<Book, String> colDate;
    @FXML
    private TableColumn<Book, String> colImage;
    @FXML
    private TableColumn<Book, Boolean> colAvail;
    @FXML
    private TextField TitleInput;
    BookService bs = new BookService();
    public static Book os ;
    @FXML
    private ImageView txtBookImage;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initCol();
        showBookData();
        setSelectedRow();        
        listenBookData();
    }
    
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                INIT                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            private void initCol() {
        colTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("bookTitle"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("bookAuthor"));
        colType.setCellValueFactory(new PropertyValueFactory<Book, String>("bookType"));
        colDate.setCellValueFactory(new PropertyValueFactory<Book, String>("bookAddDate"));
        colImage.setCellValueFactory(new PropertyValueFactory<Book, String>("bookImage"));
        colAvail.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("bookAvail"));
    }
            
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                SHOW BD                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            
    @FXML
        private void showBookData() {
        BookService bs = new BookService();
        ArrayList<Book> books = (ArrayList<Book>) bs.readALL();
        ObservableList<Book> obs = FXCollections.observableArrayList(books);
        BookTable.setItems(obs);
    }  
           
    
    
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->Form                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
        @FXML
    private void toBookUpdateForm(ActionEvent event) {
        loadWindow("bookupdateform.fxml","Update your book");
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
    ///////////////////////////                Search BOOK                      /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
    @FXML
    private void searchBook(KeyEvent event) {
        BookService bs = new BookService();
        ArrayList<Book> books = (ArrayList<Book>) bs.findbyTitle(TitleInput.getText());
        ObservableList<Book> obs = FXCollections.observableArrayList(books);
        BookTable.setItems(obs);
    }

           //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                BACK HOME     <- ---                   /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*  private void backHome(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/home.fxml"));
            btnBack.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(BookupdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
               //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                SELECT IMAGE FROM TABLE VIEW                /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     private void setSelectedRow() {
        BookTable.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            Book b = BookTable.getItems().get(BookTable.getSelectionModel().getSelectedIndex());
            String var = BookTable.getSelectionModel().getSelectedItem().getBookImage();
            File file = new File("C:\\images\\" + var);
            Image x = new Image(file.toURI().toString());
            txtBookImage.setImage(x);
        });
    }
     
     
         
               //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                Listen TO BOOK DATA            /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          private void listenBookData() {
        BookService bs = new BookService();
        ObservableList<Book> books = bs.readALL2();
        BookTable.setItems(books);
        BookTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        BookTable.getSelectionModel().selectedItemProperty().addListener((var, oldSelection, newSelection) -> {
            System.out.println(books);
            System.out.println(newSelection);
            if (newSelection != null) {
                os = newSelection;
            }
             }); 
            }

    @FXML
    private void BackHome10(ActionEvent event) {
                try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/homelib.fxml"));
            btnBack.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(BookupdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
