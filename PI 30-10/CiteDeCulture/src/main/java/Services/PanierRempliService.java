/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.AnnonceProd;
import Entities.personne;
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
import javafx.collections.ObservableList;
import Util.DataSource;

/**
 *
 * @author emna
 */




public class PanierRempliService {
    private final Connection cnx;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement ste;
    
    public PanierRempliService() {
        cnx=DataSource.getInstance().getConnexion();
    }

    
    
  
     public List<PanierRempli> readpn(int id_client) {
   String req="SELECT * FROM personne c INNER JOIN panier p on c.id=p.id_client INNER JOIN  annonce_prod a on a.id_prod=p.id_prod WHERE p.id_client="+id_client;
   
   List<PanierRempli> list=new ArrayList<>();
   AnnonceProdService as=new AnnonceProdService();
       personneService cs=new personneService ();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
              
                
           AnnonceProd p= as.readByid(rs.getInt("id_prod"));
           p.setNpProp(p.getNom_prod());
          
                    
           personne c= cs.readByidClient(rs.getInt("id"));
                            
                  
                    PanierRempli prempli=new PanierRempli();
                    prempli.setId_pn(rs.getInt("id_panier"));
                    prempli.setProd(p);
                     prempli.setClt(c);
                   
                  list.add(prempli);              
          
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierRempliService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
 
     
     
     
     
}
    

