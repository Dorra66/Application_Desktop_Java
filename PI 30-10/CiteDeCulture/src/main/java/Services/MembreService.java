/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Membre;
import Entities.Issue;
import fxml.MembreupdateController;
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
public class MembreService {

    private Connection cnx;
    private Statement ste;
    private ResultSet rs;

    public MembreService() {
        cnx = DataSource.getInstance().getConnexion();
    }

    public void addMembre(Membre m) {
        String req = "insert into membre (nameMembre,lastnameMembre,cinMembre,mobileMembre,mailMembre,adressMembre,SubscriptionMembre) values ('" + m.getNameMembre() + "','" + m.getLastnameMembre() + "','" + m.getCinMembre() + "','" + m.getMobileMembre() + "','" + m.getMailMembre() + "','" + m.getAdressMembre() + "','" + m.getSubscriptionMembre() + "')";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Succes");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
                System.out.println(" Membre added :) !");
    }

    public void updateMembre(Membre m) {
        String req = "update membre set nameMembre='" + m.getNameMembre() + "',lastnameMembre='" + m.getLastnameMembre() + "',cinMembre='" +  m.getCinMembre()  + "',mobileMembre='" +  m.getMobileMembre() + "',mailMembre='" +  m.getMailMembre() + "',adressMembre='" + m.getAdressMembre() + "',SubscriptionMembre='" + m.getSubscriptionMembre() + "' where idMembre=" + MembreupdateController.cm.getIdMembre();
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Succes");
            System.out.println(MembreupdateController.cm.getIdMembre());
            alert.showAndWait();
            
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMembre(int idMembre) {

        String req = "delete from membre where idMembre=" + idMembre;
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Succes");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Membre> readALL() {
        String req = "select * from membre";
        List<Membre> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Membre(rs.getInt("idMembre"), rs.getString("nameMembre"), rs.getString("lastnameMembre"), rs.getInt("cinMembre"), rs.getInt("mobileMembre"), rs.getString("mailMembre"), rs.getString("adressMembre"), rs.getString("SubscriptionMembre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Membre> searchMembre(int idMembre) {
        String req = "select * from membre where id=" + idMembre;
        List<Membre> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Membre(rs.getInt("idMembre"), rs.getString("nameMembre"), rs.getString("lastnameMembre"), rs.getInt("cinMembre"), rs.getInt("mobileMembre"), rs.getString("mailMembre"), rs.getString("adressMembre"), rs.getString("SubscriptionMembre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
       
                    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                FINDBY CIN                       /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Membre> findbyCin(int cinMembre) {
        String req = "select * from membre where cinMembre=" + cinMembre;
        List<Membre> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Membre(rs.getInt("idMembre"), rs.getString("nameMembre"), rs.getString("lastnameMembre"), rs.getInt("cinMembre"), rs.getInt("mobileMembre"), rs.getString("mailMembre"), rs.getString("adressMembre"), rs.getString("SubscriptionMembre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////                READ ALL    OBSERVABLE                    /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ObservableList<Membre> readALL2() {
        String req = "select * from membre";
        ObservableList<Membre> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
               list.add(new Membre(rs.getInt("idMembre"), rs.getString("nameMembre"), rs.getString("lastnameMembre"), rs.getInt("cinMembre"), rs.getInt("mobileMembre"), rs.getString("mailMembre"), rs.getString("adressMembre"), rs.getString("SubscriptionMembre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
}
