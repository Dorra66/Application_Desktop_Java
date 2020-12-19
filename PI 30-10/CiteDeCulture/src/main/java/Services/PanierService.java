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
import fxml.LoginController;

/**
 *
 * @author emna
 */
public class PanierService {
    private final Connection cnx;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement ste;
    
    public PanierService() {
        
        cnx=DataSource.getInstance().getConnexion();
    
    }
    
    
    Panier p=new Panier();
    
    
    public void insertP(Panier p){
       
                 try {
           
                     String req="insert into panier (id_prod,id_client) values (?,?)";
                     pst=cnx.prepareStatement(req);
                     pst.setInt(1,p.getId_prod());
                     pst.setInt(2,LoginController.PERSONNECONNECTEE.getId());
                     pst.executeUpdate();
            
        }           catch (SQLException ex) {
                    Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
            
            
       } 
           }
    
        
        public Panier readByid(int id_panier){
        Panier c = new Panier();
                   try {
            
            String req= "select * from panier where id_panier = "+id_panier+"";
                        ste=cnx.createStatement();
                         rs=ste.executeQuery(req);            
            while (rs.next()) {  
                c.setId(rs.getInt("id_panier"));
                c.setId_prod(rs.getInt("id_prod"));
                c.setId_client(rs.getInt("id_client"));
               
            }
        } catch (SQLException ex) { 
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         return c;
   
}
        
        

          public void deleteProd(int id_prod, int id_client){
        String req2="delete from panier where id_prod ="+id_prod+" AND id_client="+id_client+"";   //user
        
        try {
            pst=cnx.prepareStatement(req2);
           // pst.setInt(1, id_prod);
           // pst.setInt(2, id_client);
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
   
                  
          }
          
      
      
      
    public void deletePst(int id_client){
        String req2="delete from panier WHERE id_client= "+id_client+"";
        
        try {
            pst=cnx.prepareStatement(req2);
            //pst.setInt(1,id_client);
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceProd.class.getName()).log(Level.SEVERE, null, ex);
        }  
      
      
      
}
         
       public  int  getNombre (int id_client){
           int Compte = 0 ,pn;
           float montant = 0;
           AnnonceProdService as=new AnnonceProdService();
           
          
        
 String requete2 ="SELECT COUNT(id_prod ) as nbr_prod  FROM panier where id_client="+id_client+"";
                     try {       
                       ste=cnx.createStatement();
         
                       rs=ste.executeQuery(requete2);
                           while(rs.next()){
                           Compte = rs.getInt(1);}
                     }
       catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);              
       
                    return Compte; 
              
       }
                 
                     
                     
    for (int i=0 ;i < Compte ;i++){
        
        AnnonceProd a=as.readByid(Compte);
	     int x=a.getPrix();
            
                      montant+=x;
		}
    
    
		return (int) montant;
                    
   
    
        }    
         
        
       }
     
  
    
    /* public void updateePst(String libelle,int id){
        String req="update panier set libelle =?  where id=?";
        
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,libelle);
            pst.setInt(2,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
} */

       

 /* public List<PanierRempli> readpn(int id){
   String req="SELECT nom_client,prenom_client,cin_cl,adresse_cl,nom_prod,prix  FROM panier,client,annonce_prod WHERE panier.id_client=client.id_client AND panier.id_prod=annonce_prod.id_prod AND id_panier="+id+"";
       AnnonceProdService as=new AnnonceProdService();
       PanierService ps=new PanierService();
       ClientService cs =new ClientService();
   List<PanierRempli> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                PanierRempli prempli=new PanierRempli();
               ObservableList<AnnonceProd> pr= as.readbyid(id);
                rs.getInt("id_prod");
                rs.getString("nom_prod");
                rs.getInt("prix");
               ObservableList<Panier> pn= ps.readbyid(id); 
               rs.getInt("id_panier");
               ObservableList<Client> cn= cs.readbyid(id); 
               rs.getInt("id_client");
               rs.getString("nom_client");
               rs.getString("prenom_client");
               rs.getString("cin_cl");
               rs.getString("adresee_cl");
               
                  list.add(prempli);              
          
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
} */

     
     
     
      
    
    /* public void updateePst(String libelle,int id){
        String req="update panier set libelle =?  where id=?";
        
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,libelle);
            pst.setInt(2,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
} */

       

 /* public List<PanierRempli> readpn(int id){
   String req="SELECT nom_client,prenom_client,cin_cl,adresse_cl,nom_prod,prix  FROM panier,client,annonce_prod WHERE panier.id_client=client.id_client AND panier.id_prod=annonce_prod.id_prod AND id_panier="+id+"";
       AnnonceProdService as=new AnnonceProdService();
       PanierService ps=new PanierService();
       ClientService cs =new ClientService();
   List<PanierRempli> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                PanierRempli prempli=new PanierRempli();
               ObservableList<AnnonceProd> pr= as.readbyid(id);
                rs.getInt("id_prod");
                rs.getString("nom_prod");
                rs.getInt("prix");
               ObservableList<Panier> pn= ps.readbyid(id); 
               rs.getInt("id_panier");
               ObservableList<Client> cn= cs.readbyid(id); 
               rs.getInt("id_client");
               rs.getString("nom_client");
               rs.getString("prenom_client");
               rs.getString("cin_cl");
               rs.getString("adresee_cl");
               
                  list.add(prempli);              
          
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
} */

     
      
    
    /* public void updateePst(String libelle,int id){
        String req="update panier set libelle =?  where id=?";
        
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,libelle);
            pst.setInt(2,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
} */

       

 /* public List<PanierRempli> readpn(int id){
   String req="SELECT nom_client,prenom_client,cin_cl,adresse_cl,nom_prod,prix  FROM panier,client,annonce_prod WHERE panier.id_client=client.id_client AND panier.id_prod=annonce_prod.id_prod AND id_panier="+id+"";
       AnnonceProdService as=new AnnonceProdService();
       PanierService ps=new PanierService();
       ClientService cs =new ClientService();
   List<PanierRempli> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                PanierRempli prempli=new PanierRempli();
               ObservableList<AnnonceProd> pr= as.readbyid(id);
                rs.getInt("id_prod");
                rs.getString("nom_prod");
                rs.getInt("prix");
               ObservableList<Panier> pn= ps.readbyid(id); 
               rs.getInt("id_panier");
               ObservableList<Client> cn= cs.readbyid(id); 
               rs.getInt("id_client");
               rs.getString("nom_client");
               rs.getString("prenom_client");
               rs.getString("cin_cl");
               rs.getString("adresee_cl");
               
                  list.add(prempli);              
          
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
} */

