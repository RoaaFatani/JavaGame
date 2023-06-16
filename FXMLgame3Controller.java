/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.javafxfxmlbraino
 */
package javafxfxmlbraino;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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


public class FXMLgame3Controller implements Initializable {

    @FXML
    private Label scoreMsg;
    @FXML
    public static int score;
    //next Level
    @FXML
    private ChoiceBox<String> chkBox;
    @FXML
    private Button btNext;
    @FXML
    private Label lbMsgResult;
//ree Shap
    @FXML
    private Rectangle sqTree;
    @FXML
    private Polygon tngTreeTop;
    @FXML
    private Polygon tngTreeCenter;
    @FXML
    private Polygon tngTreeBottom;
    @FXML
    private Label lbMsgTree;
//Sun 
    @FXML
    private Circle cirSun;
    @FXML
    private Label lbMsgSun;
//house Shap
    @FXML
    private Rectangle sqHouse;
    @FXML
    private Label lbMsgSqHouse;
    @FXML
    private Rectangle sqHouseDoor;
    @FXML
    private Label lbMsgSqHouseDoor;
    @FXML
    private Polygon tngHouseRoof;
    @FXML
    private Label lbMsgTngHouseRoof;
    @FXML
    private Circle cirWinL;
    @FXML
    private Circle cirWinR;
    @FXML
    private Label lbMsgCirWin;
//    //cloud Shap
    @FXML
    private Circle cirCloud1;
    @FXML
    private Circle cirCloud2;
    @FXML
    private Circle cirCloud3;
    @FXML
    private Circle cirCloud4;
    @FXML
    private Rectangle sqCloud1;
    @FXML
    private Rectangle sqCloud2;
    @FXML
    private Label lbMsgCloud;

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        FXMLgame3Controller.score = score;
    }

    public AudioClip graet = new AudioClip(getClass().getResource("/video/greatt.mp3").toString());
    public AudioClip fail = new AudioClip(getClass().getResource("/video/fail.mp3").toString());
    public AudioClip adScore = new AudioClip(getClass().getResource("/video/score.mp3").toString());
    public AudioClip click = new AudioClip(getClass().getResource("/video/mouseclick.mp3").toString());
    public AudioClip end = new AudioClip(getClass().getResource("/video/finsh.mp3").toString());
    public AudioClip clap = new AudioClip(getClass().getResource("/video/clapss.mp3").toString());
    public AudioClip backgroundmusic = new AudioClip(getClass().getResource("/video/backgroundmusic.mp3").toString());


  

    @FXML
    public void ShangeScreenButtonNext(ActionEvent event) throws IOException {
        click.play();
        //backgroundmusic.play();
        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLgame3_1.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt);

        //Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //backgroundmusic.stop();

        ObservableList<String> ckList= FXCollections.observableArrayList("13", "22", "25");
        chkBox.setItems(ckList);
        chkBox.setValue("22");
        chkBox.setOnAction(e -> {

            switch (chkBox.getValue()) { //switch
                //tree
                case "13":
                    lbMsgTree.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                case "22":
                    lbMsgTree.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                case "25":
                    sqTree.setFill(Color.web("#70542d"));
                    tngTreeTop.setFill(Color.web("#74bc7a"));
                    tngTreeCenter.setFill(Color.web("#62aa69"));
                    tngTreeBottom.setFill(Color.web("#62aa69"));
                    lbMsgTree.setOpacity(0);
                    lbMsgResult.setText("Graet");
                    lbMsgResult.setTextFill(Color.web("#0b770b"));   
                    lbMsgSun.setOpacity(1);
                    ckList.addAll("3", "0", "2");
                    ckList.remove(0, 3);
                    score += 10;
                    scoreMsg.setText("Your score is : " + score);
                    graet.play();
                    adScore.play();
                    break;
                //sun
                case "3":
                    lbMsgSun.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   

                    fail.play();
                    break;
                case "0":
                    cirSun.setFill(Color.web("#fff480"));
                    lbMsgSun.setOpacity(0);
                    lbMsgResult.setText("Graet");
                    lbMsgResult.setTextFill(Color.web("#0b770b"));   
                    lbMsgCloud.setOpacity(1);
               
                    ckList.addAll("1", "-2", "-1");
                    ckList.remove(0, 3);
                    score += 10;
                    scoreMsg.setText("Your score is : " + score);
                    graet.play();
                    adScore.play();
                    break;
                case "2":
                    lbMsgSun.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                     lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                //cloud
                case "1":
                    sqCloud1.setFill(Color.web("#a3e0ff"));
                    cirCloud1.setFill(Color.web("#a3e0ff"));
                    cirCloud2.setFill(Color.web("#a3e0ff"));
                    sqCloud2.setFill(Color.web("#a3e0ff"));
                    cirCloud3.setFill(Color.web("#a3e0ff"));
                    cirCloud4.setFill(Color.web("#a3e0ff"));
                    lbMsgResult.setText("Graet");
                    lbMsgResult.setTextFill(Color.web("#0b770b"));   
                    lbMsgCloud.setOpacity(0);
                    lbMsgTngHouseRoof.setOpacity(1);
                    ckList.addAll("98", "99", "101");
                    ckList.remove(0, 3);
                    score += 10;
                    scoreMsg.setText("Your score is : " + score);
                    graet.play();
                    adScore.play();
                    break;
                case "-2":
                    lbMsgCloud.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                case "-1":
                    lbMsgCloud.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                //roof
                case "101":
                    lbMsgTngHouseRoof.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   

                    fail.play();
                    break;
                case "98":
                    lbMsgTngHouseRoof.setOpacity(1);
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setText("Try Again");
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                case "99":
                    tngHouseRoof.setFill(Color.web("#e24848"));
                    lbMsgResult.setText("Graet");
                    lbMsgResult.setTextFill(Color.web("#0b770b"));         
                    lbMsgTngHouseRoof.setOpacity(0);
                    lbMsgCirWin.setOpacity(1);
                    ckList.addAll("11", "9", "10");
                    ckList.remove(0, 3);
                    score += 10;
                    scoreMsg.setText("Your score is : " + score);
                    graet.play();
                    adScore.play();
                    break;
                //windos   
                case "11":
                    lbMsgCirWin.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                case "9":
                    lbMsgCirWin.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                case "10":
                    cirWinL.setFill(Color.web("#539ec3"));
                    cirWinR.setFill(Color.web("#539ec3"));
                    lbMsgResult.setText("Graet");
                    lbMsgResult.setTextFill(Color.web("#0b770b"));   
                    lbMsgCirWin.setOpacity(0);
                    lbMsgSqHouse.setOpacity(1);
                 
                    ckList.addAll("40", "20", "80");
                    ckList.remove(0, 3);
                    score += 10;
                    scoreMsg.setText("Your score is : " + score);
                    graet.play();
                    adScore.play();
                    break;
                //House     
                case "40":
                    sqHouse.setFill(Color.web("#faffd3"));
                    lbMsgResult.setText("Graet");
                    lbMsgResult.setTextFill(Color.web("#0b770b"));   
                    lbMsgSqHouseDoor.setOpacity(1);
                    lbMsgSqHouse.setOpacity(0);
                    
                    ckList.addAll("6", "5", "26");
                    ckList.remove(0, 3);
                    score += 10;
                    scoreMsg.setText("Your score is : " + score);
                    graet.play();
                    adScore.play();
                    break;
                case "20":
                    lbMsgSqHouse.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                case "80":
                    lbMsgSqHouse.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                //door             
                case "6":
                    lbMsgSqHouseDoor.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score -= 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;
                case "5":
                    sqHouseDoor.setFill(Color.web("#8f7141"));
                    lbMsgResult.setText("Graet");
                    lbMsgResult.setTextFill(Color.web("#0b770b"));   
                    lbMsgSqHouseDoor.setOpacity(0);
                    score += 10;
                    scoreMsg.setText("Your score is : " + score);
                    btNext.setDisable(false);
                    graet.play();
                    adScore.play();
                    end.play();
                    clap.play();
                    break;
                case "26":
                    lbMsgSqHouseDoor.setOpacity(1);
                    lbMsgResult.setText("Try Again");
                    score += 10;
                    scoreMsg.setText("Your score is : " + score);
                    lbMsgResult.setTextFill(Color.web("#ff0000"));   
                    fail.play();
                    break;

            } //switch
     });

    } //action + inti
                

}