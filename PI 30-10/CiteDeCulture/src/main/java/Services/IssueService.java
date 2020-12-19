/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.Issue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import Util.DataSource;

/**
 *
 * @author LENOVO
 */
public class IssueService {
    
       private Connection cnx;
    private Statement ste;
    private ResultSet rs;

    public IssueService() {
        cnx = DataSource.getInstance().getConnexion();
    }
    
                                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////   CREATE ISSSUE              /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    public void createIssue(int idBook , String bookTitle, int IdMembre){
        String req =  "INSERT INTO issue (bookId,bookTitle,Idmembre)  VALUES ('" + idBook + "','" + bookTitle + "','" + IdMembre + "')";
        String req2 = "UPDATE book SET bookAvail = false WHERE bookId = '" + idBook + "'";
      try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
            ste.executeUpdate(req2);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Book Issue Complete");
            alert.showAndWait();
            
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
