/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlbraino;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import org.hibernate.Query;

import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author omar
 */
public class FXMLsettingController implements Initializable {

  
    
    public  AudioClip click = new AudioClip(getClass().getResource("/video/mouseclick.mp3").toString());
    @FXML
    private Label emaillable;
    
    @FXML
    private Label namelabel;
    @FXML
    private Label scorelable;

    
    @FXML
    private Button homesetting;
    @FXML
    private ImageView soundsetting;
    @FXML
    private ImageView questhionsetting;
    
    java.io.File file = new java.io.File("set.txt");
    PrintWriter output;
    @FXML
    private Label emaillable1;
    @FXML
    private Label msg;
    @FXML
    private Hyperlink creatacount;
    
    public void scaleUp(Node node){
     node.setScaleX(node.getScaleX()+0.1);
     node.setScaleY(node.getScaleY()+0.1); 
    }
    
     public void scaleDown(Node node){
     node.setScaleX(node.getScaleX()-0.1);
     node.setScaleY(node.getScaleY()-0.1); 
    }
    
    
    @FXML
    public void homemousebtnenter(MouseEvent e){
    
     scaleUp(homesetting);
       
    }
    @FXML
    public void homemousebtnexit(MouseEvent e){

    scaleDown(homesetting);
      
    }
    @FXML
    public void soundmousebtnenter(MouseEvent e){
    
     scaleUp(soundsetting);
       
    }
    @FXML
    public void soundmousebtnexit(MouseEvent e){

    scaleDown(soundsetting);
      
    }
    @FXML
    public void quesmousebtnenter(MouseEvent e){
    
     scaleUp(questhionsetting);
       
    }
    @FXML
    public void quemousebtnexit(MouseEvent e){

    scaleDown(questhionsetting);
      
    }
    
    /*change screen from setting to main*/
    @FXML
    public void ShangeScreenButtonPushed1( ActionEvent event) throws IOException{
        click.play();
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }
    @FXML
    public void Soundclick( MouseEvent  event) throws IOException {
        click.play();
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLPrecntege.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
       
    }
    
    @FXML
    public void Quesclick( MouseEvent  event) {
            click.play();
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<user> list = null;
            String queryp = "from user";
            Query query = session.createQuery(queryp);
            boolean s = false;
            list = query.list();
            session.close();
            try {
            output = new PrintWriter(file);
            for (user userdata:list) {
               if(userdata.getUser_name().equals(globalUser.username)){
                output.append("User Name:" + userdata.getUser_name()+" " + "Email:" +userdata.getEmail()+" " + "Password:" +" " + userdata.getPassword() );
                output.println();
               }
            } output.close();
            }catch (java.io.IOException ex) {
                System.out.println(ex.toString());
                System.out.println("unfinding");
            
            }
            

        
    }
    @FXML
    public void CreatAccount( ActionEvent event) throws IOException{
        click.play();
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLsingup.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }
    
    @FXML
    public void creatAccountenter(MouseEvent e){
    
     scaleUp(msg);
     
    }
    @FXML
    public void creatAccountexit(MouseEvent e){

    scaleDown(msg);
     
    }
   
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {

try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<user> list = null;
            String queryp = "from user";
            Query query = session.createQuery(queryp);
            boolean s = false;
            list = query.list();
            
            
            
            for (user userdata:list) {
                
               if(userdata.getUser_name().equals(globalUser.username)){
                namelabel.setText(userdata.getUser_name());
                emaillable.setText(userdata.getEmail());
                //scorelable.setText(userdata.getPassword());
                s = true;
                break;
               }
               
               
               
            }
            if (s == false ){
                 msg.setText("You don't have account");
            }
            session.close();
            

            } catch (Exception e) {
                System.out.println("eror");
                
            }
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<scoretable> list = null;
            String queryp = "from scoretable";
            Query query = session.createQuery(queryp);
            boolean s = false;
            list = query.list();
            
            
            
            for (scoretable userscore:list) {
                
               if(userscore.getUser_name().equals(globalUser.username)){
                scorelable.setText(Integer.toString(userscore.getScore()));
               }
            }session.close();
            

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }}}
