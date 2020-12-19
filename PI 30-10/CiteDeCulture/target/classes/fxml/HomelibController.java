/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Entities.Book;
import Entities.Membre;
import Entities.Issue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import Services.BookService;
import Services.IssueService;
import Services.MembreService;
import Util.DataSource;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class HomelibController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private Button btnData;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnExit;
    @FXML
    private TextField bookTitleInput;
    @FXML
    private TextField bookTitleInput2;
    @FXML
    private Text txtAuthor;
    @FXML
    private Text txtType;
    @FXML
    private Text txtAvail;
    @FXML
    private Pane bookInfo;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnAddMembre;
    @FXML
    private Button btnUpdateMembre;
    @FXML
    private Button btnDataMembre;
    @FXML
    private Text txtName;
    @FXML
    private Text txtMobile;
    @FXML
    private Text txtMail;
    @FXML
    private TextField CinInput;
    @FXML
    private Button btnIssue;

    private Connection cnx;
    private Statement ste;
    private ResultSet rs;
    private ResultSet rs1;
    @FXML
    private ListView<String> IssueDataList;
    
    
    Boolean isReadyForSubmission= false;
    @FXML
    private Button btnRenew;
    @FXML
    private Button btnSubmission;
    @FXML
    private Button btnAllRequests;


    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      /////////////////////////                      BOOOOOOKS TOOOOLS                            ////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->  BOOK FORM                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
        @FXML
    private void toBookForm(ActionEvent event) {
        loadWindow("/fxml/bookform.fxml","Add new Book");
    }
    
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->  UPDATE BOOK                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @FXML
    private void toUpdateBook(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/bookupdate.fxml"));
            btnUpdate.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(HomelibController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->  BOOK DATA                     /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void allBooks(ActionEvent event) {
        loadWindow("/fxml/bookdata.fxml","ALL BOOKS");
    }
    
    
                        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                LOAD BOOK INFORMATION                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
               
    @FXML
    private void loadLivreInfo(ActionEvent event) {
       BookService bs = new BookService();
       List<Book> list = new ArrayList<>();
       list = bs.findbyTitle(bookTitleInput.getText());
       if(list.isEmpty()){
       txtAuthor.setText("No Such Book !");  
       txtType.setText("");
       txtAvail.setText("");
       return ;
       }
       txtAuthor.setText(list.get(0).getBookAuthor());
       txtType.setText(list.get(0).getBookType());
       String Avail = String.valueOf(list.get(0).getBookAvail());
       txtAvail.setText(Avail);
       }
    
    
    
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      /////////////////////////                      MEMBRS TOOOOLS                            ////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->  MEMBER FORM                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
        @FXML
    private void toMembreForm(ActionEvent event) {
        loadWindow("/fxml/membreaddform.fxml","Add new Membre");
    }
    
    
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->  MEMBRE UPDATE                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @FXML
    private void toUpdateMembre(ActionEvent event) {
               try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/membreupdate.fxml"));
            btnUpdate.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(HomelibController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->  MEMBRE DATA                        /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void allMembrs(ActionEvent event) {
        loadWindow("/fxml/membredata.fxml","ALL Membrs");
    }
    
    
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                LOAD MEMBRE INFORMATION                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
        @FXML       
    private void loadMembreInfo(ActionEvent event) {
       MembreService ms = new MembreService();
       List<Membre> list = new ArrayList<>();
       int cin=Integer.parseInt(CinInput.getText());
       list = ms.findbyCin(cin);
       if(list.isEmpty()){
       txtName.setText("No Membre !");  
       txtMobile.setText("");
       txtMail.setText("");
       return ;
       }
       txtName.setText(list.get(0).getNameMembre());
       String mobile =Integer.toString(list.get(0).getMobileMembre());
       txtMobile.setText(mobile);
       txtMail.setText(list.get(0).getMailMembre());
       }
    
    
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                --->  ALL REQUESTS                      /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void allRequests(ActionEvent event) {
        loadWindow("/fxml/allrequests.fxml","ALL Requests");
    }
    
    
    

           //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////              EXIT                      /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /* @FXML
    private void exitLib(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }*/
    
        @FXML
    private void exitLib(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/accgeneral.fxml"));
            btnExit.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(HomelibController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    ///////////////////////////               LOAD ISSUE     +              /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    @FXML
    private void loadIssueOperation(ActionEvent event) {
        
      
        if (bookTitleInput.getText().isEmpty() || CinInput.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(" PLEASE CHECK THE BOOK OR THE MEMBRE !");
            alert.showAndWait();
            return;
        }

        String Avail = txtAvail.getText();
        if (Avail.equalsIgnoreCase("false")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(" THIS BOOK IS NOT AVAILABLE SOORY  !");
            alert.showAndWait();
            return;
        }
        
            int memberCin = Integer.parseInt(CinInput.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Issue Operation ");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure want to issue the book to " + txtName.getText());
            System.out.println(txtAvail);
            Optional<ButtonType> response = alert.showAndWait();
            if (response.get() == ButtonType.OK) {
                MembreService ms = new MembreService();
                IssueService is = new IssueService();
                BookService bs = new BookService();
                int idMembre = ms.findbyCin(memberCin).get(0).getIdMembre();
                int idBook = bs.findbyTitle1(bookTitleInput.getText()).get(0).getBookId();
                String bookTitle= bs.findbyTitle1(bookTitleInput.getText()).get(0).getBookTitle();
               is.createIssue(idBook,bookTitle,idMembre);
            }
    }
    
        
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                CONNEXION                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public HomelibController() {
        cnx = DataSource.getInstance().getConnexion();
    }
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////              LOAD BOOK INFO 2 + ...              /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

    @FXML
    private void loadBookInfo2(ActionEvent event) {
        ObservableList<String> issueData = FXCollections.observableArrayList();
        String bookTitle = bookTitleInput2.getText();
        isReadyForSubmission = false ;
        String req = "select * from issue where bookTitle like '" + bookTitle + "'";
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                issueData.add("**ISSUE Information**");
                int MembreId = rs.getInt("idmembre");
                Timestamp IssueTime = rs.getTimestamp("issuetime");
                int RenewCount = rs.getInt("renewcount");
                issueData.add("Issue Date and time :" + IssueTime.toString());
                issueData.add("renew Count :" + RenewCount);
                String req2 = "select * from book where bookTitle like '" + bookTitle + "'";
                ste = cnx.createStatement();
                rs1 = ste.executeQuery(req2);
                issueData.add("**BOOK Information**");
                while (rs1.next()) {
                    issueData.add("Book Type :" + rs1.getString("bookType"));
                    issueData.add("Book Add Date :" + rs1.getString("bookAddDate"));
                }
                String req3 = "select * from membre where idMembre like '" + MembreId + "'";
                ste = cnx.createStatement();
                rs1 = ste.executeQuery(req3);
                issueData.add("**MEMBRE Information**");
                while (rs1.next()) {
                    issueData.add("Name :" + rs1.getString("nameMembre"));
                    issueData.add("Lastname :" + rs1.getString("lastnameMembre"));
                }
                isReadyForSubmission = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomelibController.class.getName()).log(Level.SEVERE, null, ex);
        }
        IssueDataList.getItems().setAll(issueData);
    }


    
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                SUBMISSION OPERATION                      /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void submissionOp(ActionEvent event) {
        if (!isReadyForSubmission) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(" PLEASE SELECT A BOOK TO SUBMIT!");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Issue Operation ");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure want to return the book ?");
        Optional<ButtonType> response = alert.showAndWait();
        if (response.get() == ButtonType.OK) {
            String bookTitle = bookTitleInput2.getText();
            String req = "DELETE FROM ISSUE WHERE booktitle  like '" + bookTitle + "'";
            String req2 = "update book set bookAvail = TRUE where bookTitle like '" + bookTitle + "'";

            execAction(req);
            execAction(req2);
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setContentText(" BOOK HAS BEEN SUBMITTED :) !");
            alert1.showAndWait();
        }
    }
           
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                UPDATE AND DELETE QUERRY NEED                    /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            public boolean execAction(String qu) {
        try {
            ste = cnx.createStatement();
            ste.execute(qu);
            return true;
        }
        catch (SQLException ex) {
              Logger.getLogger(HomelibController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally {
        }
    }
            
                     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                UPDATE AND DELETE QUERRY NEED                    /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void renewOp(ActionEvent event) {
        /*
           if (!isReadyForSubmission) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(" PLEASE SELECT A BOOK TO SUBMIT!");
            alert.showAndWait();
            return;
        }*/
       String bookTitle = bookTitleInput2.getText();
       String req = "update issue set renewcount= renewcount + 1  where bookTitle like '" + bookTitle + "'";
       execAction(req);
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setContentText(" BOOK HAS BEEN Renewed :) !");
            alert1.showAndWait();
    }
      
}
