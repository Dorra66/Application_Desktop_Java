/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.personne;
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

/**
 *
 * @author dorra
 */
public class personneService {

    private static personneService instance;
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    personne p;

    public personneService() {
        cnx = DataSource.getInstance().getConnexion();
    }

    public static personneService getInstance() {
        if (instance == null) {
            instance = new personneService();
        }
        return instance;
    }

    public void insert(personne o) {
        String req = "insert into personne (nom,prenom,email,password,role,cin) values ('" + o.getNom() + "','" + o.getPrenom() + "','" + o.getEmail() + "','" + o.getPassword() + "','" + o.getRole() + "','" + o.getCin() + "')";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(personneService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<personne> readAllper() {
        String req = "select * from personne where nom not like 'sehli'";
        List<personne> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                //                                                 
                list.add(new personne(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getInt("cin")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(personneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<personne> readById(int id) {
        String req = "select * from personne where id="+id;
        List<personne> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                //                                                 
                list.add(new personne(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getInt("cin")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(personneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public personne SearchByMail(String email) {
        personne p = new personne();
        try {

            String req2 = "select * from personne where email = '" + email + "' ";

            ste = cnx.createStatement();
            rs = ste.executeQuery(req2);

            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setPassword(rs.getString("password"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setRole(rs.getString("role"));
                p.setCin(rs.getInt("cin"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public boolean check(personne p) {
        try {

            String req2 = "select * from personne where email = '" + p.getEmail() + "' and password = '" + p.getPassword() + "' ";
            ste = cnx.createStatement();
            rs = ste.executeQuery(req2);

            while (rs.next()) {
                p.setRole(rs.getString("role"));
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    /* public String checkEmail(personne p) {
try {
   
  
            
            String req2= "select email from personne";
            ste=cnx.createStatement();
            rs=ste.executeQuery(req2);
            
            while (rs.next()) {  
                p.setRole(rs.getString("email"));
                return p.getEmail();
            }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return "error";   
    }*/
    public void deletePers(int id) {
        String req2 = "delete from personne where id  = ? ";

        try {
            pst = cnx.prepareStatement(req2);
            pst.setInt(1, id);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(personneService.class.getTypeName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateclient_n(String nom, String email) {
        String req = "update personne set nom=? where email  = ? ";

        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1, nom);
            pst.setString(2, email);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(personneService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateclient_p(String prenom, String email) {
        String req = "update personne set prenom=? where email  = ? ";

        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1, prenom);
            pst.setString(2, email);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(personneService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateclient_mdp(String password, String email) {
        String req = "update personne set password=? where email  = ? ";

        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1, password);
            pst.setString(2, email);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(personneService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void updateclient_cin(int cin, String email) {
        String req = "update personne set cin=? where email  = ? ";

        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1, cin);
            pst.setString(2, email);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(personneService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public personne Authentification(String email, String pwd) throws SQLException {

        try {
            String req = "SELECT * FROM `personne` ";
            Statement ste = cnx.createStatement();

            ResultSet r = ste.executeQuery(req);

            while (r.next()) {
                if (r.getString("email").equals(email) && r.getString("password").equals(pwd)) {
                    if (r.getString("role").equals("admin")) {
                        System.out.println("Welcome Admin");
                        p = new personne(r.getInt("id"), r.getString("nom"), r.getString("prenom"), r.getString("email"), r.getString("password"), r.getString("role"), r.getInt("cin"));
                        return p;
                    }
                    if (r.getString("role").equals("client")) {

                        p = new personne(r.getInt("id"), r.getString("nom"), r.getString("prenom"), r.getString("email"), r.getString("password"), r.getString("role"),r.getInt("cin"));
                        return p;
                    }
//                    if (r.getString("role").equals("Ouvrier")) {
//
//                         p = new personne(r.getInt("id"), r.getString("nom"), r.getString("prenom"), r.getString("email"), r.getString("password"), r.getString("role"));
//                        return p;
//
//                    }
                }
            }

            return p;
        } catch (NullPointerException ex) {

        }
        return null;
    }
    
    public personne readByidClient(int id){
        personne c = new personne();
                   try {
            
            String req= "select * from personne where id = "+id+"";
                        ste=cnx.createStatement();
                         rs=ste.executeQuery(req);            
            while (rs.next()) {  
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                 c.setEmail(rs.getString("email"));
                c.setPassword(rs.getString("password"));
                c.setRole(rs.getString("role"));
                c.setCin(rs.getInt("cin"));
               
               
            }
        } catch (SQLException ex) { 
            Logger.getLogger(personneService.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         return c;
}
}
