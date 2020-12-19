/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Entities.Avis;
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
public class AvisService {
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public AvisService() {
        cnx=DataSource.getInstance().getConnexion();
    }
    
    public void insertAvis(Avis av,int iduser){
        String req="insert into avis (IdEvent,IdUser,DescriptionAvis) values ('"+av.getIdEvent()+"','"+iduser+"','"+av.getDescriptionAvis()+"')";
       
        try {
            ste= cnx.createStatement();
             ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    
    public List<Avis> readAll(){
        String req="select * from Avis";
        List<Avis> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new Avis(rs.getInt("IdAvis"),rs.getInt("IdEvent"),rs.getInt("IdUser"),rs.getString("DescriptionAvis")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
              return list;
       }
    public List<Avis> readByIdUser(int id_user){
        String req="select * from Avis where IdUser="+id_user;
        List<Avis> list= new ArrayList<>();
       try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new Avis(rs.getInt("IdAvis"),rs.getInt("IdEvent"),rs.getInt("IdUser"),rs.getString("DescriptionAvis")));
            }
             } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
              return list;
       }
    
    
    
    
    public void deleteAvis(Avis av){
        String req="delete from Avis where IdAvis='"+av.getIdAvis()+"'";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteAvisById(int id){
        String req="delete from avis where IdEvent="+id;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void updateAvis(Avis a){
        String req="update Avis set DescriptionAvis='"+a.getDescriptionAvis()+"' where IdAvis='"+a.getIdAvis()+"'";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AvisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
