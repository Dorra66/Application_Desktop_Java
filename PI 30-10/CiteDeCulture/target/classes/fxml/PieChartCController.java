/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import fxml.AjouterActualiteController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import Services.publicitésService;

/**
 * FXML Controller class
 *
 * @author dorra
 */
public class PieChartCController implements Initializable {

    
    @FXML
    private PieChart piechartc;
    ObservableList<PieChart.Data> list=FXCollections.
            observableArrayList();
    @FXML
    private Button retchartc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         publicitésService pub = publicitésService.getInstance();
        List<Integer> nbr = new ArrayList<>();
         List<String> publ=pub.displayAllbyType(nbr);
        int i =0;
        for(String a:publ) {
            list.addAll(
                new PieChart.Data(a, nbr.get(i)) 
                    
        );
            i++;
        }
        piechartc.setAnimated(true);
        piechartc.setData(list);
        
    
             retchartc.setOnAction(e->{
             try {
                
                 Parent root ;
                 root=FXMLLoader.load(getClass().getResource("affichagePC.fxml"));
                retchartc.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
            }); 
        
    }    
    
}
