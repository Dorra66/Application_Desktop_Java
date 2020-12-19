/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.AnnonceProd;
import Entities.personne;
import Entities.Commande;
import Entities.Panier;
import Entities.PanierRempli;
import Entities.Prod_cmd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Util.DataSource;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;


/**
 *
 * @author emna
 */
public class CommandeService {
    
    private final Connection cnx;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement ste;
    
    public CommandeService() {
        cnx=DataSource.getInstance().getConnexion();
    }
    
    
    //insertion dans table commande 
    
    public void insertc (Commande c,int id_cl){
       
        CommandeService cs=new CommandeService();
          String  x=cs.retournDate();
        
         float  t=cs.gettotalcmd(id_cl);
            
         
        String req="insert into commande (date,total,id_client) values (?,?,?)";
        try {
             pst=cnx.prepareStatement(req);
             // long x=cs.retournDate();
             pst.setString (1, x);
             // float t=cs.gettotalcmd(id_client);
               pst.setFloat(2, t);
                pst.setInt(3, id_cl);
                
                 pst.executeUpdate();                                                            //id user 
             
        }
    catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
 
   /* public List<Commande> readAll(){
        String req="select * from Commande";
        List<Commande> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               list.add(new Commande(rs.getInt("id_cmd"),rs.getString("date"), rs.getInt("total"),rs.getInt("idcl")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   
}
    public void deletePst(int id){
        String req2="delete from commande where id_cmd = ? ";
        
        try {
            pst=cnx.prepareStatement(req2);
            pst.setInt(1,id);
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
  public void updateePst(String date,int total ,int id,int id_cl){
        String req="update commande set date =? , total=?,id_cl=?  where id_cmd=?";
        
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,date);
            pst.setInt(2,total);
            pst.setInt(3, id_cl);
             pst.setInt(4, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    */
    
   public String  retournDate(){
 Date actuelle = new Date();
 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
 String dat = dateFormat.format(actuelle);
 System.out.println(dat);
    return dat;  
}
  
   
   

/*public void insert_cmd ( int id_prod , Prod_cmd pr,int id_cmd){
    
             
       CommandeService cs=new CommandeService();
             
               
                 pr.setId_prod(id_prod);
                pr.setId_cmd(id_cmd);
       
        String req="insert into prod_cmd  (id_prod ,id_cmd) values ('"+id_prod+"','"+id_cmd+"')";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
           
                   
        }
          
      catch (SQLException ex) {
        Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
          
       
*/
   
   
   public float   gettotalcmd (int id_client){
           float montant=0;
       PanierRempliService ps=new PanierRempliService();
        ArrayList<PanierRempli> pers=(ArrayList<PanierRempli>) ps.readpn(id_client);
        ObservableList<PanierRempli> obs = FXCollections.observableArrayList(pers);
           

        for (int i = 0; i < obs.size() ;i++) {
           // System.out.println(obs.get(i));
          int x=   pers.get(i).getProd().getPrix();
            // System.out.println(x);
            montant+=x;
        }
        
        
        
          System.out.println(montant);
             return montant ;
   }       
   
   //parcourir et insert dans cmd_prod 
   
   
   
        public void parcourir_cmd_insert_diminuer   (int id_client){
            CommandeService cs=new CommandeService();
        
           AnnonceProdService as=new AnnonceProdService();
           PanierRempliService ps=new PanierRempliService();
       
       
        ArrayList<PanierRempli> pers=(ArrayList<PanierRempli>) ps.readpn(id_client);
        ObservableList<PanierRempli> obs = FXCollections.observableArrayList(pers);
           
           
            // Prod_cmd pr=new Prod_cmd();
              
 
        for (int i = 0; i < obs.size() ;i++) {
            
          
                 int    x=  pers.get(i).getProd().getId_prod();
                            cs.diminuerStock(x);
                           //Commande c=new Commande();
                             // cs.insertc(c, id_client);
                                //id_cmd= c.getId();
                             //Prod_cmd pr=new Prod_cmd();
                                // cs.insert_cmd(x, pr,id_cmd);
                               PanierService pss=new PanierService();
                               pss.deleteProd(x, id_client);
                 
                
        }    
        
          
        }
        
        
        
      public void  diminuerStock(int id_prod){
          
          
          try {
           String req="UPDATE annonce_prod SET stock =stock-1  where id_prod="+id_prod+"";
                     
                     pst=cnx.prepareStatement(req);
                   
                     pst.executeUpdate();
            
        }           catch (SQLException ex) {
                    Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
          
       } 
        
      }


}


     
 
    
