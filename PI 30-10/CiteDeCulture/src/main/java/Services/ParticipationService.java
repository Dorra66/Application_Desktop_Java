/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Event;
import Entities.Participation;
import Entities.personne;
import Util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author ASUS
 */
public class ParticipationService {
    
    private Connection cnx;
    private Statement ste;
    private ResultSet rs;
    
    
    public ParticipationService() {
        cnx=DataSource.getInstance().getConnexion();
        
    }
    
    public void insertParticip(Participation p){
        
        
        String req="insert into participation (IdEvent,IdUser) values ('"+p.getIdEvent()+"','"+p.getIdUser()+"')";
       String req1="update event set NbrPlaceDispo=NbrPlaceDispo-1 where IdEvent='"+p.getIdEvent()+"'";
       
        try {
            ste= cnx.createStatement();
            ste.executeUpdate(req);
            ste.executeUpdate(req1);
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    
    public void deleteParticipation(int id){
        String req2= "delete  from participation where IdEvent ="+id;
        try {
   
   
          ste= cnx.createStatement();
            ste.executeUpdate(req2);
            
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
    
    public void deleteParticipationByEvent(Event e){
        String req2= "delete  from participation where IdEvent ='"+e.getIdEvent()+"'";
        String req1="update event set NbrPlaceDispo=NbrPlaceDispo+1 where IdEvent='"+e.getIdEvent()+"'";
        try {
   
   
          ste= cnx.createStatement();
            ste.executeUpdate(req2);
            ste.executeUpdate(req1);
            
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
    
    
    
    public void deleteParticipationById(Participation p){
     String req2= "delete from participation where IdParticipation ='"+p.getIdParticipation()+"'";
         String req1="update event set NbrPlaceDispo=NbrPlaceDispo+1 where IdEvent='"+p.getIdEvent()+"'";
        try {
   
   
            ste=cnx.createStatement();
            ste.executeUpdate(req2);
            ste.executeUpdate(req1);
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
    
  
    
    public int NbrParticipations(Participation p){
     String req="select * from participation where IdEvent='"+p.getIdEvent()+"'"; 
          List<Participation> part = new ArrayList<>();
         int x=0;
          
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                // part.add(new Participation(rs.getInt("IdParticipation"),rs.getInt("IdEvent"),rs.getInt("IdUser")));
                 x=x+1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;   
     }
    
    public List<Participation> ListParticip(){
     String req="select * from participation"; 
          List<Participation> part = new ArrayList<>();
         Event e = new Event();
          
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                 part.add(new Participation(rs.getInt("IdParticipation"),rs.getInt("IdEvent"),rs.getInt("IdUser")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return part;   
     }
    
    public List<Participation> maListeParticipation(int user_id){
     String req="select * from participation where IdUser="+user_id; 
          List<Participation> part = new ArrayList<>();
         
          
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                 part.add(new Participation(rs.getInt("IdParticipation"),rs.getInt("IdEvent"),rs.getInt("IdUser")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return part;   
     }
    
    
    public List<Participation> maListeParticipationEvent(Participation p){
     String req="select * from participation where (IdEvent='"+p.getIdEvent()+"') and (IdUser='"+p.getIdUser()+"')"; 
          List<Participation> part = new ArrayList<>();
         
          
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                 part.add(new Participation(rs.getInt("IdParticipation"),rs.getInt("IdEvent"),rs.getInt("IdUser")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return part;   
     }
    
    public String nameParticipEvent(Participation p){
        String req="select NomEvent from event where IdEvent='"+p.getIdEvent()+"'"; 
          
         String str=""; 
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
           while(rs.next()){
               str=rs.getString("NomEvent");
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;   
    }
    
}
