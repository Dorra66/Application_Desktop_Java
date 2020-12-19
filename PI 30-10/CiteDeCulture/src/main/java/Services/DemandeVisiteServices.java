/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;
import Entities.demandeVisite;
import Util.DataSource;
import fxml.LoginController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author WSI
 */
public class DemandeVisiteServices {
    private Connection cnx;
    private Statement ste;
    private ResultSet rs;

    public DemandeVisiteServices() {
        cnx=DataSource.getInstance().getConnexion();
    }
    
    //Create Visit
    public void insertDV(demandeVisite dv){
        String req="insert into demandevisite (Source,nomOrganismeD,nomResponsableD,numTelD,mailD,addPostaleD,dateVisiteD,heureVisiteD,nbreVisiteursD,etatDV) values ('"+LoginController.PERSONNECONNECTEE.getPrenom()+"','"+dv.getNomOrganismeD()+"','"+dv.getNomResponsableD()+"','"+dv.getNumTelD()+"','"+dv.getMailD()+"','"+dv.getAddPostaleD()+"','"+dv.getDateVisiteD()+"','"+dv.getHeureVisiteD()+"','"+dv.getNbreVisiteursD()+"','"+"In progress"+"')";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DemandeVisiteServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Search visit
    public List<demandeVisite> searchDV(int idDV){
        String req="select * from demandevisite where idDV="+idDV;
        List<demandeVisite> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new demandeVisite(rs.getInt("idDV"),rs.getString("Source"), rs.getString("nomOrganismeD"), rs.getString("nomResponsableD"), rs.getInt("numTelD"), rs.getString("mailD"), rs.getString("addPostaleD"), rs.getDate("dateVisiteD"), rs.getString("heureVisiteD"), rs.getInt("nbreVisiteursD"), rs.getString("etatDV")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DemandeVisiteServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //Read visit
    public ObservableList<demandeVisite> readAllDV(){
        String req="select * from demandevisite where etatDV='In progress' ";
        ObservableList<demandeVisite> list = FXCollections.observableArrayList();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new demandeVisite(rs.getInt("idDV"),rs.getString("Source"), rs.getString("nomOrganismeD"), rs.getString("nomResponsableD"), rs.getInt("numTelD"), rs.getString("mailD"), rs.getString("addPostaleD"), rs.getDate("dateVisiteD"), rs.getString("heureVisiteD"), rs.getInt("nbreVisiteursD"), rs.getString("etatDV")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DemandeVisiteServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return list;
    }
    
    //Read confirmed visit
    public ObservableList<demandeVisite> readAllCDV(){
        String req="select * from demandevisite where etatDV='Confirmed'";
        ObservableList<demandeVisite> list= FXCollections.observableArrayList();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new demandeVisite(rs.getInt("idDV"),rs.getString("Source"), rs.getString("nomOrganismeD"), rs.getString("nomResponsableD"), rs.getInt("numTelD"), rs.getString("mailD"), rs.getString("addPostaleD"), rs.getDate("dateVisiteD"), rs.getString("heureVisiteD"), rs.getInt("nbreVisiteursD"), rs.getString("etatDV")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DemandeVisiteServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return list;
    }
    
    //Update visit
    public void updateDV(int idDV,demandeVisite dv){
            String req="UPDATE demandevisite SET Source='"+dv.getSource()+"',nomOrganismeD='"+dv.getNomOrganismeD()+"', nomResponsableD='"+dv.getNomResponsableD()+"', numTelD='"+dv.getNumTelD()+"', mailD='"+dv.getMailD()+"', addPostaleD='"+dv.getAddPostaleD()+"', dateVisiteD='"+dv.getDateVisiteD()+"', heureVisiteD='"+dv.getHeureVisiteD()+"', nbreVisiteursD='"+dv.getNbreVisiteursD()+"' WHERE idDV="+idDV;        
            try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DemandeVisiteServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Reply to visit request
    public void replyDV(int idDV,String etatDV){
            String req="UPDATE demandevisite SET etatDV='"+etatDV+"' WHERE idDV="+idDV;        
            try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DemandeVisiteServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Delete visit
    public void deleteDV(int idDV){
        String req="delete from demandevisite where idDV="+idDV;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DemandeVisiteServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Read visit
    public ObservableList<demandeVisite> readAllDVC(String nom){
        String req="select * from demandevisite where Source='"+nom+"'";
        ObservableList<demandeVisite> list = FXCollections.observableArrayList();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new demandeVisite(rs.getInt("idDV"),rs.getString("Source"), rs.getString("nomOrganismeD"), rs.getString("nomResponsableD"), rs.getInt("numTelD"), rs.getString("mailD"), rs.getString("addPostaleD"), rs.getDate("dateVisiteD"), rs.getString("heureVisiteD"), rs.getInt("nbreVisiteursD"), rs.getString("etatDV")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DemandeVisiteServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return list;
    }
    
    
    
}


