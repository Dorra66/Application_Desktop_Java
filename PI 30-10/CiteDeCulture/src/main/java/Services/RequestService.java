/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Request;
import fxml.AllrequestsController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import Util.DataSource;

/**
 *
 * @author LENOVO
 */
public class RequestService {
    
        
    private Connection cnx;
    private Statement ste;
    private ResultSet rs;
    
    
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                CONNEXION                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public RequestService() {
        cnx = DataSource.getInstance().getConnexion();
    }
    
    
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                ADD REQUEST                         /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    public void addRequest(Request r) {
        String req = "insert into request (booktitle,membrename,membrelastname,membremail) values ('" + r.getBookTitle() + "','" + r.getMembreName() + "','" + r.getMembreLastName()+ "','" + r.getMembreMail()+"')";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Succes");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" Request added :) !");
    }
    
                        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                READ ALL                        /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Request> readALL() {
         String req = "select * from request";
        List<Request> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Request(rs.getInt("idrequest"),rs.getString("booktitle"), rs.getString("membrename"), rs.getString("membrelastname"),rs.getString("membremail")));   //rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
                        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                FIND BY STATUS                        /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<Request> findbyTitle(String status) {
      String req = "select * from book where STATUS like '" + status + "'";
        List<Request> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Request(rs.getInt("idrequest"), rs.getString("booktitle"), rs.getString("membrename"), rs.getString("membrelastname"), rs.getString("membremail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                READ ALL    OBSERVABLE                    /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ObservableList<Request> readALL2() {
        String req = "select * from request";
        ObservableList<Request> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                 list.add(new Request(rs.getInt("idrequest"), rs.getString("booktitle"), rs.getString("membrename"), rs.getString("membrelastname"), rs.getString("membremail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    public void deleteRequest() {
        String req = "delete from request where idrequest=" + AllrequestsController.res.getIdRequest();
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
}
