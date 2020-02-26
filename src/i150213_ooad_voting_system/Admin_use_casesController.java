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
public class Admin_use_casesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public void add_voter_handler(ActionEvent e) throws IOException{
         Parent admin_options_parent = FXMLLoader.load(getClass().getResource("Add_voter.fxml"));
        Scene admin_options_scene = new Scene(admin_options_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(admin_options_scene);

        app_stage.show();
    }
    @FXML
    public void add_nominee_handler(ActionEvent e) throws IOException{
         Parent admin_options_parent = FXMLLoader.load(getClass().getResource("Add_nominee.fxml"));
        Scene admin_options_scene = new Scene(admin_options_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(admin_options_scene);

        app_stage.show();
    }
    @FXML
    public void get_winner_handler(ActionEvent e) throws IOException{
         Parent admin_options_parent = FXMLLoader.load(getClass().getResource("Get_winner.fxml"));
        Scene admin_options_scene = new Scene(admin_options_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(admin_options_scene);

        app_stage.show();
    }
    @FXML
    public void all_current_vote_counts(ActionEvent e) throws IOException{
         Parent admin_options_parent = FXMLLoader.load(getClass().getResource("All_vote_counts.fxml"));
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
