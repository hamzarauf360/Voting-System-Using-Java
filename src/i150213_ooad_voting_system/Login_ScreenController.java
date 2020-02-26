/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i150213_ooad_voting_system;

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

/**
 *
 * @author Hamza
 */
public class Login_ScreenController implements Initializable {
    
    @FXML
    private Button admin_log_but;
    private Button voter_log_but;
     private Button nominee_log_but;

    @FXML
    private void admin_login(ActionEvent event) throws IOException {
         Parent admin_options_parent = FXMLLoader.load(getClass().getResource("Admin_options.fxml"));
        Scene admin_options_scene = new Scene(admin_options_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(admin_options_scene);

        app_stage.show();
        
    }
    @FXML
     private void voter_login(ActionEvent event) throws IOException {
        Parent admin_options_parent = FXMLLoader.load(getClass().getResource("voter_login_screen.fxml"));
        Scene admin_options_scene = new Scene(admin_options_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(admin_options_scene);

        app_stage.show();
    }
     @FXML
      private void nominee_login(ActionEvent event) throws IOException {
        Parent admin_options_parent = FXMLLoader.load(getClass().getResource("nominee_login.fxml"));
        Scene admin_options_scene = new Scene(admin_options_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(admin_options_scene);

        app_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
