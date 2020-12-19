/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Book;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Services.BookService;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class BookdataController implements Initializable {
    @FXML
    private TableView<Book> BookTable;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initCol();
        showBookData();
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

            
        private void showBookData() {
        BookService bs = new BookService();
        ArrayList<Book> books = (ArrayList<Book>) bs.readALL();
        ObservableList<Book> obs = FXCollections.observableArrayList(books);
        BookTable.setItems(obs);
    }  
}
