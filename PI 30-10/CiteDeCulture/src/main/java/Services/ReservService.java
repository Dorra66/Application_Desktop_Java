/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Entities.DemandeReserv;
import Entities.Event;
import Entities.Salle;
import Util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class ReservService {
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public ReservService() {
        cnx=DataSource.getInstance().getConnexion();
    }
    
    public void insert(DemandeReserv d){
        String req="insert into reservevent(NomOrg,PrenomOrg,TelOrg,MailOrg,Categoriereserv,NomReserv,NbrPlace,DateReserv,Heure,Affiche) values ('"+d.getNomOrg()+"','"+d.getPrenomOrg()+"','"+d.getTelOrg()+"','"+d.getMailOrg()+"','"+d.getCategorieReserv()+"','"+d.getNomReserv()+"','"+d.getNbrPlace()+"','"+d.getDateReserv()+"','"+d.getHeure()+"','"+d.getAffiche()+"')";
       
        try {
            ste= cnx.createStatement();
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReservService.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    
    public List<DemandeReserv> readAll(){
        String req="select * from reservevent";
        List<DemandeReserv> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new DemandeReserv(rs.getInt("IdReserv"),rs.getString("NomOrg"),rs.getString("PrenomOrg"),rs.getInt("TelOrg"),rs.getString("MailOrg"),rs.getString("CategorieReserv"),rs.getString("NomReserv"),rs.getInt("NbrPlace"),rs.getDate("DateReserv"),rs.getString("Heure"),rs.getString("Affiche"),rs.getString("Etat")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(ReservService.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
        return list;
       }
    
    public List<DemandeReserv> readById(DemandeReserv d){
        String req="select * from reservevent where IdReserv='"+d.getIdReserv()+"'";
        List<DemandeReserv> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new DemandeReserv(rs.getInt("IdReserv"),rs.getString("NomOrg"),rs.getString("PrenomOrg"),rs.getInt("TelOrg"),rs.getString("MailOrg"),rs.getString("CategorieReserv"),rs.getString("NomReserv"),rs.getInt("NbrPlace"),rs.getDate("DateReserv"),rs.getString("Heure"),rs.getString("Affiche"),rs.getString("Etat")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(ReservService.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
        return list;
       }
    
    
    
    public void deleteReserv(DemandeReserv d){
        String req="delete from reservevent where IdReserv='"+d.getIdReserv()+"'";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReservService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateReserv(DemandeReserv d){
        String req="update reservevent set NomOrg='"+d.getNomOrg()+"',PrenomOrg='"+d.getPrenomOrg()+"',TelOrg='"+d.getTelOrg()+"',MailOrg='"+d.getMailOrg()+"', CategorieReserv='"+d.getCategorieReserv()+"',NomReserv='"+d.getNomReserv()+"',NbrPlace='"+d.getNbrPlace()+"',DateReserv='"+d.getDateReserv()+"',HeureDeb='"+d.getHeure()+"',Affiche='"+d.getAffiche()+"',Etat='"+d.getEtat()+"' where IdReserv='"+d.getIdReserv()+"'";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReservService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateEtatReserv(DemandeReserv d, String etat){
        String req="update reservevent set Etat='"+etat+"' where IdReserv='"+d.getIdReserv()+"'";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReservService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
  
}
