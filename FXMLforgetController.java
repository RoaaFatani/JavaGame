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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

public class FXMLforgetController implements Initializable {

    @FXML
    private TextField textfemail;

    @FXML
    private TextField textfpass;

    @FXML
    private Button buttlogin;

    @FXML
    private Label lablemassge;

    @FXML
    private Label label;

    public void login(ActionEvent event) throws IOException {
        String str = textfemail.getText();
        String str1 = textfpass.getText();

        if (str.isEmpty() && str1.isEmpty()) {
            lablemassge.setText("Enter your email and the password");
        } else if (!str.isEmpty() && str1.isEmpty()) {
            lablemassge.setText("Enter the password");
        } else if (str.isEmpty() && !str1.isEmpty()) {
            lablemassge.setText("Enter your email");
        } else {

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<user> list = null;
            String queryp = "from user";
            Query query = session.createQuery(queryp);
            boolean s = false;
            list = query.list();
            session.close();
            String str2 = null;
            for (user u : list) {
                if (str.equals(u.getEmail())) {
                    str2 = u.getUser_name();
                    s = true;
                 break; 
                }
            }
            if (s) {
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                session1.beginTransaction();
                user s2 = null;
                s2 = (user) session1.get(user.class, str2);
                s2.setPassword(str1);
                session1.getTransaction().commit();
                session1.close();
                System.out.println("update the password:" + s2.getUser_name());

                Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
                Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt);

                //Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(FXMLDocumentScene);
                window.show();
            }          else{
              lablemassge.setText("your email not recognized");  
            }

            
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}