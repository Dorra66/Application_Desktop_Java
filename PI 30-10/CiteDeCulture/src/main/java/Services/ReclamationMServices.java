/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.ReclamationM;
import Util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class ReclamationMServices {
    private Connection cnx;
    private Statement ste;
    private ResultSet rs;

    public ReclamationMServices() {
        cnx=DataSource.getInstance().getConnexion();
    }
    
    //Ajouter Reclamtion 
    public void insertRM(ReclamationM rm){
        String req="insert into reclamationm (Idsource,roleSource,objetReclamation,descriptionReclamation,dateReclamation,statutsReclamation,reponseReclamation,destinationReclamation) values ('"+rm.getIdsource()+"','"+rm.getRoleSource()+"','"+rm.getObjetReclamation()+"','"+rm.getDescriptionReclamation()+"','"+rm.getDateReclamation()+"','"+rm.getStatusReclamation()+"','"+rm.getReponseReclamation()+"','"+rm.getDestinationReclamation()+"')";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationMServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Supprimer Reclamation
    public void deleteRM(int idsource){
        String req="DELETE from reclamationm where idRM ="+idsource;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationMServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //afficher les reclamations
    public List<ReclamationM> readAllR(){
        String req="select * from reclamationm ";
        List<ReclamationM> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new ReclamationM(rs.getInt("idRM"),rs.getString("Idsource"), rs.getString("roleSource"), rs.getString("objetReclamation"), rs.getString("descriptionReclamation"), rs.getString("dateReclamation"), rs.getString("statutsReclamation"), rs.getString("reponseReclamation"), rs.getString("destinationReclamation")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationMServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //afficher les reclamation provenant du client
    public ObservableList<ReclamationM> readAllRC() {
        String req="select * from reclamationm ";
        ObservableList<ReclamationM> list= FXCollections.observableArrayList();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new ReclamationM(rs.getInt("idRM"),rs.getString("Idsource"), rs.getString("roleSource"), rs.getString("objetReclamation"), rs.getString("descriptionReclamation"), rs.getString("dateReclamation"), rs.getString("statutsReclamation"), rs.getString("reponseReclamation"), rs.getString("destinationReclamation")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationMServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //afficher l'historique des reclamations 
     public ObservableList<ReclamationM> readAllRH(String nom) throws SQLException{
        String req="select * from reclamationm where Idsource='"+nom+"'";
        ObservableList<ReclamationM> list = FXCollections.observableArrayList();
        
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                //list.add(new ReclamationM(rs.getInt("idRM"),rs.getString("idSource"), rs.getString("roleSource"), rs.getString("objetRM"), rs.getString("descriptionRM"), rs.getString("dateRM"), rs.getString("statutsRM"), rs.getString("reponseRM"), rs.getString("destinationRM")));
            ReclamationM rec = new ReclamationM();
            rec.setIdRM(rs.getInt("idRM"));
            rec.setIdsource(rs.getString("Idsource"));
            rec.setRoleSource(rs.getString("roleSource"));
            rec.setObjetReclamation(rs.getString("objetReclamation"));
            rec.setDescriptionReclamation(rs.getString("descriptionReclamation"));
            rec.setDateReclamation(rs.getString("dateReclamation"));
            rec.setStatusReclamation(rs.getString("statutsReclamation"));
            rec.setReponseReclamation(rs.getString("reponseReclamation"));
            rec.setDestinationReclamation(rs.getString("destinationReclamation"));
            list.add(rec);
            }
        
        return list;
    }
     
    //modifier la statut de reclamation
     public ReclamationM updateRS(ReclamationM rm) throws SQLException{
         String req ="UPDATE reclamationm SET `Idsource`='"+rm.getIdsource()+"', `objetReclamation` = '" +rm.getObjetReclamation()+"',`descriptionReclamation` = '" +rm.getDescriptionReclamation()+"',`statutsReclamation` = 'vu', `destinationReclamation` = '" +rm.getDestinationReclamation()+"', `reponseReclamation`='"+rm.getReponseReclamation()+"', `dateReclamation`='"+rm.getDateReclamation()+"' where idRM='"+rm.getIdRM()+"';";
            
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        
            return rm;
     }
     
      
}
