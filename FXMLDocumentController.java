/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlbraino;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author omar
 */
public class FXMLDocumentController extends FXMLsingupController implements Initializable {
    static public String user_name; 
    @FXML
    private  ImageView imgGirl;
    @FXML 
    private ImageView start;
    @FXML 
    private ImageView Giraffe;
    private ImageView opentreasure;
    @FXML 
    private ImageView closetreasure;
    @FXML 
    public ImageView starstate1;
    @FXML 
    private ImageView starstate2;
    
    @FXML 
    private Button home;
    @FXML 
    private Button setting;
    @FXML
    private Button starlevel;
    @FXML
    private Button scorebtn;
    @FXML
    private BorderPane pane;
    public  AudioClip click = new AudioClip(getClass().getResource("/video/mouseclick.mp3").toString());
    public  AudioClip stateClick = new AudioClip(getClass().getResource("/video/gameState.mp3").toString());
    public AudioClip hi = new AudioClip(getClass().getResource("/video/soundhi.mp3").toString());

    @FXML
    private Label scorelable;
    
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
    public void midals(ActionEvent event) throws IOException {
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLmidals.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }
      @FXML 
    public void homemousebtnenter(MouseEvent e){
    
     home.setScaleX(home.getScaleX()+0.1);
     home.setScaleY(home.getScaleY()+0.1);
     
       
    }
    @FXML 
    public void homemousebtnexit(MouseEvent e){

    
     home.setScaleX(home.getScaleX()-0.1);
     home.setScaleY(home.getScaleY()-0.1);
      
    }
     /* switch secene from main to game1 */
    @FXML
    public void ShangeScreenButtonPushedgame1( ActionEvent event) throws IOException{
        stateClick.play();
        

        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLgame1.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();

//      bigStarState(starstate1);

//      girlmove(imgGirl,-10,-300);
    }
    /* switch secene from main to game1 */
    @FXML
    public void ShangeScreenButtonPushedgame2( ActionEvent event) throws IOException{
        stateClick.play();
        
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLgame2.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
        //bigStarState(starstate2);
//       girlmove(imgGirl,-530,-50);
        
        
    }
    
    @FXML
        public void ShangeScreenButtonPushedgame3( ActionEvent event) throws IOException{
        stateClick.play();
        
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLgame3.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
        
        //Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
        //bigStarState(starstate2);
//       girlmove(imgGirl,-530,-50);
        
        
    }
    @FXML
     public void ShangeScreenButtonPushedWin( ActionEvent event) throws IOException{
         click.play();
        
       pane.setVisible(true);

       AnchorPane view = FXMLLoader.load(getClass().getResource("FXMLWin.fxml"));
       pane.setCenter(view);   
    }
    
    @FXML
    private void btnsetting(ActionEvent event) throws IOException{
        click.play();
        
        pane.setVisible(true);
       AnchorPane view = FXMLLoader.load(getClass().getResource("FXMLsetting.fxml"));
       pane.setCenter(view);
    }
      @FXML 
    public void settingmousebtnenter(MouseEvent e){
    
     setting.setScaleX(setting.getScaleX()+0.1);
     setting.setScaleY(setting.getScaleY()+0.1);
     
       
    }
    @FXML 
    public void settingmousebtnexit(MouseEvent e){

    
     setting.setScaleX(setting.getScaleX()-0.1);
     setting.setScaleY(setting.getScaleY()-0.1);
      
    }
    /*Starlevel*/
        @FXML 
    public void starlevelmousebtnenter(MouseEvent e){
    
     starlevel.setScaleX(starlevel.getScaleX()+0.1);
     starlevel.setScaleY(starlevel.getScaleY()+0.1);
     
       
    }
    @FXML 
    public void starlevelmousebtnexit(MouseEvent e){

    
     starlevel.setScaleX(starlevel.getScaleX()-0.1);
     starlevel.setScaleY(starlevel.getScaleY()-0.1);
      
    }
    /*score*/
        @FXML 
    public void scoremousebtnenter(MouseEvent e){
    
     scorebtn.setScaleX(scorebtn.getScaleX()+0.1);
     scorebtn.setScaleY(scorebtn.getScaleY()+0.1);
     
       
    }
    @FXML 
    public void scoremousebtnexit(MouseEvent e){

    
     scorebtn.setScaleX(scorebtn.getScaleX()-0.1);
     scorebtn.setScaleY(scorebtn.getScaleY()-0.1);
      
    }

    private void movestart (Node node ) {
        RotateTransition startrotate = new RotateTransition();
        startrotate.setNode(node);
        startrotate.setDuration(Duration.millis(1500));
        startrotate.setCycleCount(500);
        startrotate.setByAngle(360);
        startrotate.setAxis(Rotate.Y_AXIS);
        startrotate.play();
    }
    private void movefading (Node node ) {
        FadeTransition Giraffefade = new FadeTransition();
        Giraffefade.setNode(node);
        Giraffefade.setDuration(Duration.millis(2000));
        Giraffefade.setCycleCount(TranslateTransition.INDEFINITE);
        Giraffefade.setInterpolator(Interpolator.LINEAR);
        Giraffefade.setFromValue(1);
        Giraffefade.setToValue(0);
        Giraffefade.play();
    }
    public void bigStarState(Node node){
        ScaleTransition starbigger = new ScaleTransition();
        starbigger.setNode(node);
        starbigger.setDuration(Duration.millis(2000));
        starbigger.setCycleCount(1);
        starbigger.setInterpolator(Interpolator.LINEAR);
        starbigger.setByX(5.0);
        starbigger.setByY(5.0);
        starbigger.play();
    }
    public void girlmove(Node node,int x ,int y){
        TranslateTransition girlmoving = new TranslateTransition();
        girlmoving.setNode(node);
        girlmoving.setDuration(Duration.millis(1000));
        girlmoving.setCycleCount(1);
        girlmoving.setByX(x);
        girlmoving.setByY(y);
        girlmoving.play();
    }
    
   
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        if(globalUser.score1==0){
//        hi.play();
//        }
        movestart(start);
        //moveGiraffe(Giraffe);
        movefading(opentreasure);
        movefading(closetreasure);
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
            }
       
    
    }    
    
}
