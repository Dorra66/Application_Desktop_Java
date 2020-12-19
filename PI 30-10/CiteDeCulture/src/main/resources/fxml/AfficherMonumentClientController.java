/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import Entities.Monument;
import Services.MonumentServices;
import static fxml.AfficherMonumentClientController.vb;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherMonumentClientController implements Initializable {

    private Pagination pagination;
    @FXML
    private ImageView imgView;
    @FXML
    private Label lblNomM;

    Pagination p;
    public static VBox vb;
    @FXML
    private AnchorPane anc;
    @FXML
    private Label lblDescM;
    public static int j;
    @FXML
    private Button btnHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MonumentServices ms = new MonumentServices();
        ObservableList<Monument> list = ms.readAllM();
        List l = new ArrayList();
        l = ms.selectID();
        int id = (int) l.get(0);
        
        Monument m = new Monument();
        m = ms.searchM(id);
        
//        for (Monument m : list) {
//
//            System.out.println("test " + m.getIdM());
//
//            //p.setPageCount(4);
//            //String x = tableM.getSelectionModel().getSelectedItem().getImageM();
            File file = new File("C:\\images\\" + m.getImageM());
            Image image = new Image(file.toURI().toString());
            imgView.setImage(image);
            lblNomM.setText(m.getNomM());
            lblDescM.setText(m.getDescriptionM());
//            break;
//
//        }

    }

    @FXML
    private void nextM(MouseEvent event) throws SQLException{
       
        MonumentServices ms = new MonumentServices();
        //ObservableList<Monument> list = ms.readAllM();
        List l = new ArrayList();
        l = ms.selectID();
        System.out.println("test liste "+l.get(0));
        Monument m1 = new Monument();
        
        String nommonument = lblNomM.getText();
        m1= ms.selectIDM(nommonument);

        for (int i=0 ; i<l.size();i++){
            if (l.get(i).equals(m1.getIdM()))
                 
            j=(int) l.get(i+1);
        }
        Monument m2 = new Monument();
        m2 = ms.searchM(j);
        File file = new File("C:\\images\\" + m2.getImageM());
            Image image = new Image(file.toURI().toString());
            imgView.setImage(image);
            lblNomM.setText(m2.getNomM());
            lblDescM.setText(m2.getDescriptionM());
 

    }

    @FXML
    private void previousM(MouseEvent event) throws SQLException{
        MonumentServices ms = new MonumentServices();
        //ObservableList<Monument> list = ms.readAllM();
        List l = new ArrayList();
        l = ms.selectID();
        System.out.println("test liste "+l.get(0));
        Monument m1 = new Monument();
        
        String nommonument = lblNomM.getText();
        m1= ms.selectIDM(nommonument);
                System.out.println("9oliii shfamma "+nommonument);

        for (int i=0 ; i<l.size();i++){
            if (l.get(i).equals(m1.getIdM()))
                 
            j=(int) l.get(i-1);
        }
        Monument m2 = new Monument();
        m2 = ms.searchM(j);
        File file = new File("C:\\images\\" + m2.getImageM());
            Image image = new Image(file.toURI().toString());
            imgView.setImage(image);
            lblNomM.setText(m2.getNomM());
            lblDescM.setText(m2.getDescriptionM());
    }

    @FXML
    private void GoToHome(ActionEvent event) {
        Parent root;

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/AcceuilCM.fxml"));
                    btnHome.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilCMController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
