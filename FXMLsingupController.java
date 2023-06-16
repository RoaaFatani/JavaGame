/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlbraino;
import java.util.Date;
import static com.mchange.v2.c3p0.impl.C3P0Defaults.password;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import static javafxfxmlbraino.globalUser.userName;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author omar
 */
public class FXMLsingupController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private ChoiceBox<String> country;
    @FXML
    private Label lbmsg;
    @FXML
    private ToggleButton signUpBt;
    @FXML
    private TextField userNameTx;
    @FXML
    private TextField userEmail;
    @FXML
    private PasswordField userPassword;
    @FXML
    private DatePicker userAge;
    @FXML
    public RadioButton rbBoy;
    @FXML
    public RadioButton rbGirl;
    @FXML
    private ToggleGroup groupGender;
    @FXML
    public Circle circleImg;
    @FXML
    private Button home;

    @FXML
    private final Image imgBoy = new Image("image/boyphoto.png");
    @FXML
    private final Image imgGirl = new Image("image/girlphoto.png");

    @FXML
    public final ImagePattern imgPattBoy = new ImagePattern(imgBoy);
    @FXML
    public final ImagePattern imgPattGirl = new ImagePattern(imgGirl);

    public AudioClip click = new AudioClip(getClass().getResource("/video/mouseclick.mp3").toString());

    /* switch secene from sing in to home */
    public void ShangeScreenButtonPushed(ActionEvent event) throws IOException {
        click.play();

        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLHomepage.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt);

        //Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }

    @FXML
    public void homemousebtnenter(MouseEvent e) {

        home.setScaleX(home.getScaleX() + 0.1);
        home.setScaleY(home.getScaleY() + 0.1);

    }

    @FXML
    public void homemousebtnexit(MouseEvent e) {

        home.setScaleX(home.getScaleX() - 0.1);
        home.setScaleY(home.getScaleY() - 0.1);

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if (rbBoy.isSelected()) {
            circleImg.setFill(imgPattBoy);

        } else if (rbGirl.isSelected()) {
            circleImg.setFill(imgPattGirl);
        }
    }

    @FXML
    private void handleTexttAction(ActionEvent event) throws IOException {
        click.play();

        String strUserName = userNameTx.getText();
        String strUserEmail = userEmail.getText();
        String strUserPassword = userPassword.getText();
        if (strUserName.isEmpty() && strUserEmail.isEmpty() && strUserPassword.isEmpty()) {
            lbmsg.setText("Please Enter an User Name ,Email and Password");
        } else if (!strUserName.isEmpty() && strUserEmail.isEmpty() && strUserPassword.isEmpty()) {
            lbmsg.setText("Please Enter an Email and Password");
        } else if (!strUserName.isEmpty() && !strUserEmail.isEmpty() && strUserPassword.isEmpty()) {
            lbmsg.setText("Please Enter an Password");
        } else if (!strUserName.isEmpty() && strUserEmail.isEmpty() && !strUserPassword.isEmpty()) {
            lbmsg.setText("Please Enter an Email");
        } else if (strUserName.isEmpty() && !strUserEmail.isEmpty() && !strUserPassword.isEmpty()) {
            lbmsg.setText("Please Enter an User Name");
        } else if (strUserName.isEmpty() && !strUserEmail.isEmpty() && strUserPassword.isEmpty()) {
            lbmsg.setText("Please Enter an  User Name and Password");
        } else if (strUserName.isEmpty() && strUserEmail.isEmpty() && !strUserPassword.isEmpty()) {
            lbmsg.setText("Please Enter an  User Name and Email");
        } else {
            
            
             Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<user> list = null;
            String queryp = "from user";
            Query query = session.createQuery(queryp);
            boolean s = false;
            list = query.list();
            session.close();

            for (user u : list) {
                if (userNameTx.getText().equals(u.getUser_name())||userEmail.getText().equals(u.getEmail())) {
                    lbmsg.setText("Name or Email already exists ");
                 return;
                    }}

            System.out.println("new user");
            user user = new user();
            user.setPassword(userPassword.getText());
            user.setEmail(userEmail.getText());
            user.setUser_name(userNameTx.getText());
            globalUser.username=userNameTx.getText();
            try {
                session = HibernateUtil.getSessionFactory().openSession();

                session.beginTransaction();

                session.save(user);

                session.getTransaction().commit();
                session.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            ///******score********
          
            
            scoretable scoreuser = new scoretable();
            scoreuser.setUser_name(userNameTx.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date date = new Date();

            String frmtdDate = dateFormat.format(date);
            scoreuser.setDateTime(frmtdDate);
            scoreuser.setId(ret());

            try {
                Session session2 = HibernateUtil.getSessionFactory().openSession();
                session2.beginTransaction();
                session2.save(scoreuser);

                session2.getTransaction().commit();
                session2.close();
            } catch (Exception e) {
                System.out.println("eror");
            }

            //   scoreuser.setDateTime(strUserName);
            System.out.println("inserted user: " + user.getUser_name());

            lbmsg.setText("");

            Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt);

            //Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(FXMLDocumentScene);
            window.show();
        }

    }

    @FXML
    public void singupmousebtnenter(MouseEvent e) {

        signUpBt.setScaleX(signUpBt.getScaleX() + 0.1);
        signUpBt.setScaleY(signUpBt.getScaleY() + 0.1);

    }

    @FXML
    public void singupmousebtnexit(MouseEvent e) {

        signUpBt.setScaleX(signUpBt.getScaleX() - 0.1);
        signUpBt.setScaleY(signUpBt.getScaleY() - 0.1);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> ckList= FXCollections.observableArrayList("Saudi Arabia", "unatied Kingdom", "Greece");
    country.setItems(ckList);
    

    }
    
   
  static int idouto=16;
   static public int ret(){
         return idouto++  ;
    }

}
