/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import fxml.AcceuilController;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import jdk.nashorn.internal.ir.CatchNode;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import Entities.actualités ; 
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date ;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;


/**
 *
 * @author dorra
 */
public class actualitésService {
    private static actualitésService instance;
     private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
 
    
    public actualitésService() {
        cnx=DataSource.getInstance().getConnexion();
    }
     public static actualitésService getInstance(){
        if(instance==null) 
            instance=new actualitésService();
        return instance;
    }
  
    public void inserta(actualités p){
        String req="insert into actualités(date_Début,date_Fin,description,titre,img) values ('"+p.getDate_Début()+"','"+p.getDate_Fin()+"','"+p.getDescription()+"','"+p.getTitre()+"','"+p.getImg()+"')";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(actualitésService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
 
    public List<actualités> readAlla(){
        String req="select * from actualités";
        List<actualités> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                                                                      
                list.add(new actualités(rs.getDate("date_Début"), rs.getDate("date_Fin"), rs.getInt("id"), rs.getString("description"), rs.getString("titre"), rs.getString("img")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(actualitésService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   
    }
    
    public ObservableList<actualités> displaybyTitre(String titre) {
        String req="select * from actualités where titre like '%"+titre+"%'";
        ObservableList<actualités> list=FXCollections.observableArrayList();       
        
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                actualités p=new actualités();
                p.setDate_Début(rs.getDate("date_Début"));
               p.setDate_Fin(rs.getDate("date_Fin"));
                p.setId(rs.getInt("id"));
                p.setDescription(rs.getString("description"));
                p.setTitre(rs.getString("titre"));
                p.setImg(rs.getString("img"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(actualitésService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
  
    
     public void deletePsta(int id){
        String req2="delete from actualités where id  = ? ";
        
        
         try {
             pst=cnx.prepareStatement(req2);
               pst.setInt(1,id);
           
              pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(actualitésService.class.getTypeName()).log(Level.SEVERE, null, ex);
         }
          
       
    }
     
     public void updatePsta_date_Début(Date date_Début,int id ){
        String req="update actualités set date_Début=? where id  = ? ";
        
        
         try {
            pst=cnx.prepareStatement(req);
            pst.setDate(1,date_Début);
            pst.setInt(2,id );
            pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(actualitésService.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
         
        public void updatePsta_date_Fin(Date date_Fin,int id ){
        String req="update actualités set date_Fin=? where id  = ? ";
        
        
         try {
            pst=cnx.prepareStatement(req);
            pst.setDate(1,date_Fin);
            pst.setInt(2,id );
            pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(actualitésService.class.getName()).log(Level.SEVERE, null, ex);
         }
   
     }
         
          public void updatePsta_description(String description,int id ){
        String req="update actualités set description=? where id  = ? ";
        
        
         try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,description);
            pst.setInt(2,id );
            pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(actualitésService.class.getName()).log(Level.SEVERE, null, ex);
         }
   
     }
          public void updatePsta_titre(String titre,int id ){
        String req="update actualités set titre=? where id = ? ";
        
        
         try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,titre);
            pst.setInt(2,id);
            pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(actualitésService.class.getName()).log(Level.SEVERE, null, ex);
         }
   
     }
          
          public void updatePsta_img(String img,int id ){
        String req="update actualités set img=? where id = ? ";
        
        
         try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,img);
            pst.setInt(2,id);
            pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(actualitésService.class.getName()).log(Level.SEVERE, null, ex);
         }
   
     }
          ////////////////pdf//////////////////////
          public void generatepdfparts(String text){
          
              Document document = new Document(PageSize.A4);
              document.addAuthor("dorra");
              document.addTitle("Demo for IText");
          try{
            PdfWriter.getInstance(document,new FileOutputStream("Actualites.pdf"));
            System.out.println("writer instance created");
            document.open();
             com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.GREEN);
             com.itextpdf.text.Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.RED);
             java.util.Date now = new java.util.Date();
            Chunk date = new Chunk("Sortie le "+now.toString(), font);
            Chunk title = new Chunk("Liste des actualités", font1);
             title.setUnderline(2,-2);
            //""
             System.out.println("Document opened ..");
            Paragraph para = new Paragraph();
            para.add(date); 
            para.add(Chunk.NEWLINE);
            para.add(Chunk.NEWLINE); 
            para.add(title); 
            para.add(Chunk.NEWLINE);
            
            para.add(text);
           
            try {
                Image img;
               
                try {
             img = Image.getInstance("C:\\images\\act.jpg");
             
             img.scaleAbsolute(250, 125);
            
         document.add(img);
        
         
         } catch (BadElementException ex) {
             Logger.getLogger(actualitésService.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(actualitésService.class.getName()).log(Level.SEVERE, null, ex);
         }
                
                document.add(para);
            }
            catch (DocumentException ex) {
            System.out.println(ex.getMessage());
        }
           System.out.println("para added to document ..");
        }
        catch(Exception e){
            System.out.println(e);
       }
        document.close();
        File f=new File("Actualites.pdf");
        
        
          
          
              }
        
     
     
     
}





    

