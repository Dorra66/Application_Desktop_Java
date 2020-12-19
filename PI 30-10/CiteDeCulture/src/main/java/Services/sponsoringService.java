/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.sponsoring;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Util.DataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dorra
 */
public class sponsoringService {
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
     public sponsoringService() {
        cnx=DataSource.getInstance().getConnexion();
     }
    
     
      public void inserts(sponsoring p ){
         
        String req="insert into sponsoring (id,date_contrat,description) values ('"
                +p.getId()+"','"+p.getDate_contrat()+"','"+p.getDescription()+"')";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(sponsoringService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
      
      
      
      
    public List<sponsoring> readAlls(){
        String req="select * from sponsoring";
        List<sponsoring> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new sponsoring( rs.getInt("id"),rs.getDate("date_contrat"), rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sponsoringService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   
    }
    
     public void deletePsts(int id){
        String req2="delete from sponsoring where id = ? ";
        
       
        try {
            pst=cnx.prepareStatement(req2);
            pst.setInt(1,id);
             pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sponsoringService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
    }
     
       public void updatePsts_date_contrat(Date date_contrat,int id){
        String req5="update sponsoring set date_contrat=? where id = ? ";
        
        
         
     
        try {
            pst=cnx.prepareStatement(req5);
            pst.setDate(1,date_contrat);
            pst.setInt(2,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sponsoringService.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
       public void updatePsts_description(String description,int id){
        String reqq="update sponsoring set description=? where id = ? ";
        
        
         
     
        try {
            pst=cnx.prepareStatement(reqq);
            pst.setString(1,description);
            pst.setInt(2,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sponsoringService.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
 
}
