/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlbraino;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class FXMLPrecntegeController implements Initializable {
    @FXML
    private Button btHome;
    
    @FXML
    public void ShangeScreenButtonHome(ActionEvent event) throws IOException {

        Parent FXMLDocumentParnt = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene FXMLDocumentScene = new Scene(FXMLDocumentParnt);

        //Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(FXMLDocumentScene);
        window.show();
    }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
}
