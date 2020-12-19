/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
 
import Entities.publicités;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Util.DataSource;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author dorra
 */
public class publicitésService {
    private static publicitésService instance;
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public publicitésService() {
        cnx=DataSource.getInstance().getConnexion();
    }
    public static publicitésService getInstance(){
        if(instance==null) 
            instance=new publicitésService();
        return instance;
    }
 
     public void insertp(publicités p){
         
        String reqa="insert into publicités(id,titre,description,imag) values ('"+p.getId()+"','"+p.getTitre()+"','"+p.getDescription()+"','"+p.getImag()+"')";
       
        try {
            ste=cnx.createStatement();
             ste.executeUpdate(reqa);
        } catch (SQLException ex) {
            Logger.getLogger(publicitésService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
       
       
    }
     
    public List<publicités> readAllp(){
        String req="select * from publicités";
        List<publicités> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               
                list.add(new publicités(rs.getInt("id"), rs.getString("titre"), rs.getString("description"), rs.getString("imag")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(publicitésService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   
    }
    
   public void deletePstp(int id){
        String req2="delete from publicités where id = ? " ;
       try {
             pst=cnx.prepareStatement(req2);
            pst.setInt(1,id);
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(publicitésService.class.getTypeName()).log(Level.SEVERE, null, ex);
        }
   }
       
  
     
      public void updatePstp_titre(String titre,int id ){
        String req4="update publicités set titre=? where id = ? ";
        
        
         
        try {
            pst=cnx.prepareStatement(req4);
            pst.setString(1,titre);
            pst.setInt(2,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(publicitésService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
   
     }
      
      public void updatePstp_description(String description,int id ){
        String req4="update publicités set description=? where id = ? ";
        
        
         
        try {
            pst=cnx.prepareStatement(req4);
            pst.setString(1,description);
            pst.setInt(2,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(publicitésService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
   
     }
 
      
       public void updatePstp_imag(String imag,int id ){
        String req="update publicités set imag=? where id = ? ";
        
        
         try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,imag);
            pst.setInt(2,id);
            pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(publicitésService.class.getName()).log(Level.SEVERE, null, ex);
         }
   
     }
       
       //////////////statistiques///////////////
     public List<String> displayAllbyType(List<Integer> nbr) {
        String req="select titre , count(*) as count from publicités group by titre ";
       List<String> list=new ArrayList();
        
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               list.add(rs.getString("titre"));
               nbr.add(rs.getInt("count"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(publicitésService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
      
} 


