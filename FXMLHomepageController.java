/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlbraino;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author omar
 */
public class FXMLHomepageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BorderPane pane;
    @FXML
    private MediaView media;
    @FXML
    private Button gustbtn;
    @FXML
    private Button loginbtn;
    @FXML
    private Button singinbtn;
    
    
    private MediaPlayer mediaPlayer;
    
    public  AudioClip click = new AudioClip(getClass().getResource("/video/mouseclick.mp3").toString());
     /* switch secene from main to homepage */
    public void ShangeScreenButtonPushed( ActionEvent event) throws IOException{
        click.play();
        
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLHomepage.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }
    /*change screen from home to main*/
    public void ShangeScreenButtonPushed1( ActionEvent event) throws IOException{
        click.play();
        
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }
    /*change screen from home to log in*/
    public void ShangeScreenButtonPushed2( ActionEvent event) throws IOException{
        click.play();
        
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }
    /*change screen from home to sing up*/
    public void ShangeScreenButtonPushed3( ActionEvent event) throws IOException{
        click.play();
        
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLsingup.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }
    @FXML 
    public void gustmousebtnenter(MouseEvent e){
    
     gustbtn.setScaleX(gustbtn.getScaleX()+0.1);
     gustbtn.setScaleY(gustbtn.getScaleY()+0.1);
     
       
    }
    @FXML 
    public void gustmousebtnexit(MouseEvent e){

    
     gustbtn.setScaleX(gustbtn.getScaleX()-0.1);
     gustbtn.setScaleY(gustbtn.getScaleY()-0.1);
      
    }
     @FXML 
    public void singupmousebtnenter(MouseEvent e){
    
     singinbtn.setScaleX(singinbtn.getScaleX()+0.1);
     singinbtn.setScaleY(singinbtn.getScaleY()+0.1);
     
       
    }
    @FXML 
    public void singupmousebtnexit(MouseEvent e){

    
     singinbtn.setScaleX(singinbtn.getScaleX()-0.1);
     singinbtn.setScaleY(singinbtn.getScaleY()-0.1);
      
    }
     @FXML 
    public void loginmousebtnenter(MouseEvent e){
    
     loginbtn.setScaleX(loginbtn.getScaleX()+0.1);
     loginbtn.setScaleY(loginbtn.getScaleY()+0.1);
     
       
    }
    @FXML 
    public void loginmousebtnexit(MouseEvent e){

    
     loginbtn.setScaleX(loginbtn.getScaleX()-0.1);
     loginbtn.setScaleY(loginbtn.getScaleY()-0.1);
      
    }
    
    @FXML
    private void btnsetting(ActionEvent event) throws IOException{
        click.play();
        
       AnchorPane view = FXMLLoader.load(getClass().getResource("FXMLsetting.fxml"));
       pane.setCenter(view);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String MEDIA_URL4 = "/video/Background .mp4";
         mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL4).toExternalForm()));
         mediaPlayer.setAutoPlay(true);
         media.setMediaPlayer(mediaPlayer);
    }    
    
}
