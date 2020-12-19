/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

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

/**
 *
 * @author ASUS
 */
public class SalleService {
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public SalleService() {
        cnx=DataSource.getInstance().getConnexion();
    }
    
    public void insert(Salle s){
        String req="insert into Salle(Libelle,Capacite,CategorieSalle) values ('"+s.getLibelle()+"','"+s.getCapacite()+"','"+s.getCategorieSalle()+"')";
       
        try {
            ste= cnx.createStatement();
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SalleService.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    
    public List<Salle> readAll(){
        String req="select * from Salle";
        List<Salle> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new Salle(rs.getInt("IdSalle"),rs.getString("Libelle"),rs.getInt("Capacite"),rs.getString("CategorieSalle")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(SalleService.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
         
        return list;
       }
    
    public List<Salle> readId(int idsalle){
        String req="select * from Salle where IdSalle="+idsalle;
        List<Salle> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new Salle(rs.getInt("IdSalle"),rs.getString("Libelle"),rs.getInt("Capacite"),rs.getString("CategorieSalle")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(SalleService.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
         return list;
    }
    
    
    
    public void deleteSalle(int id){
        String req="delete from salle where IdSalle="+id;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SalleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void updateSalle(Salle s,int id){
        String req="update salle set Libelle='"+s.getLibelle()+"',Capacite='"+s.getCapacite()+"',CategorieSalle='"+s.getCategorieSalle()+"' where IdSalle="+id;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(SalleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
