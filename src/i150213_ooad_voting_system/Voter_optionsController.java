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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class Voter_optionsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public void vote_casting_handler(ActionEvent e) throws IOException{
         Parent admin_options_parent = FXMLLoader.load(getClass().getResource("cast_vote_screen.fxml"));
        Scene admin_options_scene = new Scene(admin_options_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(admin_options_scene);

        app_stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
