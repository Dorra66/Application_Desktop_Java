/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.AnnonceProd;
import Entities.Commande;
import Entities.Panier;
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
import Util.DataSource;

/**
 *
 * @author emna
 */
public class AnnonceProdService {
    private final Connection cnx;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement ste;
    
    public AnnonceProdService() {
        cnx=DataSource.getInstance().getConnexion();
    }
    
    public void insertPst(AnnonceProd a){
        String req = "insert into annonce_prod (nom_prod,description,stock,prix,image) values (?,?,?,?,?)";
        
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,a.getNom_prod());
            pst.setString(2,a.getDescription());
            pst.setInt(3,a.getStock());
            pst.setInt (4,a.getPrix());
            pst.setString(5,a.getImage());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceProdService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<AnnonceProd> readAll(){
        String req="select * from annonce_prod";
        List<AnnonceProd> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               list.add(new AnnonceProd(rs.getInt("id_prod"),rs.getString("nom_prod"), rs.getString("description"),rs.getInt("stock"),rs.getInt("prix"),rs.getString("image")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceProdService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   
        
} 
  public List<AnnonceProd> recherche(String mot){
        String req="select * from annonce_prod where nom_prod LIKE '%" + mot + "%' OR  description LIKE '%" + mot + "%'";
        List<AnnonceProd> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               list.add(new AnnonceProd(rs.getInt("id_prod"),rs.getString("nom_prod"), rs.getString("description"),rs.getInt("stock"),rs.getInt("prix"),rs.getString("image")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceProdService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   
        
} 
    public void deletePst(int id_prod){
        String req2="delete from annonce_prod where id_prod = ? ";
        
        try {
            pst=cnx.prepareStatement(req2);
            pst.setInt(1,id_prod);
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceProd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateePst(String nom_prod,String description,int stock,int prix,String image , int id_prod  ){
        String req="update annonce_prod set nom_prod =? , description=? ,stock=?  , prix=? ,image=?   where id_prod=?";
        
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,nom_prod);
            pst.setString(2,description);
            pst.setInt(3,stock);
            pst.setInt(4,prix);
            pst.setString(5,image);
            pst.setInt(6,id_prod);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceProdService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    public AnnonceProd readByid(int id_prod){
        AnnonceProd p = new AnnonceProd();
                   try {
            
            String req= "select * from annonce_prod where id_prod = "+id_prod+"";
                        ste=cnx.createStatement();
                         rs=ste.executeQuery(req);            
            while (rs.next()) {  
                p.setId_prod(rs.getInt("id_prod"));
                p.setNom(rs.getString("nom_prod"));
                p.setDescription(rs.getString("description"));
                p.setStock(rs.getInt("stock"));
                p.setPrix(rs.getInt ("prix"));
                 p.setImage(rs.getString("image"));
            }
        } catch (SQLException ex) { 
            Logger.getLogger(AnnonceProdService.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         return p;
   
}
    
    
    } 
