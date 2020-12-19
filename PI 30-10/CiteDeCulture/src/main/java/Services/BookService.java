
package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import Util.DataSource;
import Entities.Book;
import fxml.BookupdateController;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookService {
    
    
    private Connection cnx;
    private Statement ste;
    private ResultSet rs;
    
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                CONNEXION                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public BookService() {
        cnx = DataSource.getInstance().getConnexion();
    }
    
    
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                Add BOOK                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    public void addBook(Book b) {
        String req = "insert into book (bookTitle,bookAuthor,bookType,bookAddDate,bookImage) values ('" + b.getBookTitle() + "','" + b.getBookAuthor() + "','" + b.getBookType() + "','" + b.getBookAddDate() + "','" + b.getBookImage() + "')";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Succes");
            alert.showAndWait();
            b.setBookAvail(Boolean.TRUE);
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" Book added :) !");
    }
    
    
        

    
         //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                UPDATE BOOK                    /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void updateBook(Book b) {
        String req = "update book set bookTitle='" + b.getBookTitle() + "',bookAuthor='" + b.getBookAuthor() + "',bookType='" + b.getBookType() + "',bookAddDate='" + b.getBookAddDate() + "',bookImage='" + b.getBookImage() +"' where bookId =" +BookupdateController.os.getBookId(); 
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Succés");
            alert.showAndWait();
        } catch (SQLException ex) {
            System.err.println("Erreur de la modification !");
        }
    }
    
    
    
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                DELETE BOOK                        /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void deleteBook(Book b) {
        String req = "delete from book where bookTitle=" + b.getBookId();
        try {
            ste = cnx.prepareStatement(req);
            ste.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Succes");
            alert.showAndWait();
            System.out.println("Delete Done :) ");
        } catch (SQLException ex) {
            System.err.println("Delete failed :(");
        }
    }
    
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                READ ALL                        /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Book> readALL() {
        String req = "select * from book";
        List<Book> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Book(rs.getInt("bookId"), rs.getString("bookTitle"), rs.getString("bookAuthor"), rs.getString("bookType"), rs.getString("bookAddDate"), rs.getString("bookImage"), rs.getBoolean("bookAvail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
                        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                READ ALL BY AVAIL                   /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Book> readALLbyavail() {
      //  String req = "select * from book where bookAvail ='"+true+"'"; ( ( "Fievre" = True )
      String req = "select * from book where bookAvail= 1";
        List<Book> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Book(rs.getInt("bookId"), rs.getString("bookTitle"), rs.getString("bookAuthor"), rs.getString("bookType"), rs.getString("bookAddDate"), rs.getString("bookImage"), rs.getBoolean("bookAvail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                FIND BY TITLE                          /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Book> findbyTitle(String bookTitle) {
      String req = "select * from book where bookTitle like '" + bookTitle.concat("%") + "'";
        List<Book> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Book(rs.getInt("bookId"), rs.getString("bookTitle"), rs.getString("bookAuthor"), rs.getString("bookType"), rs.getString("bookAddDate"), rs.getString("bookImage"), rs.getBoolean("bookAvail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                FINDBY ID                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Book> findbyId(int bookId) {
        String req = "select * from book where bookId=" + bookId;
        List<Book> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Book(rs.getInt("bookId"), rs.getString("bookTitle"), rs.getString("bookAuthor"), rs.getString("bookType"), rs.getString("bookAddDate"), rs.getString("bookImage"), rs.getBoolean("bookAvail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
       //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////               FIND  BOOK INFO    ***** DELETE AFTER §§§§§§§§!!!!!                    /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public List<Book> findBookInfo(String titre) {
        String req = "select * from livre where titre like '" + titre + "'";
        List<Book> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Book(rs.getInt("bookId"), rs.getString("bookTitle"), rs.getString("bookAuthor"), rs.getString("bookType"), rs.getString("bookAddDate"), rs.getString("bookImage"), rs.getBoolean("bookAvail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
                        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                READ ALL    OBSERVABLE                    /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ObservableList<Book> readALL2() {
        String req = "select * from book";
        ObservableList<Book> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Book(rs.getInt("bookId"), rs.getString("bookTitle"), rs.getString("bookAuthor"), rs.getString("bookType"), rs.getString("bookAddDate"), rs.getString("bookImage"), rs.getBoolean("bookAvail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Book> findbyTitle1(String title) {
        String req = "select * from book where bookTitle like '" + title + "'";
        List<Book> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Book(rs.getInt("bookId"), rs.getString("bookTitle"), rs.getString("bookAuthor"), rs.getString("bookType"), rs.getString("bookAddDate"), rs.getString("bookImage"), rs.getBoolean("bookAvail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
