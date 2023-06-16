/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlbraino;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import org.hibernate.Query;
import org.hibernate.Session;

public class FXMLgame3_1Controller implements Initializable {
    @FXML
    private Button btHome;
    @FXML
    private Button btNext;

    @FXML
    private Label lbMsg;
    @FXML
    private Circle circle;
    @FXML
    private Polygon poly;
    @FXML
    private Rectangle square;
    @FXML
    private Button c1;
    @FXML
    private Button c2;
    @FXML
    private Button c3;
    @FXML
    private Button c4;
    @FXML
    private Button c5;
    @FXML
    private Button c6;
    @FXML
    private Button c7;
    @FXML
    private Button c8;
    @FXML
    private Button c9;
    @FXML
    private Label scoreMsg;
//    @FXML
    FXMLgame3Controller sc;
    public int score = sc.getScore();
    @FXML
    private VBox hboxPoly;
    @FXML
    private VBox hboxSquare;
    @FXML
    private VBox hboxCircle;


    public AudioClip exe = new AudioClip(getClass().getResource("/video/excellent.mp3").toString());
    public AudioClip fail = new AudioClip(getClass().getResource("/video/fail.mp3").toString());
    public AudioClip adScore = new AudioClip(getClass().getResource("/video/score.mp3").toString());
    public AudioClip end = new AudioClip(getClass().getResource("/video/finsh.mp3").toString());
    public AudioClip click = new AudioClip(getClass().getResource("/video/mouseclick.mp3").toString());
    public AudioClip clap = new AudioClip(getClass().getResource("/video/clapss.mp3").toString());
    public AudioClip backgroundmusic = new AudioClip(getClass().getResource("/video/backgroundmusic.mp3").toString());

  public void ShangeScreenButtonPushed(ActionEvent event) throws IOException {
       // backgroundmusic.play();
        click.play();
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt);

        //Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        c1.setOnAction(e -> {
            lbMsg.setText("Wrong Choice!");
            lbMsg.setTextFill(Color.rgb(255, 77, 77));
            circle.setFill(Color.WHITE);
            score -= 10;
            scoreMsg.setText("Your score is : " + score);
            fail.play();
        });
        c2.setOnAction(e -> {
            lbMsg.setText("Excellent!");
            lbMsg.setTextFill(Color.rgb(156, 231, 168));
            circle.setFill(Color.rgb(181, 209, 161));
            score += 10;
            scoreMsg.setText("Your score is : " + score);
            hboxPoly.setDisable(false);
            exe.play();
            adScore.play();
        });
        c3.setOnAction(e -> {
            lbMsg.setText("Wrong Choice!");
            lbMsg.setTextFill(Color.rgb(255, 77, 77));
            circle.setFill(Color.WHITE);
            score -= 10;
            scoreMsg.setText("Your score is : " + score);
            fail.play();

        });

        c4.setOnAction(e -> {
            lbMsg.setText("Excellent!");
            lbMsg.setTextFill(Color.rgb(156, 231, 168));
            poly.setFill(Color.rgb(230, 188, 230));
            score += 10;
            scoreMsg.setText("Your score is : " + score);
            hboxSquare.setDisable(false);
            exe.play();
            adScore.play();

        });
        c5.setOnAction(e -> {
            lbMsg.setText("Wrong Choice!");
            lbMsg.setTextFill(Color.rgb(255, 77, 77));
            poly.setFill(Color.WHITE);
            score -= 10;
            scoreMsg.setText("Your score is : " + score);
            fail.play();

        });
        c6.setOnAction(e -> {
            lbMsg.setText("Wrong Choice!");
            lbMsg.setTextFill(Color.rgb(255, 77, 77));
            poly.setFill(Color.WHITE);
            score -= 10;
            scoreMsg.setText("Your score is : " + score);
            fail.play();

        });
        c7.setOnAction(e -> {
            lbMsg.setText("Excellent!");
            lbMsg.setTextFill(Color.rgb(156, 231, 168));
            square.setFill(Color.rgb(159, 167, 245));
            score += 10;
            scoreMsg.setText("Your score is : " + score);
            exe.play();
            adScore.play();
            end.play();
            clap.play();
          //  btHome.setDisable(false);

        });
        c8.setOnAction(e -> {
            lbMsg.setText("Wrong Choice!");
            lbMsg.setTextFill(Color.rgb(255, 77, 77));
            square.setFill(Color.WHITE);
            score -= 10;
            scoreMsg.setText("Your score is : " + score);
            fail.play();

        });
        c9.setOnAction(e -> {
            lbMsg.setText("Wrong Choice!");
            lbMsg.setTextFill(Color.rgb(255, 77, 77));
            square.setFill(Color.WHITE);
            score -= 10;
            scoreMsg.setText("Your score is : " + score);
            fail.play();
            
           
        });
                    Session session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           String queryp2 = "from scoretable";
           Query query1 = session.createQuery(queryp2);
           List<scoretable> list = null;
           list = query1.list();
           session.close();
           //for id 
           int i=0;
           //for score
           int sclast=0;
             
            for (scoretable sc : list) {
                if(sc.getUser_name().equals(globalUser.username)){
                    i=sc.getId();
                    sclast=sc.getScore();
                    
                }
            }
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            session1.beginTransaction();
            scoretable s2 = null;
            int sid = i;
            s2 = (scoretable) session1.get(scoretable.class, sid);
            s2.setScore(sclast+score);
            session1.getTransaction().commit();
            session1.close();
            System.out.println("user  is:" + s2.getUser_name());
          
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // backgroundmusic.stop();
    }
}
    

