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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import javafx.scene.media.AudioClip;

/**
 * FXML Controller class
 *
 * @author omar
 */
public class FXMLgame2Controller implements Initializable {

    @FXML
    private Label label;
    @FXML
    private ImageView image;
    @FXML
    private ImageView imc1;

    @FXML
    private ImageView imc4;

    @FXML
    private ImageView imc2;

    @FXML
    private ImageView imc3;
    @FXML
    private Button bunext;

    @FXML
    private Label scoretext;

    @FXML
    private ImageView image2;
    @FXML
    private AnchorPane scene;

    @FXML
    static int score1;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image3;

    public AudioClip exe = new AudioClip(getClass().getResource("/video/excellent.mp3").toString());
    public AudioClip fail = new AudioClip(getClass().getResource("/video/fail.mp3").toString());
    public AudioClip adScore = new AudioClip(getClass().getResource("/video/score.mp3").toString());
    public AudioClip end = new AudioClip(getClass().getResource("/video/finsh.mp3").toString());
    public AudioClip click = new AudioClip(getClass().getResource("/video/mouseclick.mp3").toString());
    public AudioClip clap = new AudioClip(getClass().getResource("/video/clapss.mp3").toString());
    public AudioClip backgroundmusic = new AudioClip(getClass().getResource("/video/backgroundmusic.mp3").toString());

    public void ShangeScreenButtonPushed(ActionEvent event) throws IOException {
        //backgroundmusic.play();
        click.play();
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt);

        //Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

        double deltaX = 1;
        double deltaY = 1;

        @Override
        public void handle(ActionEvent actionEvent) {
            imc3.setLayoutX(imc3.getLayoutX() + deltaX);
            imc3.setLayoutY(imc3.getLayoutY() + deltaY);

            Bounds bounds = scene.getBoundsInLocal();
//            boolean rightBorder = c1.getLayoutX() >= (bounds.getMaxX() - c1.getRadius());
//            boolean leftBorder = c1.getLayoutX() <= (bounds.getMinX() + c1.getRadius());
//            boolean bottomBorder = c1.getLayoutY() >= (bounds.getMaxY() -c1.getRadius());
//            boolean topBorder = c1.getLayoutY() <= (bounds.getMinY() + c1.getRadius());
            boolean rightBorder = imc3.getLayoutX() >= 300;
            boolean leftBorder = imc3.getLayoutX() <= 100;
            boolean bottomBorder = imc3.getLayoutY() >= 200;
            boolean topBorder = imc3.getLayoutY() <= 64;

            if (rightBorder || leftBorder) {
                deltaX *= -1;
            }
            if (bottomBorder || topBorder) {
                deltaY *= -1;
            }
        }
    }));

    //******c2
    Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

        double deltaX2 = 1;
        double deltaY2 = 1;

        @Override
        public void handle(ActionEvent actionEvent) {
            imc2.setLayoutX(imc2.getLayoutX() + deltaX2);
            imc2.setLayoutY(imc2.getLayoutY() + deltaY2);

            Bounds bounds = scene.getBoundsInLocal();
            boolean rightBorder = imc2.getLayoutX() >= 400;//525;
            boolean leftBorder = imc2.getLayoutX() <= 200;
            boolean bottomBorder = imc2.getLayoutY() >= 1000;
            boolean topBorder = imc2.getLayoutY() <= 200;

            if (rightBorder || leftBorder) {
                deltaX2 *= -1;
            }
            if (bottomBorder || topBorder) {
                deltaY2 *= -1;
            }
        }
    }));

    Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

        double deltaX2 = 1;
        double deltaY2 = 1;

        @Override
        public void handle(ActionEvent actionEvent) {
            imc1.setLayoutX(imc1.getLayoutX() + deltaX2);
            imc1.setLayoutY(imc1.getLayoutY() + deltaY2);

            Bounds bounds = scene.getBoundsInLocal();
            boolean rightBorder = imc1.getLayoutX() >= 750;
            boolean leftBorder = imc1.getLayoutX() <= 100;
            boolean bottomBorder = imc1.getLayoutY() >= 350;
            boolean topBorder = imc1.getLayoutY() <= 100;

            if (rightBorder || leftBorder) {
                deltaX2 *= -1;
            }
            if (bottomBorder || topBorder) {
                deltaY2 *= -1;
            }
        }
    }));

    Timeline timeline4 = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

        double deltaX2 = 1;
        double deltaY2 = 1;

        @Override
        public void handle(ActionEvent actionEvent) {
            imc4.setLayoutX(imc4.getLayoutX() + deltaX2);
            imc4.setLayoutY(imc4.getLayoutY() + deltaY2);

            Bounds bounds = scene.getBoundsInLocal();
            boolean rightBorder = imc4.getLayoutX() >= 780;
            boolean leftBorder = imc4.getLayoutX() <= 640;
            boolean bottomBorder = imc4.getLayoutY() >= 200;
            boolean topBorder = imc4.getLayoutY() <= 140;

            if (rightBorder || leftBorder) {
                deltaX2 *= -1;
            }
            if (bottomBorder || topBorder) {
                deltaY2 *= -1;
            }
        }
    }));

    @FXML

    void keypAction(KeyEvent event) {
        if (image.getOpacity() == 1) {
            if (event.getCode() == KeyCode.E) {

                label.setText("  Exllant! The Animal is 'Elephant' ");
                imc3.setOpacity(0);
                imc2.setOpacity(0);
                imc1.setOpacity(0);
                bunext.setOpacity(1);
                score1 += 10;
                scoretext.setText("Your score is :" + score1);
                exe.play();
                adScore.play();

                Session session = HibernateUtil.getSessionFactory().openSession();

            } else {
                label.setText(" OOps !! try ageen ");
                score1 -= 10;
                scoretext.setText("Your score is :" + score1);
                fail.play();
            }
        } else if (image.getOpacity() == 0 && image2.getOpacity() == 1) {
            if (event.getCode() == KeyCode.C) {
                label.setText("  Exllant! The Animal is 'Cat' ");
                imc3.setOpacity(0);
                imc2.setOpacity(0);
                imc4.setOpacity(0);
                bunext.setOpacity(1);
                score1 += 10;
                scoretext.setText("Your score is :" + score1);
                exe.play();
                adScore.play();
            } else {
                label.setText(" OOps !! try ageen ");
                score1 -= 10;
                scoretext.setText("Your score is :" + score1);
                fail.play();
            }
        } else if (image2.getOpacity() == 0 && image3.getOpacity() == 1) {
            if (event.getCode() == KeyCode.P) {
                label.setText("  Exllant! The Animal is 'Panda' ");
                imc3.setOpacity(0);
                imc1.setOpacity(0);
                imc4.setOpacity(0);
                bunext.setOpacity(1);
                score1 += 10;
                scoretext.setText("Your score is :" + score1);
                exe.play();
                adScore.play();

            } else {
                label.setText(" OOps !! try ageen ");
                score1 -= 10;
                scoretext.setText("Your score is :" + score1);
                fail.play();

            }
        } else if (image3.getOpacity() == 0 && image4.getOpacity() == 1) {
            if (event.getCode() == KeyCode.D) {
                label.setText("  Exllant! The Animal is 'Duck' ");
                imc2.setOpacity(0);
                imc1.setOpacity(0);
                imc4.setOpacity(0);
                bunext.setOpacity(1);
                score1 += 10;
                clap.play();
                scoretext.setText("Your score is :" + score1);

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
                System.out.println("user 1 is:" + s2.getUser_name());

            }
        }
    }

    @FXML
    void onAction(ActionEvent event
    ) {
///image4
        if (image.getOpacity() == 1) {
            label.setText(null);
            image.setOpacity(0);
            image2.setOpacity(1);
            imc3.setOpacity(1);
            imc2.setOpacity(1);
            imc1.setOpacity(1);
            bunext.setOpacity(0.41);
            click.play();
        } else if (image.getOpacity() == 0 && image2.getOpacity() == 1) {
            label.setText(null);
            image.setOpacity(0);
            image2.setOpacity(0);
            image3.setOpacity(1);
            imc3.setOpacity(1);
            imc2.setOpacity(1);
            imc4.setOpacity(1);
            bunext.setOpacity(0.41);
            click.play();
        } else if (image2.getOpacity() == 0 && image3.getOpacity() == 1) {
            label.setText(null);
            image2.setOpacity(0);
            image3.setOpacity(0);
            image4.setOpacity(1);
            imc3.setOpacity(1);
            imc2.setOpacity(1);
            imc1.setOpacity(1);
            imc4.setOpacity(1);
            bunext.setOpacity(0.41);
            click.play();
        }

//      Image image1 = new Image("png-transparent-cat-and-dog-drawing-animation-cartoon-pet-red-fox-orange-nose.png");
//    image.setImage(image1);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundmusic.stop();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
        timeline3.setCycleCount(Animation.INDEFINITE);
        timeline3.play();
        timeline4.setCycleCount(Animation.INDEFINITE);
        timeline4.play();

// c3.setFill(imgPattE);
//         c1.setFill(imgPattB);
//         c2.setFill(imgPattC);
        // TODO
    }

}
