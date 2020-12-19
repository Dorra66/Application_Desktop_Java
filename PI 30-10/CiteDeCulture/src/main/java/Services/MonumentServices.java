/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Entities.Monument;
import Util.DataSource;
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

/**
 *
 * @author WSI
 */
public class MonumentServices {
    private Connection cnx;
    private Statement ste;
    private ResultSet rs;

    public MonumentServices() {
        cnx=DataSource.getInstance().getConnexion();
    }
    
    //Create monument
    public void insertM(Monument m){
        String req="insert into monument (nomM,descriptionM,imageM) values ('"+m.getNomM()+"','"+m.getDescriptionM()+"','"+m.getImageM()+"')";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MonumentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Search monument
    public Monument searchM(int idM){
        String req="select * from monument where idM="+idM;
        Monument m = new Monument();
        ObservableList<Monument> list=FXCollections.observableArrayList();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                m.setIdM(rs.getInt("idM"));
                m.setNomM(rs.getString("nomM"));
                m.setDescriptionM(rs.getString("descriptionM"));
                m.setImageM(rs.getString("imageM"));
                list.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonumentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
    //Read monument
    public ObservableList<Monument> readAllM(){
        String req="select * from monument";
        ObservableList<Monument> list=FXCollections.observableArrayList();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new Monument(rs.getInt("idM"),rs.getString("nomM"), rs.getString("descriptionM"), rs.getString("imageM")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonumentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    //Update monument
    public void updateM(int idM, Monument m){
        String req="update monument set nomM = '"+m.getNomM()+"', descriptionM = '"+m.getDescriptionM()+"', imageM = '"+m.getImageM()+"' where idM ="+idM;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MonumentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Delete monument
    public void deleteM(int idM){
        String req="delete from monument where idM="+idM;
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MonumentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Select Id
    
    public List<Integer> selectID(){
        List<Integer> list = new ArrayList();
        String req="select idM from monument";
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            Monument m = new Monument () ;
            while(rs.next()){
                m.setIdM(rs.getInt("idM"));
                list.add(m.getIdM());
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonumentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
     //Select Id
    
    public Monument selectIDM(String nomM) {
        List<Integer> list = new ArrayList();
        String req="select idM from monument where nomM = '"+nomM+"'";
        Monument m = new Monument () ;
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            
            while(rs.next()){
                m.setIdM(rs.getInt("idM"));
//                m.setNomM(rs.getString("nomM"));
                list.add(m.getIdM());
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonumentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return m;
    }
}
