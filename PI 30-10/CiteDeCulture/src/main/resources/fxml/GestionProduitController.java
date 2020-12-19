/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;
import java.sql.ResultSet;
import java.sql.Connection;
import Util.DataSource;
import java.util.List;
import java.sql.Statement;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import services.AnnonceProdService;
import Entities.AnnonceProd;
import Entities.Commande;
import Entities.Event;
import Services.EventService;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import javafx.scene.image.Image;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import Services.CommandeService;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author emna
 */
public class GestionProduitController implements Initializable {

    @FXML
    private TableColumn<?, ?> nomprod;
    @FXML
    private TableColumn<?, ?> desprod;
    @FXML
    private TableColumn<?, ?> stockprod;
    @FXML
    private TableColumn<?, ?> picprod;
    @FXML
    private TableColumn<?, ?> costprod;
     @FXML
    private TableView<AnnonceProd> table;
     @FXML
    private TextField nameprod ;
    @FXML
    private TextField dsprod;
     @FXML
    private TextField sprod ;
   
       @FXML
    private TextField prixprod ;
       @FXML
    private TextField iprod;
       
    @FXML
    private Button addboutton;
    @FXML
    private Button actualiser;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private TextField recherche;
    final FileChooser fileChooser = new FileChooser();
    private String file_image;
    private Desktop desktop = Desktop.getDesktop();
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    private FileInputStream fis;
    
   
    
    @FXML
    private ImageView rechercheIMG;
    private TableColumn<?,?>dt;
    private TableView<Commande>cmdtable;
    private TableColumn<?,?>txtotal;
    private TableColumn<?, ?> cl;
    
    
    
     Random rd = new Random(); 
    public   static int n ; 
  
    final   File fileSave = new File("C:\\wamp64\\www\\images\\");
    static Image image ; 
    public  static Stage stage ;
    public  String nomFichier ; 
    @FXML
    private Button addImage;
   
    @FXML
    private ImageView imageV;
    
    AnnonceProd e;
    
   

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
       // Image im1= new Image("Images/loupe.png");
       // rechercheIMG.setImage(im1);
        
        AnnonceProdService ps=new AnnonceProdService();
        ArrayList<AnnonceProd> pers=(ArrayList<AnnonceProd>) ps.readAll();
        ObservableList<AnnonceProd> obs=FXCollections.observableArrayList(pers);
        table.setItems(obs);
        nomprod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
        desprod.setCellValueFactory(new PropertyValueFactory<>("description"));
        stockprod.setCellValueFactory(new PropertyValueFactory<>("stock"));
        costprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
         picprod.setCellValueFactory(new PropertyValueFactory<>("image"));
        
        
        addboutton.setOnAction(e->{
            
            
            
            
                
               if (  nameprod.getText().equals("") || nameprod.getText().equals("") || dsprod.getText().equals("") || dsprod.getText().equals("") ||  picprod.getText().equals("") ||  picprod.getText().equals("")) {
       
                
                    Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("please complete all fields!");
        alert.show();

            
        }else {   
                   AnnonceProd ev = new AnnonceProd (nameprod.getText(), dsprod.getText(), Integer.parseInt(sprod.getText()), Integer.parseInt(prixprod.getText()), file_image);
                          

                pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
                pathto = FileSystems.getDefault().getPath("C:\\wamp64\\www\\images\\" + Current_file.getName());
                Path targetDir = FileSystems.getDefault().getPath("C:\\images");
                
                try {
                    Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(AjoutereventController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                AnnonceProdService psv = new AnnonceProdService();
                psv.insertPst(ev);
                
                Parent root;
                
                try {
                    root = FXMLLoader.load(getClass().getResource("GestionProduit.fxml"));
                    addboutton.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AjoutereventController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }});
        
        addImage.setOnAction(e->{
            FileChooser fc = new FileChooser();
            Current_file = fc.showOpenDialog(null);
            if (Current_file != null) {
                Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
                imageV.setImage(images);
                
                try {
                    fis = new FileInputStream(Current_file);
                    file_image = Current_file.getName();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AjoutereventController.class.getName()).log(Level.SEVERE, null, ex);
                }
                final GridPane inputGridPane = new GridPane();
                GridPane.setConstraints(addImage, 0, 0);
                inputGridPane.setHgap(6);
                inputGridPane.setVgap(6);
                final Pane rootGroup = new VBox(12);
                rootGroup.getChildren().addAll(inputGridPane);
                rootGroup.setPadding(new Insets(12, 12, 12, 12));
            }
        });

        //});
        actualiser.setOnAction(e->{
            
                   refresh();

                                   }  ); 
        
        
        
        
          AnnonceProdService ass=new AnnonceProdService();
       
        
        supprimer.setOnAction(e->{
            
             AnnonceProd x=table.getSelectionModel().getSelectedItem();
                 Alert alert = new Alert(AlertType.CONFIRMATION);
                 alert.setHeaderText(null);
                  alert.setContentText("Are you sure you want to delete it ?");

                 ButtonType delete = new ButtonType("Delete");
                  ButtonType buttonTypeCancel = new ButtonType("Cancel");

                alert.getButtonTypes().setAll(delete, buttonTypeCancel);

                 Optional<ButtonType> result = alert.showAndWait();
                 if (result.get() == delete){
                ass.deletePst(x.getId_prod());    
             table.getItems().remove(x);
        }

    
    else {
        // ... user chose CANCEL or closed the dialog
    }
        
             
     }  );  
        
        
        modifier.setOnAction(e->{
                      AnnonceProd x=table.getSelectionModel().getSelectedItem();
                                n=rd.nextInt(10000)+1;
                                  String s = nomFichier+n+".png";  
        /*                                try 
                { 
                  
         
                
                
                        File nomfichier = new File("C:\\wamp\\www\\images\\" + nomFichier+n + ".png");
                        ImageIO.write(SwingFXUtils.fromFXImage(imageV.getImage(),null), "png", nomfichier);
                        insertionBase(nomFichier+n);
                }
                catch (URISyntaxException ex) 
                {
                        Logger.getLogger(GestionProduitController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                catch (MalformedURLException ex) 
                {
                        Logger.getLogger(GestionProduitController.class.getName()).log(Level.SEVERE, null, ex);
                   
        
 
          } catch (IOException ex) {
                Logger.getLogger(GestionProduitController.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
                      ass.updateePst(nameprod.getText(),
                        dsprod.getText(),
                        Integer.parseInt(sprod.getText()),
                        Integer.parseInt(prixprod.getText()),
                        s ,
                         x.getId_prod() );
                          refresh();
                          
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information ");
        alert.setHeaderText(null);
        alert.setContentText("Modification made successfully!");
        alert.show();
     }  );  
        
        
        
       
       
    }
      
    @FXML
    private void update(MouseEvent event) {
        AnnonceProd x=table.getSelectionModel().getSelectedItem();
         nameprod.setText(x.getNom_prod());
         dsprod.setText(x.getDescription());
         sprod.setText(x.getStock()+"");
         prixprod.setText(x.getPrix()+"");
         iprod.setText(x.getImage());
           File nomfichier = new File("C:\\wamp64\\www\\images\\"+x.getImage());
        Image image=new Image(nomfichier.toURI().toString());
        imageV.setImage(image);
        
    }
    
    private void refresh(){
            AnnonceProdService pss=new AnnonceProdService();
        ArrayList<AnnonceProd> perss=(ArrayList<AnnonceProd>) pss.readAll();
        ObservableList<AnnonceProd> obss=FXCollections.observableArrayList(perss);
        table.setItems(obss);
        nomprod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
        desprod.setCellValueFactory(new PropertyValueFactory<>("description"));
        stockprod.setCellValueFactory(new PropertyValueFactory<>("stock"));
        picprod.setCellValueFactory(new PropertyValueFactory<>("image"));
        costprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
         picprod.setCellValueFactory(new PropertyValueFactory<>("image"));
         nameprod.setText("");
         dsprod.setText("");
         sprod.setText("");
         prixprod.setText("");
         iprod.setText("");
           
       
        
    }

    @FXML
    private void rechecher(KeyEvent event) {
        
        String champsrecherche = recherche.getText();
      
        
         AnnonceProdService pss=new AnnonceProdService();
        ArrayList<AnnonceProd> perss=(ArrayList<AnnonceProd>) pss.recherche(champsrecherche);
        ObservableList<AnnonceProd> obss=FXCollections.observableArrayList(perss);
        table.setItems(obss);
        nomprod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
        desprod.setCellValueFactory(new PropertyValueFactory<>("description"));
        stockprod.setCellValueFactory(new PropertyValueFactory<>("stock"));
        picprod.setCellValueFactory(new PropertyValueFactory<>("image"));
        costprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
    }

    
   
     @FXML
    private void AddImage(ActionEvent event) throws MalformedURLException {
             
           FileChooser fc = new FileChooser();
            Current_file = fc.showOpenDialog(null);
            if (Current_file != null) {
                Image images = new Image(Current_file.toURI().toString(), 100, 100, true, true);
                imageV.setImage(images);
                
                try {
                    fis = new FileInputStream(Current_file);
                    file_image = Current_file.getName();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AjoutereventController.class.getName()).log(Level.SEVERE, null, ex);
                }
                final GridPane inputGridPane = new GridPane();
                GridPane.setConstraints(addImage, 0, 0);
                inputGridPane.setHgap(6);
                inputGridPane.setVgap(6);
                final Pane rootGroup = new VBox(12);
                rootGroup.getChildren().addAll(inputGridPane);
                rootGroup.setPadding(new Insets(12, 12, 12, 12));
            }
        }
                
    

    
    public void insertionBase(String nomFile)throws URISyntaxException, MalformedURLException, IOException 
            {
               URLBuilder urlb = new URLBuilder("localhost");
                urlb.setConnectionType("http");
                urlb.addSubfolder("images");
                urlb.addSubfolder("uploadimage.PHP");
                urlb.addParameter("image","http://localhost/images/"+nomFile+".png");
        
                String url = urlb.getURL();
                System.out.println(url);
               
              
        
        URL URl_Serveur = new URL(url);
                HttpURLConnection conx = (HttpURLConnection) URl_Serveur.openConnection();
                conx.setRequestMethod("POST");
                conx.setDoOutput(true);
                OutputStream os = conx.getOutputStream();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {
            writer.flush();
        }
                conx.connect();


                int reponse = conx.getResponseCode();

                if (reponse == HttpsURLConnection.HTTP_OK) 
                {
                    InputStream is = conx.getInputStream();

                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    String ligne = "", resultat = "";

                    while ((ligne = br.readLine()) != null) 
                    {

                        resultat += ligne;
                    }

    }
}  
    
    private void setExtFilters(FileChooser chooser) 
    {
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

    

  class URLBuilder 
    {
    private StringBuilder folders, params;
    private String connType, host;

    void setConnectionType(String conn) 
    {
        connType = conn;
    }

    URLBuilder()
    {
        folders = new StringBuilder();
        params = new StringBuilder();
    }

    URLBuilder(String host) 
    {
        this();
        this.host = host;
    }

    void addSubfolder(String folder) 
    {
        folders.append("/");
        folders.append(folder);
    }

    void addParameter(String parameter, String value)
    {
        if(params.toString().length() > 0){params.append("&");}
        params.append(parameter);
        params.append("=");
        params.append(value);
    }

    String getURL() throws URISyntaxException, MalformedURLException
    {
        URI uri = new URI(connType, host, folders.toString(),
                params.toString(), null);
        return uri.toURL().toString();
    }

    String getRelativeURL() throws URISyntaxException, MalformedURLException
    {
        URI uri = new URI(null, null, folders.toString(), params.toString(), null);
        return uri.toString();
    }
    }
    
    
  
   

        
        
}
    
   

             
   

    
  

   

   

    

   
    
 

  

    
    
   
        
