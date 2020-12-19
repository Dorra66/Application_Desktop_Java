/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataSource {
    private static String url="jdbc:mysql://localhost:3306/cité";
    private static String username="root";
    private static String password="";
    private static Connection connexion;
    public static DataSource instance;
    
    public DataSource() {
        try {
            connexion=DriverManager.getConnection(url, username, password);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnexion() {
        return connexion;
    }
   
    
    public static DataSource getInstance(){
        if(instance==null)
            instance=new DataSource();
        return instance;
    }
}


