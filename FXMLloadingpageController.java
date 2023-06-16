/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlbraino;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author omar
 */
public class FXMLloadingpageController implements Initializable {

    @FXML
    private ProgressBar myprogressbar;
    
    @FXML
    private ImageView logo;
    
    @FXML
    private MediaView media;
    
    @FXML
    private Button startbtn;
    
    private MediaPlayer mediaPlayer;
    public AudioClip backgroundmusic = new AudioClip(getClass().getResource("/video/backgroundmusic.mp3").toString());
    public  AudioClip click = new AudioClip(getClass().getResource("/video/mouseclick.mp3").toString());

    @FXML
    private Label leter1;
    @FXML
    private Label leter2;
    @FXML
    private Label leter3;
    @FXML
    private Label leter4;
    @FXML
    private Label leter5;
    @FXML
    private Label leter6;
    
   

     /* switch secene from main to homepage */
    @FXML
    public void ShangeScreenButtonPushed( ActionEvent event) throws IOException{
        click.play();
        
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLHomepage.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }
    @FXML 
    public void startmousebtnenter(MouseEvent e){
    
     startbtn.setScaleX(startbtn.getScaleX()+0.1);
     startbtn.setScaleY(startbtn.getScaleY()+0.1);
     
       
    }
    @FXML 
    public void startmousebtnexit(MouseEvent e){

    
     startbtn.setScaleX(startbtn.getScaleX()-0.1);
     startbtn.setScaleY(startbtn.getScaleY()-0.1);
      
    }
    
    
     boolean t= true;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        myprogressbar.setStyle("-fx-accent:#74a510");
        ScaleTransition scaleleter1 = new ScaleTransition();
        scaleleter1.setNode(logo);
        scaleleter1.setDuration(Duration.millis(1000));
        scaleleter1.setCycleCount(1);
        scaleleter1.setInterpolator(Interpolator.LINEAR);
        scaleleter1.setByX(0.7);
        scaleleter1.setByY(0.7);
        scaleleter1.play();   
        
    }    
    
}
