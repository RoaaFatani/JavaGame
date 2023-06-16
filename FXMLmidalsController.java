/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlbraino;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import static java.util.Collections.list;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

public class FXMLmidalsController implements Initializable {

    @FXML
    private Label player1;

    @FXML
    private Label player2;

    @FXML
    private Label player3;

    @FXML
    private Label scoreplay1;

    @FXML
    private Label scoreplay2;

    @FXML
    private Label scoreplay3;
    @FXML
    private Button home;

    @FXML
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
    public void homemousebtnenter(MouseEvent e) {

        home.setScaleX(home.getScaleX() + 0.1);
        home.setScaleY(home.getScaleY() + 0.1);

    }

    @FXML
    public void homemousebtnexit(MouseEvent e) {

        home.setScaleX(home.getScaleX() - 0.1);
        home.setScaleY(home.getScaleY() - 0.1);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<scoretable> list = null;
        String queryp = "from scoretable";
        Query query = session.createQuery(queryp);
        // boolean s = false;
        list = query.list();
        session.close();
        List<scoretable> highToLow = list;
        Collections.sort(highToLow, new HighToLowComparator());
        System.out.println("High to low: ");
        for (int i = 0; i < 3; i++) {
            String str1 = Integer.toString(highToLow.get(i).getScore());
            if (i == 0) {
                player1.setText(highToLow.get(i).getUser_name());
                scoreplay1.setText(str1);
            }
            if (i == 1) {
                player2.setText(highToLow.get(i).getUser_name());
                scoreplay2.setText(str1);
            }
            if (i == 2) {
                player3.setText(highToLow.get(i).getUser_name());
                scoreplay3.setText(str1);
            }
        }
    }

}
