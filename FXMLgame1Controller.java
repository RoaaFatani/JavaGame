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
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author omar
 */
public class FXMLgame1Controller implements Initializable {
   
    private static final int STARTTIME = 0;
    private Timeline timeline;
    private final IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    private final IntegerProperty timemin = new SimpleIntegerProperty(STARTTIME);

    @FXML
    private Label timerLabel;

    private void updateTime() {
        // increment seconds
        if (timeSeconds.get() < 59) {
            int seconds = timeSeconds.get();
            timeSeconds.set(seconds + 1);
        } else {
            updateTime1();
        }
    }

    private void updateTime1() {
        int min = timemin.get();
        timemin.set(min + 1);
        timeSeconds.set(0);
        updateTime();
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label labelsum,labelWrong,scoreInt,minn,time;
    @FXML
    private Button butt1b,butt7b,butt2b,butt3b,butt4b,butt5b,butt6b,buttnext,butt1level2,butt5level2,butt8level2,butt9level2,butt6level2,butt4level2
    ,butt7level2,butt2level2,butt2level3,butt3level3,butt3level2,buttdone,butthint;
    @FXML
    private RadioButton r3,r2,r4,r1,c3,c2,c1;
    @FXML
    private AnchorPane PrimryPane;
    @FXML
    private int score1;

    public int getScore1() {
        return score1;
    }
    
 
 /* switch secene from gamw1 to homepage */
   
    @FXML
    private Label hintlab;
    public AudioClip hintSound = new AudioClip(getClass().getResource("/video/FullSizeRender.mp3").toString());
    public AudioClip graet = new AudioClip(getClass().getResource("/video/great.mp3").toString());
    public AudioClip fail = new AudioClip(getClass().getResource("/video/fail.mp3").toString());
    public AudioClip adScore = new AudioClip(getClass().getResource("/video/score.mp3").toString());
    public AudioClip click = new AudioClip(getClass().getResource("/video/mouseclick.mp3").toString());
    public AudioClip end = new AudioClip(getClass().getResource("/video/finsh.mp3").toString());
    public AudioClip clap = new AudioClip(getClass().getResource("/video/clapss.mp3").toString());
        public AudioClip backgroundmusic = new AudioClip(getClass().getResource("/video/backgroundmusic.mp3").toString());
 public void ShangeScreenButtonPushed(ActionEvent event) throws IOException {
       // backgroundmusic.play();
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt);

        //Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }

   

    @FXML
    private void handlebutt1(ActionEvent event) {
        buttnext.setDisable(true);
        butt1b.setDisable(true);
        score1 += 10;
        graet.play();
        scoreInt.setText("Your score is : " + score1);
        labelWrong.setText("GOOD start");
    }

    @FXML
    private void handlebutt2(ActionEvent event) {
        if (butt1b.isDisable()== false) {
            labelWrong.setText("Oops!! choose a corect Number");
            score1 -= 10;
            fail.play();
            scoreInt.setText("Your score is : " + score1);
        }
        if (butt1b.isDisable() == true) {
            butt2b.setDisable(true);
            score1 += 10;
            graet.play();
            scoreInt.setText("Your score is : " + score1);
            labelWrong.setText("Exllant!");
        }
    }

    @FXML
    private void handlebutt3(ActionEvent event) {
        if (butt2b.isDisable() == false) {
            labelWrong.setText("Oops!! choose a corect Number");
            score1 -= 10;
            fail.play();
            scoreInt.setText("Your score is : " + score1);
        }

        if (butt2b.isDisable() == true) {
            butt3b.setDisable(true);
            score1 += 10;
            graet.play();
            scoreInt.setText("Your score is : " + score1);
            labelWrong.setText("yes!");
        }
    }

    @FXML
    private void handlebutt4(ActionEvent event) {
        if (butt3b.isDisable() == false) {
            labelWrong.setText("Oops!! choose a corect Number");
            score1 -= 10;
            fail.play();
            scoreInt.setText("Your score is : " + score1);
        }
        if (butt3b.isDisable() == true) {
            butt4b.setDisable(true);
            score1 += 10;
            graet.play();
            scoreInt.setText("Your score is : " + score1);
            labelWrong.setText("You are smart!");
        }

    }

    @FXML
    private void handlebutt5(ActionEvent event) {
        if (butt4b.isDisable() == false) {
            labelWrong.setText("Oops!! choose a corect Number");
            score1 -= 10;
            fail.play();
            scoreInt.setText("Your score is : " + score1);
        }
        if (butt4b.isDisable() == true) {
            butt5b.setDisable(true);
            score1 += 10;
            graet.play();
            scoreInt.setText("Your score is : " + score1);
            labelWrong.setText("Great!");
        }
    }

    @FXML
    private void handlebutt6(ActionEvent event) {
        if (butt5b.isDisable() == false) {
            labelWrong.setText("Oops!! choose a corect Number");
            score1 -= 10;
            fail.play();
            scoreInt.setText("Your score is : " + score1);
        }
        if (butt5b.isDisable() == true) {
            butt6b.setDisable(true);
            score1 += 10;
            graet.play();
            scoreInt.setText("Your score is : " + score1);
            labelWrong.setText("Very Exllant!");
        }
    }

    @FXML
    private void handlebutt7(ActionEvent event) {
        if (butt6b.isDisable() == false) {
            labelWrong.setText("Oops!! choose a corect Number");
            score1 -= 10;
            fail.play();
            scoreInt.setText("Your score is : " + score1);
        }
        if (butt6b.isDisable() == true) {
            butt7b.setDisable(true);
            score1 += 10;
            graet.play();
            scoreInt.setText("Your score is : " + score1);
            labelWrong.setText("Great jop! We are done");
            buttnext.setDisable(false);
        }
    }

    @FXML
    private void handlebutt1level2(ActionEvent event) {
        butt1level2.setDisable(true);
        score1 += 10;
        graet.play();
        scoreInt.setText("Your score is : " + score1);
        labelWrong.setText("Exllant!");
        if (butt3level2.isDisable() == true && butt7level2.isDisable() == true && butt9level2.isDisable() == true && butt5level2.isDisable() == true) {
            buttnext.setDisable(false);
        }
    }

    @FXML
    private void handlebutt2level2(ActionEvent event) {

        labelWrong.setText("Oops!! choose a corect Number");
        score1 -= 10;
        scoreInt.setText("Your score is : " + score1);
        fail.play();
    }

    @FXML
    private void handlebutt3level2(ActionEvent event) {
        butt3level2.setDisable(true);
        score1 += 10;
        graet.play();
        scoreInt.setText("Your score is : " + score1);
        labelWrong.setText("Exllant!");
        if (butt9level2.isDisable() == true && butt7level2.isDisable() == true && butt1level2.isDisable() == true && butt5level2.isDisable() == true) {
            buttnext.setDisable(false);
        }
    }

    @FXML
    private void handlebutt4level2(ActionEvent event) {
        labelWrong.setText("Oops!! choose a corect Number");
        score1 -= 10;
        fail.play();
        scoreInt.setText("Your score is : " + score1);
    }

    @FXML
    private void handlebutt5level2(ActionEvent event) {
        butt5level2.setDisable(true);
        score1 += 10;
        graet.play();
        scoreInt.setText("Your score is : " + score1);
        labelWrong.setText("Exllant!");
        if (butt3level2.isDisable() == true && butt7level2.isDisable() == true && butt1level2.isDisable() == true && butt9level2.isDisable() == true) {
            buttnext.setDisable(false);
        }
    }

    @FXML
    private void handlebutt6level2(ActionEvent event) {
        labelWrong.setText("Oops!! choose a corect Number");
        score1 -= 10;
        fail.play();
        scoreInt.setText("Your score is : " + score1);
    }

    @FXML
    private void handlebutt7level2(ActionEvent event) {
        butt7level2.setDisable(true);
        score1 += 10;
        graet.play();
        scoreInt.setText("Your score is : " + score1);
        labelWrong.setText("Exllant!");
        if (butt3level2.isDisable() == true && butt9level2.isDisable() == true && butt1level2.isDisable() == true && butt5level2.isDisable() == true) {
            buttnext.setDisable(false);
        }
    }

    @FXML
    private void handlebutt8level2(ActionEvent event) {
        labelWrong.setText("Oops!! choose a corect Number");
        score1 -= 10;
        fail.play();
        scoreInt.setText("Your score is : " + score1);
    }

    @FXML
    private void handlebutt9level2(ActionEvent event) {

        butt9level2.setDisable(true);
        score1 += 10;
        graet.play();
        scoreInt.setText("Your score is : " + score1);
        labelWrong.setText("Exllant!");
        if (butt3level2.isDisable() == true && butt7level2.isDisable() == true && butt1level2.isDisable() == true && butt5level2.isDisable() == true) {
            buttnext.setDisable(false);
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (buttnext.isDisable() == false && butt1b.isVisible() == true) {
            labelWrong.setText("click the buttons with 'ODD NUMBER' ");
            buttnext.setDisable(true);
            butt1b.setVisible(false);
            butt2b.setVisible(false);
            butt3b.setVisible(false);
            butt4b.setVisible(false);
            butt5b.setVisible(false);
            butt6b.setVisible(false);
            butt7b.setVisible(false);
            butt1level2.setVisible(true);
            butt2level2.setVisible(true);
            butt3level2.setVisible(true);
            butt4level2.setVisible(true);
            butt5level2.setVisible(true);
            butt6level2.setVisible(true);
            butt7level2.setVisible(true);
            butt8level2.setVisible(true);
            butt9level2.setVisible(true);
        } else {
            labelWrong.setText("choose one row and colume that have same sumition ");
            hintlab.setVisible(true);
            buttnext.setDisable(true);
            buttdone.setVisible(true);
            butt1level2.setVisible(false);
            butt2level2.setVisible(false);
            butt3level2.setVisible(false);
            butt4level2.setVisible(false);
            butt5level2.setVisible(false);
            butt6level2.setVisible(false);
            butt7level2.setVisible(false);
            butt8level2.setVisible(false);
            butt9level2.setVisible(false);
            butt1level2.setVisible(true);
            butt2level2.setVisible(true);
            butt2level2.setText("3");
            butt3level2.setVisible(true);
            butt4level2.setVisible(true);
            butt4level2.setText("5");
            butt5level2.setVisible(true);
            butt5level2.setText("0");

            butt6level2.setVisible(true);
            butt6level2.setText("1");
            butt7level2.setVisible(true);
            butt7level2.setText("4");
            butt8level2.setVisible(true);
            butt8level2.setText("1");
            butt9level2.setVisible(true);
            butt9level2.setText("0");
            butt2level3.setVisible(true);
            butt3level3.setVisible(true);
            butt5b.setVisible(true);
            butt5b.setText("1");

            c1.setVisible(true);
            c2.setVisible(true);
            c3.setVisible(true);
            r1.setVisible(true);
            r2.setVisible(true);
            r3.setVisible(true);
            r4.setVisible(true);

            butt1level2.setDisable(false);
            butt2level2.setDisable(false);
            butt3level2.setDisable(false);
            butt4level2.setDisable(false);
            butt5level2.setDisable(false);
            butt6level2.setDisable(false);
            butt7level2.setDisable(false);
            butt8level2.setDisable(false);
            butt9level2.setDisable(false);
            butt5b.setDisable(false);

            if (buttnext.isDisable() == true) {
                FXMLDocumentController nme = new FXMLDocumentController();
                nme.bigStarState(nme.starstate1);
            }
        }

    }

    @FXML
    private void handleRadio(ActionEvent event) {
        if ((r1.isSelected() || r2.isSelected() || r3.isSelected() || r4.isSelected()) && (c1.isSelected() || c2.isSelected() || c3.isSelected())) {
            labelWrong.setText("click done !");
        } else if (r1.isSelected() || r2.isSelected() || r3.isSelected() || r4.isSelected()) {
            labelWrong.setText("choose one of colum");
        } else {
            // c1.isSelected() || c2.isSelected() || c3.isSelected()
            labelWrong.setText("choose one of row");
        }

    }
       public void hintMethod(ActionEvent event) {
        if(buttdone.isVisible()==true){
           hintSound.play();  
        }
       
    }

    @FXML
    private void handledone(ActionEvent event) {
        if (r4.isSelected() && c2.isSelected()) {
            labelWrong.setText("GOOD JOP!");
            labelsum.setVisible(true);
            buttdone.setVisible(false);
            butt1level2.setDisable(true);
            butt8level2.setDisable(true);
            butt2level3.setDisable(true);
            butt5level2.setDisable(true);
            butt6level2.setDisable(true);
            butt4level2.setDisable(true);
            r1.setDisable(true);
            r2.setDisable(true);
            r3.setDisable(true);
            c1.setDisable(true);
            c3.setDisable(true);

            score1 += 10;
            clap.play(); 
             Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String queryp2 = "from scoretable";
            Query query1 = session.createQuery(queryp2);
            List<scoretable> list = null;
            list = query1.list();
            session.close();
            //for id 
            int i = 0;
            //for score
            int sclast = 0;

            for (scoretable sc : list) {
                if (sc.getUser_name().equals(globalUser.username)) {
                    i = sc.getId();
                    sclast = sc.getScore();

                }
            }
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            session1.beginTransaction();
            scoretable s2 = null;
            int sid = i;
            s2 = (scoretable) session1.get(scoretable.class, sid);
            s2.setScore(sclast + score1);
            session1.getTransaction().commit();
            session1.close();
            System.out.println("user  is:" + s2.getUser_name());
            
        } else {
            labelWrong.setText("UNCORECT answer ! choose another");
            score1 -= 10;
            fail.play(); 
           
        }
           
    }

 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //backgroundmusic.stop();
        time.textProperty().bind(timeSeconds.asString());
        minn.textProperty().bind(timemin.asString());

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> updateTime()));
        timeline.setCycleCount(Animation.INDEFINITE); // repeat over and over again
        timeSeconds.set(STARTTIME);
        timemin.set(STARTTIME);
        timeline.play();
    }

}
