
package javafxfxmlbraino;

import java.io.IOException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;


public class FXMLloginController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Label msg;

    @FXML
    private ImageView login;

    @FXML
    private ImageView signup;

    @FXML
    private Hyperlink forget;
    @FXML
    private Button log_in;

    @FXML
    private Button sign_up;

    @FXML
    private Button home;

    public AudioClip click = new AudioClip(getClass().getResource("/video/mouseclick.mp3").toString());

    /* switch secene from log in to home */
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
    public void loginmousebtnenter(MouseEvent e) {

        log_in.setScaleX(log_in.getScaleX() + 0.1);
        log_in.setScaleY(log_in.getScaleY() + 0.1);

    }

    @FXML
    public void loginmousebtnexit(MouseEvent e) {

        log_in.setScaleX(log_in.getScaleX() - 0.1);
        log_in.setScaleY(log_in.getScaleY() - 0.1);

    }

    /* switch secene from log in to sing up  */
    public void ShangeScreenButtonPushedsingup(ActionEvent event) throws IOException {
        click.play();

        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLsingup.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt);

        //Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }

    @FXML
    public void singupmousebtnenter(MouseEvent e) {

        sign_up.setScaleX(sign_up.getScaleX() + 0.1);
        sign_up.setScaleY(sign_up.getScaleY() + 0.1);

    }

    @FXML
    public void singupmousebtnexit(MouseEvent e) {

        sign_up.setScaleX(sign_up.getScaleX() - 0.1);
        sign_up.setScaleY(sign_up.getScaleY() - 0.1);

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        click.play();

        String str = userName.getText();
        String str1 = password.getText();

        if (str.isEmpty() && str1.isEmpty()) {
            msg.setText("Enter your name and the password");
        } else if (!str.isEmpty() && str1.isEmpty()) {
            msg.setText("Enter the password");
        } else if (str.isEmpty() && !str1.isEmpty()) {
            msg.setText("Enter your name");
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
                if (userName.getText().equals(u.getUser_name())) {
                    if (password.getText().equals(u.getPassword())) {

                        s = true;
                        globalUser.username = str;
                        Parent root;
                        try {
//                      Parent FXMLDocumentParnt =  FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                            FXMLLoader FXMLDocumentParnt = new FXMLLoader(getClass().getResource("/javafxfxmlbraino/FXMLDocument.fxml"));
                            root = FXMLDocumentParnt.load();
                            Stage window = (Stage) log_in.getScene().getWindow();
                            // window.setUserData(scoreuser1);
                            //Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );

                            //Stage information
//                      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                            window.setScene(new Scene(root));
                            window.show();
                        } catch (Exception e) {
                            System.out.println("eror");
                        }
                    }
                }
            }

            if (s == false) {
//
                msg.setText("create an acount or user name and password is wrong");
            }

//            
//           // scoretaple scoreuser1 = new scoretaple();
//            System.out.println("login");
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            String SelectUsername = "SELECT user_name user";
//            Query querySelect = session.createQuery(SelectUsername);
//             List resultsSelect = querySelect.list();
//             
//             if(!resultsSelect.contains(str)){
//            msg.setText("create an acount ");
//            session.close();
//            return;
//        }
            //  System.out.println("login");
            //scoreuser1.setUser_name(str);
//            scoretaple scoreuser1 = new scoretaple();
//            System.out.println("login");
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            String SelectUsername = "SELECT user_name FROM user";
//            Query querySelect = session.createQuery(SelectUsername);
//             List resultsSelect = querySelect.list();
//             if(!resultsSelect.contains(str)){
//            msg.setText("create an acount ");
//            session.close();
//            return;
//        }
//             scoreuser1.setUser_name(str);
//              Parent root;
//                        try{
////                      Parent FXMLDocumentParnt =  FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//                        FXMLLoader FXMLDocumentParnt = new FXMLLoader(getClass().getResource("/javafxfxmlbraino/FXMLDocument.fxml"));
//                        root = FXMLDocumentParnt.load();
//                        Stage window = (Stage)  log_in.getScene().getWindow();
//                        window.setUserData(scoreuser1);
//                        //Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
//
//                        //Stage information
////                      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//                        window.setScene(new Scene(root));
//                        window.show();}
//                         catch(Exception e){
//             System.out.println("eror");
//}
            //***t
//            session.beginTransaction();
//            List<user> list = null;
//            String queryp = "from user";
//            Query query = session.createQuery(queryp);
//            boolean s = false;
//            list = query.list();
//            session.close();
//            for (user u : list) {
//                if (userName.getText().equals(u.getUser_name())) {
//                    if (password.getText().equals(u.getPassword())) {
//                       // scoreuser1.setEmail(u.getEmail());
//                        scoreuser1.setUser_name(userName.getText());
//                        //user1.setPassword(password.getText());
//                        globalUser.username = userName.getText();
//                        s = true;
//
//                        Parent root;
//                        try{
////                      Parent FXMLDocumentParnt =  FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//                        FXMLLoader FXMLDocumentParnt = new FXMLLoader(getClass().getResource("/javafxfxmlbraino/FXMLDocument.fxml"));
//                        root = FXMLDocumentParnt.load();
//                        Stage window = (Stage)  log_in.getScene().getWindow();
//                        window.setUserData(scoreuser1);
//                        //Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt );
//
//                        //Stage information
////                      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//                        window.setScene(new Scene(root));
//                        window.show();}
//                         catch(Exception e){
//             System.out.println("eror");
//}
//
//                    }
//                }
//                if (s == false) {
//
//                    msg.setText("create an acount ");
//                }
//
//            }
        }

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

    public void forgetpassword(ActionEvent event) throws IOException {
        click.play();

        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLforget.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt);

        //Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }

// 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private int counter = 0;

    public int getNumber() {
        int tmp = counter;
        counter++;
        return tmp;

    }

}
